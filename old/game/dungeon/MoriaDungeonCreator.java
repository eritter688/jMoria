package jMoria.game.dungeon;

import java.util.EnumSet;

import jMoria.game.enums.Tiles;
import jMoria.game.random.Rand;

public class MoriaDungeonCreator
{

	private Map map;
	private Rand rand;
	
	private EnumSet<Tiles> openSpace = EnumSet.of(
			Tiles.DARKFLOOR,
			Tiles.LIGHTFLOOR,
			Tiles.CORRFLOOR,
			Tiles.BLOCKEDFLOOR);

	
	public MoriaDungeonCreator(Map map)
	{
		this.map = map;
		//what should I be using as a seed?????
		//factor this out to the top 'game' level
		//and use it across the board??????
		rand = new Rand((long)0.1);
	}
	
	public void createDungeon(int depth)
	{}
	
	
	//
	
	
	
	//
	
	// WALLS & ROCKS
	private void placeBoundary()
	{
	}
	private void placeStreamer(int a, int b)
	{}
	
	// DOORS
	private void placeOpenDoor(int row, int col)
	{
		map.setTile(row, col, Tiles.OPENDOOR);
	}
	private void placeBrokenDoor(int row, int col)
	{
		map.setTile(row, col, Tiles.BROKENDOOR);
	}
	private void placeClosedDoor(int row, int col)
	{
		map.setTile(row, col, Tiles.CLOSEDDOOR);
	}
	private void placeLockedDoor(int row, int col)
	{
		map.setTile(row, col, Tiles.LOCKEDDOOR);
	}
	private void placeStuckDoor(int row, int col)
	{
		map.setTile(row, col, Tiles.STUCKDOOR);
	}
	private void placeSecretDoor(int row, int col)
	{
		map.setTile(row, col, Tiles.SECRETDOOR);
	}
	private void placeDoor(int row, int col)
	{
		int tmp = rand.nextInt(3);
		if(tmp == 1)
		{
			if(rand.nextInt(4) == 1)
			{
				placeBrokenDoor(row, col);
			}
			else
			{
				placeOpenDoor(row, col);
			}
		}
		else if (tmp == 2)
		{
			tmp = rand.nextInt(12);
			if (tmp > 3)
			{
				placeClosedDoor(row, col);
			}
			else if (tmp == 3)
			{
				placeStuckDoor(row, col);
			}
			else
			{
				placeLockedDoor(row, col);
			}
		}
		else
		{
			placeSecretDoor(row, col);
		}
	}
	
	// STAIRS
	private void placeUpStairs(int row, int col)
	{
		map.setTile(row, col, Tiles.UPSTAIR);
	}
	private void placeDownStairs(int row, int col)
	{
		map.setTile(row, col, Tiles.DOWNSTAIR);
	}
	private void placeStairs(int type, int num, int walls)
	{
		// type 1 = up, 2 = down
		// num = number of stairs to place
		// walls = how many walls to be next to
		
		
		// conditions for successful placement:
		// 1. floor value is less than MAX_OPEN_SPACE
		       // use enum set openSpace
		// 2. tptr == 0; thing pointer? no things here
		// 3. next_to_walls() >= WALLS????
		
		/* Called from cave generation....
		 *   place_stairs(2, randint(2)+2, 3);
  			 place_stairs(1, randint(2), 3);
  			 
  			 
		 */
		boolean flag;
		
		int y1, x1, y2, x2;
		
		for(int i = 0; i < num; i++)
		{
			flag = false;
			do
			{
				int j = 0;
				do
				{
					//TODO FIX these values. what is cur_height / cur_width?? height and width
					// of the dungeon??
					// y1 = randint(cur_height - 14);
					// x1 = randint(cur_width  - 14);
					y1 = rand.nextInt(14);
					x1 = rand.nextInt(14);
					y2 = y1 + 12;
					x2 = x1 + 12;
					do
					{
						do
						{
							//check for success
							if(1)
							{
								flag = true;
								if (type == 1)
									placeUpStairs(y1,x1);
								else
									placeDownStairs(y1,x1);
							}
							x1++;
						}
						while((x1 != x2) && (flag == false));
						x1 = x2 - 12;
						y1++;
					}
					while((y1 != y2) && (flag == false));
					j++;
				}
				while((flag == false) && (j <= 30));
				walls--;
			}
			while (flag == false);
		}
	}
	
	
}

//IN PROGRESS
/*
static void place_boundary(void);
static void place_streamer(int, int);
static void place_open_door(int, int);
static void place_broken_door(int, int);
static void place_closed_door(int, int);
static void place_locked_door(int, int);
static void place_stuck_door(int, int);
static void place_secret_door(int, int);
static void place_door(int, int);
static void place_up_stairs(int, int);
static void place_down_stairs(int, int);
static void place_stairs(int, int, int);
*/ 

// REMAINING
/*
static void correct_dir(int *, int * , int, int, int, int);
static void rand_dir(int *,int *);
static void blank_cave(void);
static void fill_cave(int);
static void vault_trap(int, int, int, int, int);
static void vault_monster(int, int, int);
static void build_room(int, int);
static void build_type1(int, int);
static void build_type2(int, int);
static void build_type3(int, int);
static void build_tunnel(int, int, int, int);
static int next_to(int, int);
static void try_door(int, int);
static void new_spot(int16 *, int16 *);
static void cave_gen(void);
static void build_store(int, int, int);
static void tlink(void);
static void mlink(void);
static void town_gen(void);
*/