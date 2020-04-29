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
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        tileMap[i][j] = new Tile(TileType.FLOOR_DARK);
      }
    }

  }

  public List<String> getMapSlice(int row, int col, int height, int width) {

    if (row < 0 || row >= this.height) {
      throw new IllegalArgumentException("requested row out of bounds.");
    }
    if (col < 0 || col >= this.width) {
      throw new IllegalArgumentException("requested column out of bounds.");
    }
    if ((row + height) >= this.height) {
      throw new IllegalArgumentException("requested height out of bounds.");
    }
    if ((col + width) >= this.width) {
      throw new IllegalArgumentException("requested width out of bounds.");
    }

    List<String> result = new ArrayList<>();
    for (int i = row; i < row + height; i++) {
      StringBuilder rowString = new StringBuilder();
      for (int j = col; j < col + width; j++) {
        rowString.append(tileMap[i][j].type.getTileChar());
      }
      result.add(rowString.toString());
    }

    return result;
  }

}
