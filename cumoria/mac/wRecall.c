/* mac/wRecall.c */

#include <MacHeaders>
#include "MacScreen.h"
#include "mac.h"

#define MaxRecallText   2048
#define MaxRecallName   80

int recallwindowlast = -1;  /* The mon_num of the last monster we printed to */
                            /* the recall window                             */
int recalllastkilled = -1;  /* The number of monsters (of type               */
                            /*  recallwindowlast) that have been killed      */
                           
int recallwindowopen = FALSE;

msWindowPtr RecallWindow = 0;
Handle      RecallText, RecallName;     /* the text is stored here */
char        *RecallPtr;                 /* text position in RecallText */
int         RecallState = FALSE;        /* which text to draw next */



pascal BOOLEAN HandleRecallWindow(theWindow, itemHit , PartHit)
msWindowPtr theWindow;
short       *itemHit;
short       *PartHit;
    {
    
    switch (*itemHit)
        {
        case actionDoOpenWindow:
            recallwindowopen = TRUE;
            recallwindowlast = -1;
            recalllastkilled = -1;
            SetStaticTextHandle(theWindow, recall_name, RecallName, TRUE);
            SetStaticTextHandle(theWindow, recall_description, RecallText, TRUE);
            break;
            
        case actionDoCloseWindow:
            /* Closeing the window will cause our text items to dispose
               of the handles. This is a _bad_ thing since we have
               allocated our storage and locked it Hi in the heap
               to avoid fragmentation, so we first set the strings to NULLS */
               
            recallwindowopen = FALSE;
            SetStaticTextHandle(theWindow, recall_name, NULL, FALSE);
            SetStaticTextHandle(theWindow, recall_description, NULL, FALSE);
            break;
        }
    
    return(TRUE);
    }

/* This is called with lots of little strings to make up the description
   of the item being loked at. It it divided into two parts, the name
   of the object, and it's description. These are seperated by \n's.
   Thus we spool text until we find a \n, and then set the name text
   to the obtained string, and then spool text until we find a \n, and
   set the description, finaly resetting RecallPos to *RecallText. To
   determine which state we are in, the global RecallState is FALSE 
   if waiting for name, and TRUE if waiting for description.
 */
 
void recallwindow_prt(msg)
char    *msg;
    {
    
    while (*msg != 0 && *msg != '\n')
        *RecallPtr++ = *msg++;
    
    if (*msg == '\n')
        {
        SetPort(RecallWindow->window);
        if (RecallState == 0)
            {
            msDrawItem(RecallWindow, recall_name);
            RecallPtr = *RecallText;
            }
        else
            {
            msDrawItem(RecallWindow, recall_description);
            RecallPtr = *RecallName;
            }
        RecallState = !RecallState;
        }
    }
    
void recallwindow_clear(void)
    {
    register int pos;
    
    RecallPtr = *RecallText;
    
    for (pos = 0; pos < MaxRecallText; pos ++)
        RecallPtr[pos] = 0;

    RecallPtr = *RecallName;
    
    for (pos = 0; pos < MaxRecallName; pos ++)
        RecallPtr[pos] = 0;
    }

void initrecallwindow(void)
    {
    RecallText = NewHandle(MaxRecallText);
    MoveHHi(RecallText);
    HLock(RecallText);
    
    RecallName = NewHandle(MaxRecallName);
    MoveHHi(RecallName);
    HLock(RecallName);
    
    recallwindow_clear();
    RecallPtr = *RecallName;
    }

void openrecallwindow(void)
    {
    RecallWindow = msGetWindow(RecallWindowID, *HandleRecallWindow);
    }

void closerecallwindow(void)
    {
    msCloseWindow(RecallWindow->window);
    }