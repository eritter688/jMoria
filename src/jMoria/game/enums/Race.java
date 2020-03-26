package jMoria.game.enums;

public enum Race {

  HUMAN("Human"),
  HALF_ELF("Half-Elf"),
  ELF("Elf"),
  HALFLING("Halfling"),
  GNOME("Gnome"),
  DWARF("Dwarf"),
  HALF_ORC("Half-Orc"),
  HALF_TROLL("Half-Troll");

  private final String race;

  Race(String race) {
    this.race = race;
  }

  public String getRace() {
    return this.race;
  }

}
