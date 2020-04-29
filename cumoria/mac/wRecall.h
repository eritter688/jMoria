/* recallwindow.h */

/* variables defined in recallwindow.c */
extern  int recallwindowopen;
extern  int recallwindowlast;
extern  int recalllastkilled;

/* function prototypes */
void openrecallwindow(void);
void closerecallwindow(void);

void recallwindow_prt(char *);
void recallwindow_clear(void);