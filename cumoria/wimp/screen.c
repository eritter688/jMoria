/*  wimp/screen.c
 *
 *  Written by Edouard Poor and Richard Knuckey
 *
 *  Copyright (c) 1992 Edouard Poor and Richard Knuckey
 */
 
#ifdef THINK_C
#include <MacHeaders>
#endif

#ifdef ARC_RISCOS2
 #include "^.source.config.h"
 #include "^.source.constant.h"
 #include "^.source.types.h"
 #include "^.source.externs.h"
#ifdef COLOUR_GFX
 #include "^.colour.colour.h"
#endif
 #include "^.wimp.screen.h"
 #include "^.arc.gfx.h"
 #include "^.arc.wimpdata.h"  /*  for rect */
 #include "^.arc.wimpfuncs.h"  /* for Wimp_Poll */
 #include "^.arc.colourtran.h"
#else
 #include "config.h"
 #include "constant.h"
 #include "types.h"
 #include "externs.h"
#ifdef COLOUR_GFX
 #include "colour.h"
#endif
 #include "screen.h"
#endif
/*#include <string.h>*/


#ifdef MAC
#include "mac.h"
#include "wGame.h"
extern  int GameCanAcceptCommands;  /* from macFrontEnd.c */
extern  colour_entry    colours[];      /* from colours.c */
extern  DefaultsHandle  Defaults;       /* mac.c*/
extern  char            MainWindow_theKey;
extern  WindowPtr       MainWindow;
extern  short           FontNumber;
extern  short           FontWidth;
extern  short           FontHeight;
extern  short           FontBaseline;
extern  int             FixedWidthFont;

screenstruct    screen;
extern DefaultsHandle   Defaults;

#endif

extern screenstruct screen;                           /* from frontend.c */
#ifdef ARC_RISCOS2
extern void dispatchpoll(eventinfo *);                /*        ''       */
extern windowhandle mainwindowhandle;                 /*        ''       */
extern void converttextrect(rect *, coord *, rect *); /*        ''       */
extern colour_entry colours[];
extern int DrawingStyle;
#endif


void screen_erase(rect *area)
    {
    unsigned char a;
    int           xloop, yloop;

    a = screen.currentattr;

    for(xloop = area->min.x; xloop <= area->max.x; xloop++)
      for(yloop = area->min.y; yloop <= area->max.y; yloop++)
        {
        screen.text.array[yloop][xloop] = ' ';
        screen.attr.array[yloop][xloop] = a;
        }

    screen_invalidate(area);
    }
    

void screen_invalidateline(int row, int left, int right)
    {
    int        loop;
    int        freeelement;
    BOOL       found = FALSE;
    int        foundpos = -1;

#define ELEMENT screen.invalid.array[row]

    if(screen.invalid.free[row] == 0)
        {
        if(left < ELEMENT[0].left)
            ELEMENT[0].left = left;
        else
            left = ELEMENT[0].left;
          
        if(right > ELEMENT[0].right)
            ELEMENT[0].right = right;
        else
            right = ELEMENT[0].right;
    
        found    = TRUE;
        foundpos = 0;
        }

    for(loop = 0; loop < INVALID_CHUNKS; loop++)
        {
        if(foundpos == loop) continue; /* gack... */

        if(ELEMENT[loop].used)
            {
            if(!(right < ELEMENT[loop].left - INVALID_MINDIST ||
                 left > ELEMENT[loop].right + INVALID_MINDIST))
                {
                if(found)
                    {
                    if(left < ELEMENT[loop].left)
                        ELEMENT[foundpos].left = left;
                    else
                        ELEMENT[foundpos].left = left = ELEMENT[loop].left;

                    if(right > ELEMENT[loop].right)
                        ELEMENT[foundpos].right = right;
                    else
                        ELEMENT[foundpos].right = right = ELEMENT[loop].right;
        
                    ELEMENT[loop].used = FALSE;
                    screen.invalid.free[row]++;
                    }
                else
                    {
                    if(left < ELEMENT[loop].left)
                        ELEMENT[loop].left = left;
                    else
                        left = ELEMENT[loop].left;

                    if(right > ELEMENT[loop].right)
                        ELEMENT[loop].right = right;
                    else
                        right = ELEMENT[loop].right;
            
                    found    = TRUE;
                    foundpos = loop;
                    }
                }
           }
        else
          freeelement = loop;
        }

    if(found == FALSE)
        {
        screen.invalid.free[row]--;
        ELEMENT[freeelement].left  = left;
        ELEMENT[freeelement].right = right;
        ELEMENT[freeelement].used  = TRUE;
        }
#undef ELEMENT
    }


void screen_invalidate (rect *area)
    {
    int yloop;

    for(yloop = area->min.y; yloop <= area->max.y; yloop++)
        {
        screen_invalidateline(yloop, area->min.x, area->max.x);
        }
    }


void screen_getcharattr(char *c, attr *a, int col, int row)
    {
    *c = screen.text.array[row][col];
    *a = screen.attr.array[row][col];
    }


void screen_getcursor(int *x, int *y)
    {
    *x = screen.cursor.x;
    *y = screen.cursor.y;
    }
    

void screen_clearinvalidline(int line)
    {
    int iloop;
    
    for(iloop = 0; iloop < INVALID_CHUNKS; iloop++)
        {
        screen.invalid.array[line][iloop].used = FALSE;
        screen.invalid.array[line][iloop].left = 0;
        screen.invalid.array[line][iloop].right = SCREEN_COLS-1;
        }
    
    screen.invalid.free[line] = INVALID_CHUNKS;
    }
    

void screen_clearinvalid(rect *area)
    {
    int yloop;
    
    for(yloop = area->min.y; yloop < area->max.y; yloop++)
        screen_clearinvalidline(yloop);
    }


void screen_redraw(void)
    {
    rect area;
    
    area.min.x = 0;
    area.min.y = 0;
    area.max.x = SCREEN_COLS-1;
    area.max.y = SCREEN_ROWS-1;
    
    screen_invalidate(&area);
    screen_update();
    }
    
    
void screen_restore(void)
    {
    int x, y, left, right;

    for(y = 0; y < SCREEN_ROWS; y++)
        {
        left = right = -1; /* cheap hack */

        for(x = 0; x < SCREEN_COLS; x++)
            {
            if(screen.text.array[y][x] != screen.savedtext.array[y][x])
                {
                if(left == -1  || left > x)   left = x;
                if(right == -1 || right < x)  right = x;
                }
            }
        if(left != -1)
            screen_invalidateline(y, left, right);
        }

    for(y = 0; y < SCREEN_ROWS; y++)
        for(x = 0; x < SCREEN_COLS; x++)
            screen.text.array[y][x] = screen.savedtext.array[y][x];

    for(y = 0; y < SCREEN_ROWS; y++)
        for(x = 0; x < SCREEN_COLS; x++)
            screen.attr.array[y][x] = screen.savedattr.array[y][x];
    }
    
    
void screen_save(void)
    {
    int x,y;

    for(y = 0; y < SCREEN_ROWS; y++)
        for(x = 0; x < SCREEN_COLS; x++)
            screen.savedtext.array[y][x] = screen.text.array[y][x];

    for(y = 0; y < SCREEN_ROWS; y++)
        for(x = 0; x < SCREEN_COLS; x++)
            screen.savedattr.array[y][x] = screen.attr.array[y][x];
    }
    
    
void screen_setcharattr(char c , attr a, int col, int row)
    {
    screen.text.array[row][col] = c;
    screen.attr.array[row][col] = a;
    
    screen_invalidateline(row, col,col);
    }
    

void screen_setcursor(int col, int row)
    {
    screen.cursor.x = col;
    screen.cursor.y = row;
    }


void screen_sleep(unsigned int time)
    {
    }


void screen_writecharattr(char c, unsigned char a)
    {
    int row, col;

    col = screen.cursor.x;
    row = screen.cursor.y;

    screen.text.array[row][col] = c;
    screen.attr.array[row][col] = a;
    
    

    screen_invalidateline(row, col, col);

    col++; 
    if(col == SCREEN_COLS)       /* I'm not really sure how nessessary */
        {                        /* all this is, but it can't hurt...  */
        col = 0;
        row++;
        if(row == SCREEN_ROWS)
            row--;
        }
    screen.cursor.x = col;
    screen.cursor.y = row;
    }


void screen_writestring(char *s)
    {
    int row, col;
    int attr;
    int start_col, end_col;

    attr = screen.currentattr;
    col  = screen.cursor.x;
    row  = screen.cursor.y;

    while (*s)
        {
        if (screen.text.array[row][col] != *s || screen.attr.array[row][col] != attr)
            break;
        s++;
        col++;
        }
    start_col = col;
        
    end_col = col-1;
    while (*s)
        {
        if (screen.text.array[row][col] !=*s || screen.attr.array[row][col] != attr)
            {
            end_col = col+1;
            screen.text.array[row][col] = *s;
            screen.attr.array[row][col] = attr;
            }
        s++;
        col++;
        }
        
    if (start_col < end_col)
        {
        if(end_col >= SCREEN_COLS)
            end_col = SCREEN_COLS-1;

        screen_invalidateline(row, start_col, end_col);
        
        if(col >= SCREEN_COLS)    /* I'm not really sure how nessessary */
            {                     /* all this is, but it can't hurt...  */
            col = 0;
            row++;
            if(row == SCREEN_ROWS)
                row--;
            }
        }
    screen.cursor.x = col;
    screen.cursor.y = row;
    }


void screen_writestringattr(char *s, attr a)
    {
    attr oldattr;

    oldattr            = screen.currentattr;
    screen.currentattr = a;

    screen_writestring(s);

    screen.currentattr = oldattr;
    }


void screen_setcurrentattr(attr foreground, attr background)
    {
    screen.currentattr = foreground;
    }


void screen_getcurrentattr(attr *foreground)
    {
    *foreground = screen.currentattr;
    }



/***************************************************************************
 *                                                                         *
 *  The code below this point is that which has to have some knowledge of  *
 *  the underlying operating system, so therefore needs specific code      *
 *  for each platform.                                                     *
 *                                                                         *
 ***************************************************************************/

void screen_beep(void)
    {
#ifdef MAC
    SysBeep(5);
#endif

#ifdef ARC_RISCOS2
    unsigned char beep[1] = 7;
    GFX_WriteN(&beep[0],1);    
#endif
    }


int screen_getkey(char *key, int immediatereturn)
    {
#ifdef MAC
    static  int lastcommandstate;
    
    if (GameCanAcceptCommands != lastcommandstate)
        {
        lastcommandstate = GameCanAcceptCommands;
        FixFileMenu();
        }
    
    if (! immediatereturn)
        while (MainWindow_theKey == 0)
            msDo1Event();
    else
        {
        msSetYieldTime(1);
        msDo1Event();
        msSetYieldTime(20);
        }
        
    *key = MainWindow_theKey;
    MainWindow_theKey = 0;
    
    if (!character_generated && *key == CTRL('C'))
        exit_game();
        
    if (*key == 0)
        return(false); 
    else
        return(true);
#endif

#ifdef ARC_RISCOS2
    eventmask mask = 0;
    eventinfo event;
    int       keypressed;

    while(TRUE)
        {
        Wimp_Poll(&event, mask);

        keypressed = -1;

        if(event.type == Key_Pressed)
            keypressed = event.data.key.code;

        /* 
         *  Translate the cursor keys to 
         *  numerical keypad numbers
         *  Also change Page Up/Down to
         *  being '>' and '<'
         */
        switch(keypressed)
            {
            case 0x18c: keypressed = '4';
                        break;
            case 0x18d: keypressed = '6';
                        break;
            case 0x18e: keypressed = '2';
                        break;
            case 0x18f: keypressed = '8';
                        break;
            case 0x19e: keypressed = '>';
                        break;
            case 0x19f: keypressed = '<';
                        break;
            }

        if(keypressed<=255 && keypressed>= 0) /* is it a legal char? */
            {
            *key = (char) keypressed;
            return TRUE;
            }
        else
            {
            *key = 0;
            dispatchpoll(&event);
            if(immediatereturn)
                return FALSE;
            }
        }
#endif
    }


void screen_update()
    {
#ifdef MAC
    short           col, row, left, right, colstart, lastattr, iloop;
    Rect            BackArea;
    RGBColor        Color;
    unsigned short  R, G, B;
    unsigned char   index;
    unsigned char   *p;
    register    BitMap      *cBit;
    
    SetPort(MainWindow);
    for (row = 0; row < SCREEN_ROWS; row++)
        {
        if (screen.invalid.free[row] == INVALID_CHUNKS)
            continue;
    
        for(iloop = 0; iloop < INVALID_CHUNKS; iloop++)
            if(screen.invalid.array[row][iloop].used)
                {
                left = screen.invalid.array[row][iloop].left;
                right = screen.invalid.array[row][iloop].right;
                    
                BackArea.left   = SCREEN_XOFFSET + left * FontWidth;
                BackArea.top    = SCREEN_YOFFSET + row*FontHeight;
                BackArea.right  = SCREEN_XOFFSET + (right+1) * FontWidth;
                BackArea.bottom = SCREEN_YOFFSET + (row+1) * FontHeight;
                EraseRect(&BackArea);
        
                MoveTo(SCREEN_XOFFSET + left * FontWidth,
                        SCREEN_YOFFSET + FontBaseline + row * FontHeight);
        
                if ((**Defaults).InColour)
                    {
                    col = left;
                    while (col <= right)
                        {
                        colstart = col;
                        lastattr = (int) screen.attr.array[row][col++];
                        while(col <= right &&
                            (screen.text.array[row][col] == 32 ||
                            lastattr == screen.attr.array[row][col]))
                            col++;
                        
                        index = screen.attr.array[row][colstart];
                        R = (unsigned short) colours[index].R;
                        G = (unsigned short) colours[index].G;
                        B = (unsigned short) colours[index].B;
                        Color.red   =  R | R << 8;
                        Color.green =  G | G << 8;
                        Color.blue  =  B | B << 8;
                    
                        RGBForeColor(&Color);
                        DrawText(&screen.text.array[row][0], colstart, col - colstart);
                        }
                    }
                else
                    DrawText(&screen.text.array[row][0], left, right - left +1);
                }           
                
        screen_clearinvalidline(row);                   
    }
#endif

#ifdef ARC_RISCOS2
    BOOL        more;
    redrawinfo  redraw;
    updateinfo  update;
    windowstate state;
    coord       offset;
    int         yloop,iloop;
    screenarray text, attr;
    rect        textrect;
    extern int  waitonupdate;  /* Do we WAIT on each update? */

    text = screen.text;
    attr = screen.attr;

    state.handle = mainwindowhandle;
    Wimp_GetWindowState(&state);
    Wimp_ScreenToWindowOffsets(&state, &offset);

    if(waitonupdate) GFX_Wait();
    for(yloop = 0; yloop < SCREEN_ROWS; yloop++)
        {
        if(screen.invalid.free[yloop] == INVALID_CHUNKS)
            continue;

        for(iloop = 0; iloop < INVALID_CHUNKS; iloop++)
            if(screen.invalid.array[yloop][iloop].used)
                {
                textrect.min.x = screen.invalid.array[yloop][iloop].left;
                textrect.max.x = screen.invalid.array[yloop][iloop].right;
                textrect.min.y = textrect.max.y = yloop;
         
                converttextrect(&textrect, &offset, &update.invalid);
         
                update.windowhandle = mainwindowhandle;
         
                Wimp_UpdateWindow(&update, &more);
                while(more)
                    {
                    Wimp_SetColour(0x87);  /* background */
         
                    if(DrawingStyle == BLACK_AND_WHITE)
                        {
                        Wimp_SetColour(0x00);  /* foreground */
                        GFX_CLG(); /* a rectangle fill would be better */
                        GFX_Move(SCREEN_XCHAROFFSET + offset.x + textrect.min.x * SCREEN_XCHARSIZE,
                                 SCREEN_YCHAROFFSET + offset.y + -yloop         * SCREEN_YCHARSIZE);
                        GFX_WriteN(&text.array[yloop][textrect.min.x], textrect.max.x - textrect.min.x + 1);
                        }
         
                    if(DrawingStyle == WHITE_AND_BLACK)
                        {
                        Wimp_SetColour(0x80);
                        Wimp_SetColour(0x07);  /* foreground */
                        GFX_CLG(); /* a rectangle fill would be better */
                        GFX_Move(SCREEN_XCHAROFFSET + offset.x + textrect.min.x * SCREEN_XCHARSIZE,
                                 SCREEN_YCHAROFFSET + offset.y + -yloop         * SCREEN_YCHARSIZE);
                        GFX_WriteN(&text.array[yloop][textrect.min.x], textrect.max.x - textrect.min.x + 1);
                        }
         
                    if(DrawingStyle == WIMP_SET_COLOUR)
                        {
                        GFX_CLG(); /* a rectangle fill would be better */
                        GFX_Move(SCREEN_XCHAROFFSET + offset.x + textrect.min.x * SCREEN_XCHARSIZE,
                                 SCREEN_YCHAROFFSET + offset.y + -yloop         * SCREEN_YCHARSIZE);
         
                            {
                            register int xloop = textrect.min.x; /* Nasty Jason, nasty... */
                            register int xloopstart, lastattr;
                            while (xloop <= textrect.max.x)
                                {
                                xloopstart = xloop;
                                lastattr = (int) attr.array[yloop][xloop++];
                                while(xloop <= textrect.max.x &&
                                      (text.array[yloop][xloop] == 32 ||
                                      colours[lastattr].L == colours[attr.array[yloop][xloop]].L))
                                    xloop ++;
         
                                Wimp_SetColour((int) colours[attr.array[yloop][xloopstart]].L);
                                GFX_WriteN(&text.array[yloop][xloopstart], xloop - xloopstart);
                                }
                            }
                        }
         
                    if(DrawingStyle == COLOUR_TRANSED)
                        {
                        GFX_CLG(); /* a rectangle fill would be better */
                        GFX_Move(SCREEN_XCHAROFFSET + offset.x + textrect.min.x * SCREEN_XCHARSIZE,
                                 SCREEN_YCHAROFFSET + offset.y + -yloop         * SCREEN_YCHARSIZE);
         
                            {
                            register int xloop = textrect.min.x; /* Nasty Jason, nasty... */
                            register int xloopstart, lastattr;
                            while (xloop <= textrect.max.x)
                                {
                                xloopstart = xloop;
                                lastattr = (int) attr.array[yloop][xloop++];
                                while(xloop <= textrect.max.x &&
                                      (text.array[yloop][xloop] == 32 ||
                                      lastattr == attr.array[yloop][xloop]) )
                                    xloop ++;
         
                                ColourTrans_SetGCOL(colours[attr.array[yloop][xloopstart]].R << 8  |
                                                    colours[attr.array[yloop][xloopstart]].G << 16 |
                                                    colours[attr.array[yloop][xloopstart]].B << 24 );
                                GFX_WriteN(&text.array[yloop][xloopstart], xloop - xloopstart);
                                }
                            }
                        }
         
                    if(DrawingStyle == COLOUR_TRANSED_DITHERED)
                        {
                        GFX_CLG(); /* a rectangle fill would be better */
                        GFX_Move(SCREEN_XCHAROFFSET + offset.x + textrect.min.x * SCREEN_XCHARSIZE,
                                 SCREEN_YCHAROFFSET + offset.y + -yloop         * SCREEN_YCHARSIZE);
         
                            {
                            register int xloop = textrect.min.x; /* Nasty Jason, nasty... */
                            register int xloopstart, lastattr;
                            while (xloop <= textrect.max.x)
                                {
                                xloopstart = xloop;
                                lastattr = (int) attr.array[yloop][xloop++];
                                while(xloop <= textrect.max.x &&
                                      (text.array[yloop][xloop] == 32 ||
                                      lastattr == attr.array[yloop][xloop]) )
                                    xloop ++;
         
                                ColourTrans_DitheredSetGCOL(
                                              colours[attr.array[yloop][xloopstart]].R << 8  |
                                              colours[attr.array[yloop][xloopstart]].G << 16 |
                                              colours[attr.array[yloop][xloopstart]].B << 24 );
                                GFX_WriteN(&text.array[yloop][xloopstart], xloop - xloopstart);
                                }
                            }
                        }
                    redraw.windowhandle = mainwindowhandle;
                    Wimp_GetRectangle(&redraw, &more);
                    }
                }
        }

    for(yloop = 0; yloop < SCREEN_ROWS; yloop++)
        {
        screen_clearinvalidline(yloop);
        }
#endif
    }
