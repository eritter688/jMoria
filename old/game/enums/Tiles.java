package jMoria.game.enums;

/*
 * uMoria 'fval definitions'
 * 
 * define NULL_WALL	0
 * define DARK_FLOOR	1
 * define LIGHT_FLOOR	2
 * define MAX_CAVE_ROOM	2
 * define CORR_FLOOR	3
 * define BLOCKED_FLOOR	4 / a corridor space with cl/st/se door or rubble/
 * define MAX_CAVE_FLOOR 4
 *
 * define MAX_OPEN_SPACE  3
 * define MIN_CLOSED_SPACE 4
 *
 * define TMP1_WALL	8
 * define TMP2_WALL	9
 *
 * define MIN_CAVE_WALL	12
 * define GRANITE_WALL	12
 * define MAGMA_WALL	13
 * define QUARTZ_WALL	14
 * define BOUNDARY_WALL	15
 *
 * 
 * 
 *  TYPE - SYMBOL - COLOUR
 */

public enum Tiles
{

	NULLWALL          (0, '0', "BLACK"),
	DARKFLOOR         (1, ' ', "BLACK"),
	LIGHTFLOOR        (2, '.', "GREY"),
	CORRFLOOR         (3, ' ', "GREY"),
	BLOCKEDFLOOR      (4, ':', "GREY"),

	TMP1WALL          (8, '█', "GREY"),
	TMP2WALL          (9, '█', "GREY"),

	GRANITEWALL       (12, '█', "GREY"),
	MAGMAWALL         (13, '█', "PINK"),
	QUARTZWALL        (14, '█', "PINK"),
	BOUNDARYWALL      (15, '█', "GREY"),

	UPSTAIR           (30, '<', "GREY"),
	DOWNSTAIR         (31, '>', "GREY"),

	TRAP              (40, '^', "RED"),
	SECRETTRAP        (41, '.', "GREY"),

	OPENDOOR          (60, '\'',"GREY"),
	BROKENDOOR        (61, '\'',"GREY"),
	CLOSEDDOOR        (62, '+', "GREY"),
	LOCKEDDOOR        (63, '+', "GREY"),
	STUCKDOOR         (64, '+', "GREY"),
	SECRETDOOR        (65, '█', "GREY");

	private int tileValue;
	private char displayCharacter;
	private String displayColor;

	Tiles(int f, char c, String s)
	{
		tileValue = f;
		displayCharacter = c;
		displayColor = s;
	}

	public int getTileValue()
	{
		return tileValue;
	}

	public char getDisplayCharacter()
	{
		return displayCharacter;
	}

	public String getDisplayColor()
	{
		return displayColor;
	}

}


