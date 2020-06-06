package jMoria.game.data;

import jMoria.game.player.enums.Race;
import jMoria.game.utils.Dice;
import java.util.HashMap;
import java.util.Map;

public class PlayerStatGenerator {

  private final Race race;
  private int[] statAdjusts;
  private int[] stats = new int[6];


  public static final Map<Race, int[]> statAdjustMap = new HashMap<>();
  public static final Map<Race, int[]> ageMap = new HashMap<>();
  public static final Map<Race, int[]> heightMap = new HashMap<>();
  public static final Map<Race, int[]> weightMap = new HashMap<>();
  public static final Map<Race, int[]> abilityMap = new HashMap<>();

  static {
    // str, int, wis, dex, con, chr
    statAdjustMap.put(Race.HUMAN, new int[]     { 0,  0,  0,  0,  0,  0});
    statAdjustMap.put(Race.HALF_ELF, new int[]  {-1,  1,  0,  1, -1,  1});
    statAdjustMap.put(Race.ELF, new int[]       {-1,  2,  1,  1, -2,  1});
    statAdjustMap.put(Race.HALFLING, new int[]  {-2,  2,  1,  3,  1,  1});
    statAdjustMap.put(Race.GNOME, new int[]     {-1,  2,  0,  2,  1, -2});
    statAdjustMap.put(Race.DWARF, new int[]     { 2, -3,  1, -2,  2, -3});
    statAdjustMap.put(Race.HALF_ORC, new int[]  { 2, -1,  0,  0,  1, -4});
    statAdjustMap.put(Race.HALF_TROLL, new int[]{ 4, -4, -2, -4,  3, -6});

    // base age, age modifier
    ageMap.put(Race.HUMAN, new int[]     {14,  6});
    ageMap.put(Race.HALF_ELF, new int[]  {24, 16});
    ageMap.put(Race.ELF, new int[]       {75, 75});
    ageMap.put(Race.HALFLING, new int[]  {21, 12});
    ageMap.put(Race.GNOME, new int[]     {50, 40});
    ageMap.put(Race.DWARF, new int[]     {35, 15});
    ageMap.put(Race.HALF_ORC, new int[]  {11,  4});
    ageMap.put(Race.HALF_TROLL, new int[]{20, 10});

    // male base, male mod, female base, female mod
    heightMap.put(Race.HUMAN, new int[]     {72,  6, 66, 4});
    heightMap.put(Race.HALF_ELF, new int[]  {66,  6, 62, 6});
    heightMap.put(Race.ELF, new int[]       {60,  4, 54, 4});
    heightMap.put(Race.HALFLING, new int[]  {36,  3, 33, 3});
    heightMap.put(Race.GNOME, new int[]     {42,  3, 39, 3});
    heightMap.put(Race.DWARF, new int[]     {48,  3, 46, 3});
    heightMap.put(Race.HALF_ORC, new int[]  {66,  1, 62, 1});
    heightMap.put(Race.HALF_TROLL, new int[]{96, 10, 84, 8});

    // male base, male mod, female base, female mod
    weightMap.put(Race.HUMAN, new int[]     {180, 25, 150, 20});
    weightMap.put(Race.HALF_ELF, new int[]  {130, 15, 100, 10});
    weightMap.put(Race.ELF, new int[]       {100,  6,  80,  6});
    weightMap.put(Race.HALFLING, new int[]  { 60,  3,  50,  3});
    weightMap.put(Race.GNOME, new int[]     { 90,  6,  75,  3});
    weightMap.put(Race.DWARF, new int[]     {150, 10, 120, 10});
    weightMap.put(Race.HALF_ORC, new int[]  {150,  5, 120,  5});
    weightMap.put(Race.HALF_TROLL, new int[]{255, 50, 225, 40});
  }

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
