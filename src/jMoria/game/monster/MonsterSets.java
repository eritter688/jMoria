package jMoria.game.monster;

import java.util.Set;

public class MonsterSets {

  public static final Set<MonsterType> TOWN_MONSTERS;
  public static final Set<MonsterType> WIN_MONSTERS;

  static {
    TOWN_MONSTERS = Set.of(
        MonsterType.FILTHY_STREET_URCHIN,
        MonsterType.BLUBBERING_IDIOT,
        MonsterType.PITIFUL_LOOKING_BEGGAR,
        MonsterType.MANGY_LOOKING_LEPER,
        MonsterType.SQUINT_EYED_ROGUE,
        MonsterType.SINGING_HAPPY_DRUNK,
        MonsterType.MEAN_LOOKING_MERCENARY,
        MonsterType.BATTLE_SCARRED_VETERAN);

    WIN_MONSTERS = Set.of(
        MonsterType.BATTLE_SCARRED_VETERAN
    );
  }

}
