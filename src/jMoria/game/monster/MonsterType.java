package jMoria.game.monster;

public enum MonsterType {
  FILTHY_STREET_URCHIN("p", "Filthy Street Urchin"),
  BLUBBERING_IDIOT("p", "Blubbering Idiot"),
  PITIFUL_LOOKING_BEGGAR("p", "Pitiful-Looking Beggar"),
  MANGY_LOOKING_LEPER("p", "Mangy-Looking Leper"),
  SQUINT_EYED_ROGUE("p", "Squint-Eyed Rogue"),
  SINGING_HAPPY_DRUNK("p", "Singing, Happy Drunk"),
  MEAN_LOOKING_MERCENARY("p", "Mean-Looking Mercenary"),
  BATTLE_SCARRED_VETERAN("p", "Battle-Scarred Veteran");

  private final String longName;
  private final String displayChar;

  MonsterType(String displayChar, String longName) {
    this.displayChar = displayChar;
    this.longName = longName;
  }
}
