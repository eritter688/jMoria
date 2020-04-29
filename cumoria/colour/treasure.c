/* source/treasure.c: dungeon object definitions

   Copyright (c) 1989-92 James E. Wilson, Robert A. Koeneke

   This software may be copied and distributed for educational, research, and
   not for profit purposes provided that this copyright and statement are
   included in all such copies. */

#ifdef ARC_RISCOS2
#include "^.source.config.h"
#include "^.source.constant.h"
#include "^.source.types.h"
#include "colour.h"
#else
#include "config.h"
#include "constant.h"
#include "types.h"
#include "colour.h"
#endif

/* Following are treasure arrays        and variables                   */

/* Object description:  Objects are defined here.  Each object has
  the following attributes:
        Descriptor : Name of item and formats.
                & is replaced with 'a', 'an', or a number.
                ~ is replaced with null or 's'.
        Character  : Character that represents the item.
        Type value : Value representing the type of object.
        Sub value  : separate value for each item of a type.
                0 - 63: object can not stack
                64 - 127: dungeon object, can stack with other D object
                128 - 191: unused, previously for store items
                192: stack with other iff have same p1 value, always
                        treated as individual objects
                193 - 255: object can stack with others iff they have
                        the same p1 value, usually considered one group
                Objects which have two type values, e.g. potions and
                scrolls, need to have distinct subvals for
                each item regardless of its tval
        Damage     : amount of damage item can cause.
        Weight     : relative weight of an item.
        Number     : number of items appearing in group.
        To hit     : magical plusses to hit.
        To damage  : magical plusses to damage.
        AC         : objects relative armor class.
                1 is worse than 5 is worse than 10 etc.
        To AC      : Magical bonuses to AC.
        P1         : Catch all for magical abilities such as
                     plusses to strength, minuses to searching.
        Flags      : Abilities of object.  Each ability is a
                     bit.  Bits 1-31 are used. (Signed integer)
        Level      : Minimum level on which item can be found.
        Cost       : Relative cost of item.

        Special Abilities can be added to item by magic_init(),
        found in misc.c.

        Scrolls, Potions, and Food:
        Flags is used to define a function which reading/quaffing
        will cause.  Most scrolls and potions have only one bit
        set.  Potions will generally have some food value, found
        in p1.

        Wands and Staffs:
        Flags defines a function, p1 contains number of charges
        for item.  p1 is set in magic_init() in misc.c.

        Chests:
        Traps are added randomly by magic_init() in misc.c.     */

/* Object list (All objects must be defined here)                */

#if defined(MACGAME) || defined(RSRC_PART2)
treasure_type *object_list;
#else
treasure_type object_list[MAX_OBJECTS] = {
/* Dungeon items from 0 to MAX_DUNGEON_OBJ */
{"Poison"                       ,0x00000001L,   TV_FOOD, ',',   /*  0*/
  500,     0,   64,   1,   1,   0,   0,  0,   0, {0,0}  ,  7, Colour_Food},
{"Blindness"                    ,0x00000002L,   TV_FOOD, ',',   /*  1*/
  500,     0,   65,   1,   1,   0,   0,  0,   0, {0,0}  ,  9, Colour_Food},
{"Paranoia"                     ,0x00000004L,   TV_FOOD, ',',   /*  2*/
  500,     0,   66,   1,   1,   0,   0,  0,   0, {0,0}  ,  9, Colour_Food},
{"Confusion"                    ,0x00000008L,   TV_FOOD, ',',   /*  3*/
  500,     0,   67,   1,   1,   0,   0,  0,   0, {0,0}  ,  7, Colour_Food},
{"Hallucination"                ,0x00000010L,   TV_FOOD, ',',   /*  4*/
  500,     0,   68,   1,   1,   0,   0,  0,   0, {0,0}  , 13, Colour_Food},
{"Cure Poison"                  ,0x00000020L,   TV_FOOD, ',',   /*  5*/
  500,    60,   69,   1,   1,   0,   0,  0,   0, {0,0}  ,  8, Colour_Food},
{"Cure Blindness"               ,0x00000040L,   TV_FOOD, ',',   /*  6*/
  500,    50,   70,   1,   1,   0,   0,  0,   0, {0,0}  , 10, Colour_Food},
{"Cure Paranoia"                ,0x00000080L,   TV_FOOD, ',',   /*  7*/
  500,    25,   71,   1,   1,   0,   0,  0,   0, {0,0}  , 12, Colour_Food},
{"Cure Confusion"               ,0x00000100L,   TV_FOOD, ',',   /*  8*/
  500,    50,   72,   1,   1,   0,   0,  0,   0, {0,0}  ,  6, Colour_Food},
{"Weakness"                     ,0x04000200L,   TV_FOOD, ',',   /*  9*/
  500,     0,   73,   1,   1,   0,   0,  0,   0, {0,0}  ,  7, Colour_Food},
{"Unhealth"                     ,0x04000400L,   TV_FOOD, ',',   /* 10*/
  500,    50,   74,   1,   1,   0,   0,  0,   0, {10,10}, 15, Colour_Food},
{"Restore Constitution"         ,0x00010000L,   TV_FOOD, ',',   /* 11*/
  500,   350,   75,   1,   1,   0,   0,  0,   0, {0,0}  , 20, Colour_Food},
{"First-Aid"                    ,0x00200000L,   TV_FOOD, ',',   /* 12*/
  500,     5,   76,   1,   1,   0,   0,  0,   0, {0,0}  ,  6, Colour_Food},
{"Minor Cures"                  ,0x00400000L,   TV_FOOD, ',',   /* 13*/
  500,    20,   77,   1,   1,   0,   0,  0,   0, {0,0}  ,  7, Colour_Food},
{"Light Cures"                  ,0x00800000L,   TV_FOOD, ',',   /* 14*/
  500,    30,   78,   1,   1,   0,   0,  0,   0, {0,0}  , 10, Colour_Food},
{"Restoring"                    ,0x001F8040L,   TV_FOOD, ',',   /* 15*/
  500,  1000,   79,   1,   1,   0,   0,  0,   0, {0,0}  , 30, Colour_Food},
{"Poison"                       ,0x00000001L,   TV_FOOD, ',',   /* 16*/
 1200,     0,   80,   1,   1,   0,   0,  0,   0, {0,0}  , 15, Colour_Food},
{"Hallucinations"               ,0x00000010L,   TV_FOOD, ',',   /* 17*/
 1200,     0,   81,   1,   1,   0,   0,  0,   0, {0,0}  , 18, Colour_Food},
{"Cure Poison"                  ,0x00000020L,   TV_FOOD, ',',   /* 18*/
 1200,    75,   82,   1,   1,   0,   0,  0,   0, {0,0}  , 19, Colour_Food},
{"Unhealth"                     ,0x00000400L,   TV_FOOD, ',',   /* 19*/
 1200,    25,   83,   1,   1,   0,   0,  0,   0, {6,8}  , 28, Colour_Food},
{"Cure Serious Wounds"          ,0x02000000L,   TV_FOOD, ',',   /* 20*/
 1200,    75,   84,   1,   2,   0,   0,  0,   0, {0,0}  , 16, Colour_Food},
{"& Ration~ of Food"            ,0x00000000L,   TV_FOOD, ',',   /* 21*/
 5000,     3,   90,   1,  10,   0,   0,  0,   0, {0,0}  ,  0, Colour_Food},
{"& Ration~ of Food"            ,0x00000000L,   TV_FOOD, ',',   /* 22*/
 5000,     3,   90,   1,  10,   0,   0,  0,   0, {0,0}  ,  5, Colour_Food},
{"& Ration~ of Food"            ,0x00000000L,   TV_FOOD, ',',   /* 23*/
 5000,     3,   90,   1,  10,   0,   0,  0,   0, {0,0}  , 10, Colour_Food},
{"& Slime Mold~"                ,0x00000000L,   TV_FOOD, ',',   /* 24*/
 3000,     2,   91,   1,   5,   0,   0,  0,   0, {0,0}  ,  1, Colour_Slimy},
{"& Piece~ of Elvish Waybread"  ,0x02000020L,   TV_FOOD, ',',   /* 25*/
 7500,    10,   92,   1,   3,   0,   0,  0,   0, {0,0}  ,  6, Colour_Cream},
{"& Piece~ of Elvish Waybread"  ,0x02000020L,   TV_FOOD, ',',   /* 26*/
 7500,    10,   92,   1,   3,   0,   0,  0,   0, {0,0}  , 12, Colour_Cream},
{"& Piece~ of Elvish Waybread"  ,0x02000020L,   TV_FOOD, ',',   /* 27*/
 7500,    10,   92,   1,   3,   0,   0,  0,   0, {0,0}  , 20, Colour_Cream},
{"& Dagger (Main Gauche)"       ,0x00000000L,   TV_SWORD, '|',  /* 28*/
    0,    25,   1,   1,  30,    0,   0,  0,   0, {1,5}  ,  2, Colour_Iron},
{"& Dagger (Misericorde)"       ,0x00000000L,   TV_SWORD, '|',  /* 29*/
    0,    10,   2,   1,  15,    0,   0,  0,   0, {1,4}  ,  0, Colour_Iron},
{"& Dagger (Stiletto)"          ,0x00000000L,   TV_SWORD, '|',  /* 30*/
    0,    10,   3,   1,  12,    0,   0,  0,   0, {1,4}  ,  0, Colour_Steel},
{"& Dagger (Bodkin)"            ,0x00000000L,   TV_SWORD, '|',  /* 31*/
    0,    10,   4,   1,  20,    0,   0,  0,   0, {1,4}  ,  1, Colour_Iron},
{"& Broken dagger"              ,0x00000000L,   TV_SWORD, '|',  /* 32*/
    0,     0,   5,   1,  15,  -2,  -2,   0,   0, {1,1}  ,  0, Colour_Cast_Iron},
{"& Backsword"                  ,0x00000000L,   TV_SWORD, '|',  /* 33*/
    0,    60,   6,   1,  95,    0,   0,  0,   0, {1,9}  ,  7, Colour_Iron},
{"& Bastard Sword"              ,0x00000000L,   TV_SWORD, '|',  /* 34*/
    0,   350,   7,   1, 140,    0,   0,  0,   0, {3,4}  , 14, Colour_Steel},
{"& Thrusting Sword (Bilbo)"    ,0x00000000L,   TV_SWORD, '|',  /* 35*/
    0,    60,   8,   1,  80,    0,   0,  0,   0, {1,6}  ,  4, Colour_Steel},
{"& Thrusting Sword (Baselard)" ,0x00000000L,   TV_SWORD, '|',  /* 36*/
    0,    80,   9,   1, 100,    0,   0,  0,   0, {1,7}  ,  5, Colour_Steel},
{"& Broadsword"                 ,0x00000000L,   TV_SWORD, '|',  /* 37*/
    0,   255,   10,   1, 150,   0,   0,  0,   0, {2,5}  ,  9, Colour_Steel},
{"& Two-Handed Sword (Claymore)",0x00000000L,   TV_SWORD, '|',  /* 38*/
    0,   775,   11,   1, 200,   0,   0,  0,   0, {3,6}  , 30, Colour_Silver},
{"& Cutlass"                    ,0x00000000L,   TV_SWORD, '|',  /* 39*/
    0,    85,   12,   1, 110,   0,   0,  0,   0, {1,7}  ,  7, Colour_Iron},
{"& Two-Handed Sword (Espadon)" ,0x00000000L,   TV_SWORD, '|',  /* 40*/
    0,   655,   13,   1, 180,   0,   0,  0,   0, {3,6}  , 35, Colour_Silver},
{"& Executioner's Sword"        ,0x00000000L,   TV_SWORD, '|',  /* 41*/
    0,   850,   14,   1, 260,   0,   0,  0,   0, {4,5}  , 40, Colour_Silver},
{"& Two-Handed Sword (Flamberge)",0x00000000L,  TV_SWORD, '|',  /* 42*/
    0,  1000,   15,   1, 240,   0,   0,  0,   0, {4,5}  , 45, Colour_Silver},
{"& Foil"                       ,0x00000000L,   TV_SWORD, '|',  /* 43*/
    0,    35,   16,   1,  30,   0,   0,  0,   0, {1,5}  ,  2, Colour_Steel},
{"& Katana"                     ,0x00000000L,   TV_SWORD, '|',  /* 44*/
    0,   400,   17,   1, 120,   0,   0,  0,   0, {3,4}  , 18, Colour_Steel},
{"& Longsword"                  ,0x00000000L,   TV_SWORD, '|',  /* 45*/
    0,   300,   18,   1, 130,   0,   0,  0,   0, {1,10} , 12, Colour_Steel},
{"& Two-Handed Sword (No-Dachi)",0x00000000L,   TV_SWORD, '|',  /* 46*/
    0,   675,   19,   1, 200,   0,   0,  0,   0, {4,4}  , 45, Colour_Silver},
{"& Rapier"                     ,0x00000000L,   TV_SWORD, '|',  /* 47*/
    0,    42,   20,   1,  40,   0,   0,  0,   0, {1,6}  ,  4, Colour_Steel},
{"& Sabre"                      ,0x00000000L,   TV_SWORD, '|',  /* 48*/
    0,    50,   21,   1,  50,   0,   0,  0,   0, {1,7}  ,  5, Colour_Iron},
{"& Small Sword"                ,0x00000000L,   TV_SWORD, '|',  /* 49*/
    0,    48,   22,   1,  75,   0,   0,  0,   0, {1,6}  ,  5, Colour_Steel},
{"& Two-Handed Sword (Zweihander)",0x00000000L, TV_SWORD, '|',  /* 50*/
    0,  1500,   23,   1, 280,   0,   0,  0,   0, {4,6}  , 50, Colour_Silver},
{"& Broken sword"               ,0x00000000L,   TV_SWORD, '|',  /* 51*/
    0,     0,   24,   1,  75,  -2,  -2,  0,   0, {1,1}  ,  0, Colour_Cast_Iron},
{"& Ball and Chain"             ,0x00000000L,   TV_HAFTED, '\\',/* 52*/
    0,   200,   1,   1, 150,    0,   0,  0,   0, {2,4}  , 20, Colour_Cast_Iron},
{"& Cat-O-Nine Tails"           ,0x00000000L,   TV_HAFTED, '\\',/* 53*/
    0,    14,   2,   1,  40,    0,   0,  0,   0, {1,4}  ,  3, Colour_Cord},
{"& Wooden Club"                ,0x00000000L,   TV_HAFTED, '\\',/* 54*/
    0,    10,   3,   1, 100,    0,   0,  0,   0, {1,3}  ,  0, Colour_Wooden},
{"& Flail"                      ,0x00000000L,   TV_HAFTED, '\\',/* 55*/
    0,   353,   4,   1, 150,    0,   0,  0,   0, {2,6}  , 12, Colour_Wooden},
{"& Two-Handed Great Flail"     ,0x00000000L,   TV_HAFTED, '\\',/* 56*/
    0,   590,   5,   1, 280,    0,   0,  0,   0, {3,6}  , 45, Colour_Wooden},
{"& Morningstar"                ,0x00000000L,   TV_HAFTED, '\\',/* 57*/
    0,   396,   6,   1, 150,    0,   0,  0,   0, {2,6}  , 10, Colour_Steel},
{"& Mace"                       ,0x00000000L,   TV_HAFTED, '\\',/* 58*/
    0,   130,   7,   1, 120,    0,   0,  0,   0, {2,4}  ,  6, Colour_Iron},
{"& War Hammer"                 ,0x00000000L,   TV_HAFTED, '\\',/* 59*/
    0,   225,   8,   1, 120,    0,   0,  0,   0, {3,3}  ,  5, Colour_Cast_Iron},
{"& Mace (Lead-filled)"         ,0x00000000L,   TV_HAFTED, '\\',/* 60*/
    0,   502,   9,   1, 180,    0,   0,  0,   0, {3,4}  , 15, Colour_Cast_Iron},
{"& Awl-Pike"                   ,0x00000000L,   TV_POLEARM, '/',/* 61*/
    0,   340,   1,   1, 160,    0,   0,  0,   0, {1,8}  ,  8, Colour_Wooden},
{"& Beaked Axe"                 ,0x00000000L,   TV_POLEARM, '/',/* 62*/
    0,   408,   2,   1, 180,    0,   0,  0,   0, {2,6}  , 15, Colour_Wooden},
{"& Fauchard"                   ,0x00000000L,   TV_POLEARM, '/',/* 63*/
    0,   376,   3,   1, 170,    0,   0,  0,   0, {1,10} , 17, Colour_Wooden},
{"& Glaive"                     ,0x00000000L,   TV_POLEARM, '/',/* 64*/
    0,   363,   4,   1, 190,    0,   0,  0,   0, {2,6}  , 20, Colour_Wooden},
{"& Halberd"                    ,0x00000000L,   TV_POLEARM, '/',/* 65*/
    0,   430,   5,   1, 190,    0,   0,  0,   0, {3,4}  , 22, Colour_Wooden},
{"& Lucerne Hammer"             ,0x00000000L,   TV_POLEARM, '/',/* 66*/
    0,   376,   6,   1, 120,    0,   0,  0,   0, {2,5}  , 11, Colour_Wooden},
{"& Pike"                       ,0x00000000L,   TV_POLEARM, '/',/* 67*/
    0,   358,   7,   1, 160,    0,   0,  0,   0, {2,5}  , 15, Colour_Wooden},
{"& Spear"                      ,0x00000000L,   TV_POLEARM, '/',/* 68*/
    0,    36,   8,   1,  50,    0,   0,  0,   0, {1,6}  ,  5, Colour_Wooden},
{"& Lance"                      ,0x00000000L,   TV_POLEARM, '/',/* 69*/
    0,   230,   9,   1, 300,    0,   0,  0,   0, {2,8}  , 10, Colour_Wooden},
{"& Javelin"                    ,0x00000000L,   TV_POLEARM, '/',/* 70*/
    0,    18,   10,   1,  30,   0,   0,  0,   0, {1,4}  ,  4, Colour_Wooden},
{"& Battle Axe (Balestarius)"   ,0x00000000L,   TV_POLEARM, '/',/* 71*/
    0,   500,   11,   1, 180,   0,   0,  0,   0, {2,8}  , 30, Colour_Wooden},
{"& Battle Axe (European)"      ,0x00000000L,   TV_POLEARM, '/',/* 72*/
    0,   334,   12,   1, 170,   0,   0,  0,   0, {3,4}  , 13, Colour_Wooden},
{"& Broad Axe"                  ,0x00000000L,   TV_POLEARM, '/',/* 73*/
    0,   304,   13,   1, 160,   0,   0,  0,   0, {2,6}  , 17, Colour_Wooden},
{"& Short Bow"                  ,0x00000000L,   TV_BOW, '}',    /* 74*/
    2,    50,   1,   1,  30,    0,   0,  0,   0, {0,0}  ,  3, Colour_Wooden},
{"& Long Bow"                   ,0x00000000L,   TV_BOW, '}',    /* 75*/
    3,   120,   2,   1,  40,    0,   0,  0,   0, {0,0}  , 10, Colour_Wooden},
{"& Composite Bow"              ,0x00000000L,   TV_BOW, '}',    /* 76*/
    4,   240,   3,   1,  40,    0,   0,  0,   0, {0,0}  , 40, Colour_Wooden},
{"& Light Crossbow"             ,0x00000000L,   TV_BOW, '}',    /* 77*/
    5,   140,   10,   1, 110,   0,   0,  0,   0, {0,0}  , 15, Colour_Wooden},
{"& Heavy Crossbow"             ,0x00000000L,   TV_BOW, '}',    /* 78*/
    6,   300,   11,   1, 200,   0,   0,  0,   0, {1,1}  , 30, Colour_Wooden},
{"& Sling"                      ,0x00000000L,   TV_BOW, '}',    /* 79*/
    1,     5,   20,   1,   5,   0,   0,  0,   0, {0,0}  ,  1, Colour_Leather},
{"& Arrow~"                     ,0x00000000L,   TV_ARROW, '{',  /* 80*/
    0,     1, 193,   1,   2,    0,   0,  0,   0, {1,4}  ,  2, Colour_Wooden},
{"& Bolt~"                      ,0x00000000L,   TV_BOLT, '{',   /* 81*/
    0,     2, 193,   1,   3,    0,   0,  0,   0, {1,5}  ,  2, Colour_Wooden},
{"& Rounded Pebble~"            ,0x00000000L,   TV_SLING_AMMO, '{',/* 82*/
    0,     1, 193,   1,   4,    0,   0,  0,   0, {1,2}  ,  0, Colour_Stone},
{"& Iron Shot~"                 ,0x00000000L,   TV_SLING_AMMO, '{',/* 83*/
    0,     2, 194,   1,   5,    0,   0,  0,   0, {1,3}  ,  3, Colour_Iron},
{"& Iron Spike~"                ,0x00000000L,   TV_SPIKE, '~',  /* 84*/
    0,     1, 193,   1,  10,    0,   0,  0,   0, {1,1}  ,  1, Colour_Iron},
{"& Brass Lantern~"             ,0x00000000L,   TV_LIGHT, '~',  /* 85*/
 7500,    35,   1,   1,  50,    0,   0,  0,   0, {1,1}  ,  1, Colour_Brass},
{"& Wooden Torch~"              ,0x00000000L,   TV_LIGHT, '~',  /* 86*/
 4000,     2, 193,   1,  30,    0,   0,  0,   0, {1,1}  ,  1, Colour_Wooden},
{"& Orcish Pick"                ,0x20000000L,   TV_DIGGING, '\\',/* 87*/
    2,   500,   2,   1, 180,    0,   0,  0,   0, {1,3}  , 20, Colour_Iron},
{"& Dwarven Pick"              ,0x20000000L,    TV_DIGGING, '\\',/* 88*/
    3,  1200,   3,   1, 200,    0,   0,  0,   0, {1,4}  , 50, Colour_Mithril},
{"& Gnomish Shovel"             ,0x20000000L,   TV_DIGGING, '\\',/* 89*/
    1,   100,   5,   1,  50,    0,   0,  0,   0, {1,2}  , 20, Colour_Steel},
{"& Dwarven Shovel"             ,0x20000000L,   TV_DIGGING, '\\',/* 90*/
    2,   250,   6,   1, 120,    0,   0,  0,   0, {1,3}  , 40, Colour_Mithril},
{"& Pair of Soft Leather Shoes" ,0x00000000L,   TV_BOOTS, ']',  /* 91*/
    0,     4,   1,   1,   5,    0,   0,  1,   0, {0,0}  ,  1, Colour_Leather},
{"& Pair of Soft Leather Boots" ,0x00000000L,   TV_BOOTS, ']',  /* 92*/
    0,     7,   2,   1,  20,    0,   0,  2,   0, {1,1}  ,  4, Colour_Leather},
{"& Pair of Hard Leather Boots" ,0x00000000L,   TV_BOOTS, ']',  /* 93*/
    0,    12,   3,   1,  40,    0,   0,  3,   0, {1,1}  ,  6, Colour_Leather},
{"& Soft Leather Cap"           ,0x00000000L,   TV_HELM, ']',   /* 94*/
    0,     4,   1,   1,  10,    0,   0,  1,   0, {0,0}  ,  2, Colour_Leather},
{"& Hard Leather Cap"           ,0x00000000L,   TV_HELM, ']',   /* 95*/
    0,    12,   2,   1,  15,    0,   0,  2,   0, {0,0}  ,  4, Colour_Leather},
{"& Metal Cap"                  ,0x00000000L,   TV_HELM, ']',   /* 96*/
    0,    30,   3,   1,  20,    0,   0,  3,   0, {1,1}  ,  7, Colour_Iron},
{"& Iron Helm"                  ,0x00000000L,   TV_HELM, ']',   /* 97*/
    0,    75,   4,   1,  75,    0,   0,  5,   0, {1,3}  , 20, Colour_Iron},
{"& Steel Helm"                 ,0x00000000L,   TV_HELM, ']',   /* 98*/
    0,   200,   5,   1,  60,    0,   0,  6,   0, {1,3}  , 40, Colour_Steel},
{"& Silver Crown"               ,0x00000000L,   TV_HELM, ']',   /* 99*/
    0,   500,   6,   1,  20,    0,   0,  0,   0, {1,1}  , 44, Colour_Silver},
{"& Golden Crown"               ,0x00000000L,   TV_HELM, ']',   /*100*/
    0,  1000,   7,   1,  30,    0,   0,  0,   0, {1,1}  , 47, Colour_Gold},
{"& Jewel-Encrusted Crown"      ,0x00000000L,   TV_HELM, ']',   /*101*/
    0,  2000,   8,   1,  40,    0,   0,  0,   0, {1,1}  , 50, Colour_Amethyst},
{"& Robe"                       ,0x00000000L,   TV_SOFT_ARMOR, '(',/*102*/
    0,     4,   1,   1,  20,    0,   0,  2,   0, {0,0}  ,  1, Colour_Dark_Blue},
{"Soft Leather Armor"           ,0x00000000L,   TV_SOFT_ARMOR, '(',/*103*/
    0,    18,   2,   1,  80,    0,   0,  4,   0, {0,0}  ,  2, Colour_Leather},
{"Soft Studded Leather"         ,0x00000000L,   TV_SOFT_ARMOR, '(',/*104*/
    0,    35,   3,   1,  90,    0,   0,  5,   0, {1,1}  ,  3, Colour_Leather},
{"Hard Leather Armor"           ,0x00000000L,   TV_SOFT_ARMOR, '(',/*105*/
    0,    55,   4,   1, 100,  -1,   0,   6,   0, {1,1}  ,  5, Colour_Leather},
{"Hard Studded Leather"         ,0x00000000L,   TV_SOFT_ARMOR, '(',/*106*/
    0,   100,   5,   1, 110,  -1,   0,   7,   0, {1,2}  ,  7, Colour_Leather},
{"Woven Cord Armor"             ,0x00000000L,   TV_SOFT_ARMOR, '(',/*107*/
    0,    45,   6,   1, 150,  -1,   0,   6,   0, {0,0}  ,  7, Colour_Cord},
{"Soft Leather Ring Mail"       ,0x00000000L,   TV_SOFT_ARMOR, '(',/*108*/
    0,   160,   7,   1, 130,  -1,   0,   6,   0, {1,2}  , 10, Colour_Leather},
{"Hard Leather Ring Mail"       ,0x00000000L,   TV_SOFT_ARMOR, '(',/*109*/
    0,   230,   8,   1, 150,  -2,   0,   8,   0, {1,3}  , 12, Colour_Leather},
{"Leather Scale Mail"           ,0x00000000L,   TV_SOFT_ARMOR, '(',/*110*/
    0,   330,   9,   1, 140,  -1,   0,  11,   0, {1,1}  , 14, Colour_Leather},
{"Metal Scale Mail"             ,0x00000000L,   TV_HARD_ARMOR, '[',/*111*/
    0,   430,   1,   1, 250,  -2,   0,  13,   0, {1,4}  , 24, Colour_Iron},
{"Chain Mail"                   ,0x00000000L,   TV_HARD_ARMOR, '[',/*112*/
    0,   530,   2,   1, 220,  -2,   0,  14,   0, {1,4}  , 26, Colour_Iron},
{"Rusty Chain Mail"             ,0x00000000L,   TV_HARD_ARMOR, '[',/*113*/
    0,     0,   3,   1, 200,  -5,   0,  14,  -8, {1,4}  , 26, Colour_Rusty},
{"Double Chain Mail"            ,0x00000000L,   TV_HARD_ARMOR, '[',/*114*/
    0,   630,   4,   1, 260,  -2,   0,  15,   0, {1,4}  , 28, Colour_Iron},
{"Augmented Chain Mail"         ,0x00000000L,   TV_HARD_ARMOR, '[',/*115*/
    0,   675,   5,   1, 270,  -2,   0,  16,   0, {1,4}  , 30, Colour_Iron},
{"Bar Chain Mail"               ,0x00000000L,   TV_HARD_ARMOR, '[',/*116*/
    0,   720,   6,   1, 280,  -2,   0,  18,   0, {1,4}  , 34, Colour_Iron},
{"Metal Brigandine Armor"       ,0x00000000L,   TV_HARD_ARMOR, '[',/*117*/
    0,   775,   7,   1, 290,  -3,   0,  19,   0, {1,4}  , 36, Colour_Steel},
{"Laminated Armor"              ,0x00000000L,   TV_HARD_ARMOR, '[',/*118*/
    0,   825,   8,   1, 300,  -3,   0,  20,   0, {1,4}  , 38, Colour_Steel},
{"Partial Plate Armor"          ,0x00000000L,   TV_HARD_ARMOR, '[',/*119*/
    0,   900,   9,   1, 260,  -3,   0,  22,   0, {1,6}  , 42, Colour_Steel},
{"Metal Lamellar Armor"         ,0x00000000L,   TV_HARD_ARMOR, '[',/*120*/
    0,   950,   10,   1, 340,  -3,   0, 23,   0, {1,6}  , 44, Colour_Steel},
{"Full Plate Armor"             ,0x00000000L,   TV_HARD_ARMOR, '[',/*121*/
    0,  1050,   11,   1, 380,  -3,   0, 25,   0, {2,4}  , 48, Colour_Silver},
{"Ribbed Plate Armor"           ,0x00000000L,   TV_HARD_ARMOR, '[',/*122*/
    0,  1200,   12,   1, 380,  -3,   0, 28,   0, {2,4}  , 50, Colour_Silver},
{"& Cloak"                      ,0x00000000L,   TV_CLOAK, '(',  /*123*/
    0,     3,   1,   1,  10,    0,   0,  1,   0, {0,0}  ,  1, Colour_Dark_Green},
{"& Set of Leather Gloves"      ,0x00000000L,   TV_GLOVES, ']', /*124*/
    0,     3,   1,   1,   5,    0,   0,  1,   0, {0,0}  ,  1, Colour_Leather},
{"& Set of Gauntlets"           ,0x00000000L,   TV_GLOVES, ']', /*125*/
    0,    35,   2,   1,  25,    0,   0,  2,   0, {1,1}  , 12, Colour_Iron},
{"& Small Leather Shield"       ,0x00000000L,   TV_SHIELD, ')', /*126*/
    0,    30,   1,   1,  50,    0,   0,  2,   0, {1,1}  ,  3, Colour_Leather},
{"& Medium Leather Shield"      ,0x00000000L,   TV_SHIELD, ')', /*127*/
    0,    60,   2,   1,  75,    0,   0,  3,   0, {1,2}  ,  8, Colour_Leather},
{"& Large Leather Shield"       ,0x00000000L,   TV_SHIELD, ')', /*128*/
    0,   120,   3,   1, 100,    0,   0,  4,   0, {1,2}  , 15, Colour_Leather},
{"& Small Metal Shield"         ,0x00000000L,   TV_SHIELD, ')', /*129*/
    0,    50,   4,   1,  65,    0,   0,  3,   0, {1,2}  , 10, Colour_Iron},
{"& Medium Metal Shield"        ,0x00000000L,   TV_SHIELD, ')', /*130*/
    0,   125,   5,   1,  90,    0,   0,  4,   0, {1,3}  , 20, Colour_Iron},
{"& Large Metal Shield"         ,0x00000000L,   TV_SHIELD, ')', /*131*/
    0,   200,   6,   1, 120,    0,   0,  5,   0, {1,3}  , 30, Colour_Iron},
{"Gain Strength"                ,0x00000001L,   TV_RING, '=',   /*132*/
    0,   400,   0,   1,   2,    0,   0,  0,   0, {0,0}  , 30, Colour_Gold},
{"Gain Dexterity"               ,0x00000008L,   TV_RING, '=',   /*133*/
    0,   400,   1,   1,   2,    0,   0,  0,   0, {0,0}  , 30, Colour_Gold},
{"Gain Constitution"            ,0x00000010L,   TV_RING, '=',   /*134*/
    0,   400,   2,   1,   2,    0,   0,  0,   0, {0,0}  , 30, Colour_Gold},
{"Gain Intelligence"            ,0x00000002L,   TV_RING, '=',   /*135*/
    0,   350,   3,   1,   2,    0,   0,  0,   0, {0,0}  , 30, Colour_Gold},
{"Speed"                        ,0x00001000L,   TV_RING, '=',   /*136*/
    0,  3000,   4,   1,   2,    0,   0,  0,   0, {0,0}  , 50, Colour_Gold},
{"Searching"                    ,0x00000040L,   TV_RING, '=',   /*137*/
    0,   250,   5,   1,   2,    0,   0,  0,   0, {0,0}  ,  7, Colour_Gold},
{"Teleportation"                ,0x80000400L,   TV_RING, '=',   /*138*/
    0,     0,   6,   1,   2,    0,   0,  0,   0, {0,0}  ,  7, Colour_Gold},
{"Slow Digestion"               ,0x00000080L,   TV_RING, '=',   /*139*/
    0,   250,   7,   1,   2,    0,   0,  0,   0, {0,0}  ,  7, Colour_Gold},
{"Resist Fire"                  ,0x00080000L,   TV_RING, '=',   /*140*/
    0,   250,   8,   1,   2,    0,   0,  0,   0, {0,0}  , 14, Colour_Gold},
{"Resist Cold"                  ,0x00200000L,   TV_RING, '=',   /*141*/
    0,   250,   9,   1,   2,    0,   0,  0,   0, {0,0}  , 14, Colour_Gold},
{"Feather Falling"              ,0x04000000L,   TV_RING, '=',   /*142*/
    0,   200,   10,   1,   2,   0,   0,  0,   0, {0,0}  ,  7, Colour_Gold},
{"Adornment"                    ,0x00000000L,   TV_RING, '=',   /*143*/
    0,    20,   11,   1,   2,   0,   0,  0,   0, {0,0}  ,  7, Colour_Gold},
/* was a ring of adornment, subval = 12 here */
{"& Arrow~"                     ,0x00000000L,   TV_ARROW, '{',  /*144*/
    0,     1, 193,   1,   2,    0,   0,  0,   0, {1,4}  , 15, Colour_Wooden},
{"Weakness"                     ,0x80000001L,   TV_RING, '=',   /*145*/
   -5,     0,   13,   1,   2,   0,   0,  0,   0, {0,0}  ,  7, Colour_Gold},
{"Lordly Protection (FIRE)"     ,0x00080000L,   TV_RING, '=',   /*146*/
    0,  1200,   14,   1,   2,   0,   0,  0,   5, {0,0}  , 50, Colour_Gold},
{"Lordly Protection (ACID)"     ,0x00100000L,   TV_RING, '=',   /*147*/
    0,  1200,   15,   1,   2,   0,   0,  0,   5, {0,0}  , 50, Colour_Gold},
{"Lordly Protection (COLD)"     ,0x00200000L,   TV_RING, '=',   /*148*/
    0,  1200,   16,   1,   2,   0,   0,  0,   5, {0,0}  , 50, Colour_Gold},
{"WOE"                          ,0x80000644L,   TV_RING, '=',   /*149*/
   -5,     0,   17,   1,   2,   0,   0,  0,  -3, {0,0}  , 50, Colour_Gold},
{"Stupidity"                    ,0x80000002L,   TV_RING, '=',   /*150*/
   -5,     0,   18,   1,   2,   0,   0,  0,   0, {0,0}  ,  7, Colour_Gold},
{"Increase Damage"              ,0x00000000L,   TV_RING, '=',   /*151*/
    0,   100,   19,   1,   2,   0,   0,  0,   0, {0,0}  , 20, Colour_Gold},
{"Increase To-Hit"              ,0x00000000L,   TV_RING, '=',   /*152*/
    0,   100,   20,   1,   2,   0,   0,  0,   0, {0,0}  , 20, Colour_Gold},
{"Protection"                   ,0x00000000L,   TV_RING, '=',   /*153*/
    0,   100,   21,   1,   2,   0,   0,  0,   0, {0,0}  ,  7, Colour_Gold},
{"Aggravate Monster"            ,0x80000200L,   TV_RING, '=',   /*154*/
    0,     0,   22,   1,   2,   0,   0,  0,   0, {0,0}  ,  7, Colour_Gold},
{"See Invisible"                ,0x01000000L,   TV_RING, '=',   /*155*/
    0,   340,   23,   1,   2,   0,   0,  0,   0, {0,0}  , 40, Colour_Gold},
{"Sustain Strength"             ,0x00400000L,   TV_RING, '=',   /*156*/
    1,   750,   24,   1,   2,   0,   0,  0,   0, {0,0}  , 44, Colour_Gold},
{"Sustain Intelligence"         ,0x00400000L,   TV_RING, '=',   /*157*/
    2,   600,   25,   1,   2,   0,   0,  0,   0, {0,0}  , 44, Colour_Gold},
{"Sustain Wisdom"               ,0x00400000L,   TV_RING, '=',   /*158*/
    3,   600,   26,   1,   2,   0,   0,  0,   0, {0,0}  , 44, Colour_Gold},
{"Sustain Constitution"         ,0x00400000L,   TV_RING, '=',   /*159*/
    4,   750,   27,   1,   2,   0,   0,  0,   0, {0,0}  , 44, Colour_Gold},
{"Sustain Dexterity"            ,0x00400000L,   TV_RING, '=',   /*160*/
    5,   750,   28,   1,   2,   0,   0,  0,   0, {0,0}  , 44, Colour_Gold},
{"Sustain Charisma"             ,0x00400000L,   TV_RING, '=',   /*161*/
    6,   500,   29,   1,   2,   0,   0,  0,   0, {0,0}  , 44, Colour_Gold},
{"Slaying"                      ,0x00000000L,   TV_RING, '=',   /*162*/
    0,  1000,   30,   1,   2,   0,   0,  0,   0, {0,0}  , 50, Colour_Gold},
{"Wisdom"                       ,0x00000004L,   TV_AMULET, '"', /*163*/
    0,   300,   0,   1,   3,    0,   0,  0,   0, {0,0}  , 20, Colour_Silver},
{"Charisma"                     ,0x00000020L,   TV_AMULET, '"', /*164*/
    0,   250,   1,   1,   3,    0,   0,  0,   0, {0,0}  , 20, Colour_Silver},
{"Searching"                    ,0x00000040L,   TV_AMULET, '"', /*165*/
    0,   250,   2,   1,   3,    0,   0,  0,   0, {0,0}  , 14, Colour_Silver},
{"Teleportation"                ,0x80000400L,   TV_AMULET, '"', /*166*/
    0,     0,   3,   1,   3,    0,   0,  0,   0, {0,0}  , 14, Colour_Silver},
{"Slow Digestion"               ,0x00000080L,   TV_AMULET, '"', /*167*/
    0,   200,   4,   1,   3,    0,   0,  0,   0, {0,0}  , 14, Colour_Silver},
{"Resist Acid"                  ,0x00100000L,   TV_AMULET, '"', /*168*/
    0,   300,   5,   1,   3,    0,   0,  0,   0, {0,0}  , 24, Colour_Silver},
{"Adornment"                    ,0x00000000L,   TV_AMULET, '"', /*169*/
    0,    20,   6,   1,   3,    0,   0,  0,   0, {0,0}  , 16, Colour_Silver},
/* was an amulet of adornment here, subval = 7 */
{"& Bolt~"                      ,0x00000000L,   TV_BOLT, '{',   /*170*/
    0,     2, 193,   1,   3,    0,   0,  0,   0, {1,5}  , 25, Colour_Wooden},
{"the Magi"                     ,0x01800040L,   TV_AMULET, '"', /*171*/
    0,  5000,   8,   1,   3,    0,   0,  0,   3, {0,0}  , 50, Colour_Silver},
{"DOOM"                         ,0x8000007FL,   TV_AMULET, '"', /*172*/
   -5,     0,   9,   1,   3,    0,   0,  0,   0, {0,0}  , 50, Colour_Silver},
{"Enchant Weapon To-Hit"        ,0x00000001L,   TV_SCROLL1, '?',/*173*/
    0,   125,   64,   1,   5,   0,   0,  0,   0, {0,0}  , 12, Colour_Paper},
{"Enchant Weapon To-Dam"        ,0x00000002L,   TV_SCROLL1, '?',/*174*/
    0,   125,   65,   1,   5,   0,   0,  0,   0, {0,0}  , 12, Colour_Paper},
{"Enchant Armor"                ,0x00000004L,   TV_SCROLL1, '?',/*175*/
    0,   125,   66,   1,   5,   0,   0,  0,   0, {0,0}  , 12, Colour_Paper},
{"Identify"                     ,0x00000008L,   TV_SCROLL1, '?',/*176*/
    0,    50,   67,   1,   5,   0,   0,  0,   0, {0,0}  ,  1, Colour_Paper},
{"Identify"                     ,0x00000008L,   TV_SCROLL1, '?',/*177*/
    0,    50,   67,   1,   5,   0,   0,  0,   0, {0,0}  ,  5, Colour_Paper},
{"Identify"                     ,0x00000008L,   TV_SCROLL1, '?',/*178*/
    0,    50,   67,   1,   5,   0,   0,  0,   0, {0,0}  , 10, Colour_Paper},
{"Identify"                     ,0x00000008L,   TV_SCROLL1, '?',/*179*/
    0,    50,   67,   1,   5,   0,   0,  0,   0, {0,0}  , 30, Colour_Paper},
{"Remove Curse"                 ,0x00000010L,   TV_SCROLL1, '?',/*180*/
    0,   100,   68,   1,   5,   0,   0,  0,   0, {0,0}  ,  7, Colour_Paper},
{"Light"                        ,0x00000020L,   TV_SCROLL1, '?',/*181*/
    0,    15,   69,   1,   5,   0,   0,  0,   0, {0,0}  ,  0, Colour_Paper},
{"Light"                        ,0x00000020L,   TV_SCROLL1, '?',/*182*/
    0,    15,   69,   1,   5,   0,   0,  0,   0, {0,0}  ,  3, Colour_Paper},
{"Light"                        ,0x00000020L,   TV_SCROLL1, '?',/*183*/
    0,    15,   69,   1,   5,   0,   0,  0,   0, {0,0}  ,  7, Colour_Paper},
{"Summon Monster"               ,0x00000040L,   TV_SCROLL1, '?',/*184*/
    0,     0,   70,   1,   5,   0,   0,  0,   0, {0,0}  ,  1, Colour_Paper},
{"Phase Door"                   ,0x00000080L,   TV_SCROLL1, '?',/*185*/
    0,    15,   71,   1,   5,   0,   0,  0,   0, {0,0}  ,  1, Colour_Paper},
{"Teleport"                     ,0x00000100L,   TV_SCROLL1, '?',/*186*/
    0,    40,   72,   1,   5,   0,   0,  0,   0, {0,0}  , 10, Colour_Paper},
{"Teleport Level"               ,0x00000200L,   TV_SCROLL1, '?',/*187*/
    0,    50,   73,   1,   5,   0,   0,  0,   0, {0,0}  , 20, Colour_Paper},
{"Monster Confusion"            ,0x00000400L,   TV_SCROLL1, '?',/*188*/
    0,    30,   74,   1,   5,   0,   0,  0,   0, {0,0}  ,  5, Colour_Paper},
{"Magic Mapping"                ,0x00000800L,   TV_SCROLL1, '?',/*189*/
    0,    40,   75,   1,   5,   0,   0,  0,   0, {0,0}  ,  5, Colour_Paper},
{"Sleep Monster"                ,0x00001000L,   TV_SCROLL1, '?',/*190*/
    0,    35,   76,   1,   5,   0,   0,  0,   0, {0,0}  ,  5, Colour_Paper},
{"Rune of Protection"           ,0x00002000L,   TV_SCROLL1, '?',/*191*/
    0,   500,   77,   1,   5,   0,   0,  0,   0, {0,0}  , 50, Colour_Paper},
{"Treasure Detection"           ,0x00004000L,   TV_SCROLL1, '?',/*192*/
    0,    15,   78,   1,   5,   0,   0,  0,   0, {0,0}  ,  0, Colour_Paper},
{"Object Detection"             ,0x00008000L,   TV_SCROLL1, '?',/*193*/
    0,    15,   79,   1,   5,   0,   0,  0,   0, {0,0}  ,  0, Colour_Paper},
{"Trap Detection"               ,0x00010000L,   TV_SCROLL1, '?',/*194*/
    0,    35,   80,   1,   5,   0,   0,  0,   0, {0,0}  ,  5, Colour_Paper},
{"Trap Detection"               ,0x00010000L,   TV_SCROLL1, '?',/*195*/
    0,    35,   80,   1,   5,   0,   0,  0,   0, {0,0}  ,  8, Colour_Paper},
{"Trap Detection"               ,0x00010000L,   TV_SCROLL1, '?',/*196*/
    0,    35,   80,   1,   5,   0,   0,  0,   0, {0,0}  , 12, Colour_Paper},
{"Door/Stair Location"          ,0x00020000L,   TV_SCROLL1, '?',/*197*/
    0,    35,   81,   1,   5,   0,   0,  0,   0, {0,0}  ,  5, Colour_Paper},
{"Door/Stair Location"          ,0x00020000L,   TV_SCROLL1, '?',/*198*/
    0,    35,   81,   1,   5,   0,   0,  0,   0, {0,0}  , 10, Colour_Paper},
{"Door/Stair Location"          ,0x00020000L,   TV_SCROLL1, '?',/*199*/
    0,    35,   81,   1,   5,   0,   0,  0,   0, {0,0}  , 15, Colour_Paper},
{"Mass Genocide"                ,0x00040000L,   TV_SCROLL1, '?',/*200*/
    0,  1000,   82,   1,   5,   0,   0,  0,   0, {0,0}  , 50, Colour_Paper},
{"Detect Invisible"             ,0x00080000L,   TV_SCROLL1, '?',/*201*/
    0,    15,   83,   1,   5,   0,   0,  0,   0, {0,0}  ,  1, Colour_Paper},
{"Aggravate Monster"            ,0x00100000L,   TV_SCROLL1, '?',/*202*/
    0,     0,   84,   1,   5,   0,   0,  0,   0, {0,0}  ,  5, Colour_Paper},
{"Trap Creation"                ,0x00200000L,   TV_SCROLL1, '?',/*203*/
    0,     0,   85,   1,   5,   0,   0,  0,   0, {0,0}  , 12, Colour_Paper},
{"Trap/Door Destruction"        ,0x00400000L,   TV_SCROLL1, '?',/*204*/
    0,    50,   86,   1,   5,   0,   0,  0,   0, {0,0}  , 12, Colour_Paper},
{"Door Creation"                ,0x00800000L,   TV_SCROLL1, '?',/*205*/
    0,   100,   87,   1,   5,   0,   0,  0,   0, {0,0}  , 12, Colour_Paper},
{"Recharging"                   ,0x01000000L,   TV_SCROLL1, '?',/*206*/
    0,   200,   88,   1,   5,   0,   0,  0,   0, {0,0}  , 40, Colour_Paper},
{"Genocide"                     ,0x02000000L,   TV_SCROLL1, '?',/*207*/
    0,   750,   89,   1,   5,   0,   0,  0,   0, {0,0}  , 35, Colour_Paper},
{"Darkness"                     ,0x04000000L,   TV_SCROLL1, '?',/*208*/
    0,     0,   90,   1,   5,   0,   0,  0,   0, {0,0}  ,  1, Colour_Paper},
{"Protection from Evil"         ,0x08000000L,   TV_SCROLL1, '?',/*209*/
    0,    50,   91,   1,   5,   0,   0,  0,   0, {0,0}  , 30, Colour_Paper},
{"Create Food"                  ,0x10000000L,   TV_SCROLL1, '?',/*210*/
    0,    10,   92,   1,   5,   0,   0,  0,   0, {0,0}  ,  5, Colour_Paper},
{"Dispel Undead"                ,0x20000000L,   TV_SCROLL1, '?',/*211*/
    0,   200,   93,   1,   5,   0,   0,  0,   0, {0,0}  , 40, Colour_Paper},
{"*Enchant Weapon*"             ,0x00000001L,   TV_SCROLL2, '?',/*212*/
    0,   500,   94,   1,   5,   0,   0,  0,   0, {0,0}  , 50, Colour_Paper},
{"Curse Weapon"                 ,0x00000002L,   TV_SCROLL2, '?',/*213*/
    0,     0,   95,   1,   5,   0,   0,  0,   0, {0,0}  , 50, Colour_Paper},
{"*Enchant Armor*"              ,0x00000004L,   TV_SCROLL2, '?',/*214*/
    0,   500,   96,   1,   5,   0,   0,  0,   0, {0,0}  , 50, Colour_Paper},
{"Curse Armor"                  ,0x00000008L,   TV_SCROLL2, '?',/*215*/
    0,     0,   97,   1,   5,   0,   0,  0,   0, {0,0}  , 50, Colour_Paper},
{"Summon Undead"                ,0x00000010L,   TV_SCROLL2, '?',/*216*/
    0,     0,   98,   1,   5,   0,   0,  0,   0, {0,0}  , 15, Colour_Paper},
{"Blessing"                     ,0x00000020L,   TV_SCROLL2, '?',/*217*/
    0,    15,   99,   1,   5,   0,   0,  0,   0, {0,0}  ,  1, Colour_Paper},
{"Holy Chant"                   ,0x00000040L,   TV_SCROLL2, '?',/*218*/
    0,    40, 100,   1,   5,    0,   0,  0,   0, {0,0}  , 12, Colour_Paper},
{"Holy Prayer"                  ,0x00000080L,   TV_SCROLL2, '?',/*219*/
    0,    80, 101,   1,   5,    0,   0,  0,   0, {0,0}  , 24, Colour_Paper},
{"Word-of-Recall"               ,0x00000100L,   TV_SCROLL2, '?',/*220*/
    0,   150, 102,   1,   5,    0,   0,  0,   0, {0,0}  ,  5, Colour_Paper},
{"*Destruction*"                ,0x00000200L,   TV_SCROLL2, '?',/*221*/
    0,   250, 103,   1,   5,    0,   0,  0,   0, {0,0}  , 40, Colour_Paper},
/* SMJ, AJ, Water must be subval 64-66 resp. for objdes to work */
{"Slime Mold Juice"             ,0x30000000L,   TV_POTION1, '!',/*222*/
  400,     2,   64,   1,   4,   0,   0,  0,   0, {1,1}  ,  0, Colour_Icky_Green},
{"Apple Juice"                  ,0x00000000L,   TV_POTION1, '!',/*223*/
  250,     1,   65,   1,   4,   0,   0,  0,   0, {1,1}  ,  0, Colour_Light_Brown},
{"Water"                        ,0x00000000L,   TV_POTION1, '!',/*224*/
  200,     0,   66,   1,   4,   0,   0,  0,   0, {1,1}  ,  0, Colour_Clear},
{"Gain Strength"                ,0x00000001L,   TV_POTION1, '!',/*225*/
    0,   300,   67,   1,   4,   0,   0,  0,   0, {1,1}  , 25, Colour_Blue},
{"Weakness"                     ,0x00000002L,   TV_POTION1, '!',/*226*/
    0,     0,   68,   1,   4,   0,   0,  0,   0, {1,1}  ,  3, Colour_Blue},
{"Restore Strength"             ,0x00000004L,   TV_POTION1, '!',/*227*/
    0,   300,   69,   1,   4,   0,   0,  0,   0, {1,1}  , 40, Colour_Blue},
{"Gain Intelligence"            ,0x00000008L,   TV_POTION1, '!',/*228*/
    0,   300,   70,   1,   4,   0,   0,  0,   0, {1,1}  , 25, Colour_Blue},
{"Lose Intelligence"            ,0x00000010L,   TV_POTION1, '!',/*229*/
    0,     0,   71,   1,   4,   0,   0,  0,   0, {1,1}  , 25, Colour_Blue},
{"Restore Intelligence"         ,0x00000020L,   TV_POTION1, '!',/*230*/
    0,   300,   72,   1,   4,   0,   0,  0,   0, {1,1}  , 40, Colour_Blue},
{"Gain Wisdom"                  ,0x00000040L,   TV_POTION1, '!',/*231*/
    0,   300,   73,   1,   4,   0,   0,  0,   0, {1,1}  , 25, Colour_Blue},
{"Lose Wisdom"                  ,0x00000080L,   TV_POTION1, '!',/*232*/
    0,     0,   74,   1,   4,   0,   0,  0,   0, {1,1}  , 25, Colour_Blue},
{"Restore Wisdom"               ,0x00000100L,   TV_POTION1, '!',/*233*/
    0,   300,   75,   1,   4,   0,   0,  0,   0, {1,1}  , 40, Colour_Blue},
{"Charisma"                     ,0x00000200L,   TV_POTION1, '!',/*234*/
    0,   300,   76,   1,   4,   0,   0,  0,   0, {1,1}  , 25, Colour_Blue},
{"Ugliness"                     ,0x00000400L,   TV_POTION1, '!',/*235*/
    0,     0,   77,   1,   4,   0,   0,  0,   0, {1,1}  , 25, Colour_Blue},
{"Restore Charisma"             ,0x00000800L,   TV_POTION1, '!',/*236*/
    0,   300,   78,   1,   4,   0,   0,  0,   0, {1,1}  , 40, Colour_Blue},
{"Cure Light Wounds"            ,0x10001000L,   TV_POTION1, '!',/*237*/
   50,    15,   79,   1,   4,   0,   0,  0,   0, {1,1}  ,  0, Colour_Blue},
{"Cure Light Wounds"            ,0x10001000L,   TV_POTION1, '!',/*238*/
   50,    15,   79,   1,   4,   0,   0,  0,   0, {1,1}  ,  1, Colour_Blue},
{"Cure Light Wounds"            ,0x10001000L,   TV_POTION1, '!',/*239*/
   50,    15,   79,   1,   4,   0,   0,  0,   0, {1,1}  ,  2, Colour_Blue},
{"Cure Serious Wounds"          ,0x30002000L,   TV_POTION1, '!',/*240*/
  100,    40,   80,   1,   4,   0,   0,  0,   0, {1,1}  ,  3, Colour_Blue},
{"Cure Critical Wounds"         ,0x70004000L,   TV_POTION1, '!',/*241*/
  100,   100,   81,   1,   4,   0,   0,  0,   0, {1,1}  ,  5, Colour_Blue},
{"Healing"                      ,0x70008000L,   TV_POTION1, '!',/*242*/
  200,   200,   82,   1,   4,   0,   0,  0,   0, {1,1}  , 12, Colour_Blue},
{"Gain Constitution"            ,0x00010000L,   TV_POTION1, '!',/*243*/
    0,   300,   83,   1,   4,   0,   0,  0,   0, {1,1}  , 25, Colour_Blue},
{"Gain Experience"              ,0x00020000L,   TV_POTION1, '!',/*244*/
    0,  2500,   84,   1,   4,   0,   0,  0,   0, {1,1}  , 50, Colour_Blue},
{"Sleep"                        ,0x00040000L,   TV_POTION1, '!',/*245*/
  100,     0,   85,   1,   4,   0,   0,  0,   0, {1,1}  ,  0, Colour_Blue},
{"Blindness"                    ,0x00080000L,   TV_POTION1, '!',/*246*/
    0,     0,   86,   1,   4,   0,   0,  0,   0, {1,1}  ,  0, Colour_Blue},
{"Confusion"                    ,0x00100000L,   TV_POTION1, '!',/*247*/
   50,     0,   87,   1,   4,   0,   0,  0,   0, {1,1}  ,  0, Colour_Blue},
{"Poison"                       ,0x00200000L,   TV_POTION1, '!',/*248*/
    0,     0,   88,   1,   4,   0,   0,  0,   0, {1,1}  ,  3, Colour_Blue},
{"Haste Self"                   ,0x00400000L,   TV_POTION1, '!',/*249*/
    0,    75,   89,   1,   4,   0,   0,  0,   0, {1,1}  ,  1, Colour_Blue},
{"Slowness"                     ,0x00800000L,   TV_POTION1, '!',/*250*/
   50,     0,   90,   1,   4,   0,   0,  0,   0, {1,1}  ,  1, Colour_Blue},
{"Gain Dexterity"               ,0x02000000L,   TV_POTION1, '!',/*251*/
    0,   300,   91,   1,   4,   0,   0,  0,   0, {1,1}  , 25, Colour_Blue},
{"Restore Dexterity"            ,0x04000000L,   TV_POTION1, '!',/*252*/
    0,   300,   92,   1,   4,   0,   0,  0,   0, {1,1}  , 40, Colour_Blue},
{"Restore Constitution"         ,0x68000000L,   TV_POTION1, '!',/*253*/
    0,   300,   93,   1,   4,   0,   0,  0,   0, {1,1}  , 40, Colour_Blue},
{"Lose Experience"              ,0x00000002L,   TV_POTION2, '!',/*254*/
    0,     0,   95,   1,   4,   0,   0,  0,   0, {1,1}  , 10, Colour_Blue},
{"Salt Water"                   ,0x00000004L,   TV_POTION2, '!',/*255*/
    0,     0,   96,   1,   4,   0,   0,  0,   0, {1,1}  ,  0, Colour_Blue},
{"Invulnerability"              ,0x00000008L,   TV_POTION2, '!',/*256*/
    0,   250,   97,   1,   4,   0,   0,  0,   0, {1,1}  , 40, Colour_Blue},
{"Heroism"                      ,0x00000010L,   TV_POTION2, '!',/*257*/
    0,    35,   98,   1,   4,   0,   0,  0,   0, {1,1}  ,  1, Colour_Blue},
{"Super Heroism"                ,0x00000020L,   TV_POTION2, '!',/*258*/
    0,   100,   99,   1,   4,   0,   0,  0,   0, {1,1}  ,  3, Colour_Blue},
{"Boldness"                     ,0x00000040L,   TV_POTION2, '!',/*259*/
    0,    10, 100,   1,   4,    0,   0,  0,   0, {1,1}  ,  1, Colour_Blue},
{"Restore Life Levels"          ,0x00000080L,   TV_POTION2, '!',/*260*/
    0,   400, 101,   1,   4,    0,   0,  0,   0, {1,1}  , 40, Colour_Blue},
{"Resist Heat"                  ,0x00000100L,   TV_POTION2, '!',/*261*/
    0,    30, 102,   1,   4,    0,   0,  0,   0, {1,1}  ,  1, Colour_Blue},
{"Resist Cold"                  ,0x00000200L,   TV_POTION2, '!',/*262*/
    0,    30, 103,   1,   4,    0,   0,  0,   0, {1,1}  ,  1, Colour_Blue},
{"Detect Invisible"             ,0x00000400L,   TV_POTION2, '!',/*263*/
    0,    50, 104,   1,   4,    0,   0,  0,   0, {1,1}  ,  3, Colour_Blue},
{"Slow Poison"                  ,0x00000800L,   TV_POTION2, '!',/*264*/
    0,    25, 105,   1,   4,    0,   0,  0,   0, {1,1}  ,  1, Colour_Blue},
{"Neutralize Poison"            ,0x00001000L,   TV_POTION2, '!',/*265*/
    0,    75, 106,   1,   4,    0,   0,  0,   0, {1,1}  ,  5, Colour_Blue},
{"Restore Mana"                 ,0x00002000L,   TV_POTION2, '!',/*266*/
    0,   350, 107,   1,   4,    0,   0,  0,   0, {1,1}  , 25, Colour_Blue},
{"Infra-Vision"                 ,0x00004000L,   TV_POTION2, '!',/*267*/
    0,    20, 108,   1,   4,    0,   0,  0,   0, {1,1}  ,  3, Colour_Blue},
{"& Flask~ of oil"              ,0x00040000L,   TV_FLASK, '!',  /*268*/
 7500,     3,   64,   1,  10,   0,   0,  0,   0, {2,6}  ,  1, Colour_Oil},
{"Light"                        ,0x00000001L,   TV_WAND, '-',   /*269*/
    0,   200,   0,   1,  10,    0,   0,  0,   0, {1,1}  ,  2, Colour_Iron},
{"Lightning Bolts"              ,0x00000002L,   TV_WAND, '-',   /*270*/
    0,   600,   1,   1,  10,    0,   0,  0,   0, {1,1}  , 15, Colour_Iron},
{"Frost Bolts"                  ,0x00000004L,   TV_WAND, '-',   /*271*/
    0,   800,   2,   1,  10,    0,   0,  0,   0, {1,1}  , 20, Colour_Iron},
{"Fire Bolts"                   ,0x00000008L,   TV_WAND, '-',   /*272*/
    0,  1000,   3,   1,  10,    0,   0,  0,   0, {1,1}  , 30, Colour_Iron},
{"Stone-to-Mud"                 ,0x00000010L,   TV_WAND, '-',   /*273*/
    0,   300,   4,   1,  10,    0,   0,  0,   0, {1,1}  , 12, Colour_Iron},
{"Polymorph"                    ,0x00000020L,   TV_WAND, '-',   /*274*/
    0,   400,   5,   1,  10,    0,   0,  0,   0, {1,1}  , 20, Colour_Iron},
{"Heal Monster"                 ,0x00000040L,   TV_WAND, '-',   /*275*/
    0,     0,   6,   1,  10,    0,   0,  0,   0, {1,1}  ,  2, Colour_Iron},
{"Haste Monster"                ,0x00000080L,   TV_WAND, '-',   /*276*/
    0,     0,   7,   1,  10,    0,   0,  0,   0, {1,1}  ,  2, Colour_Iron},
{"Slow Monster"                 ,0x00000100L,   TV_WAND, '-',   /*277*/
    0,   500,   8,   1,  10,    0,   0,  0,   0, {1,1}  ,  2, Colour_Iron},
{"Confuse Monster"              ,0x00000200L,   TV_WAND, '-',   /*278*/
    0,   400,   9,   1,  10,    0,   0,  0,   0, {1,1}  ,  2, Colour_Iron},
{"Sleep Monster"                ,0x00000400L,   TV_WAND, '-',   /*279*/
    0,   500,   10,   1,  10,   0,   0,  0,   0, {1,1}  ,  7, Colour_Iron},
{"Drain Life"                   ,0x00000800L,   TV_WAND, '-',   /*280*/
    0,  1200,   11,   1,  10,   0,   0,  0,   0, {1,1}  , 50, Colour_Iron},
{"Trap/Door Destruction"        ,0x00001000L,   TV_WAND, '-',   /*281*/
    0,   100,   12,   1,  10,   0,   0,  0,   0, {1,1}  , 12, Colour_Iron},
{"Magic Missile"                ,0x00002000L,   TV_WAND, '-',   /*282*/
    0,   200,   13,   1,  10,   0,   0,  0,   0, {1,1}  ,  2, Colour_Iron},
{"Wall Building"                ,0x00004000L,   TV_WAND, '-',   /*283*/
    0,   400,   14,   1,  10,   0,   0,  0,   0, {1,1}  , 25, Colour_Iron},
{"Clone Monster"                ,0x00008000L,   TV_WAND, '-',   /*284*/
    0,     0,   15,   1,  10,   0,   0,  0,   0, {1,1}  , 15, Colour_Iron},
{"Teleport Away"                ,0x00010000L,   TV_WAND, '-',   /*285*/
    0,   350,   16,   1,  10,   0,   0,  0,   0, {1,1}  , 20, Colour_Iron},
{"Disarming"                    ,0x00020000L,   TV_WAND, '-',   /*286*/
    0,   700,   17,   1,  10,   0,   0,  0,   0, {1,1}  , 20, Colour_Iron},
{"Lightning Balls"              ,0x00040000L,   TV_WAND, '-',   /*287*/
    0,  1200,   18,   1,  10,   0,   0,  0,   0, {1,1}  , 35, Colour_Iron},
{"Cold Balls"                   ,0x00080000L,   TV_WAND, '-',   /*288*/
    0,  1500,   19,   1,  10,   0,   0,  0,   0, {1,1}  , 40, Colour_Iron},
{"Fire Balls"                   ,0x00100000L,   TV_WAND, '-',   /*289*/
    0,  1800,   20,   1,  10,   0,   0,  0,   0, {1,1}  , 50, Colour_Iron},
{"Stinking Cloud"               ,0x00200000L,   TV_WAND, '-',   /*290*/
    0,   400,   21,   1,  10,   0,   0,  0,   0, {1,1}  ,  5, Colour_Iron},
{"Acid Balls"                   ,0x00400000L,   TV_WAND, '-',   /*291*/
    0,  1650,   22,   1,  10,   0,   0,  0,   0, {1,1}  , 48, Colour_Iron},
{"Wonder"                       ,0x00800000L,   TV_WAND, '-',   /*292*/
    0,   250,   23,   1,  10,   0,   0,  0,   0, {1,1}  ,  2, Colour_Iron},
{"Light"                        ,0x00000001L,   TV_STAFF, '_',  /*293*/
    0,   250,   0,   1,  50,    0,   0,  0,   0, {1,2}  ,  5, Colour_Wooden},
{"Door/Stair Location"          ,0x00000002L,   TV_STAFF, '_',  /*294*/
    0,   350,   1,   1,  50,    0,   0,  0,   0, {1,2}  , 10, Colour_Wooden},
{"Trap Location"                ,0x00000004L,   TV_STAFF, '_',  /*295*/
    0,   350,   2,   1,  50,    0,   0,  0,   0, {1,2}  , 10, Colour_Wooden},
{"Treasure Location"            ,0x00000008L,   TV_STAFF, '_',  /*296*/
    0,   200,   3,   1,  50,    0,   0,  0,   0, {1,2}  ,  5, Colour_Wooden},
{"Object Location"              ,0x00000010L,   TV_STAFF, '_',  /*297*/
    0,   200,   4,   1,  50,    0,   0,  0,   0, {1,2}  ,  5, Colour_Wooden},
{"Teleportation"                ,0x00000020L,   TV_STAFF, '_',  /*298*/
    0,   400,   5,   1,  50,    0,   0,  0,   0, {1,2}  , 20, Colour_Wooden},
{"Earthquakes"                  ,0x00000040L,   TV_STAFF, '_',  /*299*/
    0,   350,   6,   1,  50,    0,   0,  0,   0, {1,2}  , 40, Colour_Wooden},
{"Summoning"                    ,0x00000080L,   TV_STAFF, '_',  /*300*/
    0,     0,   7,   1,  50,    0,   0,  0,   0, {1,2}  , 10, Colour_Wooden},
{"Summoning"                    ,0x00000080L,   TV_STAFF, '_',  /*301*/
    0,     0,   7,   1,  50,    0,   0,  0,   0, {1,2}  , 50, Colour_Wooden},
{"*Destruction*"                ,0x00000200L,   TV_STAFF, '_',  /*302*/
    0,  2500,   8,   1,  50,    0,   0,  0,   0, {1,2}  , 50, Colour_Wooden},
{"Starlight"                    ,0x00000400L,   TV_STAFF, '_',  /*303*/
    0,   800,   9,   1,  50,    0,   0,  0,   0, {1,2}  , 20, Colour_Wooden},
{"Haste Monsters"               ,0x00000800L,   TV_STAFF, '_',  /*304*/
    0,     0,   10,   1,  50,   0,   0,  0,   0, {1,2}  , 10, Colour_Wooden},
{"Slow Monsters"                ,0x00001000L,   TV_STAFF, '_',  /*305*/
    0,   800,   11,   1,  50,   0,   0,  0,   0, {1,2}  , 10, Colour_Wooden},
{"Sleep Monsters"               ,0x00002000L,   TV_STAFF, '_',  /*306*/
    0,   700,   12,   1,  50,   0,   0,  0,   0, {1,2}  , 10, Colour_Wooden},
{"Cure Light Wounds"            ,0x00004000L,   TV_STAFF, '_',  /*307*/
    0,   350,   13,   1,  50,   0,   0,  0,   0, {1,2}  ,  5, Colour_Wooden},
{"Detect Invisible"             ,0x00008000L,   TV_STAFF, '_',  /*308*/
    0,   200,   14,   1,  50,   0,   0,  0,   0, {1,2}  ,  5, Colour_Wooden},
{"Speed"                        ,0x00010000L,   TV_STAFF, '_',  /*309*/
    0,  1000,   15,   1,  50,   0,   0,  0,   0, {1,2}  , 40, Colour_Wooden},
{"Slowness"                     ,0x00020000L,   TV_STAFF, '_',  /*310*/
    0,     0,   16,   1,  50,   0,   0,  0,   0, {1,2}  , 40, Colour_Wooden},
{"Mass Polymorph"               ,0x00040000L,   TV_STAFF, '_',  /*311*/
    0,   750,   17,   1,  50,   0,   0,  0,   0, {1,2}  , 46, Colour_Wooden},
{"Remove Curse"                 ,0x00080000L,   TV_STAFF, '_',  /*312*/
    0,   500,   18,   1,  50,   0,   0,  0,   0, {1,2}  , 47, Colour_Wooden},
{"Detect Evil"                  ,0x00100000L,   TV_STAFF, '_',  /*313*/
    0,   350,   19,   1,  50,   0,   0,  0,   0, {1,2}  , 20, Colour_Wooden},
{"Curing"                       ,0x00200000L,   TV_STAFF, '_',  /*314*/
    0,  1000,   20,   1,  50,   0,   0,  0,   0, {1,2}  , 25, Colour_Wooden},
{"Dispel Evil"                  ,0x00400000L,   TV_STAFF, '_',  /*315*/
    0,  1200,   21,   1,  50,   0,   0,  0,   0, {1,2}  , 49, Colour_Wooden},
{"Darkness"                     ,0x01000000L,   TV_STAFF, '_',  /*316*/
    0,     0,   22,   1,  50,   0,   0,  0,   0, {1,2}  , 50, Colour_Wooden},
{"Darkness"                     ,0x01000000L,   TV_STAFF, '_',  /*317*/
    0,     0,   22,   1,  50,   0,   0,  0,   0, {1,2}  ,  5, Colour_Wooden},
{"[Beginners-Magik]"            ,0x0000007FL,   TV_MAGIC_BOOK, '?',/*318*/
    0,    25,   64,   1,  30,   0,   0,  0,   0, {1,1}  , 40, Colour_Old_Parchment},
{"[Magik I]"                    ,0x0000FF80L,   TV_MAGIC_BOOK, '?',/*319*/
    0,   100,   65,   1,  30,   0,   0,  0,   0, {1,1}  , 40, Colour_Old_Parchment},
{"[Magik II]"                   ,0x00FF0000L,   TV_MAGIC_BOOK, '?',/*320*/
    0,   400,   66,   1,  30,   0,   0,  0,   0, {1,1}  , 40, Colour_Old_Parchment},
{"[The Mages Guide to Power]"   ,0x7F000000L,   TV_MAGIC_BOOK, '?',/*321*/
    0,   800,   67,   1,  30,   0,   0,  0,   0, {1,1}  , 40, Colour_Old_Parchment},
{"[Beginners Handbook]"         ,0x000000FFL,   TV_PRAYER_BOOK, '?',/*322*/
    0,    25,   64,   1,  30,   0,   0,  0,   0, {1,1}  , 40, Colour_Old_Parchment},
{"[Words of Wisdom]"            ,0x0000FF00L,   TV_PRAYER_BOOK, '?',/*323*/
    0,   100,   65,   1,  30,   0,   0,  0,   0, {1,1}  , 40, Colour_Old_Parchment},
{"[Chants and Blessings]"       ,0x01FF0000L,   TV_PRAYER_BOOK, '?',/*324*/
    0,   300,   66,   1,  30,   0,   0,  0,   0, {1,1}  , 40, Colour_Old_Parchment},
{"[Exorcism and Dispelling]"    ,0x7E000000L,   TV_PRAYER_BOOK, '?',/*325*/
    0,   900,   67,   1,  30,   0,   0,  0,   0, {1,1}  , 40, Colour_Old_Parchment},
{"& Small wooden chest"         ,0x0F000000L,    TV_CHEST, '&', /*326*/
    0,    20,   1,   1, 250,    0,   0,  0,   0, {2,3}  ,  7, Colour_Wooden},
{"& Large wooden chest"         ,0x15000000L,    TV_CHEST, '&', /*327*/
    0,    60,   4,   1, 500,    0,   0,  0,   0, {2,5}  , 15, Colour_Wooden},
{"& Small iron chest"           ,0x0F000000L,    TV_CHEST, '&', /*328*/
    0,   100,   7,   1, 300,    0,   0,  0,   0, {2,4}  , 25, Colour_Iron},
{"& Large iron chest"           ,0x1F000000L,    TV_CHEST, '&', /*329*/
    0,   150,   10,   1,1000,   0,   0,  0,   0, {2,6}  , 35, Colour_Iron},
{"& Small steel chest"          ,0x0F000000L,    TV_CHEST, '&', /*330*/
    0,   200,   13,   1, 500,   0,   0,  0,   0, {2,4}  , 45, Colour_Steel},
{"& Large steel chest"          ,0x23000000L,    TV_CHEST, '&', /*331*/
    0,   250,   16,   1,1000,   0,   0,  0,   0, {2,6}  , 50, Colour_Steel},
{"& Rat Skeleton"               ,0x00000000L,    TV_MISC, 's',  /*332*/
    0,     0,   1,   1,  10,    0,   0,  0,   0, {1,1}  ,  1, Colour_Bone},
{"& Giant Centipede Skeleton"   ,0x00000000L,    TV_MISC, 's',  /*333*/
    0,     0,   2,   1,  25,    0,   0,  0,   0, {1,1}  ,  1, Colour_Bone},
{"some filthy rags"             ,0x00000000L,   TV_SOFT_ARMOR, '~',/*334*/
    0,     0,   63,   1,  20,   0,   0,  1,   0, {0,0}  ,  0, Colour_Dirt},
{"& empty bottle"               ,0x00000000L,    TV_MISC, '!',  /*335*/
    0,     0,   4,   1,   2,    0,   0,  0,   0, {1,1}  ,  0, Colour_Clear},
{"some shards of pottery"       ,0x00000000L,    TV_MISC, '~',  /*336*/
    0,     0,   5,   1,   5,    0,   0,  0,   0, {1,1}  ,  0, Colour_Pottery},
{"& Human Skeleton"             ,0x00000000L,    TV_MISC, 's',  /*337*/
    0,     0,   7,   1,  50,    0,   0,  0,   0, {1,1}  ,  1, Colour_Bone},
{"& Dwarf Skeleton"             ,0x00000000L,    TV_MISC, 's',  /*338*/
    0,     0,   8,   1,  60,    0,   0,  0,   0, {1,1}  ,  1, Colour_Bone},
{"& Elf Skeleton"               ,0x00000000L,    TV_MISC, 's',  /*339*/
    0,     0,   9,   1,  40,    0,   0,  0,   0, {1,1}  ,  1, Colour_Bone},
{"& Gnome Skeleton"             ,0x00000000L,    TV_MISC, 's',  /*340*/
    0,     0,   10,   1,  25,   0,   0,  0,   0, {1,1}  ,  1, Colour_Bone},
{"& broken set of teeth"        ,0x00000000L,    TV_MISC, 's',  /*341*/
    0,     0,   11,   1,   3,   0,   0,  0,   0, {1,1}  ,  0, Colour_Bone},
{"& large broken bone"          ,0x00000000L,    TV_MISC, 's',  /*342*/
    0,     0,   12,   1,   2,   0,   0,  0,   0, {1,1}  ,  0, Colour_Bone},
{"& broken stick"               ,0x00000000L,    TV_MISC, '~',  /*343*/
    0,     0,   13,   1,   3,   0,   0,  0,   0, {1,1}  ,  0, Colour_Wooden},
/* end of Dungeon items */
/* Store items, which are not also dungeon items, some of these can be
   found above, except that the number is >1 below */
{"& Ration~ of Food"            ,0x00000000L,   TV_FOOD, ',',   /*344*/
 5000,     3,   90,   5,  10,   0,   0,  0,   0, {0,0}  ,  0, Colour_Food},
{"& Hard Biscuit~"              ,0x00000000L,   TV_FOOD, ',',   /*345*/
  500,     1,   93,   5,   2,   0,   0,  0,   0, {0,0}  ,  0, Colour_Food},
{"& Strip~ of Beef Jerky"       ,0x00000000L,   TV_FOOD, ',',   /*346*/
 1750,     2,   94,   5,   2,   0,   0,  0,   0, {0,0}  ,  0, Colour_Food},
{"& Pint~ of Fine Ale"          ,0x00000000L,   TV_FOOD, ',',   /*347*/
  500,     1,   95,   3,  10,   0,   0,  0,   0, {0,0}  ,  0, Colour_Brown},
{"& Pint~ of Fine Wine"         ,0x00000000L,   TV_FOOD, ',',   /*348*/
  400,     2,   96,   1,  10,   0,   0,  0,   0, {0,0}  ,  0, Colour_Wine},
{"& Pick"                       ,0x20000000L,   TV_DIGGING, '\\',/*349*/
    1,    50,   1,   1, 150,    0,   0,  0,   0, {1,3}  ,  0, Colour_Iron},
{"& Shovel"                     ,0x20000000L,   TV_DIGGING, '\\',/*350*/
    0,    15,   4,   1,  60,    0,   0,  0,   0, {1,2}  ,  0, Colour_Iron},
{"Identify"                     ,0x00000008L,   TV_SCROLL1, '?',/*351*/
    0,    50,  67,   2,   5,    0,   0,  0,   0, {0,0}  ,  0, Colour_Paper},
{"Light"                        ,0x00000020L,   TV_SCROLL1, '?',/*352*/
    0,    15,  69,   3,   5,    0,   0,  0,   0, {0,0}  ,  0, Colour_Paper},
{"Phase Door"                   ,0x00000080L,   TV_SCROLL1, '?',/*353*/
    0,    15,  71,   2,   5,    0,   0,  0,   0, {0,0}  ,  0, Colour_Paper},
{"Magic Mapping"                ,0x00000800L,   TV_SCROLL1, '?',/*354*/
    0,    40,  75,   2,   5,    0,   0,  0,   0, {0,0}  ,  0, Colour_Paper},
{"Treasure Detection"           ,0x00004000L,   TV_SCROLL1, '?',/*355*/
    0,    15,  78,   2,   5,    0,   0,  0,   0, {0,0}  ,  0, Colour_Paper},
{"Object Detection"             ,0x00008000L,   TV_SCROLL1, '?',/*356*/
    0,    15,  79,   2,   5,    0,   0,  0,   0, {0,0}  ,  0, Colour_Paper},
{"Detect Invisible"             ,0x00080000L,   TV_SCROLL1, '?',/*357*/
    0,    15,  83,   2,   5,    0,   0,  0,   0, {0,0}  ,  0, Colour_Paper},
{"Blessing"                     ,0x00000020L,   TV_SCROLL2, '?',/*358*/
    0,    15,  99,   2,   5,    0,   0,  0,   0, {0,0}  ,  0, Colour_Paper},
{"Word-of-Recall"               ,0x00000100L,   TV_SCROLL2, '?',/*359*/
    0,   150, 102,   3,   5,    0,   0,  0,   0, {0,0}  ,  0, Colour_Paper},
{"Cure Light Wounds"            ,0x10001000L,   TV_POTION1, '!',/*360*/
   50,    15,  79,   2,   4,    0,   0,  0,   0, {1,1}  ,  0, Colour_Blue},
{"Heroism"                      ,0x00000010L,   TV_POTION2, '!',/*361*/
    0,    35,  98,   2,   4,    0,   0,  0,   0, {1,1}  ,  0, Colour_Blue},
{"Boldness"                     ,0x00000040L,   TV_POTION2, '!',/*362*/
    0,    10, 100,   2,   4,    0,   0,  0,   0, {1,1}  ,  0, Colour_Blue},
{"Slow Poison"                  ,0x00000800L,   TV_POTION2, '!',/*363*/
    0,    25, 105,   2,   4,    0,   0,  0,   0, {1,1}  ,  0, Colour_Blue},
{"& Brass Lantern~"             ,0x00000000L,   TV_LIGHT, '~',  /*364*/
 7500,    35,   0,   1,  50,    0,   0,  0,   0, {1,1}  ,  1, Colour_Brass},
{"& Wooden Torch~"              ,0x00000000L,   TV_LIGHT, '~',  /*365*/
 4000,     2, 192,   5,  30,    0,   0,  0,   0, {1,1}  ,  1, Colour_Wooden},
{"& Flask~ of oil"              ,0x00040000L,   TV_FLASK, '!',  /*366*/
 7500,     3,   64,   5,  10,   0,   0,  0,   0, {2,6}  ,  1, Colour_Oil},
/* end store items */
/* start doors */
/* Secret door must have same subval as closed door in  */
/* TRAP_LISTB.  See CHANGE_TRAP. Must use & because of stone_to_mud. */
{"& open door"                  ,0x00000000L, TV_OPEN_DOOR, '\'',
    0,     0,   1,   1,   0,    0,   0,  0,   0, {1,1}  ,  0, Colour_Wooden},
{"& closed door"                ,0x00000000L, TV_CLOSED_DOOR, '+',
    0,     0,   19,   1,   0,   0,   0,  0,   0, {1,1}  ,  0, Colour_Wooden},
#ifdef ATARI_ST
{"& secret door"                ,0x00000000L, TV_SECRET_DOOR,
   (unsigned char)240, /* 369 */
#else
{"& secret door"                ,0x00000000L, TV_SECRET_DOOR, '#',/* 369 */
#endif
    0,     0,   19,   1,   0,   0,   0,  0,   0, {1,1}  ,  0, Colour_Wall},
/* end doors */
/* stairs */
{"an up staircase "             ,0x00000000L, TV_UP_STAIR, '<', /* 370 */
    0,     0,   1,   1,   0,    0,   0,  0,   0, {1,1}  ,  0, Colour_Wooden},
{"a down staircase"             ,0x00000000L, TV_DOWN_STAIR, '>',/* 371 */
    0,     0,   1,   1,   0,    0,   0,  0,   0, {1,1}  ,  0, Colour_Wooden},
/* store door */
/* Stores are just special traps                */
{"General Store"                ,0x00000000L, TV_STORE_DOOR, '1',/* 372 */
    0,     0, 101,   1,   0,    0,   0,  0,   0, {0,0}  ,  0, Colour_Red},
{"Armory"                       ,0x00000000L, TV_STORE_DOOR, '2',
    0,     0, 102,   1,   0,    0,   0,  0,   0, {0,0}  ,  0, Colour_Green},
{"Weapon Smiths"                ,0x00000000L, TV_STORE_DOOR, '3',
    0,     0, 103,   1,   0,    0,   0,  0,   0, {0,0}  ,  0, Colour_Blue},
{"Temple"                       ,0x00000000L, TV_STORE_DOOR, '4',
    0,     0, 104,   1,   0,    0,   0,  0,   0, {0,0}  ,  0, Colour_Yellow},
{"Alchemy Shop"                 ,0x00000000L, TV_STORE_DOOR, '5',
    0,     0, 105,   1,   0,    0,   0,  0,   0, {0,0}  ,  0, Colour_Cyan},
{"Magic Shop"                   ,0x00000000L, TV_STORE_DOOR, '6',/* 377 */
    0,     0, 106,   1,   0,    0,   0,  0,   0, {0,0}  ,  0, Colour_Purple},
/* end store door */
/* Traps are just Nasty treasures.                              */
/* Traps: Level represents the relative difficulty of disarming;        */
/* and P1 represents the experienced gained when disarmed*/
{"an open pit"                  ,0x00000000L, TV_VIS_TRAP, ' ', /* 378 */
    1,     0,   1,   1,   0,    0,   0,  0,   0, {2,6}  ,50, Colour_Warning},
{"an arrow trap"                ,0x00000000L, TV_INVIS_TRAP, '^',
    3,     0,   2,   1,   0,    0,   0,  0,   0, {1,8}  ,90, Colour_Warning},
{"a covered pit"                ,0x00000000L, TV_INVIS_TRAP, '^',
    2,     0,   3,   1,   0,    0,   0,  0,   0, {2,6}  ,60, Colour_Warning},
{"a trap door"                  ,0x00000000L, TV_INVIS_TRAP, '^',
    5,     0,   4,   1,   0,    0,   0,  0,   0, {2,8}  ,75, Colour_Warning},
{"a gas trap"                   ,0x00000000L, TV_INVIS_TRAP, '^',
    3,     0,   5,   1,   0,    0,   0,  0,   0, {1,4}  ,95, Colour_Warning},
{"a loose rock"                 ,0x00000000L, TV_INVIS_TRAP, ';',
    0,     0,   6,   1,   0,    0,   0,  0,   0, {0,0}  ,10, Colour_Warning},
{"a dart trap"                  ,0x00000000L, TV_INVIS_TRAP, '^',
    5,     0,   7,   1,   0,    0,   0,  0,   0, {1,4}  ,110, Colour_Warning},
{"a strange rune"               ,0x00000000L, TV_INVIS_TRAP, '^',
    5,     0,   8,   1,   0,    0,   0,  0,   0, {0,0}  ,90, Colour_Warning},
{"some loose rock"              ,0x00000000L, TV_INVIS_TRAP, '^',
    5,     0,   9,   1,   0,    0,   0,  0,   0, {2,6}  ,90, Colour_Warning},
{"a gas trap"                   ,0x00000000L, TV_INVIS_TRAP, '^',
   10,     0,   10,   1,   0,   0,   0,  0,   0, {1,4}  ,105, Colour_Warning},
{"a strange rune"               ,0x00000000L, TV_INVIS_TRAP, '^',
    5,     0,   11,   1,   0,   0,   0,  0,   0, {0,0}  ,90, Colour_Warning},
{"a blackened spot"             ,0x00000000L, TV_INVIS_TRAP, '^',
   10,     0,   12,   1,   0,   0,   0,  0,   0, {4,6}  ,110, Colour_Warning},
{"some corroded rock"           ,0x00000000L, TV_INVIS_TRAP, '^',
   10,     0,   13,   1,   0,   0,   0,  0,   0, {4,6}  ,110, Colour_Warning},
{"a gas trap"                   ,0x00000000L, TV_INVIS_TRAP, '^',
    5,     0,   14,   1,   0,   0,   0,  0,   0, {2,6}  ,105, Colour_Warning},
{"a gas trap"                   ,0x00000000L, TV_INVIS_TRAP, '^',
    5,     0,   15,   1,   0,   0,   0,  0,   0, {1,4}  ,110, Colour_Warning},
{"a gas trap"                   ,0x00000000L, TV_INVIS_TRAP, '^',
    5,     0,   16,   1,   0,   0,   0,  0,   0, {1,8}  ,105, Colour_Warning},
{"a dart trap"                  ,0x00000000L, TV_INVIS_TRAP, '^',
    5,     0,   17,   1,   0,   0,   0,  0,   0, {1,8}  ,110, Colour_Warning},
{"a dart trap"                  ,0x00000000L, TV_INVIS_TRAP, '^',/* 395 */
    5,     0,   18,   1,   0,   0,   0,  0,   0, {1,8}  ,110, Colour_Warning},
/* rubble */
{"some rubble"                  ,0x00000000L, TV_RUBBLE, ':',   /* 396 */
    0,     0,   1,   1,   0,    0,   0,  0,   0, {0,0}  ,  0, Colour_Stone},
/* mush */
{"& pint~ of fine grade mush"   ,0x00000000L, TV_FOOD, ',',     /* 397 */
 1500,     0,  97,   1,   1,   0,   0,   0,   0, {1,1}  ,  1, Colour_Leperous},
/* Special trap */
{"a strange rune"               ,0x00000000L, TV_VIS_TRAP, '^', /* 398 */
    0,     0,   99,   1,   0,   0,   0,  0,   0, {0,0}  , 10, Colour_Random},
/* Gold list (All types of gold and gems are defined here)      */
{"copper"                       ,0x00000000L, TV_GOLD, '$',     /* 399 */
    0,     3,   1,   1,   0,    0,   0,  0,   0, {0,0}    ,  1, Colour_Copper},
{"copper"                       ,0x00000000L, TV_GOLD, '$',
    0,     4,   2,   1,   0,    0,   0,  0,   0, {0,0}    ,  1, Colour_Copper},
{"copper"                       ,0x00000000L, TV_GOLD, '$',
    0,     5,   3,   1,   0,    0,   0,  0,   0, {0,0}    ,  1, Colour_Copper},
{"silver"                       ,0x00000000L, TV_GOLD, '$',
    0,     6,   4,   1,   0,    0,   0,  0,   0, {0,0}    ,  1, Colour_Silver},
{"silver"                       ,0x00000000L, TV_GOLD, '$',
    0,     7,   5,   1,   0,    0,   0,  0,   0, {0,0}    ,  1, Colour_Silver},
{"silver"                       ,0x00000000L, TV_GOLD, '$',
    0,     8,   6,   1,   0,    0,   0,  0,   0, {0,0}    ,  1, Colour_Silver},
{"garnets"                      ,0x00000000L, TV_GOLD, '*',
    0,     9,   7,   1,   0,    0,   0,  0,   0, {0,0}    ,  1, Colour_Garnet},
{"garnets"                      ,0x00000000L, TV_GOLD, '*',
    0,    10,   8,   1,   0,    0,   0,  0,   0, {0,0}    ,  1, Colour_Garnet},
{"gold"                         ,0x00000000L, TV_GOLD, '$',
    0,    12,   9,   1,   0,    0,   0,  0,   0, {0,0}    ,  1, Colour_Gold},
{"gold"                         ,0x00000000L, TV_GOLD, '$',
    0,    14,   10,   1,   0,   0,   0,  0,   0, {0,0}    ,  1, Colour_Gold},
{"gold"                         ,0x00000000L, TV_GOLD, '$',
    0,    16,   11,   1,   0,   0,   0,  0,   0, {0,0}    ,  1, Colour_Gold},
{"opals"                        ,0x00000000L, TV_GOLD, '*',
    0,    18,   12,   1,   0,   0,   0,  0,   0, {0,0}    ,  1, Colour_Random},
{"sapphires"                    ,0x00000000L, TV_GOLD, '*',
    0,    20,   13,   1,   0,   0,   0,  0,   0, {0,0}    ,  1, Colour_Sapphire},
{"gold"                         ,0x00000000L, TV_GOLD, '$',
    0,    24,   14,   1,   0,   0,   0,  0,   0, {0,0}    ,  1, Colour_Gold},
{"rubies"                       ,0x00000000L, TV_GOLD, '*',
    0,    28,   15,   1,   0,   0,   0,  0,   0, {0,0}    ,  1, Colour_Ruby},
{"diamonds"                     ,0x00000000L, TV_GOLD, '*',
    0,    32,   16,   1,   0,   0,   0,  0,   0, {0,0}    ,  1, Colour_Diamond},
{"emeralds"                     ,0x00000000L, TV_GOLD, '*',
    0,    40,   17,   1,   0,   0,   0,  0,   0, {0,0}    ,  1, Colour_Emerald},
{"mithril"                      ,0x00000000L, TV_GOLD, '$',     /* 416 */
    0,    80,   18,   1,   0,   0,   0,  0,   0, {0,0}    ,  1, Colour_Mithril},
/* nothing, used as inventory place holder */
/* must be stackable, so that can be picked up by inven_carry */
{"nothing"                      ,0x00000000L,  TV_NOTHING, ' ', /* 417 */
   0,       0,  64,   0,   0,   0,   0,   0,   0, {0,0}    ,  0, Colour_Red},
/* these next two are needed only for the names */
{"& ruined chest"               ,0x00000000L,   TV_CHEST, '&',  /* 418 */
   0,      0,   0,   1, 250,    0,   0,  0,   0, {0,0}  ,  0, Colour_Medium_Grey_Low},
{""                             ,0x00000000L,  TV_NOTHING, ' ', /* 419 */
   0,       0,   0,   0,   0,   0,   0,   0,   0, {0,0}  ,  0, Colour_Red}
};
#endif

char *special_names[SN_ARRAY_SIZE] = {
        CNIL,                   "(R)",                  "(RA)",
        "(RF)",                 "(RC)",                 "(RL)",
        "(HA)",                 "(DF)",                 "(SA)",
        "(SD)",                 "(SE)",                 "(SU)",
        "(FT)",                 "(FB)",                 "of Free Action",
        "of Slaying",           "of Clumsiness",        "of Weakness",
        "of Slow Descent",      "of Speed",             "of Stealth",
        "of Slowness",          "of Noise",             "of Great Mass",
        "of Intelligence",      "of Wisdom",            "of Infra-Vision",
        "of Might",             "of Lordliness",        "of the Magi",
        "of Beauty",            "of Seeing",            "of Regeneration",
        "of Stupidity",         "of Dullness",          "of Blindness",
        "of Timidness",         "of Teleportation",     "of Ugliness",
        "of Protection",        "of Irritation",        "of Vulnerability",
        "of Enveloping",        "of Fire",              "of Slay Evil",
        "of Dragon Slaying",    "(Empty)",              "(Locked)",
        "(Poison Needle)",      "(Gas Trap)",           "(Explosion Device)",
        "(Summoning Runes)",    "(Multiple Traps)",     "(Disarmed)",
        "(Unlocked)",           "of Slay Animal"
};

/* Pairing things down for THINK C.  */
#ifndef RSRC_PART2
int16 sorted_objects[MAX_DUNGEON_OBJ];

/* Identified objects flags                                     */
int8u object_ident[OBJECT_IDENT_SIZE];
int16 t_level[MAX_OBJ_LEVEL+1];
inven_type t_list[MAX_TALLOC];
inven_type inventory[INVEN_ARRAY_SIZE];
#endif

/* Treasure related values                                      */
int16 inven_ctr = 0;            /* Total different obj's        */
int16 inven_weight = 0;         /* Cur carried weight   */
int16 equip_ctr = 0;            /* Cur equipment ctr    */
int16 tcptr;                    /* Cur treasure heap ptr        */

