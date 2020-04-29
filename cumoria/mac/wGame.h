/* mac/wGame.h */

#define SCREEN_XOFFSET  4
#define SCREEN_YOFFSET  3

typedef struct
    {
    Rect        Screen;
    Rect        Bounds;
    Style       FontStyle;
    short       FontSize;
    Str255      FontName;
    int         ReversedText;
    int         InColour;
    char        UseExternal;    
    char        UseScreen;
    char        Graphics;
    }   DefaultsType, *DefaultsPtr, **DefaultsHandle;


void ChangeFontSize(short);
void ChangeFontStyle(char);
void ChangeFontNumber(short);
void ImplementFontChanges(void);