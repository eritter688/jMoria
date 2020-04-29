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

  private MoriaMap moriaMap;

  /**
   * Create a town level for jMoria.
   * <p>
   * Place the six stores randomly at each of six predetermined spots. Place boundary wall around
   * town. Place one down staircase. Place a few town level monsters.
   *
   * @param moriaMap The MoriaMap to be used in the creation process.
   */
  public void createTown(MoriaMap moriaMap) {
    this.moriaMap = moriaMap;
    placeBoundaryWall();

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
    // TODO do store maintenance
    //fillCave(TileType.FLOOR_DARK);
    fillCave(TileType.FLOOR_LIGHT);
    placeStairs(TileType.STAIRCASE_DOWN, 1, false);
    // TODO allocate monsters
  }

  /**
   * Create a dungeon level for jMoria.
   *
   * @param moriaMap The MoriaMap to be used in the creation process.
   * @param depth    The depth of the dungeon level.
   */
  public void createDungeon(MoriaMap moriaMap, int depth) {
    this.moriaMap = moriaMap;
  }

  /**
   * Set the Tile at the requested coordinates to type.
   *
   * @param type The TileType for the Tile to be set to.
   * @param row  Coordinate of the requested Tile. (with col)
   * @param col  Coordinate of the requested Tile. (with row)
   */
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
   * Place wall boundary tiles around the perimeter of the MoriaMap.
   */
  private void placeBoundaryWall() {
    // left and right
    for (int y = 0; y < moriaMap.height; y++) {
      moriaMap.tileMap[y][0].type = TileType.WALL_BOUNDARY;
      moriaMap.tileMap[y][moriaMap.width - 1].type = TileType.WALL_BOUNDARY;
    }
    // top and bottom
    for (int x = 0; x < moriaMap.width; x++) {
      moriaMap.tileMap[0][x].type = TileType.WALL_BOUNDARY;
      moriaMap.tileMap[moriaMap.height - 1][x].type = TileType.WALL_BOUNDARY;
    }
  }

  /**
   * Place 'num' staircases of 'type' randomly on the map.
   * <p>
   * Can only be placed on a tile of the OPEN_SPACE type.
   * TODO Cannot be placed on a tile that is already occupied by something.
   * <p>
   * array[row_index][col_index]
   * array[y][x]
   *
   * @param type       Staircase type: up or down.
   * @param num        Number of staircases to place on the map.
   * @param nextToWall Should stairs be placed next to a wall type?
   */
  private void placeStairs(TileType type, int num, boolean nextToWall) {

    if (!TileSets.STAIR_TYPES.contains(type)) {
      throw new IllegalArgumentException("type must be a valid staircase.");
    }

    boolean flag = false;
    for (int i = 0; i < num; i++) {
      do {
        int y = Math.randInt(moriaMap.height);
        int x = Math.randInt(moriaMap.width);
        Tile t = moriaMap.tileMap[y][x];
        // TODO Ensure tile is 'empty' ie no treasure/monster/etc...
        if ((TileSets.OPEN_SPACE.contains(t.type)) &&
            nextToWall == nextToWalls(y, x)) {
          t.type = type;
          flag = true;
        }
      } while (!flag);
    }
  }

  /**
   * Check whether a point is next to a Tile of type WALL. NOTES / TODO: This function only covers
   * /n/s/e/w, what about nw/ne/sw/se? No boundary checks?
   *
   * @param row Coordinate to check. (with col)
   * @param col Coordinate to check. (with row)
   * @return TRUE if coordinate is next to a Tile of type WALL, else FALSE.
   */
  public boolean nextToWalls(int row, int col) {
    return (TileSets.WALL_TYPES.contains(moriaMap.tileMap[row - 1][col].type)) ||
        (TileSets.WALL_TYPES.contains(moriaMap.tileMap[row + 1][col].type)) ||
        (TileSets.WALL_TYPES.contains(moriaMap.tileMap[row][col - 1].type)) ||
        (TileSets.WALL_TYPES.contains(moriaMap.tileMap[row][col + 1].type));
  }

}
