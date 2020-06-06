package jMoria.game.data;

import jMoria.game.player.enums.Race;
import jMoria.game.utils.Dice;

public class PlayerStatGenerator {

  private final Race race;
  private int[] statAdjusts;
  private int[] stats = new int[6];

  public PlayerStatGenerator(Race race) {
    this.race = race;
    switch (race) {
      case HUMAN:
        statAdjusts = new int[]{0, 0, 0, 0, 0, 0};
        break;
      case HALF_ELF:
        statAdjusts = new int[]{-1, 1, 0, 1, -1, 1};
        break;
      case ELF:
        statAdjusts = new int[]{-1, 2, 1, 1, -2, 1};
        break;
      case HALFLING:
        statAdjusts = new int[]{-2, 2, 1, 3, 1, 1};
        break;
      case GNOME:
        statAdjusts = new int[]{-1, 2, 0, 2, 1, -2};
        break;
      case DWARF:
        statAdjusts = new int[]{2, -3, 1, -2, 2, -3};
        break;
      case HALF_ORC:
        statAdjusts = new int[]{2, -1, 0, 0, 1, -4};
        break;
      case HALF_TROLL:
        statAdjusts = new int[]{4, -4, -2, -4, 3, -6};
        break;
    }
  }

  public void roll() {
    initialRoll();
    adjustmentRoll();
  }

  private void initialRoll() {
    int total = 0;
    int[] temp = new int[18];

    do {
      total = 0;
      for (int i = 0; i < 18; i++) {
        int sides = (3 + i % 3);
        temp[i] = new Dice(1, sides).roll();
        total += temp[i];
      }
    } while (total <= 42 || total >= 54);

    for (int i = 0; i < 6; i++) {
      stats[i] = 5 + temp[3 * i] + temp[3 * i + 1] + temp[3 * i + 2];
    }
  }

  private void adjustmentRoll() {

    for (int i = 0; i < 6; i++) {
      int temp = stats[i];
      int adjustment = statAdjusts[i];

      if (adjustment < 0) {

        for (int j = 0; j > adjustment; j--) {
          if (temp > 108) {
            temp--;
          } else if (temp > 88) {
            temp += -new Dice(1, 6).roll() - 2;
          } else if (temp > 18) {
            temp += -new Dice(1, 15).roll() - 5;
            if (temp < 18) {
              temp = 18;
            }
          } else if (temp > 3) {
            temp--;
          }
        }

      } else {

        for (int j = 0; j < adjustment; j++) {
          if (temp < 18) {
            temp++;
          } else if (temp < 88) {
            temp += new Dice(1, 15).roll() + 5;
          } else if (temp < 108) {
            temp += new Dice(1, 6).roll() + 2;
          } else if (temp < 118) {
            temp++;
          }
        }
      }
      stats[i] = temp;
    }

  }

}
