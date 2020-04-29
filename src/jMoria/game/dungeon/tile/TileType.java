package jMoria.game.dungeon.tile;

public enum TileType {
  NULL("*"), // TODO Ensure this isn't a used character.

  FLOOR_DARK(" "),
  FLOOR_LIGHT("."),
  FLOOR_CORRIDOR("."),

  WALL_BOUNDARY(String.valueOf('\u2588')), // Block character.
  WALL_GRANITE(String.valueOf('\u2588')),
  WALL_MAGMA(String.valueOf('\u2588')),
  WALL_QUARTZ(String.valueOf('\u2588')),

  STAIRCASE_DOWN(">"),
  STAIRCASE_UP("<"),

  STORE_ONE("1"),
  STORE_TWO("2"),
  STORE_THREE("3"),
  STORE_FOUR("4"),
  STORE_FIVE("5"),
  STORE_SIX("6");

  private final String tileChar;

  TileType(String tileChar) {
    this.tileChar = tileChar;
  }

  public String getTileChar() {
    return this.tileChar;
  }

}
