/*  MacScreen.h: THINK C interface file for MacScreen.lib
 *
 *  Copyright (c) 1992 Richard Knuckey
 *
 *  Header from MacScreen.Lib. MacScreen is a High-Level interface
 *  manager written in pascal by Richard Knuckey.
 *
 *  Permission is given for the use of this library and header file for the
 *  creation and modification of Moria. Any other use is strictly prohibited.
 *   
 *  Version 1.0a5
 *
 *  18 August 1992
 */

typedef char    BOOLEAN;            /*for compatability, pascal BOOELAN is 1 byte */
 
/* Generic Globals */

#define kButtonFrameSize    3       /* button frame’s pen size */
#define kButtonFrameInset   -4      /* inset rectangle adjustment around button */
#define kOSEvent            app4Evt /* event used by MultiFinder */
#define kSuspendResumeMessage 1     /* high byte of suspend/resume event message*/
#define kResumeMask         1       /* bit of message field for resume vs. suspend */
#define kMouseMovedMessage  0xFA    /* high byte of mouse-moved event message */
#define kNoEvents           0       /* no events mask */

#define kExtremeNeg  -32768         /* kExtremeNeg and kExtremePos are used to*/
                                    /*   set up wide open rectangles and regions*/
#define kExtremePos  32766          /* required for old region bug */

#define kOffscreenLoc  0x4000

#define kDITop      0x0050          /* kDITop and kDILeft are used to locate*/
#define kDILeft     0x0070          /*     the Disk Initialization dialogs. */


#define kScrollbarWidth  16         /* kScrollBarWidth can be used in calculating values for*/
                                    /*       control positioning and sizing.*/
#define kScrollbarAdjust  kScrollbarWidth - 1

#define kDelayTime  8       /* For the delay time when flashing the*/
                            /*       menubar and highlighting a button.*/
                            /*       8/60ths of a second*/

#define kStartPtH   2       /* offset from the left of the screen */
#define kStartPtV   2       /* offset from the top of the screen */
#define kStaggerH   16      /* staggering amounts for new windows */
#define kStaggerV   22

#define chBackspace 8       /* ASCII code for Backspace character */
#define chClear     27      /* ASCII code for Clear key (aka ESC) */
#define chDown      31      /* ASCII code for down arrow */
#define chEnd       4       /* ASCII code for the End key */
#define chEnter     3       /* ASCII code for Enter character */
#define chEscape    27      /* ASCII code for Escape (aka Clear) key */
#define chFunction  16      /* ASCII code for any function key */
#define chFwdDelete 0x7F    /* ASCII code for forward delete */
#define chHelp      5       /* ASCII code for Help key */
#define chHome      1       /* ASCII code for the Home key */
#define chLeft      28      /* ASCII code for left arrow */
#define chPageDown  12      /* ASCII code for Page Down key */
#define chPageUp    11      /* ASCII code for Page Up key */
#define chReturn    13      /* ASCII code for Return character */
#define chRight     29      /* ASCII code for right arrow */
#define chSpace     32      /* ASCII code for Space character */
#define chTab       9       /* ASCII code for Tab character */
#define chUp        30      /* ASCII code for up arrow */

/* Define these for gQDVersion */
#define kQDOriginal 0       /* Original QuickDraw */
#define kQD8Bit     1       /* 8-bit Color QuickDraw */
#define kQD32Bit    2       /* 32-bit QuickDraw */

/* item Constants */

/* EditText Flags */

#define ETnormal            0x0000  /* Simple edit field, no scroll bars */
#define ETverticalScroll    0x0001  /* Has vertical Scroll bar */
#define EThorizontalScroll  0x0002  /* Has Horizontal Scroll bar */
#define ETgrowIcon          0x0004  /* leave room for grow icon  */
#define ETviewOnly          0x0008  /* disallow editing, but allow selection */
#define ETuseStyles         0x0010  /* Use Styled text editing */
#define ETnewLineCRonly     0x0020  /* Start a new line only when CR is present.*/
#define ETnoframe           0x0040  /* Don't draw a box around the text */


/* corresponding Bits  */

#define ETverticalScrollBit     0
#define EThorizontalScrollBit   1
#define ETgrowIconBit           2
#define ETviewOnlyBit           3
#define ETuseStylesBit          4
#define ETnewLineCRonlyBit      5
#define ETnoframeBit            6


/*----------------------------------------------------------------------------*/
/*High Level window management constants*/


/* Window Descriptor flags. These constants describe the bitmap settings for
 * the flags field of both a Window Descriptor resource and a main window
 * record (msWindowType)
 */

/*Add these together to determine the correct flag value or create masks*/

#define msNormal        0x0000      /* Document, CloseBox, GrowBox*/
#define msNoCloseBox    0x0001      /* Window has no close box (noMove implies this*/
#define msNoGrow        0x0002      /* Window is not resizable (NoMove implies this*/
#define msModal         0x0004      /* Window is allways frontmost in this application layer*/
#define msNoMove        0x0008      /* Window cannot be moved (does NOT imply Modal)*/
#define msFloating      0x0010      /* Window is a floating window */
#define msAutoOK        0x0020      /* Automatcaly map return and enter to button ID1*/
#define msAutoCancel    0x0040      /* Automaticaly map Escape and command-. to button ID2 */
#define msAutoCloseOK   0x0080      /* Automaticaly close the window when button ID1 is clicked*/
#define msAutoCloseCancel   0x0100  /* Automaticaly close the window when button ID2 is clicked*/
#define msOneCopyOnly   0x0200      /* Only one window using this ID is allowed on screen at once*/
#define msPollCallback  0x0400      /* Callback proc will be called repeatedly on null events*/
#define msLowLevel      0x0800      /* Low Level window, No items, rceive events */
#define msColour        0x1000

/*Bit numbers corresponding to the above mask constants*/

#define msNoCloseBoxBit     0
#define msNoGrowBit         1
#define msModalBit          2
#define msNoMoveBit         3
#define msFloatingBit       4
#define msAutoOKBit         5
#define msAutoCancelBit     6
#define msAutoCloseOKBit    7
#define msAutoCloseCancelBit    8
#define msOneCopyOnlyBit    9
#define msPollCallbackBit   10
#define msLowLevelBit       11
#define msColourBit         12
#define msInCallBackBit     30      /*Used internaly - flag set if within a callbackproc*/
#define msPendingCloseWindowBit  31 /*Used internaly */


/*Item Kind constants*/

#define ButtonItem          1   /* push Button */
#define CheckBoxItem        2   /* Check Box */
#define RadioItem           3   /* Radio Button */
#define ResourceControlItem 4   /* control definition as found in a 'CNTL' resource */
#define StaticTextItem      5   /* Display only text */
#define EditTextItem        6   /* Editable text */
#define LineItem            7   /* gray line */
#define PICTItem            8   /* picture */
#define ProgressItem        9   /* Progress bar */
#define IconItem            10  /* Icon family in optional colour and small icon styles*/

#define MinUserItem         128 /* Item ID's 1-127 are reserved for std items */


/*Item Descriptor flags. These constants describe the bitmap settings for the flags field*/
/*of both a Item Descriptor resource and an Item record (msItemType)*/

#define iNormal     0x0000  /*Item is normal*/
#define iDisabled   0x0001  /*Item is disabled - Draw in 'greyed out' state*/
#define iHighlight  0x0002  /*Item is highlighted ie, draw thick box surrounding text or button*/
#define iAcceptKeys 0x0004  /*item accepts input from the keybard, place in keyboard item queue*/
#define iNoMouse    0x0008  /*Item doesnt not accept mouse input*/
#define iHiden      0x0010  /*Item is invisable*/

/*Bit numbers corresponding to the above mask constants*/
#define iDisabledBit    0
#define iHighlightBit   1
#define iAcceptKeysBit  2
#define iNoMouseBit     3
#define iHidenBit       4


/*Dummy item Numbers passed to window callback routines*/

#define actionNullEvent     0
#define actionDoOpenWindow  -1
#define actionDoCloseWindow -2
#define actionDoActivate    -3
#define actionDoDeactivate  -4
#define actionDoFixMenus    -5
#define actionHandleEvent   -6
#define actionDoDispose     -7
#define actionDoCreateWindow    -8


/*item Commands accepted by items*/

#define actionInitialize    1   /*parse Data retrieved from the descriptor and set up private datahandle*/
#define actionDraw          2   /*Draw the item*/
#define actionHandleMouse   3   /*Handle a mouse down event in the item*/
#define actionHandleKey     4   /*Handle a key press passed to the item*/
#define actionMouseMoved    5   /*Handle Cursor changing over the item*/
#define actionReposition    6   /*move the command to the new bounds*/
#define actionActivate      10  /*Handle Activate Event*/
#define actionDeActivate    11  /*Handle DeActivate Event*/
#define actionIdle          12  /*Do Idle Task*/
#define actionEnable        13  /*Enable the item*/
#define actionDisable       14  /*Disable the item*/
#define actionSetKeyFocus   15  /*Hilight item to show that it is the curent key focus*/
#define actionUnSetKeyFocus 16
#define actionSetHighlight  15
#define actionUnSetHighlight 16
#define actionHandleEditing             1000
#define actionHandleChangeFontNumber    1001
#define actionHandleChangeFontSize      1002
#define actionHandleChangeFontStyle     1003
#define actionDispose       2000    /*Dispose of any storage allocated by the item*/


/*Standard Editing Constants, pass these in the data field to HandleEditing*/

#define editHandleUndoCmd       1
#define editHandleCutCmd        3
#define editHandleCopyCmd       4
#define editHandlePasteCmd      5
#define editHandleClearCmd      6
#define editHandleSelectAllCmd  8


/* position constants, justification */

#define msAbsolute  0
#define msLeft      1
#define msCenter    2
#define msRight     3



/* Menu Constants, used by the High Level routines. You MUST set the MenuID's
 *  of the standard menus as defined here to these
 */

#define AppleMenuID     128
#define AboutCmd        1

#define FileMenuID      129

#define EditMenuID      130
#define UndoCmd         1
#define CutCmd          3
#define CopyCmd         4
#define PasteCmd        5
#define ClearCmd        6
#define SelectAllCmd    8

/*Compile time constants*/

/* MinimumHighLevelWindowKindID defines the minimum (*WindowPeek).WindowKind
 * value for a window to be ttrated by these routines as a High Level Window
 */

#define MinimumHighLevelWindowKindID  128


/*resource types*/

#define kWindowResourceType 'Wind'  /*Resource type where the basic window definition is found*/
#define kItemsResourceType  'Itm#'  /*Resource type of window item descriptors*/
#define kItemResourceType   'Item'  /*Resource type of one single window item descriptor*/

#define kTextResourceType   'TEXT'
#define kStyleResourceType  'styl'
#define WindowPositionType  'Wpos'


/* -------------------------------------------------------------------------- */
/* Data types */

/* Position Data types. These allow coordinates to be 'ancored' to various
 * sides of windows ormonitors, and to justify coordinates
 */
 
typedef struct {
    short   position;
    short   offset;
    }   CoordinateType;

typedef struct {
    CoordinateType  top;
    CoordinateType  left;
    CoordinateType  bottom;
    CoordinateType  right;
    } PositionType;


/*Main Item Types*/

typedef struct{
    long            flags;      /* Option flags for this item*/
    short           itemKind;   /* Type of item*/
    PositionType    position;   /* used to calculate bounds when window is resized*/
    Rect            bounds;     /* real bounds as they currently stand*/
    ProcPtr         cbProc;     /* pointer to item handler proc */
    Handle          Data;       /* private data for this item*/
    } msItemType, *msItemPtr, **msItemHandle;

typedef msItemType      msItemListType, *msItemListPtr, *msItemListHandle;


/*resource formats and indiviual item data and descriptor types*/

typedef struct {
    long            iflags;     /*options flags for this item*/
    short           iKind;      /*Type of item*/
    PositionType    iPosition;  /*determines where the control is to be drawn*/
    short           iDataSize;  /*size of following information*/
    
    /* Data pertaining to this control, Follows of length _dataSize_*/
    } ItemDescriptorType, *ItemDescriptorPtr, *ItemDescriptorHandle;
    

/* The following  types are used to define the data structures contained in
 * the data field of an item descriptor or item datahandle type
 */


/* Data types used in item types and descriptors */

typedef short   ResourceDescriptorType;     /*Resource ID chunck*/

typedef struct   {  /*Font descriptor Chunk*/
    short       FontNumber;     /*Offset to font lookup table resource for font name*/
    short       FontSize;       /*size of font*/
    Style       FontStyle;      /*Font style, as defined in Quickdraw (1 byte)*/
    SignedByte  Justification;  /*TE justification*/
    } FontDescriptorType;


typedef char TextType[230]; /*Note: NO length byte*/


typedef struct  {   /*Vaid Chars Chunck*/
    char    aMin, aMax, bMin, bMax;
    } ValidCharsType;   /*two ranges of valid chars, put NULLs if not used*/



/*Temp strings data type, replaces ^0,^1,^2 and ^3 in items*/


typedef Str255  ReplaceStringsType[4];
typedef ReplaceStringsType  *ReplaceStringsPtr;
typedef ReplaceStringsPtr   *ReplaceStringsHandle;

/*  The Following data types describe the information passed in Data when calling
    Items */
    
typedef struct
    {
    Point   where;
    long    when;
    short   modifiers;
    }   HandleMouseDataType, *HandleMouseDataPtr;
    

typedef struct
    {
    char    theChar;
    short   modifiers;
    }   HandleKeyDataType, *HandleKeyDataPtr;
    

/* Internal Menu handler Structure */
    
typedef struct
    {
    short   ID;
    ProcPtr callBackProc;
    Ptr     next;
    }   msMenuType, *msMenuPtr, **msMenuHandle;
    

/*Main Window Types*/

typedef struct {
    WindowPtr           window;
    long                flags;
    short               baseKind;
    PositionType        position;
    Rect                growRect;
    ProcPtr             callbackProc;
    ProcPtr             activateEditCallbackProc;
    short               keyFocus;
    short               enterFocus;
    msItemListHandle    items;
    Ptr                 next;
    }msWindowType, *msWindowPtr;


/*Structure of the windowResourcetype*/

typedef struct
    {
    long            wflags;     /*see WindowDefinitionFlags as defined above*/
    short           wKind;      /*must be unique for each window type, usually it's resource ID*/
    short           wBaseKind;  /*Window wkind to base position on, if zero, none defined.*/
    PositionType    wPosition;
    Rect            wMinSize, wMaxSize;
    short           witemsID;
    Str255          wTitle;
    } WindowDescriptorType, *WindowDescriptorPtr, **WindowDescriptorHandle; 


/* Wpos resource structure */

typedef struct
    {
    Rect        screen;
    Rect        window;
    }   SavedPositionType, *SavedPositionPtr, **SavedPositionHandle;
    

typedef struct
    {
    short   MachineType;        /* What Machine this is */
    short   SystemVersion;      /* System version Number */
    short   ProcessorType;      /* which CPU this is */
    BOOLEAN HasFPU;             /* true if machine has a FPU */
    short   QDVersion;          /* Major QD version number */
    short   KeyboardType;       /* Which type of kyeboard is present */
    short   AppleTalkVersion;   /* Appletalk version number */
    BOOLEAN HasPMMU;            /* true if machine has a PMMU or equivalent*/
    BOOLEAN HasWaitNextEvent;   /* true if WNE avaliable */
    short   AppResRef;          /* ref for app res file*/
    BOOLEAN InBackground;       /* true if running in background */
    OSType  Signature;          /* application's Type */
    Str255  AppName;            /* App's name */
    } StdGlobalsType, *StdGlobalsPtr;



/* Items */


/*push button, radio button and check box types*/

typedef struct
    {
    char    dTitle[230];
    } ButtonDescriptorType, *ButtonDescriptorPtr, **ButtonDescriptorHandle;


typedef struct
    {
    ControlHandle   TheControl;
    } ButtonDataType, *ButtonDataPtr, **ButtonDataHandle;



/*Edit text types*/

typedef struct {
    ResourceDescriptorType  dTextResourceID;
    FontDescriptorType      dFont;
    long                    dFlags;
    char                    dTextvInset;
    char                    dTexthInset;
    short                   dMaxChars;
    ValidCharsType          dValidChars;
    TextType                dText;
    } EditTextDescriptorType, *EditTextDescriptorPtr, **EditTextDescriptorHandle;


typedef struct {
    long            ETflags;
    short           textVInset;
    short           textHInset;
    short           maxChars;
    ValidCharsType  validChars;
    TEHandle        hTE;
    short           textLines;
    short           textWidth;
    ControlHandle   vScroll;
    ControlHandle   hScroll;
    short           hScrollGrid;
    } EditTextDataType, *EditTextDataPtr, **EditTextDataHandle;


/*Static text Types*/
typedef struct   {
    ResourceDescriptorType  dTextresourceID;
    FontDescriptorType      dFont;
    TextType                dText;
    } StaticTextDescriptorType, *StaticTextDescriptorPtr, **StaticTextDescriptorHandle;
    

typedef struct  {
    FontDescriptorType  font;
    Handle              theText;
    Handle              theStyle;
    } StaticTextDataType, *StaticTextDataPtr;
    
/*PICT*/

typedef struct {
    short   dResourceID;
    } PICTDescriptorType, *PICTDescriptorPtr;
    
typedef struct {
    PicHandle   thePICT;
    } PICTDataType, *PICTDataPtr, *PICTDataHandle;

/*Icons*/

typedef struct {
    short   dResourceID;
    } IconDescriptorType, *IconDescriptorPtr;
    
typedef struct {
    Handle  theIcon;
    } IconDataType, *IconDataPtr, *IconDataHandle;
    

/* Progress Bar */

typedef struct
    {
    short   setting;
    }   ProgressDataType, *ProgressDataPtr, **ProgressDataHandle;


/* Prototypes */

/*Generic Utilities*/

pascal StdGlobalsType* GetGlobals( void );
pascal BOOLEAN  TrapExists( short );
pascal long     GetGestaltResult( OSType );
pascal Handle   GetAppNamedResource( ResType, Str255 *, OSErr *);
pascal Handle   GetAppIndResource (ResType, short, OSErr *);
pascal Handle   GetAppResource (ResType, short, OSErr *);
pascal void     PullApplicationToFront(void);

/*Screen Utilities*/
pascal Rect     msDetermineWindowBounds( WindowDescriptorPtr );
pascal Rect     msDetermineItemBounds( PositionType*, msWindowPtr );
pascal void     msFixWindowPosition( msWindowPtr );
pascal short    MModalprocID(void);
pascal BOOLEAN  TestFlags (long, long);
pascal void     GlobalToLocalRect ( Rect* );
pascal void     LocalToGlobalRect ( Rect* );
pascal BOOLEAN  CompareRect( Rect*, Rect* );
pascal long     MakeEven (long);
pascal short    ByteToInteger ( Byte);
pascal long     ByteToLongint ( Byte);
pascal BOOLEAN  CallHighLevelWindow(msWindowPtr, short, short);
pascal BOOLEAN  CallLowLevelWindow( msWindowPtr, short, EventRecord* );
pascal BOOLEAN  EventCallBack(msWindowPtr, short);
pascal WindowPtr ScanWindowList (short);

/* function for Items */
pascal void     ItemCallBack ( msWindowPtr, short*, short*);

/*procedures specific to iButton, iCheck and iRadio types*/
pascal BOOLEAN  GetButtonState ( msWindowPtr, short);
pascal void     SetButtonState (msWindowPtr, short, BOOLEAN);

pascal void     GetItemTitle ( msWindowPtr, short, Str255 *);
pascal void     SetItemTitle ( msWindowPtr, short, Str255);

pascal Handle   GetStaticTextHandle( msWindowPtr, short );
pascal Handle   GetStaticTextStyleHandle( msWindowPtr, short );
pascal void     SetStaticTextHandle( msWindowPtr, short, Handle, BOOLEAN);
pascal void     SetStaticTextStyleHandle( msWindowPtr, short, Handle, BOOLEAN);
pascal void     GetStaticTextString( msWindowPtr, short, Str255 *);
pascal void     SetStaticTextString( msWindowPtr, short, Str255 *);

pascal TEHandle GetEditTextTEHandle( msWindowPtr, short );
pascal Handle   GetEditTextHandle( msWindowPtr, short );
pascal void     SetEditTextHandle( msWindowPtr, short, Handle, BOOLEAN);
pascal void     RecalculateEditText( msWindowPtr, short);

pascal void     UpdateProgress ( msWindowPtr, short, long, long);

/* Initialisation and allocation of items */
pascal short    msNewitem (msWindowPtr, ItemDescriptorHandle);
pascal short    msGetItem (short,  msWindowPtr);
pascal void     msGetItems (short,  msWindowPtr);

/* Disposing */
pascal void     msDisposeItem (msWindowPtr, short);
pascal void     msDisposeItems (msWindowPtr);

/* Item Display and manipulation */
pascal msItemHandle msGetItemHandle ( msWindowPtr, short);
pascal void     HiliteItem ( msWindowPtr, short, short);
pascal void     msDrawItem ( msWindowPtr, short);
pascal void     msDrawitems ( msWindowPtr);
pascal void     ActivateItem ( msWindowPtr, short, BOOLEAN);
pascal void     ActivateItems ( msWindowPtr, BOOLEAN);
pascal void     msEnableItem ( msWindowPtr, short,  BOOLEAN);
pascal void     IdleItem( msWindowPtr, short);
pascal void     IdleItems( msWindowPtr);
pascal void     DetermineKeyFocus(msWindowPtr, BOOLEAN);
pascal void     SetKeyFocus (msWindowPtr, short);
pascal void     ItemKey( msWindowPtr, char, short );
pascal void     msRepositionItem( msWindowPtr, short);
pascal void     msRepositionItems ( msWindowPtr);

/*Text Edit*/
pascal void     InstallActivateEditProc ( msWindowPtr, ProcPtr);
pascal void     ActivateEditing (msWindowPtr, BOOLEAN);
pascal void     HandleTextEditFunction ( msWindowPtr, short, short);

/* Low Level */
pascal void     msCallItem(msWindowPtr, short, Ptr);
pascal void     msInstallItemProc(msWindowPtr, short, ProcPtr);


/*Initialisation*/
pascal void     msInitialise (short, short, ProcPtr);
pascal void     msShutdown(void);

/*Event Processing*/
pascal void     msStartEventLoop(void);
pascal void     msStopEventLoop(void);
pascal void     msDo1Event(void);

pascal void     msSetEventMask (short);
pascal void     msGetEventMask (short *);
pascal void     msSetYieldTime (short);
pascal void     msSetBackground ( ProcPtr);
pascal void     msGetBackground ( ProcPtr *);
pascal void     msSetEventHook ( ProcPtr);
pascal void     msGetEventHook ( ProcPtr *);
pascal void     msSetSuspend (ProcPtr);
pascal void     msGetSuspend ( ProcPtr *);
pascal void     msSetMouseMoved ( ProcPtr);
pascal void     msGetMouseMoved (ProcPtr *);
pascal void     msSetMouseRgn (RgnHandle);
pascal void     msGetMouseRgn ( RgnHandle *);
pascal void     msHighLevelEventHook (ProcPtr);
pascal void     msGetHighLevelEventHook (ProcPtr *);


/*Menu Handling*/
pascal void     msInstallAppleMenu (ProcPtr);
pascal void     msInstallMenu (MenuHandle, ProcPtr, BOOLEAN);
pascal void     msRemoveMenu (short);
pascal void     msSetDefaultFixMenus ( ProcPtr);
pascal void     msGetDefaultFixMenus ( ProcPtr *);
pascal void     msDrawMenuBar (BOOLEAN);


/*  Window Handling */
pascal msWindowPtr  msNewWindow ( WindowDescriptorHandle,  ProcPtr);
pascal msWindowPtr  msGetWindow ( short, ProcPtr);
pascal msWindowPtr  msInstallWindow ( WindowPtr, ProcPtr );
pascal BOOLEAN      msCloseWindow ( WindowPtr);
pascal void         msRemoveWindow (WindowPtr);


/*procedure msSetReplacementText (Str0, Str1, Str2, Str3: stringHandle);*/

pascal Handle GetPreference (OSType, short);
pascal OSErr  AddPreference (OSType, short, Handle);
pascal OSErr  DeletePreference (Handle);
pascal void   UpdatePreferences(void);


