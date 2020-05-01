package jMoria.game.monster;

import jMoria.game.monster.attack.AttackDescription;
import jMoria.game.monster.attack.AttackType;
import jMoria.game.utils.Dice;
import java.util.ArrayList;
import java.util.List;

public class Monster {

  public MonsterType monsterType;

  public int hitPoints;

  public List<MonsterAttack> attacks = new ArrayList<>();
  public List<Integer> spells = new ArrayList<>();

  public int y;
  public int x;
  public int distanceToPlayer;


  public Monster(MonsterType monsterType) {
    this.monsterType = monsterType;
  }

  public void setBase() {

  }

  public static class MonsterAttack {

    public AttackType attackType;
    public AttackDescription attackDescription;
    public Dice dice;

    public MonsterAttack(AttackType attackType, AttackDescription attackDescription, int num,
        int sides) {
      this.attackType = attackType;
      this.attackDescription = attackDescription;
      this.dice = new Dice(num, sides);
    }
  }

}
