 /* mac/mac.c  - Front End Interface code */

/* Written by Richard Knuckey
 * Copyright (c) 1992 Richard Knuckey
 * For UMoria 5.5.0
 */

#include <MacHeaders>
#include "MacScreen.h"

#include <setjmp.h>
#include <string.h>
#include <stdlib.h>

#include "DumpRes.h"
#include "config.h"
#include "constant.h"
#include "types.h"
#include "externs.h"
#include "macrsrc.h"
#include "mac.h"
#include "wRecall.h"
#include "wGame.h"

static long game_flag;
static long exit_code;
static jmp_buf jb;

static short savedir, applvrefnum;
static BOOLEAN showAllTypes;

#define PATHLEN                 256

int savefileset = FALSE;
char savefilename[64];
short savefilevol;
int next, savedgame, restart_flag;


int GameCanAcceptCommands = 0;
int Quitting = FALSE;
int wimp = FALSE;

/* Global Interface Vars */

MenuHandle      FileMenu;
MenuHandle      EditMenu;
MenuHandle      MoriaMenu;
MenuHandle      FontMenu;
short           FontSelection;
msWindowPtr     OptionWindow;
msWindowPtr     FontSizeWindow, ConfirmSaveWindow;
int             optionwindowopen = FALSE;
int             fontsizewindowopen = FALSE;
int             ConfirmSaveResult;
Cursor          WatchCursor;
StdGlobalsType  * g;


extern WindowPtr MainWindow;    /* Declared in wGame.c */
extern DefaultsHandle   Defaults;
extern  Handle  KCHRresource;
extern  long    trans_state;


/* ------------------------------------------------------------------------
 * FixFileMenu
 *
 */

void    FixFileMenu( void )
    {
    WindowPtr   FrontMost;

    FrontMost = FrontWindow();
    
    if (MainWindow)
        {
        DisableItem(FileMenu, NewCmd);
        DisableItem(FileMenu, OpenCmd);
        }
    else
        {
        EnableItem(FileMenu, NewCmd);
        EnableItem(FileMenu, OpenCmd);
        }
        
    if (FrontMost == 0L)
        {
        DisableItem(FileMenu, CloseCmd);
        DisableItem(FileMenu, SaveCmd);
        DisableItem(FileMenu, SaveAsCmd);
        EnableItem(FileMenu, QuitCmd);
        }
    else if (FrontMost == MainWindow)
        {
        switch (GameCanAcceptCommands)
            {
        case 2:
            DisableItem(FileMenu, SaveCmd);
            DisableItem(FileMenu, SaveAsCmd);
            EnableItem(FileMenu, CloseCmd);
            EnableItem(FileMenu, QuitCmd);
            break;

        case 1:
            EnableItem(FileMenu, SaveCmd);
            EnableItem(FileMenu, SaveAsCmd);
            EnableItem(FileMenu, CloseCmd);
            EnableItem(FileMenu, QuitCmd);
            break;

        case 0:
            DisableItem(FileMenu, SaveCmd);
            DisableItem(FileMenu, SaveAsCmd);
            DisableItem(FileMenu, CloseCmd);
            DisableItem(FileMenu, QuitCmd);
            }
        }
    else        /* any other window */
        {
        EnableItem(FileMenu, CloseCmd);
        DisableItem(FileMenu, SaveCmd);
        DisableItem(FileMenu, SaveAsCmd);
        if (!MainWindow || GameCanAcceptCommands)
            EnableItem(FileMenu, QuitCmd);
        }
    }   


/* ------------------------------------------------------------------------
 * RestoreWimpNextEventLoop
 *
 * Needed because the Screen Manager restores the Highlight state of the
 * Menu bar after our menu handler returns. In the case of starting a 
 * new game, this doesn't return until the game is stopped! 
 * The easiest way to thus clear the highlight state is to install a
 * background proc that is called when Moria calls msDo1Event. This
 * also gives the most pleasing results.
 *
 */
 
pascal void RestoreWimpNextEventLoop(void)
    {
    HiliteMenu(0);
    InitCursor();
    msSetBackground(0L);    /* remove ourself */
    }   
    
    
    
    
/* ------------------------------------------------------------------------
 * MakeFileName
 *
 */

    
char *makefilename(buffer, suffix, append)
char *buffer, *suffix;
int append;
    {
    long len;
    char *p;

    len = strlen(py.misc.name) + ((append) ? strlen(suffix)+3 : 0);

    if ( (strlen(py.misc.name) == 0) || (len > 31) )
        strcpy(buffer, suffix);
    else
        {
        strcpy(buffer, py.misc.name);
        if (append)
            {
            strcat(buffer, "Õs ");
            strcat(buffer, suffix);
            }
        for (p = buffer; *p; p++)
            if (*p == ':') *p = '.';
        }
    return(buffer);
    }


/* ------------------------------------------------------------------------
 * GetDirID
 *
 */

OSErr GetDirID(wdVRefNum, vRefNum, dirID)
short wdVRefNum;
short *vRefNum;
long *dirID;
    {
    OSErr err;
    WDPBRec wdpb;

    wdpb.ioNamePtr = NULL;
    wdpb.ioVRefNum = wdVRefNum;
    wdpb.ioWDIndex = 0;
    wdpb.ioWDProcID = 0;
    wdpb.ioWDVRefNum = 0;
    err = PBGetWDInfo(&wdpb, false);

    if (!err)
        {
        *vRefNum = wdpb.ioWDVRefNum;
        *dirID = wdpb.ioWDDirID;
        }

    return(err);
    }


/* ------------------------------------------------------------------------
 * MakePath
 *
 */


OSErr MakePath(vRefNum, dirID, fName, pathName)
short vRefNum;
long dirID;
char *fName;
char *pathName;
    {
    char buf[PATHLEN], *bufptr;
    long len;
    OSErr err;
    Str255 vNameBuf;
    CInfoPBRec cipb;

    bufptr = buf + PATHLEN;

    *--bufptr = '\0';

    if (fName != NULL)
        {
        len = strlen(fName);
        strncpy(bufptr -= len, fName, len);
        }

    cipb.dirInfo.ioNamePtr = vNameBuf;
    cipb.dirInfo.ioVRefNum = vRefNum;
    cipb.dirInfo.ioFDirIndex = -1;

    do
        {
        cipb.dirInfo.ioDrDirID = dirID;
        err = PBGetCatInfo(&cipb, false);
        if (!err)
            {
            *--bufptr = ':';
            len = strlen(p2cstr(vNameBuf));
            strncpy(bufptr -= len, (char *)vNameBuf, len);
            dirID = cipb.dirInfo.ioDrParID;
            }
        }
    while ( (!err) && (dirID != fsRtParID) );

    strcpy(pathName, bufptr);

    return(err);
    }


/* ------------------------------------------------------------------------
 * sfposition
 *
 */

void sfposition(vrefnum)
short vrefnum;
    {
    short v;
    long d;

    GetDirID(vrefnum, &v, &d);
    SFSaveDisk = -v;
    CurDirStore = d;
    }


/* ------------------------------------------------------------------------
 * doputfile
 *
 */

int doputfile(prompt, fname, vrefnum)
char *prompt;
char *fname;
short *vrefnum;
    {
    char p[256], f[256];
    SFReply reply;
    Point loc;
    long h, v;
    EventRecord DummyEvent;
    long        EventMask;

    h=40;
    v=40;

    loc.h = (short) h;
    loc.v = (short) v;

    strncpy(p, prompt, 255);
    strncpy(f, fname, 255);
    p[255] = '\0';
    f[255] = '\0';
    c2pstr(p);
    c2pstr(f);

    SFPutFile(loc, p, f, NULL, &reply);

    if (reply.good)
        {
        p2cstr(reply.fName);
        strcpy(fname, (char *)reply.fName);
        *vrefnum = reply.vRefNum;
        }
    
    if (!reply.good)
        Quitting = FALSE;
        
    return(reply.good);
    }

pascal short getFileHook( short item, DialogPtr theDialog)
    {
    if (item == 11)
        {
        ControlHandle   theControl;
        short           itemType;
        Rect            box;
        
        GetDItem(theDialog, 11, &itemType, &theControl, &box);
        SetCtlValue(theControl, showAllTypes = !showAllTypes);
        return(sfHookRebuildList);
        }
    return(item);
    }
    
pascal BOOLEAN getFileFilter ( ParmBlkPtr pb)
    {
    if (showAllTypes)
        return( FALSE );
    else
        return (!(pb->fileParam.ioFlFndrInfo.fdType == SAVE_FTYPE));
    }
    
/* ------------------------------------------------------------------------
 * dogetfile
 *
 */


int dogetfile(fname, vrefnum)
char *fname;
short *vrefnum;
    {
    SFTypeList types;
    SFReply reply;
    Point loc;
    long h, v;

    h=40;
    v=40;

    loc.h = (short) h;
    loc.v = (short) v;

    showAllTypes = FALSE;

    SFGetFile(loc, NULL, *getFileFilter, -1, types, *getFileHook, &reply);

    if (reply.good)
        {
        p2cstr(reply.fName);
        strcpy(fname, (char *)reply.fName);
        *vrefnum = reply.vRefNum;
        }

    return(reply.good);
    }

/* ------------------------------------------------------------------------
 * currentdirectory
 *
 */

short currentdirectory()
    {
    short vrefnum;

    (void) GetVol(NULL, &vrefnum);
    }


/* ------------------------------------------------------------------------
 * changedirectory
 *
 */

void changedirectory(vrefnum)
short vrefnum;
    {
    (void) GetVol(NULL, &savedir);
    (void) SetVol(NULL, vrefnum);
    }


/* ------------------------------------------------------------------------
 * appldirectory
 *
 */

void appldirectory()
    {
    (void) GetVol(NULL, &savedir);
    (void) SetVol(NULL, applvrefnum);
    }


/* ------------------------------------------------------------------------
 * restoredirectory
 *
 */

void restoredirectory()
    {
    (void) SetVol(NULL, savedir);
    }


/* ------------------------------------------------------------------------
 * initsavedefaults
 *
 */

void initsavedefaults()
    {
    if (!savefileset)
        {
        (void) makefilename(savefilename, "", FALSE);
        savefilevol = currentdirectory();
        }
    }

/* ------------------------------------------------------------------------
 * setsavedefaults
 *
 */

void setsavedefaults(name, vol)
char *name;
short vol;
    {
    strncpy(savefilename, name, 63);
    savefilename[63] = '\0';

    savefilevol = vol;
    }


/* ------------------------------------------------------------------------
 * getsavedefaults
 *
 */

int getsavedefaults(name, vol)
char *name;
short *vol;
    {
    strcpy(name, savefilename);
    *vol = savefilevol;

    return(savefileset);
    }

/* ------------------------------------------------------------------------
 * setfileinfo
 *
 */


long setfileinfo(fname, vrefnum, ftype)
char *fname;
short vrefnum;
long ftype;
    {
    long fcreator;
    char temp[64];
    FileParam pb;
    OSErr err;

    fcreator = MORIA_FCREATOR;

    strcpy(temp, fname);
    (void) c2pstr(temp);

    pb.ioCompletion = NULL;
    pb.ioNamePtr = (unsigned char *)temp;
    pb.ioVRefNum = vrefnum;
    pb.ioFVersNum = 0;
    pb.ioFDirIndex = 0;

    err = PBGetFInfo((ParmBlkPtr) &pb, FALSE);

    if (err == noErr)
        {
        pb.ioFlFndrInfo.fdType = ftype;
        pb.ioFlFndrInfo.fdCreator = fcreator;
        err = PBSetFInfo((ParmBlkPtr) &pb, FALSE);
        }

    return(err == noErr);
    }


/* ------------------------------------------------------------------------
 * goback
 *
 */

void goback(void)
    {
    longjmp(jb, 1);
    }


/* ------------------------------------------------------------------------
 * setupmem
 *
 * Allocates and initializes various areas of memory for the game,
 * Needed to make the game restartable
 */


int setupmem(restart)
int restart;
    {
    int i;
    memtable_type *m;

    for (i = 0, m = memtable; i < MAX_PTRS; i++, m++)
        {
        if (!restart)
            {
            *m->memPtr = (char *) NewPtrClear(m->elemCnt * m->elemSiz);
            if (*m->memPtr == NULL) return(FALSE);
            }
        else if (m->restartFlag)
            {
            memset(*m->memPtr, 0, m->elemCnt * m->elemSiz);
            }
        }
    return(TRUE);
    }


/* ------------------------------------------------------------------------
 * getresources
 *
 * Retreive initial setting for a whole bunch of globals variables.
 * Needed to make the game restartable.
 */

int getresources(restart)
int restart;
    {
    int i, rc;
    restable_type *r;

    for (i = 0, r = restable; i < MAX_RESOURCES; i++, r++)
        {
        if (!restart) *r->memPtr = NULL;

        if ( (!restart) || (r->restartFlag) )
            {
            rc = LoadRes(r->memPtr, r->resType, r->resID, r->elemCnt,
                    r->elemSiz, r->strProc);
            if (!rc) return(FALSE);
            }
        }
    return(TRUE);
    }

/* ------------------------------------------------------------------------
 * getrestart
 *
 * Needed to make the game restartable.
 */
 
int getrestart(restart)
int restart;
    {
    int i, rc;
    unsigned size;
    char *p, *q;

    if (restart)
        {
        size = 0;
        for (i = 0; i < MAX_RESTART; i++)
            size += restart_vars[i].size;
        p = NULL;
        rc = LoadRes(&p, restartRsrc, restart_id, 1, size, NULL);

        if (!rc)
            return(FALSE);

        q = p;
        for (i = 0; i < MAX_RESTART; i++)
            {
            BlockMove(q, restart_vars[i].ptr, restart_vars[i].size);
            q += restart_vars[i].size;
            }
        DisposPtr(p);
        }
    return(TRUE);
    }


/* ------------------------------------------------------------------------
 * clearvars
 *
 * Needed to make the game restartable.
 */

int clearvars(restart)
int restart;
    {
    int i;
    clrtable_type *c;

    if (restart)
        for (i = 0, c = clrtable; i < MAX_CLRS; i++, c++)
            memset(c->ptr, 0, c->size);

    return(TRUE);
    }

/* ------------------------------------------------------------------------
 * loaddata
 *
 * setup our global variables from our resources, this allows the game to
 * be restartable buy simple reloading fresh copies.
 */


void loaddata(restart)
int restart;
    {
    if (
            (!setupmem(restart))        ||
            (!getresources(restart))    ||
            (!getrestart(restart))      ||
            (!clearvars(restart))           )

                SysBeep(5);

    }

/* start saved game */

void startsaved(void)
    {
    int argc;
    char *argv[2];

    SetCursor(&WatchCursor);
    savefileset = TRUE;
    if (restart_flag)
        loaddata(TRUE);
    msSetBackground(*RestoreWimpNextEventLoop);

    clear_screen();

    argc = 0;
    argv[argc++] = NULL;

    game_flag = TRUE;
    moria_main(argc, argv);

    /* should never get here */
    }



void startnew(void)
    {
    int argc;
    long local_newgameopt;
    char *argv[3];
    
    SetCursor(&WatchCursor);
    savefileset = FALSE;
    if (restart_flag)
        loaddata(TRUE);
    msSetBackground(*RestoreWimpNextEventLoop);

    clear_screen();

    local_newgameopt = '-n\0\0';

    argc = 0;
    argv[argc++] = NULL;
    argv[argc++] = (char *) &local_newgameopt;

    game_flag = TRUE;

    
    moria_main(argc, argv);
    
    /* should never get here */
    }


/* ------------------------------------------------------------------------
 * HandleConfirmSaveWindow
 *
 */

pascal BOOLEAN  HandleConfirmSaveWindow(theWindow, itemHit, PartHit)
msWindowPtr theWindow;
short       *itemHit;
short       *PartHit;
    {
    switch (*itemHit)
        {
        case actionDoCloseWindow:
            return(TRUE);
            break;
        
        case actionDoFixMenus:
            DisableItem(GetMHandle(AppleMenuID), AboutCmd);
            DisableItem(FileMenu, 0);
            DisableItem(EditMenu, 0);
            DisableItem(MoriaMenu, 0);
            DisableItem(FontMenu, 0);
            break;
            
        case saveYes:
        case saveNo:
        case saveCancel:
            ConfirmSaveResult = (int)*itemHit;
            (void)msCloseWindow(theWindow->window);
            break;
        }
    }


int confirm_save(int CanCancel)
    {
    ConfirmSaveWindow = msGetWindow( ConfirmSaveWindowID, *HandleConfirmSaveWindow);
    if (!CanCancel)
        msEnableItem(ConfirmSaveWindow, saveCancel, FALSE);
    
    ConfirmSaveResult = 0;
    while ( ConfirmSaveResult == 0 )
        msDo1Event();
    return(ConfirmSaveResult);
    }

/* ------------------------------------------------------------------------
 * TextToShort
 *
 * Utility routine to convert a textHandle to a integer
 *
 */

short   TextToShort(Text)
Handle  Text;
    {
    short   num, length, i;
    char    *s;
    
    HLock(Text);
    length = GetHandleSize(Text);
    s = *Text;
    num = 0;

    for ( i = 0; i < length; i++ )
        num = (num * 10) + (s[i] - 48);
        
    HUnlock(Text);
    return(num);
    }


/* ------------------------------------------------------------------------
 * HandleFontSizeWindow
 *
 */

pascal BOOLEAN  HandleFontSizeWindow(theWindow, itemHit, PartHit)
msWindowPtr theWindow;
short       *itemHit;
short       *PartHit;
    {
    short   NewSize;
    
    switch (*itemHit)
        {
        case actionDoOpenWindow:
            fontsizewindowopen = TRUE;
            break;
            
        case actionDoCloseWindow:
            fontsizewindowopen = FALSE;
            return(TRUE);
            break;
        
        case actionDoFixMenus:
            DisableItem(MoriaMenu, 0);
            DisableItem(FontMenu, 0);
            break;
            
        case fontSizeChange:
            NewSize = TextToShort(GetEditTextHandle(theWindow, fontSizeEditText));
            if (NewSize < 4 || NewSize > 255)
                SysBeep(5);
            else
                {
                ChangeFontSize(NewSize);
                ImplementFontChanges();
                }
            break;
        }
    }


/* ------------------------------------------------------------------------
 * Select_OptionWindow
 *
 */


void Select_OptionWindow(void)
    {
    SelectWindow(OptionWindow->window);
    }


/* ------------------------------------------------------------------------
 * HandleOptionsWindow
 * 
 */

pascal BOOLEAN  HandleOptionsWindow ( theWindow, itemHit , PartHit)
msWindowPtr theWindow;
short       *itemHit;
short       *PartHit;
    {
    switch (*itemHit)
        {
        case actionDoOpenWindow:
            optionwindowopen = TRUE;
            if (rogue_like_commands)
                SetButtonState (theWindow, optionRogue, true);
            else
                SetButtonState (theWindow, optionOriginal, true);
            SetButtonState (theWindow, optionPrint, find_prself);
            SetButtonState (theWindow, optionStop, find_bound);
            SetButtonState (theWindow, optionCut, find_cut);
            SetButtonState (theWindow, optionExamine, find_examine);
            SetButtonState (theWindow, optionRun, find_ignore_doors);
            SetButtonState (theWindow, optionPrompt, prompt_carry_flag);
            SetButtonState (theWindow, optionHighlight, highlight_seams);
            SetButtonState (theWindow, optionBeep, sound_beep_flag);
            SetButtonState (theWindow, optionDisplay, display_counts);
            SetButtonState (theWindow, optionShow, show_weight_flag);
            break;
            
        case actionDoCloseWindow:
            optionwindowopen = FALSE;
            break;
            
        case actionDoFixMenus:
            EnableItem(GetMHandle(AppleMenuID), AboutCmd);
            
            EnableItem(FileMenu, 0);
            FixFileMenu();
            
            DisableItem(EditMenu, 0);
            EnableItem(MoriaMenu, 0);
            DisableItem(FontMenu, 0);
        
            break;
            
        case optionOriginal:
            SetButtonState (theWindow, optionOriginal, true);
            SetButtonState (theWindow, optionRogue, false);
            rogue_like_commands = false;
            break;
            
        case optionRogue:
            SetButtonState (theWindow, optionOriginal, false);
            SetButtonState (theWindow, optionRogue, true);
            rogue_like_commands = true;
            break;
        
        case optionPrint:
            find_prself = !find_prself;
            SetButtonState (theWindow, optionPrint, find_prself);
            break;
            
        case optionStop:
            find_bound = !find_bound;
            SetButtonState (theWindow, optionStop, find_bound);
            break;
            
        case optionCut:
            find_cut = !find_cut;
            SetButtonState (theWindow, optionCut, find_cut);
            break;
        
        case optionExamine:
            find_examine = !find_examine;
            SetButtonState (theWindow, optionExamine, find_examine);
            break;
            
        case optionRun:
            find_ignore_doors = !find_ignore_doors;
            SetButtonState (theWindow, optionRun, find_ignore_doors);
            break;
            
        case optionPrompt:
            prompt_carry_flag = !prompt_carry_flag;
            SetButtonState (theWindow, optionPrompt, prompt_carry_flag);
            break;
            
        case optionHighlight:
            highlight_seams = !highlight_seams;
            SetButtonState (theWindow, optionHighlight, highlight_seams);
            break;
            
        case optionBeep:
            sound_beep_flag = !sound_beep_flag;
            SetButtonState (theWindow, optionBeep, sound_beep_flag);
            break;
            
        case optionDisplay:
            display_counts = !display_counts;
            SetButtonState (theWindow, optionDisplay, display_counts);
            break;
            
        case optionShow:
            show_weight_flag = !show_weight_flag;
            SetButtonState (theWindow, optionShow, show_weight_flag);
            break;
            
        }
    return(TRUE);
    }


/* ------------------------------------------------------------------------
 * HandleAboutWindow
 *
 */

pascal BOOLEAN  HandleAboutWindow ( theWindow, itemHit , PartHit)
msWindowPtr theWindow;
short       *itemHit;
short       *PartHit;
    {
    switch (*itemHit)
        {
        case actionDoFixMenus:
            DisableItem(GetMHandle(AppleMenuID), AboutCmd);
            EnableItem(FileMenu, 0);
            FixFileMenu();
            DisableItem(EditMenu, 0);
            DisableItem(MoriaMenu, 0);
            DisableItem(FontMenu, 0);
            break;
        }
    return(TRUE);
    }
    

/* ------------------------------------------------------------------------
 * handleAboutCmd
 *
 * Handles the selection of About Moria... from the Apple Menu
 */

pascal void HandleAboutCmd(void)
    {
    msWindowPtr ignored;
    
    ignored = msGetWindow( AboutWindowID, *HandleAboutWindow);
    }   /* of HandleAboutCmd */



/* ------------------------------------------------------------------------
 * handleFileMenu
 *
 * Handles selections from the file menu
 */

pascal void HandleFileMenu (item)
short   item;
    {
    WindowPtr   FrontMost;
    extern      void OpenCreateWindow(void);
    int32u      save_turn;  
    
    switch (item)
        {
        case NewCmd:    /* Start New Character */
            startnew();
            break;
        
            
        case OpenCmd:   /* Open saved character */
            if (dogetfile(savefilename, &savefilevol))
                startsaved();
            break;
                
        
        case CloseCmd:
            (void)msCloseWindow( (msWindowPtr)FrontWindow() );
            break;
            
        case SaveAsCmd:
            savefileset = false;
        case SaveCmd:
            save_turn = turn;
            (void) strcpy (died_from, "(saved)");
            msg_print ("Saving game...");
            put_qio();
            if (save_char())
                {
                msg_print("Saved.");
                savefileset = TRUE;
                }
            else
                msg_print("Canceled.");
            msg_print(NULL);
            character_saved = FALSE;
            turn = save_turn;
            (void) strcpy (died_from, "(alive and well)");
            break;
    
        case QuitCmd:
            if (GameCanAcceptCommands || MainWindow == 0)
                {
                Quitting = TRUE;
                
                do
                    {
                    FrontMost = FrontWindow();
                    if (FrontMost && Quitting)
                        {
                        (void)msCloseWindow( FrontMost );
                        if (FrontMost == MainWindow)
                            return; /* let moria quit itself */
                        }
                    }
                while (Quitting && FrontMost);

                if (Quitting)
                    msStopEventLoop();
                }
            else
                SysBeep(5);
            break;
        }
    }

/* ------------------------------------------------------------------------
 * handleEditMenu
 *
 * Handles selections from the Edit menu
 */

pascal void HandleEditMenu (item)
short   item;
    {
    /* msHandleTextEditFunction((msWindowPtr)FrontWindow(), item, 0); */
    }   /*of procedure handleEditmenu*/


/* ------------------------------------------------------------------------
 * handleMoriaMenu
 *
 * Handles selections from the Moria menu
 */

pascal void HandleMoriaMenu (item)
short   item;
    {
    RGBColor    Color;
    
    switch (item)
        {
        case RecallCmd:
            openrecallwindow();
            break;
            
        case OptionsCmd:
            OptionWindow = msGetWindow( OptionsWindowID, *HandleOptionsWindow);
            break;
            
        case ColourCmd:
            SetPort(MainWindow);
            CheckItem(MoriaMenu, ColourCmd, (**Defaults).InColour = !(**Defaults).InColour);
            if ((**Defaults).InColour)
                {
                Color.red = Color.green = Color.blue = 0;
                RGBBackColor(&Color);
                DisableItem(MoriaMenu, ReverseCmd);
                CheckItem(MoriaMenu, ReverseCmd, FALSE);
                (**Defaults).ReversedText = FALSE;
                }
            else
                {
                Color.red = Color.green = Color.blue = 65535;
                RGBBackColor(&Color);
                Color.red = Color.green = Color.blue = 0;
                RGBForeColor(&Color);
                EnableItem(MoriaMenu, ReverseCmd);
                }
            EraseRect(&(MainWindow->portRect));
            screen_redraw();
            break;
            
        case ReverseCmd:
            SetPort(MainWindow);
            CheckItem(MoriaMenu, ReverseCmd, (**Defaults).ReversedText = !(**Defaults).ReversedText);
            if (g->QDVersion)
                {
                if ((**Defaults).ReversedText)
                    {
                    Color.red = Color.green = Color.blue = 65535;
                    RGBForeColor(&Color);
                    Color.red = Color.green = Color.blue = 0;
                    RGBBackColor(&Color);
                    }
                else
                    {
                    Color.red = Color.green = Color.blue = 0;
                    RGBForeColor(&Color);
                    Color.red = Color.green = Color.blue = 65535;
                    RGBBackColor(&Color);
                    }
                EraseRect(&(MainWindow->portRect));
                screen_redraw();
                }
            else
                { 
                if ((**Defaults).ReversedText)
                    {
                    PenPat(white);
                    BackPat(black);
                    }
                else
                    {
                    PenPat(black);
                    BackPat(white);
                    }
                InvertRect(&(MainWindow->portBits.bounds));
                }
            break;
                
        case    GraphicsCmd:
            CheckItem(MoriaMenu, GraphicsCmd, (**Defaults).Graphics = !(**Defaults).Graphics);
            EraseRect(&(MainWindow->portRect));
            screen_redraw();
            break;
        }
    }   /*of procedure handleMoriaMenu*/


/* ------------------------------------------------------------------------
 * handleFontMenu
 *
 * Handles selections from the Font menu
 */

pascal void HandleFontMenu (item)
short   item;
    {
    short   fNumber;
    
    switch (item)
        {
        case p9Cmd:
            ChangeFontSize(9);
            break;
            
        case p10Cmd:
            ChangeFontSize(10);
            break;
            
        case p12Cmd:
            ChangeFontSize(12);
            break;
            
        case p14Cmd:
            ChangeFontSize(14);
            break;
            
        case p18Cmd:
            ChangeFontSize(18);
            break;
            
        case OtherSizeCmd:
            FontSizeWindow = msGetWindow(FontSizeWindowID, *HandleFontSizeWindow);
            return;
        
        
        case PlainCmd:
            ChangeFontStyle(0);
            break;
            
        case BoldCmd:
            ChangeFontStyle(bold);
            break;
            
        
        default:
            CheckItem(FontMenu, FontSelection, FALSE);
            GetItem(FontMenu, item, &(**Defaults).FontName);
            GetFNum(&(**Defaults).FontName, &fNumber);
            FontSelection = item;
            CheckItem(FontMenu, FontSelection, TRUE);
            ChangeFontNumber(fNumber);
            break;
        }
            
    ImplementFontChanges();
    }


/* ------------------------------------------------------------------------
 * DefaultFixMenus
 *
 * Handles the Default menu active settings
 */

pascal void DefaultFixMenus(void)
    {
    WindowPtr   FrontMost;
    
    EnableItem(GetMHandle(AppleMenuID), AboutCmd);
    EnableItem(FileMenu, 0);
    
    FixFileMenu();
    
    FrontMost = FrontWindow();
    if (FrontMost == 0L)
        {
        DisableItem(EditMenu, 0);
        DisableItem(MoriaMenu, 0);
        DisableItem(FontMenu, 0);
        
        }
    else if (FrontMost == MainWindow)
        {
        DisableItem(EditMenu, 0);
        EnableItem(MoriaMenu, 0);
        EnableItem(FontMenu, 0);
        }
    else    /* assume frontmost = DA, thus enable Editmenu */
        {
        EnableItem(EditMenu, 0);
        DisableItem(MoriaMenu, 0);
        DisableItem(FontMenu, 0);
        }
    }

    
/* ------------------------------------------------------------------------
 * getstack
 *
 */


static void getstack(request)
long request;
    {
    long cursize;
    Ptr newlimit;

    cursize = (((long *) CurStackBase) - ((long *) ApplLimit)) - 8;
    if (cursize < request)
        {
        newlimit = (Ptr)(((long *) CurStackBase - request) - 8);
        if (newlimit > HeapEnd)
            ApplLimit = newlimit;
        }
    }


/* ------------------------------------------------------------------------
 * initmacintosh
 *
 * Initialize the enviroment and set up windows and menus
 */


void initmacintosh(void)
    {
    InitGraf(&thePort);
    InitFonts();
    FlushEvents(everyEvent, 0);
    InitWindows();
    InitMenus();
    TEInit();
    InitDialogs(0L);
    InitCursor();
    
    
    MaxApplZone();
    
    msInitialise(4, 20, 0L);
    PullApplicationToFront();
    }
    

/* ------------------------------------------------------------------------
 * initwimp
 *
 */

    
void initwimp(void)
    {
    Str255  fName;
    short   fNumber, ItemNo, NumItems;
    
    WatchCursor = **GetCursor(watchCursor);
    SetCursor(&WatchCursor);

    g = GetGlobals();
    initrecallwindow();
    
     if (g->KeyboardType <= envMacPlusKbd)
        {
        trans_state = 0;
        KCHRresource = GetResource('KCHR', 128);
        MoveHHi(KCHRresource);
        HLock(KCHRresource);
        }
     

/* --- Initialize menus */
    
    msInstallAppleMenu(  *HandleAboutCmd);
    
    FileMenu = GetMenu(FileMenuID);
    msInstallMenu(FileMenu, *HandleFileMenu, false);

    EditMenu = GetMenu(EditMenuID);
    msInstallMenu(EditMenu, *HandleEditMenu, false);

    MoriaMenu = GetMenu(MoriaMenuID);
    msInstallMenu(MoriaMenu, *HandleMoriaMenu, false);


    FontMenu = GetMenu(FontMenuID);
    
    NumItems = CountMItems(FontMenu);
    for (ItemNo = FirstFontCmd; ItemNo <= NumItems; ItemNo++)
        {
        GetItem(FontMenu, ItemNo, &fName);
        GetFNum(&fName, &fNumber);
        if (!fNumber)
            DelMenuItem(FontMenu, ItemNo);
        }
        
    msInstallMenu(FontMenu, *HandleFontMenu, false);
    
    msSetDefaultFixMenus(*DefaultFixMenus);
    
    if (g->QDVersion == 0)
        DisableItem(MoriaMenu, ColourCmd);
            
    /* Commands not yet implemented */
    DisableItem(MoriaMenu, HistoryCmd);
    DisableItem(MoriaMenu, HighScoresCmd);
    DisableItem(MoriaMenu, HelpCmd);
    msDrawMenuBar(true);
    }
   

/* ------------------------------------------------------------------------
 * CheckFinder
 *
 */

void CheckFinder(void)
    {
    short   message, count, i;
    AppFile appfile;

    CountAppFiles(&message, &count);

    for (i = 1; i <= count; i++)
        {
        GetAppFiles(i, &appfile);
        if (appfile.fType == SAVE_FTYPE)
            break;
        }

    if (i <= count)
        {
        setsavedefaults(p2cstr(appfile.fName), appfile.vRefNum);
        startsaved();
        }
    }

 
/* ------------------------------------------------------------------------
 * main
 *
 * Initialize moria and start'er up
 */

    
int main()
    {
    getstack(6000L);/*I have no idea of why this is working for 6000L*/
                    /* and not for higher values (the stack should be)
                    /* around 16K */
    
    initmacintosh();
    initwimp();
    
    restart_flag = FALSE;
    loaddata(restart_flag);
    GetVol(NULL, &applvrefnum); /* Save the application volume */
    InitCursor();
    
    if (setjmp(jb))         /* we return here from end_game with TRUE */
        restart_flag = TRUE;
    else
        CheckFinder();      /* see if we are starting with a save file */
    
    if (!Quitting)
        msStartEventLoop();

    msShutdown();
    }
    
