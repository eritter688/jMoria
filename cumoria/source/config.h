/* source/config.h: configuration definitions

   Copyright (c) 1989-92 James E. Wilson

   This software may be copied and distributed for educational, research, and
   not for profit purposes provided that this copyright and statement are
   included in all such copies. */

#define CONFIG_H_INCLUDED
#ifdef CONSTANT_H_INCLUDED
/*Constant.h should always be included after config.h, because it uses
some of the system defines set up here.*/
#endif

/* Person to bother if something goes wrong.  */
/* Recompile files.c and misc2.c if this changes.  */
#define WIZARD  "David Grabiner"
/* The wizard password and wizard uid are no longer used.  */


/* System definitions.  You must define one of these as appropriate for
   the system you are compiling moria on.  */

/* No system definition is needed for 4.3BSD, SUN OS, DG/UX.  */

/* If you are compiling on an ultrix/4.2BSD/Dynix/etc. version of UNIX,
   define this.  It is not needed for SUNs.  */
/* #ifndef ultrix
#define ultrix
#endif */

/* If you are compiling under IBM's AIX 3.0, then you can either define
   SYS_V, or you can define nothing (thus compiling as if on a BSD system)
   but you must comment out the AIX LFLAG line in the Makefile so that
   moria will be linked with -lbsd.  */

/* If you are compiling on a SYS V version of UNIX, define this.  */
/* #define SYS_V */

/* If you are compiling on a SYS III version of UNIX, define this.
   The SYS_III support may not be complete.  I do not know if this works.  */
/* #define SYS_III */

/* If you are compiling on an ATARI ST with Mark Williams C, define this.  */
/* #define ATARIST_MWC */

/* If you are compiling on an Atari ST with GCC, you do not need to define
   anything.  */

/* If you are compiling on an Atari ST with TC, define this.  */
/* #define ATARIST_TC */

/* If we are in Think C, then we must be on a mac. */
#ifdef THINK_C
#define MAC
/* Set the following when building the data resources. See mac/Install */
/*  #define RSRC        */
/*  #define RSRC_PART1  */
/*  #define RSRC_PART2  */
#define MACGAME
#endif

/* If we are running an Archimedes with RiscOS 2 then #define this */
/* #define ARC_RISCOS2 */

/* For Xenix systems, define SYS_V and unix.  */
#ifdef M_XENIX
#define SYS_V
#define unix
#endif

/* If you are compiling under VMS, define this.  */
/* #define VMS */

/* If you are using the tcio.c file instead of io.c, then define this.
   The tcio.c file uses TURBO C builtin functions instead of curses library
   calls.  It only works if you are using TURBO C.
   The default is to assume you are using it if you are using TURBO C
   on an IBM-PC.  */
#if defined(MSDOS) && defined(__TURBOC__)
#define USING_TCIO
#endif


/* Files used by moria, set these to valid pathnames for your system.  */

#ifdef MSDOS
/* Files which can be in a varying place */
#define MORIA_SAV       moriasav
#define MORIA_TOP       moriatop
#define MORIA_MOR       "news"
#define MORIA_TOP_NAME  "scores"
#define MORIA_SAV_NAME  "MORIA.SAV"
#define MORIA_CNF_NAME  "MORIA.CNF"
#define MORIA_HELP      "roglcmds.hlp"
#define MORIA_ORIG_HELP "origcmds.hlp"
#define MORIA_WIZ_HELP  "rwizcmds.hlp"
#define MORIA_OWIZ_HELP "owizcmds.hlp"
#define MORIA_WELCOME   "welcome.hlp"
#define MORIA_VER       "version.hlp"

#else
#ifdef MAC

/* These files are stored in TEXT resources in the App, */
/* And can be overridden with TEXT resources in the preferences file */
/* The names are retained to find the appropriate text */
#define MORIA_FILES_RESOURCE_TYPE   'TEXT'
#define MORIA_MOR       "news"
#define MORIA_HELP      "roglcmds"
#define MORIA_ORIG_HELP "origcmds"
#define MORIA_WIZ_HELP  "rwizcmds"
#define MORIA_OWIZ_HELP "owizcmds"
#define MORIA_WELCOME   "welcome"
#define MORIA_VER       "version"
/* The scores file is kept in a seperate file in the same directory */
/* as the application */
#define MORIA_TOP       "Moria High Scores"
/* File types and creators for the Mac */
#define MORIA_FCREATOR  'Mria'
#define SAVE_FTYPE      'SAVE'
#define INFO_FCREATOR   'QED1'
#define INFO_FTYPE      'TEXT'
#define SCORE_FTYPE     'High'
#define CONFIG_FTYPE    'Pref'

#define COLOUR_GFX      /* Now in Colour! (where avaliable) */
#define WIMP            /* We use GUI routines */

#else

#ifdef ARC_RISCOS2

/* The Archimedes Norcroft C compiler expects functions to be
   in ANSI style 'int is_a_vowel(char ch)' _IF_ they have been ANSI
   prototyped. The below prototype is put around fuction declarations
   to allow them to be ANSI style. Note that this only is a problem
   if anything is passed to the function so 'int redraw(void)' is
   not a problem. */
#define ANSIPROTO

/* This is a define to allow colour to be added (hopefully seamlessly)
   to moria... (note correct spelling :-)  */
/* #define COLOUR_GFX */
#define WIMP

#define MORIA_SAV       "<Moria$Dir>.SavedGame"
#define MORIA_HOU       "<MoriaFiles$Dir>.hours"
#define MORIA_MOR       "<MoriaFiles$Dir>.news"
#define MORIA_TOP       "<MoriaFiles$Dir>.scores"
#define MORIA_HELP      "<MoriaFiles$Dir>.roglcmds"
#define MORIA_ORIG_HELP "<MoriaFiles$Dir>.origcmds"
#define MORIA_WIZ_HELP  "<MoriaFiles$Dir>.rwizcmds"
#define MORIA_OWIZ_HELP "<MoriaFiles$Dir>.owizcmds"
#define MORIA_WELCOME   "<MoriaFiles$Dir>.welcome"
#define MORIA_VER       "<MoriaFiles$Dir>.version"

#else

#ifdef VMS
#define MORIA_SAV       "moria.sav"
/* These 3 files need a dot at the end to prevent VMS from deciding that
   they are *.DAT files or anything else equally wierd. */
#define MORIA_HOU       "moria:hours."
#define MORIA_MOR       "moria:news."
#define MORIA_TOP       "moria:scores."
#define MORIA_HELP      "moria:roglcmds.hlp"
#define MORIA_ORIG_HELP "moria:origcmds.hlp"
#define MORIA_WIZ_HELP  "moria:rwizcmds.hlp"
#define MORIA_OWIZ_HELP "moria:owizcmds.hlp"
#define MORIA_WELCOME   "moria:welcome.hlp"
#define MORIA_VER       "moria:version.hlp"

#else

#ifdef AMIGA
#define MORIA_SAV       "moria.sav"
#define MORIA_HOU       "moria:hours"
#define MORIA_MOR       "moria:news"
#define MORIA_TOP       "moria:scores"
#define MORIA_HELP      "moria:roglcmds.hlp"
#define MORIA_ORIG_HELP "moria:origcmds.hlp"
#define MORIA_WIZ_HELP  "moria:rwizcmds.hlp"
#define MORIA_OWIZ_HELP "moria:owizcmds.hlp"
#define MORIA_WELCOME   "moria:welcome.hlp"
#define MORIA_VER       "moria:version.hlp"

#else
#if defined(GEMDOS)
/* Atari ST */
#define MORIA_SAV       "moria.sav"
#define MORIA_HOU       "files\\hours"
#define MORIA_MOR       "files\\news"
#define MORIA_TOP       "files\\scores"
#define MORIA_HELP      "files\\roglcmds.hlp"
#define MORIA_ORIG_HELP "files\\origcmds.hlp"
#define MORIA_WIZ_HELP  "files\\rwizcmds.hlp"
#define MORIA_OWIZ_HELP "files\\owizcmds.hlp"
#define MORIA_WELCOME   "files\\welcome.hlp"
#define MORIA_VER       "files\\version.hlp"

#else
#if defined(atarist) && defined(__GNUC__)
/* atari-st compiled with gnu-c  */

#define MORIA_SAV       "moria.save"
#define MORIA_HOU       (char *)prefix_file("files/hours")
#define MORIA_MOR       (char *)prefix_file("files/news")
#define MORIA_TOP       (char *)prefix_file("files/scores")
#define MORIA_HELP      (char *)prefix_file("files/roglcmds.hlp")
#define MORIA_ORIG_HELP (char *)prefix_file("files/origcmds.hlp")
#define MORIA_WIZ_HELP  (char *)prefix_file("files/rwizcmds.hlp")
#define MORIA_OWIZ_HELP (char *)prefix_file("files/owizcmds.hlp")
#define MORIA_WELCOME   (char *)prefix_file("files/welcome.hlp")
#define MORIA_VER       (char *)prefix_file("files/version.hlp")

#else

/* This must be unix.  */
#define MORIA_SAV       "moria.save"
#define MORIA_HOU       "/users/studs/grad/Common/UMoria/hours"
#define MORIA_MOR       "/users/studs/grad/Common/UMoria/news"
#define MORIA_TOP       "/users/studs/grad/Common/UMoria/Moria High Scores"
#define MORIA_HELP      "/users/studs/grad/Common/UMoria/roglcmds.hlp"
#define MORIA_ORIG_HELP "/users/studs/grad/Common/UMoria/origcmds.hlp"
#define MORIA_WIZ_HELP  "/users/studs/grad/Common/UMoria/rwizcmds.hlp"
#define MORIA_OWIZ_HELP "/users/studs/grad/Common/UMoria/owizcmds.hlp"
#define MORIA_WELCOME   "/users/studs/grad/Common/UMoria/welcome.hlp"
#define MORIA_VER       "/users/studs/grad/Common/UMoria/version.hlp"

#endif
#endif
#endif
#endif
#endif
#endif
#endif

/* This sets the default user interface.  */
/* To use the original key bindings (keypad for movement) set ROGUE_LIKE
   to FALSE; to use the rogue-like key bindings (vi style movement)
   set ROGUE_LIKE to TRUE.  */
/* If you change this, you only need to recompile main.c.  */
#define ROGUE_LIKE FALSE


/* For the ANDREW distributed file system, define this to ensure that
   the program is secure with respect to the setuid code, this prohibits
   inferior shells.  It also does not relinquish setuid priviledges at the
   start, but instead calls the ANDREW library routines bePlayer(), beGames(),
   and Authenticate().  */
/* #define SECURE */



/* System dependent defines follow.  You should not need to change anything
   below.  */

#ifdef ATARIST_TC
#define USG
#include <stdio.h>      /* Needed for TC ...printf */
#endif

#if defined(ATARIST_TC) || defined(ATARIST_MWC)
#define ATARI_ST
#endif

/* Substitute strchr for index on USG versions of UNIX.  */
#if defined(SYS_V) || defined(MSDOS) || defined(MAC) || defined(VMS) || defined(ARC_RISCOS2)
#define index strchr
#endif
#ifdef ATARIST_TC
#define index strchr
#endif

#ifdef SYS_III
char *index();
#endif

/* Define USG for many systems, this is basically to select SYS V style
   system calls (as opposed to BSD style).  */
#if defined(SYS_III) || defined(SYS_V) || defined(MSDOS) || defined(MAC) || defined(ARC_RISCOS2)
#ifndef USG
#define USG
#endif
#endif

#if defined(ATARIST_MWC) || defined(AMIGA) || defined(VMS)
#define USG
#endif

#ifdef AMIGA
#ifndef ultrix
#define ultrix
#endif
#endif

/* Pyramid runs 4.2BSD-like UNIX version */
#if defined(Pyramid)
#define ultrix
#endif

#ifndef ARC_RISCOS2
#if defined(_MSC_VER) && (_MSC_VER < 600)
#define register      /* MSC 4.0 still has a problem with register bugs ... */
#endif
#endif

#ifdef MAC
/* Window text size */
#define SCREEN_ROWS       24
#define SCREEN_COLS       80
#endif

#ifdef ARC_RISCOS2
/* Window text size */
#define SCREEN_ROWS       24
#define SCREEN_COLS       80
#include <stdio.h>
/* The compiler automatically only includes files once so
   this should be OK here. It needs it for abs() and others */ 
#include <stdlib.h>
#define index strchr
#define LINT_ARGS
#endif

#ifdef VMS
#define unlink delete
#define index strchr
#define exit uexit
/* In constants.h, ESCAPE is defined to be the CTRL-Z key, instead of the
   escape key.  */
#endif

#if defined(SYS_V) && defined(lint)
/* Define this to prevent <string.h> from including <NLchar.h> on a PC/RT
   running AIX.  This prevents a bunch of lint errors.  */
#define RTPC_NO_NLS
#endif

#ifdef SECURE
extern int PlayerUID;
#define getuid() PlayerUID
#define geteuid() PlayerUID
#endif

#ifdef THINK_C
/* Apparently, THINK C is only happy if this is defined.  This can not
   be defined in general, because some systems have include files which
   merely test whether STDC is defined, they do not test the value.  */
/* Check how standard we are: Some code tests value of __STDC__.  */
#ifndef __STDC__
#define __STDC__        0
#endif
#endif

#if defined(ARC_RISCOS2) || defined(MAC)
/* These colours are for the desktop on the Archimedes and are probably */
/* not portable to other machines without having to custom set the      */
/* palette.                                                             */
#ifdef COLOUR_GFX
#define WHITE          0
#define LIGHTGREY_HIGH 1
#define LIGHTGREY_LOW  2
#define MIDGREY_HIGH   3
#define MIDGREY_LOW    4
#define DARKGREY_HIGH  5
#define DARKGREY_LOW   6
#define BLACK          7
#define DARKBLUE       8
#define YELLOW         9
#define LIGHTGREEN     10
#define RED            11
#define CREAM          12
#define DARKGREEN      13
#define ORANGE         14
#define LIGHTBLUE      15
#define RND_COLOUR     255
#endif
#endif
