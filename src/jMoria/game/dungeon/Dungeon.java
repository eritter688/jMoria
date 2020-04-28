package jMoria.game.dungeon;

import jMoria.game.monster.Monster;
import jMoria.game.player.Player;

public class Dungeon {

  private int width;
  private int height;
  private int depth;

  private Player player;
  private Monster[] monsters;

  private int[][] map;

  public Dungeon(int width, int height, int depth) {
    this.width = width;
    this.height = height;
    this.depth = depth;
  }

}
