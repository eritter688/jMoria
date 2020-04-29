/* mac/screen.h */

#ifndef BOOL
#define BOOL int
#define TRUE 1
#define FALSE 0
#endif

#ifdef ARC_RISCOS2
#define SCREEN_XCHARSIZE    16 /* OS coords */
#define SCREEN_YCHARSIZE    32 /*   ditto   */
#define SCREEN_XCHAROFFSET  0  /*    ''     */
#define SCREEN_YCHAROFFSET -4  /*   uh-huh  */

#define BLACK_AND_WHITE         1
#define WHITE_AND_BLACK         2
#define WIMP_SET_COLOUR         3
#define COLOUR_TRANSED          4
#define COLOUR_TRANSED_DITHERED 5
#endif




/* structs */


#define INVALID_CHUNKS  4
#define INVALID_MINDIST 3

#ifdef ARC_RISCOS2
#include "^.arc.wimpdata.h"
#else
typedef struct { int x, y; } coord;
typedef struct { coord min, max; } rect;
#endif

#define BOOLEAN char

/* Structs */


typedef struct
    {
    unsigned char array[SCREEN_ROWS][SCREEN_COLS];
    }
screenarray;


typedef struct
    {
    BOOL used;
    int left, right;
    }
invalidlistelement;


typedef struct
    {
    int                 free[SCREEN_ROWS];
    invalidlistelement  array[SCREEN_ROWS][INVALID_CHUNKS];
    }
invalidlist;


  
typedef struct
    {
    coord       cursor;
    attr        currentattr;
    invalidlist invalid;
    screenarray text;
    screenarray attr;
    screenarray savedtext;
    screenarray savedattr;
    }
screenstruct;


void    screen_beep(void);
void    screen_erase(rect *);
void    screen_invalidate(rect *);
void    screen_getcharattr(char *, attr *, int, int);
void    screen_getcursor(int *, int *);
int     screen_getkey(char *, int );
void    screen_restore(void);
void    screen_save(void);
void    screen_setcharattr(char, attr, int, int);
void    screen_setcursor(int, int);
void    screen_sleep(unsigned int);
void    screen_update(void);
void    screen_redraw(void);
void    screen_writecharattr(char, attr);
void    screen_writestring(char *);
void    screen_writestringattr(char *, attr);
void    screen_setcurrentattr(attr, attr);
void    screen_getcurrentattr(attr *);

