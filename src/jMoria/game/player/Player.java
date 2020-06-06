package jMoria.game.player;

import jMoria.game.player.enums.Class;
import jMoria.game.player.enums.Race;
import jMoria.game.player.enums.Sex;

public class Player {

  public String name;
  public Race race;
  public Sex sex;
  public Class playerClass;

  public int age = 0;
  public int height = 0;
  public int weight = 0;
  public int socialClass = 0;

  // STATS

  public int strength = 0;
  public int intelligence = 0;
  public int wisdom = 0;
  public int dexterity = 0;
  public int constitution = 0;
  public int charisma = 0;

  public int maxStrength = 0;
  public int maxIntelligence = 0;
  public int maxWisdom = 0;
  public int maxDexterity = 0;
  public int maxConstitution = 0;
  public int maxCharisma = 0;

  // ABILITIES

  public int fighting = 0;
  public int bowsThrow = 0;
  public int savingThrow = 0;
  public int stealth = 0;
  public int disarming = 0;
  public int magicDevice = 0;
  public int perception = 0;
  public int searching = 0;
  public int infraVision = 0;

  public int bonusToHit = 0;
  public int bonusToDamage = 0;
  public int bonusToArmorClass = 0;
  public int totalArmorClass = 0;

  public int level = 1;
  public int experience = 0;
  public int maxExperience = 0;
  public int gold = 0;
  public int maxHitPoints = 0;
  public int currentHitPoints = 0;
  public int maxMana = 0;
  public int currentMana = 0;

  public String characterBackground = "";

}
