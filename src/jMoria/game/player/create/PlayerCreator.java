package jMoria.game.player.create;

import jMoria.game.player.Player;
import jMoria.game.player.enums.Class;
import jMoria.game.player.enums.Race;
import jMoria.game.player.enums.Sex;
import jMoria.game.utils.Dice;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class PlayerCreator {

  private final Player player;

  public static final Map<Race, int[]> statAdjustMap = new HashMap<>();
  public static final Map<Race, int[]> ageMap = new HashMap<>();
  public static final Map<Race, int[]> heightMap = new HashMap<>();
  public static final Map<Race, int[]> weightMap = new HashMap<>();
  public static final Map<Race, int[]> abilityMap = new HashMap<>();
  public static final Map<Race, EnumSet<Class>> classMap = new HashMap<>();

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

    // ability map

    // class map
    classMap.put(Race.HUMAN, EnumSet.allOf(Class.class));
    classMap.put(Race.HALF_ELF, EnumSet.allOf(Class.class));
    classMap.put(Race.ELF, EnumSet.of(Class.WARRIOR, Class.MAGE, Class.PRIEST, Class.ROGUE, Class.RANGER));
    classMap.put(Race.HALFLING, EnumSet.of(Class.WARRIOR, Class.MAGE, Class.ROGUE));
    classMap.put(Race.GNOME, EnumSet.of(Class.WARRIOR, Class.MAGE, Class.PRIEST, Class.ROGUE));
    classMap.put(Race.DWARF, EnumSet.of(Class.WARRIOR, Class.PRIEST));
    classMap.put(Race.HALF_ORC, EnumSet.of(Class.WARRIOR, Class.PRIEST, Class.ROGUE));
    classMap.put(Race.HALF_TROLL, EnumSet.of(Class.WARRIOR, Class.PRIEST));
  }

  /**
   * UMoria and older variants used a normalized distribution but we're just going
   * simple here and possibly modifying a little up or down or just stay the same.
   *
   * @param baseValue
   * @param modValue
   * @return A possibly modified integer value from the original.
   */
  public static int adjustFromBaseValue(int baseValue, int modValue) {
    int roll = new Dice(1, 3).roll();
    if(roll == 1) {
      return baseValue + new Dice(1, modValue).roll();
    } else if (roll == 2) {
      return baseValue - new Dice(1, modValue).roll();
    } else {
      return baseValue;
    }
  }

  public PlayerCreator(Player p) {
    this.player = p;
  }

  public void roll() {
    int[] stats = new int[6];

    baseStatRoll(stats);
    adjustStatRoll(stats);
    setStats(stats);

    ageRoll();
    heightRoll();
    weightRoll();

    // TODO see player.create.history
    socialClassRoll();
//    PlayerHistoryGenerator historyGenerator = new PlayerHistoryGenerator(this.player);
//    historyGenerator.generateHistory();
//    System.out.println(player.characterBackground);
//    HumanHistoryGenerator hg = new HumanHistoryGenerator();
//    hg.generateHistory();

  }

  private void setStats(int[] stats) {
    player.strength = stats[0];
    player.intelligence = stats[1];
    player.wisdom = stats[2];
    player.dexterity = stats[3];
    player.constitution = stats[4];
    player.charisma = stats[5];

    player.maxStrength = stats[0];
    player.maxIntelligence = stats[1];
    player.maxWisdom = stats[2];
    player.maxDexterity = stats[3];
    player.maxConstitution = stats[4];
    player.maxCharisma = stats[5];
  }

  private void baseStatRoll(int[] stats) {
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

  private void adjustStatRoll(int[] stats) {

    for (int i = 0; i < 6; i++) {
      int stat = stats[i];
      int adjustment = statAdjustMap.get(player.race)[i];

      if (adjustment < 0) {

        for (int j = 0; j > adjustment; j--) {
          if (stat > 108) {
            stat--;
          } else if (stat > 88) {
            stat += -new Dice(1, 6).roll() - 2;
          } else if (stat > 18) {
            stat += -new Dice(1, 15).roll() - 5;
            if (stat < 18) {
              stat = 18;
            }
          } else if (stat > 3) {
            stat--;
          }
        }

      } else {

        for (int j = 0; j < adjustment; j++) {
          if (stat < 18) {
            stat++;
          } else if (stat < 88) {
            stat += new Dice(1, 15).roll() + 5;
          } else if (stat < 108) {
            stat += new Dice(1, 6).roll() + 2;
          } else if (stat < 118) {
            stat++;
          }
        }
      }
      stats[i] = stat;
    }

  }

  private void ageRoll() {
    int base_age = ageMap.get(player.race)[0];
    int age_mod = ageMap.get(player.race)[1];
    player.age = base_age + new Dice(1, age_mod).roll();
  }

  private void heightRoll() {
    int base_height;
    int height_mod;
    if (player.sex == Sex.MALE) {
      base_height = heightMap.get(player.race)[0];
      height_mod = heightMap.get(player.race)[1];
    } else {
      base_height = heightMap.get(player.race)[2];
      height_mod = heightMap.get(player.race)[3];
    }
    player.height = adjustFromBaseValue(base_height, height_mod);
  }

  private void weightRoll() {
    int base_weight;
    int weight_mod;
    if (player.sex == Sex.MALE) {
      base_weight = weightMap.get(player.race)[0];
      weight_mod = weightMap.get(player.race)[1];
    } else {
      base_weight = weightMap.get(player.race)[2];
      weight_mod = weightMap.get(player.race)[3];
    }
    player.weight = adjustFromBaseValue(base_weight, weight_mod);
  }

  // TODO
  private void socialClassRoll() {
    int socialClass = new Dice(1, 100).roll();
  }

  public EnumSet<Class> getClassOptions() {
    return classMap.get(player.race);
  }

  public void setPlayerClass(Class playerClass) {
    player.playerClass = playerClass;
  }


}
