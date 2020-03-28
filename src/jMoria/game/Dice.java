package jMoria.game;

import java.util.Random;

public class Dice {

  private Random generator;

  public Dice() {
    // TODO
    // Remove this before actually finalizing the game.
    if (Game.DEBUG) {
      generator = new Random(Game.RANDOM_SEED);
    } else {
      generator = new Random();
    }
  }

  public int rollDice(int rolls, int sides) {

    if (rolls <= 0 || sides <= 0) {
      throw new IllegalArgumentException("Rolls and or sides must be positive values.");
    }

    int sum = 0;
    for (int x = 0; x < rolls; x++) {
      sum += (generator.nextInt(sides) + 1);
    }

    return sum;
  }
}
