package jMoria.game.player.enums;

public enum Class {
  WARRIOR("Warrior"),
  MAGE("Mage"),
  PRIEST("Priest"),
  ROGUE("Rogue"),
  RANGER("Ranger"),
  PALADIN("Paladin");

  private final String playerClass;

  Class(String playerClass) {
    this.playerClass = playerClass;
  }

  public String getPlayerClass() {
    return this.playerClass;
  }
}
