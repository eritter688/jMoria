/* wimp/wimp.h: definitions for all protable GUI interfaces

   Copyright (c) 1992 Richard Knuckey & Edouard Poor

   This software may be copied and distributed for educational, research, and
   not for profit purposes provided that this copyright and statement are
   included in all such copies. */


/* externs */

extern  int     wimp;           /* 1 = use wimp, 0 = use standard */

#if 0
extern  int     in_colour;      /* 1 = colour, 0 = b&w */
extern  int     reversed;       /* 1 = reverse, 0 = normal */
extern  int     use_graphics;   /* 1 = use graphic characters, 0 = TEXT */

extern  int     accept_commands;/* 0 = game cannot accept commands */
                                /* 1 = game can accept commands */
                                /* 2 = can quit via control-c */
#endif


/* prototypes */

void    wimp_create_character(void);    /* <machine>/wCreate.c */
