package jMoria.game.monster;

import java.util.List;

public abstract class AbstractMonster {

  public MonsterType monsterType;
  public String name;
  public String displayChar;
  public String displayColour;

  public int maxHitPoints;
  public int currentHitPoints;

  public List<Integer> attacks;
  public List<Integer> spells;

}
