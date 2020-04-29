/* mac/wGame.c */

/* Written by Richard Knuckey
 *
 * Copyright (c) 1992 Richard Knuckey
 */

#include <MacHeaders>
#include "MacScreen.h"
#include "config.h"
#include "constant.h"
#include "types.h"
#include "externs.h"
#include "colour.h"
#include "wGame.h"
#include "wRecall.h"
#include "mac.h"


WindowPtr       MainWindow;
BOOLEAN         MainWindow_ExitGame;
short           FontNumber = monaco;
Str255          DefaultFontName = "\pMonaco";
short           FontWidth;
short           FontHeight;
short           FontBaseline;
int             FixedWidthFont;
DefaultsHandle  Defaults;
Handle          KCHRresource;
long            trans_state;

extern  int GameCanAcceptCommands;  /* from macFrontEnd.c */
extern  colour_entry    colours[];      /* from colours.c */
extern  MenuHandle  FontMenu, MoriaMenu;        /* from macFrontEnd.c */
extern  StdGlobalsType  * g;        /*macFrontEnd.c*/
extern  msWindowPtr     OptionWindow;
extern  msWindowPtr     FontSizeWindow;
extern  int             optionwindowopen;
extern  int             fontsizewindowopen;


/* Key handling globals, we wait in screen_getkey until MainWindow_Key
 * recieves a keypress MainWindow_Key is set to 0 unitl a key is pressed.
 * upon a keypress we set MainWindow_theKey to the key pressed.
 */
 
char    MainWindow_theKey = 0;

 
/* Utility Routine */

CopyPStr(a, b)
char    *a, *b;
    {
    char    length, i;
    
    for (length = *a, i = 0; i <= length; i++)
        *b++ = *a++;
    }
 
 
void    ChangeFontSize(short newSize)
    {
    switch ((**Defaults).FontSize)
        {
        case 9:
            CheckItem(FontMenu, p9Cmd, FALSE);
            break;
        case 10:
            CheckItem(FontMenu, p10Cmd, FALSE);
            break;
        case 12:
            CheckItem(FontMenu, p12Cmd, FALSE);
            break;
        case 14:
            CheckItem(FontMenu, p14Cmd, FALSE);
            break;
        case 18:
            CheckItem(FontMenu, p18Cmd, FALSE);
            break;
        default:
            CheckItem(FontMenu, OtherSizeCmd, FALSE);
        }
        
    switch (newSize)
        {
        case 9:
            CheckItem(FontMenu, p9Cmd, TRUE);
            break;
        case 10:
            CheckItem(FontMenu, p10Cmd, TRUE);
            break;
        case 12:
            CheckItem(FontMenu, p12Cmd, TRUE);
            break;
        case 14:
            CheckItem(FontMenu, p14Cmd, TRUE);
            break;
        case 18:
            CheckItem(FontMenu, p18Cmd, TRUE);
            break;
        default:
            CheckItem(FontMenu, OtherSizeCmd, TRUE);
            break;
        }
        (**Defaults).FontSize = newSize;
    }
 
void ChangeFontStyle(char newStyle)
    {
    (**Defaults).FontStyle = (Style)newStyle;
    CheckItem(FontMenu, PlainCmd, newStyle ? FALSE: TRUE);
    CheckItem(FontMenu, BoldCmd,  newStyle ? TRUE:  FALSE); 
    }
 
void ChangeFontNumber(short newNumber)
    {
    FontNumber = newNumber;
    
    SetItemStyle(FontMenu, p9Cmd,  RealFont(newNumber, 9 ) ? outline: 0);
    SetItemStyle(FontMenu, p10Cmd, RealFont(newNumber, 10) ? outline: 0);
    SetItemStyle(FontMenu, p12Cmd, RealFont(newNumber, 12) ? outline: 0);
    SetItemStyle(FontMenu, p14Cmd, RealFont(newNumber, 14) ? outline: 0);
    SetItemStyle(FontMenu, p18Cmd, RealFont(newNumber, 18) ? outline: 0);   
    }
    
 int    InitFontSelection (void)
    {
    short   ItemNo, NumItems, fNumber;
    Str255  fname;
    extern  short   FontSelection;
    
    NumItems = CountMItems(FontMenu);
    for (ItemNo = FirstFontCmd; ItemNo <= NumItems; ItemNo++)
        {
        GetItem(FontMenu, ItemNo, &fname);
        if (EqualString(&fname, &((**Defaults).FontName) ,FALSE,TRUE))
            {
            GetFNum(&fname, &fNumber);
            if (fNumber)
                {
                FontSelection = ItemNo;
                CheckItem(FontMenu, ItemNo, TRUE);
                ChangeFontNumber(fNumber);
                return TRUE;
                }
            }
        }
    return FALSE;
    }
    
void UpdateDefaults(void)
    {
    (**Defaults).Screen = screenBits.bounds;
    ChangedResource(Defaults);
    UpdatePreferences();
    }
    
void InitDefaults(void)
    {
    (**Defaults).FontStyle = 0;
    (**Defaults).FontSize = 9;
    CopyPStr(&DefaultFontName, &(**Defaults).FontName);
    (**Defaults).ReversedText = FALSE;
    (**Defaults).InColour = FALSE;
    (**Defaults).UseExternal = FALSE;
    (**Defaults).UseScreen = TRUE;
    (**Defaults).Graphics = FALSE;
    }
    
int GetDefaults(void)
    {
    Defaults = (DefaultsHandle)GetPreference(DefaultsResourceType, DefaultsResourceID);
    if (Defaults == 0L)
        {
        Defaults = (DefaultsHandle)NewHandle(sizeof(DefaultsType));
        InitDefaults();
        (void)AddPreference(DefaultsResourceType, DefaultsResourceID, Defaults);
        
        return TRUE;
        }
    else
        return FALSE;
    }

void ImplementFontChanges(void)
    {
    FontInfo    FontMetrics;
    FontRec     **theFont;

    
    SetPort(MainWindow);
    TextFont(FontNumber);
    TextFace((**Defaults).FontStyle);
    TextSize((**Defaults).FontSize);
    GetFontInfo(&FontMetrics);
    FontBaseline = FontMetrics.ascent + FontMetrics.leading;
    FontHeight = FontBaseline + FontMetrics.descent;
    FontWidth = CharWidth(' ');
    
    SizeWindow(MainWindow, SCREEN_XOFFSET*2 + (SCREEN_COLS-1)*FontWidth, 
                           SCREEN_YOFFSET*2 + SCREEN_ROWS*FontHeight, true);
    
    /* We size the window at SCREEN_COLS - 1 since Moria never writes to
       the last column, thus we can save a few pixels of screen space */
      
    UpdateDefaults();
    
    ValidRect(&(MainWindow->portRect));
    EraseRect(&(MainWindow->portRect));
    screen_redraw(); 
    }
        
    
/* ------------------------------------------------------------------------
 * KeyTransEventHook
 *
 * This intercepts an event and remaps the keyboard using the KCHR we
 * loaded in initwimp. It calls KeyTrans, to translate vitual keycodes
 * to ASCII values. This is only called on keyboards without an Escape
 * or control keys such as on a MacPlus. The KCHR maps the control key
 * to the option key and the tilde key to the escape key. This will work
 * even under system 7.0 since we are forcing a keytranslation instead
 * of simply setting the system wide KCHR, which under system 7.0 requires
 * the KCHR resource to be in the system for reasons discussed in
 * Inside Macintosh VI pp 14-96
 */

RemapKeys(theEvent)
EventRecord *theEvent;
    {
    short   keycode;
    char    *p, *q;     /* used for byte level acces to variables */
    long    ascii_code;
    
    p = &keycode;
    
    q = &theEvent->message;
    p[1] = q[2];
    
    q = &theEvent->modifiers;
    p[0] = q[0];
    
    ascii_code = KeyTrans(*KCHRresource,keycode,&trans_state);
    
    p = &ascii_code;
    theEvent->message = p[3];
    }


void    CreateWindow(msWindowPtr theWindow, WindowDescriptorPtr descriptor)
    {
    Rect    bounds;
    
    bounds = msDetermineWindowBounds(descriptor);
    if (g->QDVersion)
        MainWindow = NewCWindow(NULL, &bounds, descriptor->wTitle,
            FALSE, noGrowDocProc, (Ptr)-1L, TRUE, 0);
    else
        MainWindow = NewWindow(NULL, &bounds, descriptor->wTitle,
            FALSE, noGrowDocProc, (Ptr)-1L, TRUE, 0);
        
    theWindow->window = MainWindow;
    
    (void)GetDefaults();
    if (EqualRect(&(**Defaults).Screen, &screenBits.bounds) == 0)
        InitDefaults();

    SetPort(MainWindow);
    if (!InitFontSelection())
        {
        CopyPStr(&DefaultFontName, &(**Defaults).FontName);
        if (!InitFontSelection())
            SysBeep(5);
        }

    ChangeFontSize((**Defaults).FontSize);
    ChangeFontStyle((**Defaults).FontStyle);
    ImplementFontChanges();
    }
    
pascal BOOLEAN HandleMainWindow(msWindowPtr theWindow,
                                    short itemHit, EventRecord *theEvent)
    {
    char    theChar;
    
    switch (itemHit)
        {
        case actionDoCreateWindow:
            CreateWindow(theWindow, (WindowDescriptorPtr)(theWindow->next));
            break;
            
        case actionDoOpenWindow:
            if (g->QDVersion)
                TextMode(srcOr);
            else  
                TextMode(srcXor);   
        
            if ((**Defaults).ReversedText)
                {
                CheckItem(MoriaMenu, ReverseCmd, TRUE);
                CheckItem(MoriaMenu, ColourCmd, FALSE);
                if (g->QDVersion)
                    {       
                    RGBColor    Color;
            
                    (**Defaults).InColour = FALSE;
                    Color.red = Color.green = Color.blue = 65535;
                    RGBForeColor(&Color);
                    Color.red = Color.green = Color.blue = 0;
                    RGBBackColor(&Color);
                    EraseRect(&(MainWindow->portRect));
                    }
                else
                    { 
                    PenPat(white);
                    BackPat(black);
                    InvertRect(&(MainWindow->portRect));
                    }
                }
    
            if ((**Defaults).InColour)
                {
                if (g->QDVersion)
                    {
                    RGBColor    Color;
            
                    Color.red = Color.green = Color.blue = 0;
                    RGBBackColor(&Color);
                    CheckItem(MoriaMenu, ColourCmd, TRUE);
                    DisableItem(MoriaMenu, ReverseCmd);
                    CheckItem(MoriaMenu, ReverseCmd, FALSE);
                    (**Defaults).ReversedText = FALSE;
                    EraseRect(&(MainWindow->portRect));
                    }
                else
                    (**Defaults).InColour = FALSE;
                }
            ValidRect(&(MainWindow->portRect));
            break;
            
        case actionDoCloseWindow:
            if (!MainWindow_ExitGame)
                { 
                switch (GameCanAcceptCommands)
                    {
                    case 0: /* Unable to Save => Report Error */
                        SysBeep(5);
                        break;
            
                    case 1: /* Able to save => fake up save command */
                        MainWindow_theKey = CTRL('X');
                        break;
            
                    case 2: /* In Create Character => fake up exit game */
                        MainWindow_theKey = CTRL('C');
                        break;
                    }
                }
            else
                {
                if (recallwindowopen)
                    closerecallwindow();
                if (optionwindowopen)
                    msCloseWindow(OptionWindow->window);
                if (fontsizewindowopen)
                    msCloseWindow(FontSizeWindow->window);
                SetPort(theWindow->window); /* Set Port back */
                }
            
            return (MainWindow_ExitGame);
            
        
        case actionDoDispose:
            DisposeWindow(MainWindow);
            break;
            
        case actionDoFixMenus:
            msDrawMenuBar(true);
            break;
            
        case actionHandleEvent:
            switch (theEvent->what)
                {
                case keyDown:
                case autoKey:
                    ObscureCursor();
                    if (g->KeyboardType <= envMacPlusKbd)
                        RemapKeys ( theEvent );
                    
                    theChar = (char)(theEvent->message & charCodeMask);
                    
                    switch (theChar)
                        {
                        case chEnter:   MainWindow_theKey = chReturn;   break;
                        case chLeft:    MainWindow_theKey = '4';        break;
                        case chRight:   MainWindow_theKey = '6';        break;
                        case chUp:      MainWindow_theKey = '8';        break;
                        case chDown:    MainWindow_theKey = '2';        break;
                        case '`':       MainWindow_theKey = chEscape;   break;
                        
                        default:        MainWindow_theKey = theChar;
                        }
                    break;
                    
                case updateEvt:
                    EraseRect(&(MainWindow->portRect));
                    screen_redraw();
                    break;
                    
                default:
                    ;
                }
            break;
            
        default:
            ;
        }
    return(TRUE);
    }
    
    
void Open_MainWindow(void)
    {
    MainWindow_ExitGame = FALSE;
    (void) msGetWindow( MainWindowID, *HandleMainWindow);
    msDrawMenuBar(true);
    }


void Close_MainWindow(void)
    {
    SetPort(MainWindow);
    UpdateDefaults();
    MainWindow_ExitGame = TRUE;
    msCloseWindow(MainWindow);
    MainWindow = 0L;
    FixFileMenu();
    }
