package jMoria.game.enums;

public enum PlayerClass {

  WARRIOR("Warrior"),
  MAGE("Mage"),
  PRIEST("Priest"),
  ROGUE("Rogue"),
  RANGER("Ranger"),
  PALADIN("Paladin");

  private final String playerClass;

  PlayerClass(String playerClass) {
    this.playerClass = playerClass;
  }

  public String getPlayerClass() {
    return this.playerClass;
  }
}
