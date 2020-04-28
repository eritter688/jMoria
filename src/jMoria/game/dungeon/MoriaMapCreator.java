package jMoria.game.dungeon;

import jMoria.game.dungeon.tile.Tile;
import jMoria.game.dungeon.tile.TileSets;
import jMoria.game.dungeon.tile.TileType;
import jMoria.game.utils.Math;

public class MoriaMapCreator {

  public static final int TOWN_WIDTH = 66;
  public static final int TOWN_HEIGHT = 22;

  public static final int DUNGEON_WIDTH = 10;
  public static final int DUNGEON_HEIGHT = 10;

  private MoriaMap moriaMap;

  public void createMap(int depth) {
    if (depth == 0) {
      this.moriaMap = new MoriaMap(depth, TOWN_HEIGHT, TOWN_WIDTH);
      createTown();
    } else {
      this.moriaMap = new MoriaMap(depth, DUNGEON_HEIGHT, DUNGEON_WIDTH);
      createDungeon(depth);
    }
  }

  public MoriaMap getMoriaMap() {
    return this.moriaMap;
  }

  private void createTown() {
    fillCave(TileType.FLOOR_DARK);

//    int rooms[] = new int[6];
//    int k;
//    for (int i = 0; i < 6; i++) {
//      rooms[i] = i;
//    }
//    int l = 6;
//    for (int i = 0; i < 2; i++) {
//      for (int j = 0; j < 3; j++) {
//        k = Math.randInt(l) - 1;
//        //placeStore(rooms[k], i, j);
//        for (int m = k; m < l - 1; m++) {
//          rooms[m] = rooms[m + 1];
//        }
//        l--;
//      }
//    }

//    for (i = 0; i < 6; i++) {
//      rooms[i] = i;
//    }
//    l = 6;
//    for (i = 0; i < 2; i++) {
//      for (j = 0; j < 3; j++) {
//        k = randint(l) - 1;
//        build_store(rooms[k], i, j);
//        for (m = k; m < l - 1; m++) {
//          rooms[m] = rooms[m + 1];
//        }
//        l--;
//      }
//    }

    placeBoundary();
    placeStairs(TileType.STAIRCASE_DOWN, 1, false);
  }

  private void createDungeon(int depth) {
  }

  private void placeTile(TileType type, int row, int col) {
    moriaMap.tileMap[row][col].type = type;
  }

  /*



   */

  private void placeStore(TileType type, int x, int y) {

    if (!TileSets.STORE_TYPES.contains(type)) {
      throw new IllegalArgumentException("type must be a valid store.");
    }

  }

  private void fillCave(TileType type) {
    for (Tile[] tileRow : moriaMap.tileMap) {
      for (Tile t : tileRow) {
        t.type = type;
      }
    }
  }

  private void placeBoundary() {
    for (int i = 0; i < moriaMap.width; i++) {
      moriaMap.tileMap[i][0].type = TileType.WALL_BOUNDARY;
      moriaMap.tileMap[i][moriaMap.height - 1].type = TileType.WALL_BOUNDARY;
    }
    for (int j = 0; j < moriaMap.height; j++) {
      moriaMap.tileMap[0][j].type = TileType.WALL_BOUNDARY;
      moriaMap.tileMap[moriaMap.width - 1][j].type = TileType.WALL_BOUNDARY;
    }
  }

  private void placeStairs(TileType type, int num, boolean nextToWall) {

    if (!TileSets.STAIR_TYPES.contains(type)) {
      throw new IllegalArgumentException("type must be a valid staircase.");
    }

    // TODO How many is appropriate here? Will it work?
    if (num <= 0 || num > 3) {
      throw new IllegalArgumentException("num must be integer between 1 and 3.");
    }

    boolean flag = false;
    for (int i = 0; i < num; i++) {
      do {
        int x = Math.randInt(moriaMap.width) - 1;
        int y = Math.randInt(moriaMap.height) - 1;
        Tile t = moriaMap.tileMap[x][y];
        if (nextToWall && !nextToWalls(x, y)) {
          break;
        }
        // TODO Ensure tile is 'empty' ie no treasure/monster/etc...
        if (TileSets.OPEN_SPACE.contains(t.type)) {
          t.type = type;
          flag = true;
        }
      } while (!flag);
    }
  }

  // TODO
  // This only covers n/s/w/e...
  // What about nw/ne/sw/se ??
  // BOUNDARY CHECK?
  public boolean nextToWalls(int x, int y) {
    return (TileSets.WALL_TYPES.contains(moriaMap.tileMap[x - 1][y].type)) ||
        (TileSets.WALL_TYPES.contains(moriaMap.tileMap[x + 1][y].type)) ||
        (TileSets.WALL_TYPES.contains(moriaMap.tileMap[x][y - 1].type)) ||
        (TileSets.WALL_TYPES.contains(moriaMap.tileMap[x][y + 1].type));
  }

}
