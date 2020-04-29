package jMoria.game.dungeon;

import jMoria.game.dungeon.tile.Tile;
import jMoria.game.dungeon.tile.TileType;
import java.util.ArrayList;
import java.util.List;

public class MoriaMap {

  public int depth;
  public int width;
  public int height;
  public Tile[][] tileMap;

  // array[row_index][col_index]
  // array[y][x]
  public MoriaMap(int depth, int height, int width) {
    this.depth = depth;
    this.height = height;
    this.width = width;
    this.tileMap = new Tile[height][width];
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        tileMap[y][x] = new Tile(TileType.NULL);
      }
    }
  }

  // IDEA
  // When we get to actual dungeon time and moving the player around,
  // ensure this doesn't give a hint to the player that they are near
  // the boundary of the map...
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
