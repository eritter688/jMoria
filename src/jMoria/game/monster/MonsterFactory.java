package jMoria.game.monster;

import jMoria.game.monster.Monster.MonsterAttack;
import jMoria.game.monster.attack.AttackDescription;
import jMoria.game.monster.attack.AttackType;

/*
name "Filthy Street Urchin"
cmove ,0x0012000AL,
spells 0x00000000L,
cdefense 0x2034,
exp/kill 0,
sleep/inactive 40,
aaf 4,
AC 1,
speed 11, (+10)
char 'p',
HP {1,4},
attack type/damage {72,148,0,0}		,
colour 0},


*/
public class MonsterFactory {

  public static Monster createMonster(MonsterType monsterType) {
    Monster m;
    switch (monsterType) {
      case FILTHY_STREET_URCHIN:
        m = new Monster(MonsterType.FILTHY_STREET_URCHIN);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BEG, 0, 0));
        m.attacks.add(new MonsterAttack(AttackType.STEAL_MONEY, AttackDescription.TOUCH, 0, 0));
        break;
      case BLUBBERING_IDIOT:
        m = new Monster(MonsterType.BLUBBERING_IDIOT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.DROOL, 0, 0));
        break;
      case PITIFUL_LOOKING_BEGGAR:
        m = new Monster(MonsterType.PITIFUL_LOOKING_BEGGAR);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BEG, 0, 0));
        break;
      case MANGY_LOOKING_LEPER:
        m = new Monster(MonsterType.MANGY_LOOKING_LEPER);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BEG, 0, 0));
        break;
      case SQUINT_EYED_ROGUE:
        m = new Monster(MonsterType.SQUINT_EYED_ROGUE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        m.attacks.add(new MonsterAttack(AttackType.STEAL_OBJECT, AttackDescription.TOUCH, 0, 0));
        break;
      case SINGING_HAPPY_DRUNK:
        m = new Monster(MonsterType.SINGING_HAPPY_DRUNK);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BEG, 0, 0));
        break;
      case MEAN_LOOKING_MERCENARY:
        m = new Monster(MonsterType.MEAN_LOOKING_MERCENARY);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 10));
        break;
      case BATTLE_SCARRED_VETERAN:
        m = new Monster(MonsterType.BATTLE_SCARRED_VETERAN);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 2, 6));
        break;
      case GREY_MUSHROOM_PATCH:
        m = new Monster(MonsterType.GREY_MUSHROOM_PATCH);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.CONFUSION, AttackDescription.SPORE, 1, 4));
        break;
      case GIANT_YELLOW_CENTIPEDE:
        m = new Monster(MonsterType.GIANT_YELLOW_CENTIPEDE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 3));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.STING, 1, 3));
        break;
      case GIANT_WHITE_CENTIPEDE:
        m = new Monster(MonsterType.GIANT_WHITE_CENTIPEDE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 2));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.STING, 1, 2));
        break;
      case WHITE_ICKY_THING:
        m = new Monster(MonsterType.WHITE_ICKY_THING);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.TOUCH, 1, 2));
        break;
      case CLEAR_ICKY_THING:
        m = new Monster(MonsterType.CLEAR_ICKY_THING);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.TOUCH, 1, 2));
        break;
      case GIANT_WHITE_MOUSE:
        m = new Monster(MonsterType.GIANT_WHITE_MOUSE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 2));
        break;
      case LARGE_BROWN_SNAKE:
        m = new Monster(MonsterType.LARGE_BROWN_SNAKE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 3));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CRUSH, 1, 4));
        break;
      case LARGE_WHITE_SNAKE:
        m = new Monster(MonsterType.LARGE_WHITE_SNAKE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 1));
        break;
      case KOBOLD:
        m = new Monster(MonsterType.KOBOLD);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        break;
      case WHITE_WORM_MASS:
        m = new Monster(MonsterType.WHITE_WORM_MASS);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.CRAWL, 1, 2));
        break;
      case FLOATING_EYE:
        m = new Monster(MonsterType.FLOATING_EYE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.PARALYSIS, AttackDescription.GAZE, 0, 0));
        break;
      case SHRIEKER_MUSHROOM_PATCH:
        m = new Monster(MonsterType.SHRIEKER_MUSHROOM_PATCH);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.AGGRAVATE, AttackDescription.WAIL, 0, 0));
        break;
      case BLUBBERING_ICKY_THING:
        m = new Monster(MonsterType.BLUBBERING_ICKY_THING);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.CRAWL, 1, 4));
        m.attacks.add(new MonsterAttack(AttackType.EAT_FOOD, AttackDescription.CRAWL, 0, 0));
        break;
      case METALLIC_GREEN_CENTIPEDE:
        m = new Monster(MonsterType.METALLIC_GREEN_CENTIPEDE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CRAWL, 1, 1));
        break;
      case NOVICE_WARRIOR:
        m = new Monster(MonsterType.NOVICE_WARRIOR);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 7));
        break;
      case NOVICE_ROGUE:
        m = new Monster(MonsterType.NOVICE_ROGUE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        m.attacks.add(new MonsterAttack(AttackType.STEAL_MONEY, AttackDescription.TOUCH, 0, 0));
        break;
      case NOVICE_PRIEST:
        m = new Monster(MonsterType.NOVICE_PRIEST);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 5));
        break;
      case NOVICE_MAGE:
        m = new Monster(MonsterType.NOVICE_MAGE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 4));
        break;
      case YELLOW_MUSHROOM_PATCH:
        m = new Monster(MonsterType.YELLOW_MUSHROOM_PATCH);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.FEAR, AttackDescription.SPORE, 1, 6));
        break;
      case WHITE_JELLY:
        m = new Monster(MonsterType.WHITE_JELLY);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.TOUCH, 1, 2));
        break;
      case GIANT_GREEN_FROG:
        m = new Monster(MonsterType.GIANT_GREEN_FROG);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 3));
        break;
      case GIANT_BLACK_ANT:
        m = new Monster(MonsterType.GIANT_BLACK_ANT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 4));
        break;
      case WHITE_HARPY:
        m = new Monster(MonsterType.WHITE_HARPY);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 1));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 1));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 2));
        break;
      case BLUE_YEEK:
        m = new Monster(MonsterType.BLUE_YEEK);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 5));
        break;
      case GREEN_WORM_MASS:
        m = new Monster(MonsterType.GREEN_WORM_MASS);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.CORROSION, AttackDescription.CRAWL, 1, 3));
        break;
      case LARGE_BLACK_SNAKE:
        m = new Monster(MonsterType.LARGE_BLACK_SNAKE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 4));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CRUSH, 1, 6));
        break;
      case POLTERGEIST:
        m = new Monster(MonsterType.POLTERGEIST);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.FEAR, AttackDescription.HIT, 1, 1));
        break;
      case METALLIC_BLUE_CENTIPEDE:
        m = new Monster(MonsterType.METALLIC_BLUE_CENTIPEDE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CRAWL, 1, 2));
        break;
      case GIANT_WHITE_LOUSE:
        m = new Monster(MonsterType.GIANT_WHITE_LOUSE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 1));
        break;
      case BLACK_NAGA:
        m = new Monster(MonsterType.BLACK_NAGA);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CRUSH, 1, 8));
        break;
      case SPOTTED_MUSHROOM_PATCH:
        m = new Monster(MonsterType.SPOTTED_MUSHROOM_PATCH);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.SPORE, 2, 4));
        break;
      case YELLOW_JELLY:
        m = new Monster(MonsterType.YELLOW_JELLY);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.TOUCH, 1, 3));
        break;
      case SCRUFFY_LOOKING_HOBBIT:
        m = new Monster(MonsterType.SCRUFFY_LOOKING_HOBBIT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 4));
        m.attacks.add(new MonsterAttack(AttackType.STEAL_MONEY, AttackDescription.TOUCH, 0, 0));
        break;
      case HUGE_BROWN_BAT:
        m = new Monster(MonsterType.HUGE_BROWN_BAT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 2));
        break;
      case GIANT_WHITE_ANT:
        m = new Monster(MonsterType.GIANT_WHITE_ANT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 4));
        break;
      case YELLOW_MOLD:
        m = new Monster(MonsterType.YELLOW_MOLD);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 4));
        break;
      case METALLIC_RED_CENTIPEDE:
        m = new Monster(MonsterType.METALLIC_RED_CENTIPEDE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CRAWL, 1, 2));
        break;
      case YELLOW_WORM_MASS:
        m = new Monster(MonsterType.YELLOW_WORM_MASS);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.DRAIN_DEXTERITY, AttackDescription.CRAWL, 1, 3));
        break;
      case LARGE_GREEN_SNAKE:
        m = new Monster(MonsterType.LARGE_GREEN_SNAKE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 4));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CRUSH, 1, 6));
        break;
      case RADIATION_EYE:
        m = new Monster(MonsterType.RADIATION_EYE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.POISON_STRENGTH, AttackDescription.GAZE, 1, 6));
        break;
      case DROOLING_HARPY:
        m = new Monster(MonsterType.DROOLING_HARPY);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 1));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 1));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 2));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.DROOL, 0, 0));
        break;
      case SILVER_MOUSE:
        m = new Monster(MonsterType.SILVER_MOUSE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.EAT_LIGHT, AttackDescription.HIT, 1, 1));
        break;
      case BLACK_MUSHROOM_PATCH:
        m = new Monster(MonsterType.BLACK_MUSHROOM_PATCH);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.SPORE, 1, 3));
        break;
      case BLUE_JELLY:
        m = new Monster(MonsterType.BLUE_JELLY);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.COLD, AttackDescription.TOUCH, 1, 6));
        break;
      case CREEPING_COPPER_COINS:
        m = new Monster(MonsterType.CREEPING_COPPER_COINS);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 4));
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.TOUCH, 2, 4));
        break;
      case GIANT_WHITE_RAT:
        m = new Monster(MonsterType.GIANT_WHITE_RAT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.BITE, 1, 3));
        break;
      case GIANT_BLACK_CENTIPEDE:
        m = new Monster(MonsterType.GIANT_BLACK_CENTIPEDE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 2));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.STING, 1, 2));
        break;
      case GIANT_BLUE_CENTIPEDE:
        m = new Monster(MonsterType.GIANT_BLUE_CENTIPEDE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 3));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.STING, 1, 4));
        break;
      case BLUE_WORM_MASS:
        m = new Monster(MonsterType.BLUE_WORM_MASS);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.COLD, AttackDescription.CRAWL, 1, 4));
        break;
      case LARGE_GREY_SNAKE:
        m = new Monster(MonsterType.LARGE_GREY_SNAKE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 5));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CRUSH, 1, 8));
        break;
      case JACKAL:
        m = new Monster(MonsterType.JACKAL);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 6));
        break;
      case GREEN_NAGA:
        m = new Monster(MonsterType.GREEN_NAGA);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CRUSH, 1, 8));
        m.attacks.add(new MonsterAttack(AttackType.ACID, AttackDescription.SPIT, 2, 6));
        break;
      case GREEN_GLUTTON_GHOST:
        m = new Monster(MonsterType.GREEN_GLUTTON_GHOST);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.EAT_FOOD, AttackDescription.SLIME, 1, 1));
        break;
      case WHITE_MUSHROOM_PATCH:
        m = new Monster(MonsterType.WHITE_MUSHROOM_PATCH);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.PARALYSIS, AttackDescription.SPORE, 2, 4));
        break;
      case GREEN_JELLY:
        m = new Monster(MonsterType.GREEN_JELLY);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.CORROSION, AttackDescription.TOUCH, 1, 2));
        break;
      case SKELETON_KOBOLD:
        m = new Monster(MonsterType.SKELETON_KOBOLD);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        break;
      case SILVER_JELLY:
        m = new Monster(MonsterType.SILVER_JELLY);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.EAT_LIGHT, AttackDescription.TOUCH, 1, 3));
        break;
      case GIANT_BLACK_FROG:
        m = new Monster(MonsterType.GIANT_BLACK_FROG);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 6));
        break;
      case GREY_ICKY_THING:
        m = new Monster(MonsterType.GREY_ICKY_THING);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.TOUCH, 1, 5));
        break;
      case DISENCHANTER_EYE:
        m = new Monster(MonsterType.DISENCHANTER_EYE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.DISENCHANT, AttackDescription.GAZE, 0, 0));
        break;
      case BLACK_YEEK:
        m = new Monster(MonsterType.BLACK_YEEK);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 5));
        break;
      case RED_WORM_MASS:
        m = new Monster(MonsterType.RED_WORM_MASS);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.FIRE, AttackDescription.CRAWL, 1, 6));
        break;
      case GIANT_HOUSE_FLY:
        m = new Monster(MonsterType.GIANT_HOUSE_FLY);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 2));
        break;
      case COPPERHEAD_SNAKE:
        m = new Monster(MonsterType.COPPERHEAD_SNAKE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.BITE, 2, 4));
        break;
      case ROT_JELLY:
        m = new Monster(MonsterType.ROT_JELLY);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.EAT_FOOD, AttackDescription.TOUCH, 2, 3));
        break;
      case PURPLE_MUSHROOM_PATCH:
        m = new Monster(MonsterType.PURPLE_MUSHROOM_PATCH);
        m.setBase();
        m.attacks
            .add(new MonsterAttack(AttackType.DRAIN_CONSTITUTION, AttackDescription.SPORE, 1, 2));
        break;
      case BROWN_MOLD:
        m = new Monster(MonsterType.BROWN_MOLD);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.CONFUSION, AttackDescription.HIT, 1, 4));
        break;
      case GIANT_BROWN_BAT:
        m = new Monster(MonsterType.GIANT_BROWN_BAT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 3));
        break;
      case CREEPING_SILVER_COINS:
        m = new Monster(MonsterType.CREEPING_SILVER_COINS);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.TOUCH, 2, 6));
        break;
      case ORC:
        m = new Monster(MonsterType.ORC);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 8));
        break;
      case GREY_HARPY:
        m = new Monster(MonsterType.GREY_HARPY);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 2));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 2));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 2));
        break;
      case BLUE_ICKY_THING:
        m = new Monster(MonsterType.BLUE_ICKY_THING);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.COLD, AttackDescription.TOUCH, 2, 3));
        break;
      case RATTLESNAKE:
        m = new Monster(MonsterType.RATTLESNAKE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.BITE, 2, 5));
        break;
      case BLOODSHOT_EYE:
        m = new Monster(MonsterType.BLOODSHOT_EYE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.BLINDNESS, AttackDescription.GAZE, 2, 6));
        break;
      case RED_NAGA:
        m = new Monster(MonsterType.RED_NAGA);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CRUSH, 1, 10));
        m.attacks.add(new MonsterAttack(AttackType.POISON_STRENGTH, AttackDescription.BITE, 1, 4));
        break;
      case RED_JELLY:
        m = new Monster(MonsterType.RED_JELLY);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.POISON_STRENGTH, AttackDescription.TOUCH, 1, 5));
        break;
      case GIANT_RED_FROG:
        m = new Monster(MonsterType.GIANT_RED_FROG);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.POISON_STRENGTH, AttackDescription.BITE, 2, 4));
        break;
      case GREEN_ICKY_THING:
        m = new Monster(MonsterType.GREEN_ICKY_THING);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.CORROSION, AttackDescription.TOUCH, 2, 5));
        break;
      case ZOMBIE_KOBOLD:
        m = new Monster(MonsterType.ZOMBIE_KOBOLD);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 2));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 2));
        break;
      case LOST_SOUL:
        m = new Monster(MonsterType.LOST_SOUL);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 2, 2));
        m.attacks.add(new MonsterAttack(AttackType.DRAIN_WISDOM, AttackDescription.TOUCH, 0, 0));
        break;
      case GREEDY_LITTLE_GNOME:
        m = new Monster(MonsterType.GREEDY_LITTLE_GNOME);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 7));
        m.attacks.add(new MonsterAttack(AttackType.STEAL_OBJECT, AttackDescription.TOUCH, 0, 0));
        break;
      case GIANT_GREEN_FLY:
        m = new Monster(MonsterType.GIANT_GREEN_FLY);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 4));
        break;
      case BROWN_YEEK:
        m = new Monster(MonsterType.BROWN_YEEK);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        break;
      case GREEN_MOLD:
        m = new Monster(MonsterType.GREEN_MOLD);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.FEAR, AttackDescription.HIT, 1, 4));
        break;
      case SKELETON_ORC:
        m = new Monster(MonsterType.SKELETON_ORC);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 2, 5));
        break;
      case SEEDY_LOOKING_HUMAN:
        m = new Monster(MonsterType.SEEDY_LOOKING_HUMAN);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 3, 4));
        break;
      case RED_ICKY_THING:
        m = new Monster(MonsterType.RED_ICKY_THING);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.TOUCH, 1, 3));
        m.attacks.add(new MonsterAttack(AttackType.ACID, AttackDescription.BREATHE, 1, 5));
        break;
      case BANDIT:
        m = new Monster(MonsterType.BANDIT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 2, 4));
        m.attacks.add(new MonsterAttack(AttackType.STEAL_MONEY, AttackDescription.TOUCH, 0, 0));
        break;
      case YETI:
        m = new Monster(MonsterType.YETI);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 3));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 3));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 4));
        break;
      case BLOODSHOT_ICKY_THING:
        m = new Monster(MonsterType.BLOODSHOT_ICKY_THING);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.TOUCH, 1, 4));
        m.attacks.add(new MonsterAttack(AttackType.CORROSION, AttackDescription.BREATHE, 2, 4));
        break;
      case GIANT_GREY_RAT:
        m = new Monster(MonsterType.GIANT_GREY_RAT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.BITE, 1, 4));
        break;
      case BLACK_HARPY:
        m = new Monster(MonsterType.BLACK_HARPY);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 2));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 2));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 3));
        break;
      case GIANT_BLACK_BAT:
        m = new Monster(MonsterType.GIANT_BLACK_BAT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 6));
        break;
      case CLEAR_YEEK:
        m = new Monster(MonsterType.CLEAR_YEEK);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 5));
        break;
      case ORC_SHAMAN:
        m = new Monster(MonsterType.ORC_SHAMAN);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        break;
      case GIANT_RED_ANT:
        m = new Monster(MonsterType.GIANT_RED_ANT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 4));
        m.attacks.add(new MonsterAttack(AttackType.POISON_STRENGTH, AttackDescription.STING, 1, 4));
        break;
      case KING_COBRA:
        m = new Monster(MonsterType.KING_COBRA);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.BLINDNESS, AttackDescription.SPIT, 1, 2));
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.BITE, 3, 4));
        break;
      case CLEAR_MUSHROOM_PATCH:
        m = new Monster(MonsterType.CLEAR_MUSHROOM_PATCH);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.SPORE, 1, 1));
        break;
      case GIANT_WHITE_TICK:
        m = new Monster(MonsterType.GIANT_WHITE_TICK);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.BITE, 2, 6));
        break;
      case HAIRY_MOLD:
        m = new Monster(MonsterType.HAIRY_MOLD);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.HIT, 1, 3));
        break;
      case DISENCHANTER_MOLD:
        m = new Monster(MonsterType.DISENCHANTER_MOLD);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.DISENCHANT, AttackDescription.TOUCH, 1, 6));
        break;
      case GIANT_RED_CENTIPEDE:
        m = new Monster(MonsterType.GIANT_RED_CENTIPEDE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 2));
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.STING, 1, 2));
        break;
      case CREEPING_GOLD_COINS:
        m = new Monster(MonsterType.CREEPING_GOLD_COINS);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 2, 5));
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.TOUCH, 3, 5));
        break;
      case GIANT_FRUIT_FLY:
        m = new Monster(MonsterType.GIANT_FRUIT_FLY);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 2));
        break;
      case BRIGAND:
        m = new Monster(MonsterType.BRIGAND);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 2, 4));
        m.attacks.add(new MonsterAttack(AttackType.STEAL_OBJECT, AttackDescription.TOUCH, 0, 0));
        break;
      case ORC_ZOMBIE:
        m = new Monster(MonsterType.ORC_ZOMBIE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 4));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 4));
        break;
      case ORC_WARRIOR:
        m = new Monster(MonsterType.ORC_WARRIOR);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 2, 6));
        break;
      case VORPAL_BUNNY:
        m = new Monster(MonsterType.VORPAL_BUNNY);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 5));
        break;
      case NASTY_LITTLE_GNOME:
        m = new Monster(MonsterType.NASTY_LITTLE_GNOME);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 5));
        break;
      case HOBGOBLIN:
        m = new Monster(MonsterType.HOBGOBLIN);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 10));
        break;
      case BLACK_MAMBA:
        m = new Monster(MonsterType.BLACK_MAMBA);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.BITE, 4, 4));
        break;
      case GRAPE_JELLY:
        m = new Monster(MonsterType.GRAPE_JELLY);
        m.setBase();
        m.attacks
            .add(new MonsterAttack(AttackType.DRAIN_EXPERIENCE, AttackDescription.TOUCH, 5, 8));
        break;
      case MASTER_YEEK:
        m = new Monster(MonsterType.MASTER_YEEK);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 8));
        break;
      case PRIEST:
        m = new Monster(MonsterType.PRIEST);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 2, 3));
        break;
      case GIANT_CLEAR_ANT:
        m = new Monster(MonsterType.GIANT_CLEAR_ANT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 4));
        break;
      case AIR_SPIRIT:
        m = new Monster(MonsterType.AIR_SPIRIT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 3));
        break;
      case SKELETON_HUMAN:
        m = new Monster(MonsterType.SKELETON_HUMAN);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 8));
        break;
      case HUMAN_ZOMBIE:
        m = new Monster(MonsterType.HUMAN_ZOMBIE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 4));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 4));
        break;
      case MOANING_SPIRIT:
        m = new Monster(MonsterType.MOANING_SPIRIT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.FEAR, AttackDescription.WAIL, 0, 0));
        m.attacks.add(new MonsterAttack(AttackType.DRAIN_DEXTERITY, AttackDescription.TOUCH, 1, 8));
        break;
      case SWORDSMAN:
        m = new Monster(MonsterType.SWORDSMAN);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 3, 5));
        break;
      case KILLER_BROWN_BEETLE:
        m = new Monster(MonsterType.KILLER_BROWN_BEETLE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 3, 4));
        break;
      case OGRE:
        m = new Monster(MonsterType.OGRE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 2, 8));
        break;
      case GIANT_RED_SPECKLED_FROG:
        m = new Monster(MonsterType.GIANT_RED_SPECKLED_FROG);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 3, 4));
        break;
      case MAGIC_USER:
        m = new Monster(MonsterType.MAGIC_USER);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 2, 2));
        break;
      case BLACK_ORC:
        m = new Monster(MonsterType.BLACK_ORC);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 3, 4));
        break;
      case GIANT_LONG_EARED_BAT:
        m = new Monster(MonsterType.GIANT_LONG_EARED_BAT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 4));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 2));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 2));
        break;
      case GIANT_GNAT:
        m = new Monster(MonsterType.GIANT_GNAT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 1));
        break;
      case KILLER_GREEN_BEETLE:
        m = new Monster(MonsterType.KILLER_GREEN_BEETLE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 4, 4));
        break;
      case GIANT_FLEA:
        m = new Monster(MonsterType.GIANT_FLEA);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 2));
        break;
      case GIANT_WHITE_DRAGON_FLY:
        m = new Monster(MonsterType.GIANT_WHITE_DRAGON_FLY);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.COLD, AttackDescription.BITE, 1, 6));
        break;
      case HILL_GIANT:
        m = new Monster(MonsterType.HILL_GIANT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 3, 6));
        break;
      case SKELETON_HOBGOBLIN:
        m = new Monster(MonsterType.SKELETON_HOBGOBLIN);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 2, 5));
        break;
      case FLESH_GOLEM:
        m = new Monster(MonsterType.FLESH_GOLEM);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        break;
      case WHITE_DRAGON_BAT:
        m = new Monster(MonsterType.WHITE_DRAGON_BAT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.COLD, AttackDescription.BITE, 1, 3));
        break;
      case GIANT_BLACK_LOUSE:
        m = new Monster(MonsterType.GIANT_BLACK_LOUSE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 2));
        break;
      case GUARDIAN_NAGA:
        m = new Monster(MonsterType.GUARDIAN_NAGA);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CRUSH, 2, 8));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 8));
        break;
      case GIANT_GREY_BAT:
        m = new Monster(MonsterType.GIANT_GREY_BAT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 6));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 2));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 2));
        break;
      case GIANT_CLEAR_CENTIPEDE:
        m = new Monster(MonsterType.GIANT_CLEAR_CENTIPEDE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 2, 4));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.STING, 2, 4));
        break;
      case GIANT_YELLOW_TICK:
        m = new Monster(MonsterType.GIANT_YELLOW_TICK);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.BITE, 3, 9));
        break;
      case GIANT_EBONY_ANT:
        m = new Monster(MonsterType.GIANT_EBONY_ANT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 2, 3));
        break;
      case FROST_GIANT:
        m = new Monster(MonsterType.FROST_GIANT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.COLD, AttackDescription.HIT, 3, 6));
        break;
      case CLAY_GOLEM:
        m = new Monster(MonsterType.CLAY_GOLEM);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 8));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 8));
        break;
      case HUGE_WHITE_BAT:
        m = new Monster(MonsterType.HUGE_WHITE_BAT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 6));
        break;
      case GIANT_TAN_BAT:
        m = new Monster(MonsterType.GIANT_TAN_BAT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.FEAR, AttackDescription.BITE, 1, 2));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 1));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 1));
        break;
      case VIOLET_MOLD:
        m = new Monster(MonsterType.VIOLET_MOLD);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.PARALYSIS, AttackDescription.HIT, 1, 2));
        break;
      case UMBER_HULK:
        m = new Monster(MonsterType.UMBER_HULK);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.CONFUSION, AttackDescription.GAZE, 0, 0));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 2, 6));
        break;
      case GELATINOUS_CUBE:
        m = new Monster(MonsterType.GELATINOUS_CUBE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.ACID, AttackDescription.TOUCH, 1, 10));
        break;
      case GIANT_BLACK_RAT:
        m = new Monster(MonsterType.GIANT_BLACK_RAT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.BITE, 1, 5));
        break;
      case GIANT_GREEN_DRAGON_FLY:
        m = new Monster(MonsterType.GIANT_GREEN_DRAGON_FLY);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.BITE, 1, 6));
        break;
      case FIRE_GIANT:
        m = new Monster(MonsterType.FIRE_GIANT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.FIRE, AttackDescription.HIT, 3, 7));
        break;
      case GREEN_DRAGON_BAT:
        m = new Monster(MonsterType.GREEN_DRAGON_BAT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.BITE, 1, 3));
        break;
      case QUASIT:
        m = new Monster(MonsterType.QUASIT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.DRAIN_DEXTERITY, AttackDescription.BITE, 1, 6));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 3));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 3));
        break;
      case TROLL:
        m = new Monster(MonsterType.TROLL);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 4));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 4));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 6));
        break;
      case WATER_SPIRIT:
        m = new Monster(MonsterType.WATER_SPIRIT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 2, 4));
        break;
      case GIANT_BROWN_SCORPION:
        m = new Monster(MonsterType.GIANT_BROWN_SCORPION);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 2, 4));
        m.attacks.add(new MonsterAttack(AttackType.POISON_STRENGTH, AttackDescription.STING, 1, 7));
        break;
      case EARTH_SPIRIT:
        m = new Monster(MonsterType.EARTH_SPIRIT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 8));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 8));
        break;
      case FIRE_SPIRIT:
        m = new Monster(MonsterType.FIRE_SPIRIT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.FIRE, AttackDescription.HIT, 2, 6));
        break;
      case URUK_HAI_ORC:
        m = new Monster(MonsterType.URUK_HAI_ORC);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 3, 5));
        break;
      case STONE_GIANT:
        m = new Monster(MonsterType.STONE_GIANT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 3, 8));
        break;
      case STONE_GOLEM:
        m = new Monster(MonsterType.STONE_GOLEM);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 10));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 10));
        break;
      case GREY_OOZE:
        m = new Monster(MonsterType.GREY_OOZE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.COLD, AttackDescription.TOUCH, 2, 6));
        break;
      case DISENCHANTER_OOZE:
        m = new Monster(MonsterType.DISENCHANTER_OOZE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.DISENCHANT, AttackDescription.TOUCH, 0, 0));
        break;
      case GIANT_SPOTTED_RAT:
        m = new Monster(MonsterType.GIANT_SPOTTED_RAT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.BITE, 1, 5));
        break;
      case MUMMIFIED_KOBOLD:
        m = new Monster(MonsterType.MUMMIFIED_KOBOLD);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        break;
      case KILLER_BLACK_BEETLE:
        m = new Monster(MonsterType.KILLER_BLACK_BEETLE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 4, 5));
        break;
      case RED_MOLD:
        m = new Monster(MonsterType.RED_MOLD);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.FIRE, AttackDescription.TOUCH, 4, 4));
        break;
      case QUYLTHULG:
        m = new Monster(MonsterType.QUYLTHULG);
        m.setBase();
        break;
      case GIANT_RED_BAT:
        m = new Monster(MonsterType.GIANT_RED_BAT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 7));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 3));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 3));
        break;
      case GIANT_BLACK_DRAGON_FLY:
        m = new Monster(MonsterType.GIANT_BLACK_DRAGON_FLY);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.BLINDNESS, AttackDescription.BITE, 1, 6));
        break;
      case CLOUD_GIANT:
        m = new Monster(MonsterType.CLOUD_GIANT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.LIGHTNING, AttackDescription.HIT, 3, 8));
        break;
      case BLACK_DRAGON_BAT:
        m = new Monster(MonsterType.BLACK_DRAGON_BAT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.ACID, AttackDescription.BITE, 1, 3));
        break;
      case BLUE_DRAGON_BAT:
        m = new Monster(MonsterType.BLUE_DRAGON_BAT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.LIGHTNING, AttackDescription.BITE, 1, 3));
        break;
      case MUMMIFIED_ORC:
        m = new Monster(MonsterType.MUMMIFIED_ORC);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 2, 4));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 2, 4));
        break;
      case KILLER_BORING_BEETLE:
        m = new Monster(MonsterType.KILLER_BORING_BEETLE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 4, 5));
        break;
      case KILLER_STAG_BEETLE:
        m = new Monster(MonsterType.KILLER_STAG_BEETLE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 3, 4));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 12));
        break;
      case BLACK_MOLD:
        m = new Monster(MonsterType.BLACK_MOLD);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 4, 3));
        break;
      case IRON_GOLEM:
        m = new Monster(MonsterType.IRON_GOLEM);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 12));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 12));
        break;
      case GIANT_YELLOW_SCORPION:
        m = new Monster(MonsterType.GIANT_YELLOW_SCORPION);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 8));
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.STING, 2, 5));
        break;
      case GREEN_OOZE:
        m = new Monster(MonsterType.GREEN_OOZE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.ACID, AttackDescription.TOUCH, 2, 3));
        break;
      case BLACK_OOZE:
        m = new Monster(MonsterType.BLACK_OOZE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.CORROSION, AttackDescription.TOUCH, 2, 6));
        break;
      case WARRIOR:
        m = new Monster(MonsterType.WARRIOR);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 3, 5));
        break;
      case RED_DRAGON_BAT:
        m = new Monster(MonsterType.RED_DRAGON_BAT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.FIRE, AttackDescription.BITE, 1, 3));
        break;
      case KILLER_BLUE_BEETLE:
        m = new Monster(MonsterType.KILLER_BLUE_BEETLE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 4, 5));
        break;
      case GIANT_SILVER_ANT:
        m = new Monster(MonsterType.GIANT_SILVER_ANT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.ACID, AttackDescription.BITE, 4, 4));
        break;
      case CRIMSON_MOLD:
        m = new Monster(MonsterType.CRIMSON_MOLD);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 3));
        m.attacks.add(new MonsterAttack(AttackType.FEAR, AttackDescription.TOUCH, 0, 0));
        break;
      case FOREST_WIGHT:
        m = new Monster(MonsterType.FOREST_WIGHT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        m.attacks
            .add(new MonsterAttack(AttackType.DRAIN_EXPERIENCE, AttackDescription.TOUCH, 12, 8));
        break;
      case BERZERKER:
        m = new Monster(MonsterType.BERZERKER);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 8));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 8));
        break;
      case MUMMIFIED_HUMAN:
        m = new Monster(MonsterType.MUMMIFIED_HUMAN);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 2, 4));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 2, 4));
        break;
      case BANSHEE:
        m = new Monster(MonsterType.BANSHEE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.FEAR, AttackDescription.WAIL, 0, 0));
        m.attacks
            .add(new MonsterAttack(AttackType.DRAIN_EXPERIENCE, AttackDescription.TOUCH, 14, 8));
        break;
      case GIANT_TROLL:
        m = new Monster(MonsterType.GIANT_TROLL);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 3, 4));
        break;
      case GIANT_BROWN_TICK:
        m = new Monster(MonsterType.GIANT_BROWN_TICK);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.BITE, 1, 10));
        m.attacks.add(new MonsterAttack(AttackType.BLINDNESS, AttackDescription.STING, 1, 1));
        break;
      case KILLER_RED_BEETLE:
        m = new Monster(MonsterType.KILLER_RED_BEETLE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.POISON_STRENGTH, AttackDescription.BITE, 4, 4));
        break;
      case WOODEN_MOLD:
        m = new Monster(MonsterType.WOODEN_MOLD);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.TOUCH, 2, 6));
        break;
      case GIANT_BLUE_DRAGON_FLY:
        m = new Monster(MonsterType.GIANT_BLUE_DRAGON_FLY);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 6));
        break;
      case GIANT_GREY_ANT_LION:
        m = new Monster(MonsterType.GIANT_GREY_ANT_LION);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 2, 12));
        break;
      case DISENCHANTER_BAT:
        m = new Monster(MonsterType.DISENCHANTER_BAT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.DISENCHANT, AttackDescription.HIT, 0, 0));
        break;
      case GIANT_FIRE_TICK:
        m = new Monster(MonsterType.GIANT_FIRE_TICK);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.FIRE, AttackDescription.SPIT, 3, 7));
        break;
      case WHITE_WRAITH:
        m = new Monster(MonsterType.WHITE_WRAITH);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        m.attacks
            .add(new MonsterAttack(AttackType.DRAIN_EXPERIENCE, AttackDescription.TOUCH, 15, 8));
        break;
      case GIANT_BLACK_SCORPION:
        m = new Monster(MonsterType.GIANT_BLACK_SCORPION);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 10));
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.STING, 2, 5));
        break;
      case CLEAR_OOZE:
        m = new Monster(MonsterType.CLEAR_OOZE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.CONFUSION, AttackDescription.TOUCH, 1, 8));
        break;
      case KILLER_FIRE_BEETLE:
        m = new Monster(MonsterType.KILLER_FIRE_BEETLE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 3, 4));
        m.attacks.add(new MonsterAttack(AttackType.FIRE, AttackDescription.SPIT, 4, 5));
        break;
      case VAMPIRE:
        m = new Monster(MonsterType.VAMPIRE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        m.attacks
            .add(new MonsterAttack(AttackType.DRAIN_EXPERIENCE, AttackDescription.TOUCH, 18, 8));
        break;
      case GIANT_RED_DRAGON_FLY:
        m = new Monster(MonsterType.GIANT_RED_DRAGON_FLY);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.FEAR, AttackDescription.BITE, 1, 6));
        break;
      case SHIMMERING_MOLD:
        m = new Monster(MonsterType.SHIMMERING_MOLD);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.LIGHTNING, AttackDescription.TOUCH, 5, 4));
        break;
      case BLACK_KNIGHT:
        m = new Monster(MonsterType.BLACK_KNIGHT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 5, 5));
        break;
      case MAGE:
        m = new Monster(MonsterType.MAGE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 2, 5));
        break;
      case ICE_TROLL:
        m = new Monster(MonsterType.ICE_TROLL);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 5));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 5));
        m.attacks.add(new MonsterAttack(AttackType.COLD, AttackDescription.BITE, 3, 6));
        break;
      case GIANT_PURPLE_WORM:
        m = new Monster(MonsterType.GIANT_PURPLE_WORM);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 8));
        m.attacks.add(new MonsterAttack(AttackType.ACID, AttackDescription.BITE, 2, 8));
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.STING, 1, 8));
        break;
      case YOUNG_BLUE_DRAGON:
        m = new Monster(MonsterType.YOUNG_BLUE_DRAGON);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 4));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 4));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 6));
        break;
      case YOUNG_WHITE_DRAGON:
        m = new Monster(MonsterType.YOUNG_WHITE_DRAGON);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 4));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 4));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 6));
        break;
      case YOUNG_GREEN_DRAGON:
        m = new Monster(MonsterType.YOUNG_GREEN_DRAGON);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 4));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 4));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 6));
        break;
      case GIANT_FIRE_BAT:
        m = new Monster(MonsterType.GIANT_FIRE_BAT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.FIRE, AttackDescription.BITE, 3, 6));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 4));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 4));
        break;
      case GIANT_GLOWING_RAT:
        m = new Monster(MonsterType.GIANT_GLOWING_RAT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.LIGHTNING, AttackDescription.BITE, 2, 6));
        break;
      case SKELETON_TROLL:
        m = new Monster(MonsterType.SKELETON_TROLL);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 3, 4));
        break;
      case GIANT_LIGHTNING_BAT:
        m = new Monster(MonsterType.GIANT_LIGHTNING_BAT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.LIGHTNING, AttackDescription.BITE, 3, 8));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 5));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 5));
        break;
      case GIANT_STATIC_ANT:
        m = new Monster(MonsterType.GIANT_STATIC_ANT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.LIGHTNING, AttackDescription.BITE, 5, 5));
        break;
      case GRAVE_WIGHT:
        m = new Monster(MonsterType.GRAVE_WIGHT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 7));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 7));
        m.attacks
            .add(new MonsterAttack(AttackType.DRAIN_EXPERIENCE, AttackDescription.TOUCH, 20, 8));
        break;
      case KILLER_SLICER_BEETLE:
        m = new Monster(MonsterType.KILLER_SLICER_BEETLE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 5, 8));
        break;
      case GIANT_WHITE_ANT_LION:
        m = new Monster(MonsterType.GIANT_WHITE_ANT_LION);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.COLD, AttackDescription.BITE, 3, 10));
        break;
      case GHOST:
        m = new Monster(MonsterType.GHOST);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.FEAR, AttackDescription.WAIL, 0, 0));
        m.attacks
            .add(new MonsterAttack(AttackType.DRAIN_EXPERIENCE, AttackDescription.TOUCH, 22, 8));
        m.attacks
            .add(new MonsterAttack(AttackType.DRAIN_INTELLIGENCE, AttackDescription.CLAW, 1, 10));
        break;
      case GIANT_BLACK_ANT_LION:
        m = new Monster(MonsterType.GIANT_BLACK_ANT_LION);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 2, 12));
        m.attacks.add(new MonsterAttack(AttackType.ACID, AttackDescription.SPIT, 3, 6));
        break;
      case DEATH_WATCH_BEETLE:
        m = new Monster(MonsterType.DEATH_WATCH_BEETLE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 5, 4));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.WAIL, 5, 6));
        break;
      case OGRE_MAGE:
        m = new Monster(MonsterType.OGRE_MAGE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 3, 6));
        break;
      case TWO_HEADED_TROLL:
        m = new Monster(MonsterType.TWO_HEADED_TROLL);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 8));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 8));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 6));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 6));
        break;
      case INVISIBLE_STALKER:
        m = new Monster(MonsterType.INVISIBLE_STALKER);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        break;
      case GIANT_HUNTER_ANT:
        m = new Monster(MonsterType.GIANT_HUNTER_ANT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 4, 8));
        break;
      case NINJA:
        m = new Monster(MonsterType.NINJA);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.HIT, 3, 4));
        m.attacks.add(new MonsterAttack(AttackType.POISON_STRENGTH, AttackDescription.HIT, 3, 4));
        break;
      case BARROW_WIGHT:
        m = new Monster(MonsterType.BARROW_WIGHT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 8));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 8));
        m.attacks
            .add(new MonsterAttack(AttackType.DRAIN_EXPERIENCE, AttackDescription.TOUCH, 26, 8));
        break;
      case SKELETON_2_HEADED_TROLL:
        m = new Monster(MonsterType.SKELETON_2_HEADED_TROLL);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 9));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 9));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 5));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 5));
        break;
      case WATER_ELEMENTAL:
        m = new Monster(MonsterType.WATER_ELEMENTAL);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 10));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 10));
        break;
      case FIRE_ELEMENTAL:
        m = new Monster(MonsterType.FIRE_ELEMENTAL);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.FIRE, AttackDescription.HIT, 4, 6));
        break;
      case LICH:
        m = new Monster(MonsterType.LICH);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.DRAIN_DEXTERITY, AttackDescription.TOUCH, 2, 8));
        m.attacks
            .add(new MonsterAttack(AttackType.DRAIN_EXPERIENCE, AttackDescription.TOUCH, 30, 8));
        m.attacks.add(new MonsterAttack(AttackType.EAT_CHARGES, AttackDescription.TOUCH, 0, 0));
        break;
      case MASTER_VAMPIRE:
        m = new Monster(MonsterType.MASTER_VAMPIRE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        m.attacks
            .add(new MonsterAttack(AttackType.DRAIN_EXPERIENCE, AttackDescription.TOUCH, 32, 8));
        break;
      case SPIRIT_TROLL:
        m = new Monster(MonsterType.SPIRIT_TROLL);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 5));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 5));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 6));
        m.attacks.add(new MonsterAttack(AttackType.DRAIN_WISDOM, AttackDescription.TOUCH, 0, 0));
        break;
      case GIANT_RED_SCORPION:
        m = new Monster(MonsterType.GIANT_RED_SCORPION);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 6));
        m.attacks.add(new MonsterAttack(AttackType.POISON, AttackDescription.STING, 1, 4));
        break;
      case EARTH_ELEMENTAL:
        m = new Monster(MonsterType.EARTH_ELEMENTAL);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 4, 6));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 4, 6));
        break;
      case YOUNG_BLACK_DRAGON:
        m = new Monster(MonsterType.YOUNG_BLACK_DRAGON);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 5));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 5));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 6));
        break;
      case YOUNG_RED_DRAGON:
        m = new Monster(MonsterType.YOUNG_RED_DRAGON);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 8));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 8));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 2, 8));
        break;
      case NECROMANCER:
        m = new Monster(MonsterType.NECROMANCER);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 2, 6));
        break;
      case MUMMIFIED_TROLL:
        m = new Monster(MonsterType.MUMMIFIED_TROLL);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 2, 6));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 2, 6));
        break;
      case GIANT_RED_ANT_LION:
        m = new Monster(MonsterType.GIANT_RED_ANT_LION);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.FIRE, AttackDescription.BITE, 3, 12));
        break;
      case MATURE_WHITE_DRAGON:
        m = new Monster(MonsterType.MATURE_WHITE_DRAGON);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 8));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 8));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 2, 8));
        break;
      case XORN:
        m = new Monster(MonsterType.XORN);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        break;
      case GIANT_MOTTLED_ANT_LION:
        m = new Monster(MonsterType.GIANT_MOTTLED_ANT_LION);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 2, 10));
        break;
      case GREY_WRAITH:
        m = new Monster(MonsterType.GREY_WRAITH);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 10));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 10));
        m.attacks
            .add(new MonsterAttack(AttackType.DRAIN_EXPERIENCE, AttackDescription.TOUCH, 34, 8));
        break;
      case YOUNG_MULTI_HUED_DRAGON:
        m = new Monster(MonsterType.YOUNG_MULTI_HUED_DRAGON);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 9));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 9));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 2, 10));
        break;
      case MATURE_BLUE_DRAGON:
        m = new Monster(MonsterType.MATURE_BLUE_DRAGON);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 8));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 8));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 2, 10));
        break;
      case MATURE_GREEN_DRAGON:
        m = new Monster(MonsterType.MATURE_GREEN_DRAGON);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 4));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 4));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 1, 6));
        break;
      case IRIDESCENT_BEETLE:
        m = new Monster(MonsterType.IRIDESCENT_BEETLE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 4, 6));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 12));
        m.attacks.add(new MonsterAttack(AttackType.PARALYSIS, AttackDescription.GAZE, 0, 0));
        break;
      case KING_VAMPIRE:
        m = new Monster(MonsterType.KING_VAMPIRE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 6));
        m.attacks
            .add(new MonsterAttack(AttackType.DRAIN_EXPERIENCE, AttackDescription.TOUCH, 38, 8));
        break;
      case KING_LICH:
        m = new Monster(MonsterType.KING_LICH);
        m.setBase();
        m.attacks
            .add(new MonsterAttack(AttackType.DRAIN_DEXTERITY, AttackDescription.TOUCH, 2, 10));
        m.attacks
            .add(new MonsterAttack(AttackType.DRAIN_EXPERIENCE, AttackDescription.TOUCH, 36, 8));
        m.attacks.add(new MonsterAttack(AttackType.EAT_CHARGES, AttackDescription.TOUCH, 0, 0));
        break;
      case MATURE_RED_DRAGON:
        m = new Monster(MonsterType.MATURE_RED_DRAGON);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 10));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 10));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 2, 12));
        break;
      case MATURE_BLACK_DRAGON:
        m = new Monster(MonsterType.MATURE_BLACK_DRAGON);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 8));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 8));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 2, 10));
        break;
      case MATURE_MULTI_HUED_DRAGON:
        m = new Monster(MonsterType.MATURE_MULTI_HUED_DRAGON);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 10));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 10));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 2, 12));
        break;
      case ANCIENT_WHITE_DRAGON:
        m = new Monster(MonsterType.ANCIENT_WHITE_DRAGON);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 8));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 8));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 2, 8));
        break;
      case EMPEROR_WIGHT:
        m = new Monster(MonsterType.EMPEROR_WIGHT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 12));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 12));
        m.attacks
            .add(new MonsterAttack(AttackType.DRAIN_EXPERIENCE, AttackDescription.TOUCH, 42, 8));
        break;
      case BLACK_WRAITH:
        m = new Monster(MonsterType.BLACK_WRAITH);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 12));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 12));
        m.attacks
            .add(new MonsterAttack(AttackType.DRAIN_EXPERIENCE, AttackDescription.TOUCH, 44, 8));
        break;
      case NETHER_WRAITH:
        m = new Monster(MonsterType.NETHER_WRAITH);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 12));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 1, 12));
        m.attacks
            .add(new MonsterAttack(AttackType.DRAIN_EXPERIENCE, AttackDescription.TOUCH, 52, 8));
        break;
      case SORCERER:
        m = new Monster(MonsterType.SORCERER);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.HIT, 2, 8));
        break;
      case ANCIENT_BLUE_DRAGON:
        m = new Monster(MonsterType.ANCIENT_BLUE_DRAGON);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 9));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 9));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 2, 12));
        break;
      case ANCIENT_GREEN_DRAGON:
        m = new Monster(MonsterType.ANCIENT_GREEN_DRAGON);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 8));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 8));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 2, 10));
        break;
      case ANCIENT_BLACK_DRAGON:
        m = new Monster(MonsterType.ANCIENT_BLACK_DRAGON);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 9));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 9));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 2, 10));
        break;
      case CRYSTAL_OOZE:
        m = new Monster(MonsterType.CRYSTAL_OOZE);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.COLD, AttackDescription.TOUCH, 4, 4));
        break;
      case DISENCHANTER_WORM:
        m = new Monster(MonsterType.DISENCHANTER_WORM);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.DISENCHANT, AttackDescription.CRAWL, 1, 4));
        break;
      case ROTTING_QUYLTHULG:
        m = new Monster(MonsterType.ROTTING_QUYLTHULG);
        m.setBase();
        break;
      case ANCIENT_RED_DRAGON:
        m = new Monster(MonsterType.ANCIENT_RED_DRAGON);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 10));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 10));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 2, 14));
        break;
      case DEATH_QUASIT:
        m = new Monster(MonsterType.DEATH_QUASIT);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.DRAIN_DEXTERITY, AttackDescription.BITE, 3, 6));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 3, 3));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 3, 3));
        break;
      case EMPEROR_LICH:
        m = new Monster(MonsterType.EMPEROR_LICH);
        m.setBase();
        m.attacks
            .add(new MonsterAttack(AttackType.DRAIN_DEXTERITY, AttackDescription.TOUCH, 2, 12));
        m.attacks
            .add(new MonsterAttack(AttackType.DRAIN_EXPERIENCE, AttackDescription.TOUCH, 46, 8));
        m.attacks.add(new MonsterAttack(AttackType.EAT_CHARGES, AttackDescription.TOUCH, 0, 0));
        break;
      case ANCIENT_MULTI_HUED_DRAGON:
        m = new Monster(MonsterType.ANCIENT_MULTI_HUED_DRAGON);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 12));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.CLAW, 1, 12));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.BITE, 3, 12));
        break;
      case EVIL_IGGY:
        m = new Monster(MonsterType.EVIL_IGGY);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.POISON_STRENGTH, AttackDescription.HIT, 4, 6));
        m.attacks.add(new MonsterAttack(AttackType.STEAL_OBJECT, AttackDescription.HIT, 0, 0));
        break;
      case BALROG:
        m = new Monster(MonsterType.BALROG);
        m.setBase();
        m.attacks.add(new MonsterAttack(AttackType.FIRE, AttackDescription.HIT, 10, 12));
        m.attacks.add(new MonsterAttack(AttackType.NORMAL, AttackDescription.TRAMPLE, 8, 12));
        m.attacks.add(new MonsterAttack(AttackType.EAT_CHARGES, AttackDescription.TOUCH, 0, 0));
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + monsterType);
    }
    return m;
  }

}
