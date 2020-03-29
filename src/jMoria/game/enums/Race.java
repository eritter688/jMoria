package jMoria.game.enums;

public enum Race {
  HUMAN("Human", 14, 6, 72, 6, 180, 25, 66, 4, 150, 20),
  HALF_ELF("Half-Elf", 24, 16, 66, 6, 130, 15, 62, 6, 100, 10),
  ELF("Elf", 75, 75, 60, 4, 100, 6, 54, 4, 80, 6),
  HALFLING("Halfling", 21, 12, 36, 3, 60, 3, 33, 3, 50, 3),
  GNOME("Gnome", 50, 40, 42, 3, 90, 6, 39, 3, 75, 3),
  DWARF("Dwarf", 35, 15, 48, 3, 150, 10, 46, 3, 120, 10),
  HALF_ORC("Half-Orc", 11, 4, 66, 1, 150, 5, 62, 1, 120, 5),
  HALF_TROLL("Half-Troll", 20, 10, 96, 10, 255, 50, 84, 8, 225, 40);

  private final String race;

  private final int baseAge;
  private final int ageModifier;

  private final int maleBaseHeight;
  private final int maleModHeight;
  private final int femaleBaseHeight;
  private final int femaleModHeight;

  private final int maleBaseWeight;
  private final int maleModWeight;
  private final int femaleBaseWeight;
  private final int femaleModWeight;

  Race(String race, int baseAge, int ageModifier, int maleBaseHeight, int maleModHeight, int femaleBaseHeight, int femaleModHeight, int maleBaseWeight, int maleModWeight, int femaleBaseWeight, int femaleModWeight) {
    this.race = race;
    this.baseAge = baseAge;
    this.ageModifier = ageModifier;
    this.maleBaseHeight = maleBaseHeight;
    this.maleModHeight = maleModHeight;
    this.femaleBaseHeight = femaleBaseHeight;
    this.femaleModHeight = femaleModHeight;
    this.maleBaseWeight = maleBaseWeight;
    this.maleModWeight = maleModWeight;
    this.femaleBaseWeight = femaleBaseWeight;
    this.femaleModWeight = femaleModWeight;
  }

  public String getRace() {
    return this.race;
  }

  public int rollAge() {
    return 1;
  }

  public int rollHeight() {
    return 1;
  }

  public int rollWeight() {
    return 1;
  }
}
