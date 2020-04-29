/* wimp/io.c: terminal I/O code for wimp environments

   Copyright (c) 1989-91 James E. Wilson, Robert A. Koeneke

   This software may be copied and distributed for educational, research, and
   not for profit purposes provided that this copyright and statement are
   included in all such copies. */

#include <ctype.h>
#include <string.h>

#ifdef ARC_RISCOS2
 #include "^.source.config.h"
 #include "^.source.constant.h"
 #include "^.source.types.h"
 #include "^.source.externs.h"
 #ifdef COLOUR_GFX
  #include "^.colour.colour.h"  /* attr defined in here */
 #endif
 #include "screen.h"
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



/* Attributes of normal and hilighted characters */
/* are now defined in screen.h */

#ifdef ARC_RISCOS2
extern void historywindow_prt(char *);
extern void historywindow_clearhilight(void);
#endif

#ifdef COLOUR_GFX
void setattr(attr a)
{
  screen_setcurrentattr(a, 0);
}
#endif

/* initializes curses routines */
void init_curses()
{
  /* Primary initialization is done in frontend.c since game is restartable */
  /* Only need to clear the screen here */
#ifdef MAC
  Open_MainWindow();
#endif
  clear_screen();
  screen_update();
}

/* Set up the terminal into a suitable state for moria.  -CJS- */
void moriaterm()
{
/* Nothing to do on the Arc */
}

/* Dump IO to buffer                                    -RAK-   */
void put_buffer(char *out_str, int row, int col)
{
  /* The screen manager handles writes past the edge ok */

  screen_setcursor(col, row);
  screen_writestring(out_str);
}

/* Dump the IO buffer to terminal                       -RAK-   */
void put_qio()
{
  screen_change = TRUE;    /* Let inven_command know something has changed. */
  screen_update();
}

/* Put the terminal in the original mode.                          -CJS- */
void restore_term()
/* Nothing to do on the Arc */
{
#ifdef MAC
Close_MainWindow();
#endif
}

void shell_out()
{
/*  alert_error("This command is not implemented on the Archimedes.");    */
/* But I'll do a crufty later and make it use the std desktop commandline */
/* escape...                                                              */
}

/* Returns a single character input from the terminal.  This silently -CJS-
   consumes ^R to redraw the screen and reset the terminal, so that this
   operation can always be performed at any input prompt.  inkey() never
   returns ^R.  */
char inkey()
/* This routine does nothing special with direction keys */
/* Just returns their keypad ascii value (e.g. '0'-'9') */
{
  char ch;
  rect area;

  put_qio();
  command_count = 0;

  do
    {
      screen_getkey(&ch, FALSE);
      if(ch == CTRL('R'))
          {
          area.min.x = 0;
          area.min.y = 0;
          area.max.x = SCREEN_COLS-1;
          area.max.y = SCREEN_ROWS-1;
          screen_invalidate(&area);
          screen_update();
          }
    }
  while (ch == CTRL('R'));

/* used to nasty mac things here to do with extractdir... */

  return(ch);
}


/* Flush the buffer                                     -RAK-   */
void flush()
{
/* Removed put_qio() call.  Reduces flashing.  Doesn't seem to hurt. */
/*  FlushScreenKeys(); */
/* WHAT does this do?? */
}

/* Clears given line of text                            -RAK-   */
void erase_line(int row, int col)
{
  rect area;

  if (row == MSG_LINE && msg_flag)
    msg_print(" ");

  area.min.x = col;
  area.min.y = row;
  area.max.x = SCREEN_COLS-1; /* C arrays are 0..n-1 */
  area.max.y = row;
  screen_erase(&area);
}

/* Clears screen */
void clear_screen()
{
  rect area;

  if (msg_flag)
    msg_print(NULL);

  area.min.x = 0;
  area.min.y = 0;
  area.max.x = SCREEN_COLS-1;
  area.max.y = SCREEN_ROWS-1;
  screen_erase(&area);
}

void clear_from (int row)
{
  rect area;

  area.min.x = 0;
  area.min.y = row;
  area.max.x = SCREEN_COLS-1;
  area.max.y = SCREEN_ROWS-1;
  screen_erase(&area);
}

/* Outputs a char to a given interpolated y, x position -RAK-   */
void print(char ch, int row, int col)
{
  char          cnow;
  unsigned char anow, a;

  row -= panel_row_prt;/* Real co-ords convert to screen positions */
  col -= panel_col_prt;

  screen_getcurrentattr(&a);
  screen_getcharattr(&cnow, &anow, col, row);    /* Check current */

  if ((cnow != ch) || (anow != a))  /* If char is already set, ignore op */
    screen_setcharattr(ch, a, col, row);
}

/* Outputs a char to a given interpolated y, x position -RAK-   */
/* also take an attr parameter for colour               -EMP-   */
void printattr(char ch, attr a, int row, int col)
{
  char          cnow;
  unsigned char anow;

  row -= panel_row_prt;/* Real co-ords convert to screen positions */
  col -= panel_col_prt;

  screen_getcharattr(&cnow, &anow, col, row);    /* Check current */
  
  /* Edouard's (self-confessed) hacky random-colour calculation ... */
  if (a == RND_COLOUR)
    a = (randint(5) == 1) ? (randint(6) - 1) : (randint(8) + 7);


  if ((cnow != ch) || (anow != a))  /* If char is already set, ignore op */
    screen_setcharattr(ch, a, col, row);
}

/* Moves the cursor to a given interpolated y, x position       -RAK-   */
void move_cursor_relative(int row, int col)
{
  row -= panel_row_prt;/* Real co-ords convert to screen positions */
  col -= panel_col_prt;

  screen_setcursor(col, row);
}

/* Print a message so as not to interrupt a counted command. -CJS- */
void count_msg_print(char *p)
{
  int i;

  i = command_count;
  msg_print(p);
  command_count = i;
}

/* Outputs a line to a given y, x position              -RAK-   */
void prt(char *str_buff, int row, int col)
{
  rect area;

  if (row == MSG_LINE && msg_flag)
    msg_print(NULL);

  area.min.x = col;
  area.min.y = row;
  area.max.x = SCREEN_COLS-1;
  area.max.y = row;
  screen_erase(&area);

  put_buffer(str_buff, row, col);
}

/* move cursor to a given y, x position */
void move_cursor(int row, int col)
{
  screen_setcursor(col, row);
}

/* Outputs message to top line of screen                                */
/* These messages are kept for later reference.  */
void msg_print(char *str_buff)
{
  register int old_len, new_len;
  int      combine_messages = FALSE;
  char     in_char;
  rect     area;

#ifdef COLOUR_GFX
  setattr(Colour_Plain_Text);
#endif

  if (msg_flag)
    {
      old_len = strlen(old_msg[last_msg]) + 1;

      /* If the new message and the old message are short enough, we want
         display them together on the same line.  So we don't flush the old
         message in this case.  */
         
      if (str_buff)
        new_len = strlen (str_buff);
      else
        new_len = 0;

      if (! str_buff || (new_len + old_len + 2 >= 73))
        {
          /* ensure that the complete -more- message is visible. */
          if (old_len > 73)
            old_len = 73;
#ifdef COLOUR_GFX
          setattr(Colour_Input);
#endif
          put_buffer(" -more-", MSG_LINE, old_len);
#ifdef COLOUR_GFX
          setattr(Colour_Plain_Text);
#endif
          /* let sigint handler know that we are waiting for a space */
          wait_for_more = 1;
          do
            {
              in_char = inkey();
            }
          while ((in_char != ' ') && (in_char != ESCAPE) && (in_char != '\n')
                 && (in_char != '\r'));
          wait_for_more = 0;
        }
      else
        combine_messages = TRUE;
    }

  if (! combine_messages)
    {
    area.min.x = 0;
    area.min.y = MSG_LINE;
    area.max.x = SCREEN_COLS-1;
    area.max.y = MSG_LINE;
    screen_erase(&area);
    }

  /* Make the null string a special case.  -CJS- */
  if (str_buff)
    {
      command_count = 0;
      msg_flag = TRUE;

      /* If the new message and the old message are short enough, display
         them on the same line.  */
      
      if (combine_messages)
        {
          put_buffer (str_buff, MSG_LINE, old_len + 2);
#ifdef ARC_RISCOS2
          historywindow_concat(str_buff, old_len + 2);
#endif
          strcat (old_msg[last_msg], "  ");
          strcat (old_msg[last_msg], str_buff);
        }
      else
        {
          put_buffer(str_buff, MSG_LINE, 0);
#ifdef ARC_RISCOS2
          historywindow_prt(str_buff);  /* JCW: add to history buffer window */
#endif
          last_msg++;
          if (last_msg >= MAX_SAVE_MSG)
            last_msg = 0;
          (void) strncpy(old_msg[last_msg], str_buff, VTYPESIZ);
          old_msg[last_msg][VTYPESIZ - 1] = '\0';
        }
    }
  else
    msg_flag = FALSE;

#ifdef COLOUR_GFX
  setattr(Colour_Default);
#endif
}

/* Used to verify a choice - user gets the chance to abort choice.  -CJS- */
int get_check(char *prompt)
{
  int res;
  int x, y;

#ifdef COLOUR_GFX
  setattr(Colour_Title);
#endif
  prt(prompt, 0, 0);
  screen_getcursor(&x, &y);
  if (x > 73)
    screen_setcursor(73, y);
  screen_writestringattr(" [y/n]", Colour_Input);
  do
    {
      res = inkey();
    }
  while(res == ' ');

#ifdef COLOUR_GFX
  setattr(Colour_Default);
#endif
  erase_line(0, 0);
  if (res == 'Y' || res == 'y')
    return TRUE;
  else
    return FALSE;
}

/* Prompts (optional) and returns ord value of input char       */
/* Function returns false if <ESCAPE> is input  */
int get_com(char *prompt, char *command)
{
  int res;

#ifdef COLOUR_GFX
  setattr(Colour_Plain_Text);
#endif
  if (prompt)
    prt(prompt, 0, 0);
  *command = inkey();
#ifdef COLOUR_GFX
  setattr(Colour_Default);
#endif
  if (*command == 0 || *command == ESCAPE)
    res = FALSE;
  else
    res = TRUE;
  erase_line(MSG_LINE, 0);
  return(res);
}

/* Gets a string terminated by <RETURN>         */
/* Function returns false if <ESCAPE> is input  */
int get_string(char *in_str, int row, int column, int slen)
{
  register int start_col, end_col, i;
  char *p;
  int flag, abort;
  rect area;

  abort = FALSE;
  flag  = FALSE;
  area.min.x = column;
  area.min.y = row;
  area.max.x = column + slen - 1;
  area.max.y = row;
  screen_erase(&area);
  screen_setcursor(column, row);
  start_col = column;
  end_col = column + slen - 1;
  if (end_col > 79)
    {
      slen = 80 - column;
      end_col = 79;
    }
  p = in_str;
  do
    {
      i = inkey();
      switch(i)
        {
        case ESCAPE:
          abort = TRUE;
          break;
        case CTRL('J'): case CTRL('M'):
          flag  = TRUE;
          break;
        case DELETE: case CTRL('H'):
          if (column > start_col)
            {
              column--;
              put_buffer(" ", row, column);
              move_cursor(row, column);
              *--p = '\0';
            }
          break;
        default:
          if (!isprint(i) || column > end_col)
            bell();
          else
            {
              screen_setcursor(column, row);
              screen_writecharattr((char) i, Colour_Input);
              *p++ = i;
              column++;
            }
          break;
        }
    }
  while ((!flag) && (!abort));
  if (abort)
    return(FALSE);
  /* Remove trailing blanks     */
  while (p > in_str && p[-1] == ' ')
    p--;
  *p = '\0';
  return(TRUE);
}

/* Pauses for user response before returning            -RAK-   */
void pause_line(int prt_line)
{
#ifdef COLOUR_GFX
  setattr(Colour_Attention);
#endif
  prt("[Press any key to continue.]", prt_line, 23);
  (void) inkey();
  erase_line(prt_line, 0);
#ifdef COLOUR_GFX
  setattr(Colour_Default);
#endif
}

/* Pauses for user response before returning            -RAK-   */
/* NOTE: Delay is for players trying to roll up "perfect"       */
/*      characters.  Make them wait a bit.                      */
void pause_exit(int prt_line, int delay)
{
  char dummy;

#ifdef COLOUR_GFX
  setattr(Colour_Warning);
#endif
  prt("[Press any key to continue, or Q to exit]", prt_line, 10);
  dummy = inkey();
  if (dummy == 'Q')
    {
      erase_line(prt_line, 0);
      if (delay > 0)  (void) screen_sleep((unsigned)delay);
      exit_game();
    }
  erase_line(prt_line, 0);
#ifdef COLOUR_GFX
  setattr(Colour_Default);
#endif
}

void save_screen()
{
  screen_save();
}

void restore_screen()
{
  screen_restore();
}

void bell()
{
  put_qio();
  if (! sound_beep_flag)
    return;
  screen_beep();
}

/* definitions used by screen_map() */
/* index into border character array */
#define TL 0    /* top left */
#define TR 1
#define BL 2
#define BR 3
#define HE 4    /* horizontal edge */
#define VE 5

/* Display highest priority object in the RATIO by RATIO area */
#define RATIO 3

void screen_map()
{
  register int  i, j;
  static int8u border[6] = {
    '+', '+', '+', '+', '-', '|'        /* normal chars */
  };
  int8u map[MAX_WIDTH / RATIO + 1];
#ifdef COLOUR_GFX
  int8u map_col[MAX_WIDTH / RATIO + 1];
  int k;
#endif
  int8u tmp;
  int priority[256];
  int row, orow, col, myrow, mycol = 0;

  for (i = 0; i < 256; i++)
    priority[i] = 0;
  priority['<'] = 5;
  priority['>'] = 5;
  priority['@'] = 10;
  priority['#'] = -5;
  priority['.'] = -10;
  priority['\''] = -3;
  priority[' '] = -15;

  save_screen();
  clear_screen();
  screen_setcursor(0, 0);
  screen_writecharattr(border[TL], Colour_White);
  for (i = 0; i < MAX_WIDTH / RATIO; i++)
    screen_writecharattr(border[HE], Colour_White);
  screen_writecharattr(border[TR], Colour_White);
  orow = -1;
  map[MAX_WIDTH / RATIO] = '\0';
  for (i = 0; i < MAX_HEIGHT; i++)
    {
      row = i / RATIO;
      if (row != orow)
        {
          if (orow >= 0)
            {
              screen_setcursor(0, orow+1);
              screen_writecharattr(border[VE], Colour_White);
#ifdef COLOUR_GFX
              screen_setcursor(1, orow+1);
              for (k = 0; k < MAX_HEIGHT; k++)
                {
                  screen_writecharattr(map[k], map_col[k]);
                }
#else
              screen_writestring((char *) map);
#endif
              screen_writecharattr(border[VE], Colour_White);
            }
          for (j = 0; j < MAX_WIDTH / RATIO; j++)
            map[j] = ' ';
          orow = row;
        }
      for (j = 0; j < MAX_WIDTH; j++)
        {
          col = j / RATIO;
          tmp = loc_symbol(i, j);
          if (priority[map[col]] < priority[tmp])
            {
            map[col] = tmp;
#ifdef COLOUR_GFX
            map_col[col] = loc_colour(i, j);
#endif
            }
          if (map[col] == '@')
            {
              mycol = col + 1; /* account for border */
              myrow = row + 1;
            }
        }
    }
  if (orow >= 0)
    {
      screen_setcursor(0, orow+1);
      screen_writecharattr(border[VE], Colour_White);
#ifdef COLOUR_GFX
      screen_setcursor(1, orow+1);
      for (k = 0; k < MAX_HEIGHT; k++)
       {
         screen_writecharattr(map[k], map_col[k]);
       }
#else
      screen_writestring((char *) map);
#endif
      screen_writecharattr(border[VE], Colour_White);
    }
  screen_setcursor(0, orow + 2);
  screen_writecharattr(border[BL], Colour_White);
  for (i = 0; i < MAX_WIDTH / RATIO; i++)
    screen_writecharattr(border[HE], Colour_White);
  screen_writecharattr(border[BR], Colour_White);
  screen_setcursor(23, 23);
  screen_writestringattr("Hit any key to continue", Colour_Attention);
  if (mycol > 0)
    screen_setcursor(mycol, myrow);
  (void) inkey();
  restore_screen();
}
