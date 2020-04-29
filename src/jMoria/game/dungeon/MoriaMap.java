package jMoria.game.dungeon;

import jMoria.game.dungeon.tile.Tile;
import jMoria.game.dungeon.tile.TileType;
import java.util.ArrayList;
import java.util.List;

public class MoriaMap {

  public static final int TOWN_WIDTH = 66;
  public static final int TOWN_HEIGHT = 22;

  public static final int DUNGEON_WIDTH = 10;
  public static final int DUNGEON_HEIGHT = 10;

  public int depth;
  public int height;
  public int width;
  public Tile[][] tileMap;

  /**
   * Set up a map of NULL Tiles and engage the MoriaMapCreator to fill in the details for us.
   *
   * @param depth Depth of the requested MoriaMap. 0 = Town. 50/100/150, etc = Dungeon.
   */
  public MoriaMap(int depth) {
    this.depth = depth;
    this.height = depth != 0 ? DUNGEON_HEIGHT : TOWN_HEIGHT;
    this.width = depth != 0 ? DUNGEON_WIDTH : TOWN_WIDTH;
    this.tileMap = new Tile[height][width];
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        tileMap[y][x] = new Tile(TileType.NULL);
      }
    }
    MoriaMapCreator moriaMapCreator = new MoriaMapCreator();
    if (depth == 0) {
      moriaMapCreator.createTown(this);
    } else {
      moriaMapCreator.createDungeon(this, depth);
    }
  }

  /**
   * Provide a slice of the overall map for viewing.
   *
   * @param row    Top left coordinate of the requested view slice. (with col)
   * @param col    Top left coordinate of the requested view slice. (with row)
   * @param height Height of the requested view slice in Tiles.
   * @param width  Width of the requested view slice in Tiles.
   * @return List of strings representing rows of the requested view slice.
   */
  public List<String> getMapSlice(int row, int col, int height, int width) {
    List<String> result = new ArrayList<>();
    for (int y = row; y < row + height; y++) {
      StringBuilder rowString = new StringBuilder();
      for (int x = col; x < col + width; x++) {
        rowString.append(tileMap[y][x].type.getTileChar());
      }
      result.add(rowString.toString());
    }
    return result;
  }

}
