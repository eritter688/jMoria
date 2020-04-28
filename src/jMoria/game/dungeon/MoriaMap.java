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

  public MoriaMap(int depth, int width, int height) {
    this.depth = depth;
    this.width = width;
    this.height = height;
    this.tileMap = new Tile[width][height];
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        tileMap[i][j] = new Tile(TileType.FLOOR_DARK);
      }
    }
  }

  public List<String> getMapAsString() {
    List<String> result = new ArrayList<>();
    for (Tile[] tiles : tileMap) {
      String rowString = "";
      for (Tile t : tiles) {
        rowString += t.type.getTileChar();
      }
      result.add(rowString);
    }
    return result;
  }

  // NO SAFETY CHECKS
  public List<String> getMapSlice(int row, int col, int width, int height) {
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
