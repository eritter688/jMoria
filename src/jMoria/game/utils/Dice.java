package jMoria.game.utils;

public class Dice {

  private final int num;
  private final int sides;

  public Dice(int num, int sides) {
    this.num = num;
    this.sides = sides;
  }

  public int roll() {
    int result = 0;
    for (int i = 0; i < num; i++) {
      result += Math.randIntOne(sides);
    }
    return result;
  }

  @Override
  public String toString() {
    return "Dice{" + num + "d" + sides + "}";
  }
}
