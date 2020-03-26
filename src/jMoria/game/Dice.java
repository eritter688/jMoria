package jMoria.game;

public class Dice {

  private ResourcePackage gameResources;

  public Dice(ResourcePackage gameResources) {
    this.gameResources = gameResources;
  }

  public int rollDice(int rolls, int sides) {

    if (rolls <= 0 || sides <= 0) {
      throw new IllegalArgumentException("Rolls and or sides must be positive values.");
    }

    int sum = 0;
    for (int x = 0; x < rolls; x++) {
      sum += (int) (Math.random() * sides + 1);
    }

    return sum;
  }
}
