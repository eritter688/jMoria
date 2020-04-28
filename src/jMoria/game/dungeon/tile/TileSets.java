package jMoria.game.dungeon.tile;

import java.util.HashSet;
import java.util.Set;

public class TileSets {

  public static final Set<TileType> OPEN_SPACE;
  public static final Set<TileType> STAIR_TYPES;
  public static final Set<TileType> WALL_TYPES;
  public static final Set<TileType> STORE_TYPES;

  static {
    OPEN_SPACE = new HashSet<>();
    OPEN_SPACE.add(TileType.NULL);
    OPEN_SPACE.add(TileType.FLOOR_DARK);
    OPEN_SPACE.add(TileType.FLOOR_LIGHT);
    OPEN_SPACE.add(TileType.FLOOR_CORRIDOR);

    STAIR_TYPES = new HashSet<>();
    STAIR_TYPES.add(TileType.STAIRCASE_DOWN);
    STAIR_TYPES.add(TileType.STAIRCASE_UP);

    WALL_TYPES = new HashSet<>();
    WALL_TYPES.add(TileType.WALL_BOUNDARY);
    WALL_TYPES.add(TileType.WALL_GRANITE);
    WALL_TYPES.add(TileType.WALL_MAGMA);
    WALL_TYPES.add(TileType.WALL_QUARTZ);

    STORE_TYPES = new HashSet<>();
    STORE_TYPES.add(TileType.STORE_ONE);
    STORE_TYPES.add(TileType.STORE_TWO);
    STORE_TYPES.add(TileType.STORE_THREE);
    STORE_TYPES.add(TileType.STORE_FOUR);
    STORE_TYPES.add(TileType.STORE_FIVE);
    STORE_TYPES.add(TileType.STORE_SIX);
  }

}
