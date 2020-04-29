package jMoria.game.dungeon;

import jMoria.game.dungeon.tile.Tile;
import jMoria.game.dungeon.tile.TileSets;
import jMoria.game.dungeon.tile.TileType;
import jMoria.game.utils.Math;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

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

    // Place the six store types randomly at each of the six predetermined
    // start points.
    List<TileType> store_list = new ArrayList<>();
    TileSets.STORE_TYPES.iterator().forEachRemaining(store_list::add);
    Collections.shuffle(store_list);
    Iterator<TileType> store_iterator = store_list.iterator();
    int[] rows = {5, 5, 5, 15, 15, 15};
    int[] cols = {16, 32, 48, 16, 32, 48};
    for (int i = 0; i < 6; i++) {
      placeStore(store_iterator.next(), rows[i], cols[i]);
    }
    //fillCave(TileType.FLOOR_DARK);
    fillCave(TileType.FLOOR_LIGHT);
    placeBoundaryWall();
    placeStairs(TileType.STAIRCASE_DOWN, 1, false);
    // allocate monsters
    // do store maintenance
  }

  private void createDungeon(int depth) {
  }

  private void placeTile(TileType type, int row, int col) {
    moriaMap.tileMap[row][col].type = type;
  }

  private void placeStore(TileType type, int row, int col) {

    if (!TileSets.STORE_TYPES.contains(type)) {
      throw new IllegalArgumentException("type must be a valid store.");
    }

    System.out.println(String.format("%d %d", row, col));

    int y_height = row - Math.randInt(3) + 1;
    int y_depth = row + Math.randInt(4) + 1;
    int x_left = col - Math.randInt(6) + 1;
    int x_right = col + Math.randInt(6) + 1;

    for (int i = y_height; i <= y_depth; i++) {
      for (int j = x_left; j <= x_right; j++) {
        moriaMap.tileMap[i][j].type = TileType.WALL_BOUNDARY;
      }
    }

    // Place the door...
    int tmp = Math.randInt(4);
    if (tmp == 0 || tmp == 1) {
      // horizontal coordinate
    } else {
      // vertical coordinate
    }
    switch (Math.randInt(4)) {
      case 0:
        // door on top
        break;
      case 1:
        // door on bottom
        break;
      case 2:
        // door on left
        break;
      case 3:
        // door on right
        break;
    }
    //moriaMap.tileMap[i][j].type = type;
  }

  /**
   * Fill in empty (NULL) map tiles with desired type.
   *
   * @param type Type of tile to use as filler.
   */
  private void fillCave(TileType type) {
    for (Tile[] tileRow : moriaMap.tileMap) {
      for (Tile t : tileRow) {
        if (t.type == TileType.NULL) {
          t.type = type;
        }
      }
    }
  }

  /**
   * Place boundary tiles around along the top and bottom rows, and the first and last column of the
   * tileMap.
   * <p>
   * array[row_index][col_index] array[y][x]
   */
  private void placeBoundaryWall() {
    // left and right
    for (int i = 0; i < moriaMap.height; i++) {
      moriaMap.tileMap[i][0].type = TileType.WALL_BOUNDARY;
      moriaMap.tileMap[i][moriaMap.width - 1].type = TileType.WALL_BOUNDARY;
    }
    // top and bottom
    for (int j = 0; j < moriaMap.width; j++) {
      moriaMap.tileMap[0][j].type = TileType.WALL_BOUNDARY;
      moriaMap.tileMap[moriaMap.height - 1][j].type = TileType.WALL_BOUNDARY;
    }
  }

  /**
   * Place 'num' staircases of 'type' randomly on the map.
   * <p>
   * Can only be placed on a tile of the OPEN_SPACE type. // TODO Cannot be placed on a tile that is
   * already occupied by something.
   * <p>
   * <p>
   * array[row_index][col_index] array[y][x]
   *
   * @param type       Staircase type: up or down.
   * @param num        Number of staircases to place on the map. 1-3.
   * @param nextToWall Should this be next to a wall?? //TODO
   */
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
        int y = Math.randInt(moriaMap.height);
        int x = Math.randInt(moriaMap.width);
        Tile t = moriaMap.tileMap[y][x];
//        if (nextToWall && !nextToWalls(x, y)) {
//          break;
//        }
        // TODO Ensure tile is 'empty' ie no treasure/monster/etc...
        if (TileSets.OPEN_SPACE.contains(t.type)) {
          t.type = type;
          flag = true;
        }
      } while (!flag);
    }
  }

//  // TODO
//  // This only covers n/s/w/e...
//  // What about nw/ne/sw/se ??
//  // BOUNDARY CHECK?
//  public boolean nextToWalls(int x, int y) {
//    return (TileSets.WALL_TYPES.contains(moriaMap.tileMap[x - 1][y].type)) ||
//        (TileSets.WALL_TYPES.contains(moriaMap.tileMap[x + 1][y].type)) ||
//        (TileSets.WALL_TYPES.contains(moriaMap.tileMap[x][y - 1].type)) ||
//        (TileSets.WALL_TYPES.contains(moriaMap.tileMap[x][y + 1].type));
//  }

}
