package jMoria.game.player.create.history;

import jMoria.game.player.Player;
import jMoria.game.player.enums.Race;
import jMoria.game.utils.Dice;

public class PlayerHistoryGenerator {

  private static class HistoryObject {

    public String text;
    public int roll;
    public int chart;
    public int next;
    public int bonus;

    public HistoryObject(String text, int roll, int chart, int next, int bonus) {
      this.text = text;
      this.roll = roll;
      this.chart = chart;
      this.next = next;
      this.bonus = bonus;
    }
  }

  private final HistoryObject[] hTable = new HistoryObject[128];
  private final Player player;

  public PlayerHistoryGenerator(Player p) {
    this.player = p;
    int i = -1;
    hTable[++i] = new HistoryObject("You are the illegitimate and unacknowledged child ",
        10, 1, 2, 25);
    hTable[++i] = new HistoryObject("You are the illegitimate but acknowledged child ",
        20, 1, 2, 35);
    hTable[++i] = new HistoryObject("You are one of several children ",
        95, 1, 2, 45);
    hTable[++i] = new HistoryObject("You are the first child ",
        100, 1, 2, 50);
    hTable[++i] = new HistoryObject("of a Serf.  ",
        40, 2, 3, 65);
    hTable[++i] = new HistoryObject("of a Yeoman.  ",
        65, 2, 3, 80);
    hTable[++i] = new HistoryObject("of a Townsman.  ",
        80, 2, 3, 90);
    hTable[++i] = new HistoryObject("of a Guildsman.  ",
        90, 2, 3, 105);
    hTable[++i] = new HistoryObject("of a Landed Knight.  ",
        96, 2, 3, 120);
    hTable[++i] = new HistoryObject("of a Titled Noble.  ",
        99, 2, 3, 130);
    hTable[++i] = new HistoryObject("of a Royal Blood Line.  ",
        100, 2, 3, 140);
    hTable[++i] = new HistoryObject("You are the black sheep of the family.  ",
        20, 3, 50, 20);
    hTable[++i] = new HistoryObject("You are a credit to the family.  ",
        80, 3, 50, 55);
    hTable[++i] = new HistoryObject("You are a well liked child.  ",
        100, 3, 50, 60);
    hTable[++i] = new HistoryObject("Your mother was a Green-Elf.  ",
        40, 4, 1, 50);
    hTable[++i] = new HistoryObject("Your father was a Green-Elf.  ",
        75, 4, 1, 55);
    hTable[++i] = new HistoryObject("Your mother was a Grey-Elf.  ",
        90, 4, 1, 55);
    hTable[++i] = new HistoryObject("Your father was a Grey-Elf.  ",
        95, 4, 1, 60);
    hTable[++i] = new HistoryObject("Your mother was a High-Elf.  ",
        98, 4, 1, 65);
    hTable[++i] = new HistoryObject("Your father was a High-Elf.  ",
        100, 4, 1, 70);
    hTable[++i] = new HistoryObject("You are one of several children ",
        60, 7, 8, 50);
    hTable[++i] = new HistoryObject("You are the only child ",
        100, 7, 8, 55);
    hTable[++i] = new HistoryObject("of a Green-Elf ",
        75, 8, 9, 50);
    hTable[++i] = new HistoryObject("of a Grey-Elf ",
        95, 8, 9, 55);
    hTable[++i] = new HistoryObject("of a High-Elf ",
        100, 8, 9, 60);
    hTable[++i] = new HistoryObject("Ranger.  ",
        40, 9, 54, 80);
    hTable[++i] = new HistoryObject("Archer.  ",
        70, 9, 54, 90);
    hTable[++i] = new HistoryObject("Warrior.  ",
        87, 9, 54, 110);
    hTable[++i] = new HistoryObject("Mage.  ",
        95, 9, 54, 125);
    hTable[++i] = new HistoryObject("Prince.  ",
        99, 9, 54, 140);
    hTable[++i] = new HistoryObject("King.  ",
        100, 9, 54, 145);
    hTable[++i] = new HistoryObject("You are one of several children of a Halfling ",
        85, 10, 11, 45);
    hTable[++i] = new HistoryObject("You are the only child of a Halfling ",
        100, 10, 11, 55);
    hTable[++i] = new HistoryObject("Bum.  ",
        20, 11, 3, 55);
    hTable[++i] = new HistoryObject("Tavern Owner.  ",
        30, 11, 3, 80);
    hTable[++i] = new HistoryObject("Miller.  ",
        40, 11, 3, 90);
    hTable[++i] = new HistoryObject("Home Owner.  ",
        50, 11, 3, 100);
    hTable[++i] = new HistoryObject("Burglar.  ",
        80, 11, 3, 110);
    hTable[++i] = new HistoryObject("Warrior.  ",
        95, 11, 3, 115);
    hTable[++i] = new HistoryObject("Mage.  ",
        99, 11, 3, 125);
    hTable[++i] = new HistoryObject("Clan Elder.  ",
        100, 11, 3, 140);
    hTable[++i] = new HistoryObject("You are one of several children of a Gnome ",
        85, 13, 14, 45);
    hTable[++i] = new HistoryObject("You are the only child of a Gnome ",
        100, 13, 14, 55);
    hTable[++i] = new HistoryObject("Beggar.  ",
        20, 14, 3, 55);
    hTable[++i] = new HistoryObject("Braggart.  ",
        50, 14, 3, 70);
    hTable[++i] = new HistoryObject("Prankster.  ",
        75, 14, 3, 85);
    hTable[++i] = new HistoryObject("Warrior.  ",
        95, 14, 3, 100);
    hTable[++i] = new HistoryObject("Mage.  ",
        100, 14, 3, 125);
    hTable[++i] = new HistoryObject("You are one of two children of a Dwarven ",
        25, 16, 17, 40);
    hTable[++i] = new HistoryObject("You are the only child of a Dwarven ",
        100, 16, 17, 50);
    hTable[++i] = new HistoryObject("Thief.  ",
        10, 17, 18, 60);
    hTable[++i] = new HistoryObject("Prison Guard.  ",
        25, 17, 18, 75);
    hTable[++i] = new HistoryObject("Miner.  ",
        75, 17, 18, 90);
    hTable[++i] = new HistoryObject("Warrior.  ",
        90, 17, 18, 110);
    hTable[++i] = new HistoryObject("Priest.  ",
        99, 17, 18, 130);
    hTable[++i] = new HistoryObject("King.  ",
        100, 17, 18, 150);
    hTable[++i] = new HistoryObject("You are the black sheep of the family.  ",
        15, 18, 57, 10);
    hTable[++i] = new HistoryObject("You are a credit to the family.  ",
        85, 18, 57, 50);
    hTable[++i] = new HistoryObject("You are a well liked child.  ",
        100, 18, 57, 55);
    hTable[++i] = new HistoryObject("Your mother was an Orc, but it is unacknowledged.  ",
        25, 19, 20, 25);
    hTable[++i] = new HistoryObject("Your father was an Orc, but it is unacknowledged.  ",
        100, 19, 20, 25);
    hTable[++i] = new HistoryObject("You are the adopted child ",
        100, 20, 2, 50);
    hTable[++i] = new HistoryObject("Your mother was a Cave-Troll ",
        30, 22, 23, 20);
    hTable[++i] = new HistoryObject("Your father was a Cave-Troll ",
        60, 22, 23, 25);
    hTable[++i] = new HistoryObject("Your mother was a Hill-Troll ",
        75, 22, 23, 30);
    hTable[++i] = new HistoryObject("Your father was a Hill-Troll ",
        90, 22, 23, 35);
    hTable[++i] = new HistoryObject("Your mother was a Water-Troll ",
        95, 22, 23, 40);
    hTable[++i] = new HistoryObject("Your father was a Water-Troll ",
        100, 22, 23, 45);
    hTable[++i] = new HistoryObject("Cook.  ",
        5, 23, 62, 60);
    hTable[++i] = new HistoryObject("Warrior.  ",
        95, 23, 62, 55);
    hTable[++i] = new HistoryObject("Shaman.  ",
        99, 23, 62, 65);
    hTable[++i] = new HistoryObject("Clan Chief.  ",
        100, 23, 62, 80);
    hTable[++i] = new HistoryObject("You have dark brown eyes, ",
        20, 50, 51, 50);
    hTable[++i] = new HistoryObject("You have brown eyes, ",
        60, 50, 51, 50);
    hTable[++i] = new HistoryObject("You have hazel eyes, ",
        70, 50, 51, 50);
    hTable[++i] = new HistoryObject("You have green eyes, ",
        80, 50, 51, 50);
    hTable[++i] = new HistoryObject("You have blue eyes, ",
        90, 50, 51, 50);
    hTable[++i] = new HistoryObject("You have blue-gray eyes, ",
        100, 50, 51, 50);
    hTable[++i] = new HistoryObject("straight ",
        70, 51, 52, 50);
    hTable[++i] = new HistoryObject("wavy ",
        90, 51, 52, 50);
    hTable[++i] = new HistoryObject("curly ",
        100, 51, 52, 50);
    hTable[++i] = new HistoryObject("black hair, ",
        30, 52, 53, 50);
    hTable[++i] = new HistoryObject("brown hair, ",
        70, 52, 53, 50);
    hTable[++i] = new HistoryObject("auburn hair, ",
        80, 52, 53, 50);
    hTable[++i] = new HistoryObject("red hair, ",
        90, 52, 53, 50);
    hTable[++i] = new HistoryObject("blond hair, ",
        100, 52, 53, 50);
    hTable[++i] = new HistoryObject("and a very dark complexion.",
        10, 53, 0, 50);
    hTable[++i] = new HistoryObject("and a dark complexion.",
        30, 53, 0, 50);
    hTable[++i] = new HistoryObject("and an average complexion.",
        80, 53, 0, 50);
    hTable[++i] = new HistoryObject("and a fair complexion.",
        90, 53, 0, 50);
    hTable[++i] = new HistoryObject("and a very fair complexion.",
        100, 53, 0, 50);
    hTable[++i] = new HistoryObject("You have light grey eyes, ",
        85, 54, 55, 50);
    hTable[++i] = new HistoryObject("You have light blue eyes, ",
        95, 54, 55, 50);
    hTable[++i] = new HistoryObject("You have light green eyes, ",
        100, 54, 55, 50);
    hTable[++i] = new HistoryObject("straight ",
        75, 55, 56, 50);
    hTable[++i] = new HistoryObject("wavy ",
        100, 55, 56, 50);
    hTable[++i] = new HistoryObject("black hair, and a fair complexion.",
        75, 56, 0, 50);
    hTable[++i] = new HistoryObject("brown hair, and a fair complexion.",
        85, 56, 0, 50);
    hTable[++i] = new HistoryObject("blond hair, and a fair complexion.",
        95, 56, 0, 50);
    hTable[++i] = new HistoryObject("silver hair, and a fair complexion.",
        100, 56, 0, 50);
    hTable[++i] = new HistoryObject("You have dark brown eyes, ",
        99, 57, 58, 50);
    hTable[++i] = new HistoryObject("You have glowing red eyes, ",
        100, 57, 58, 60);
    hTable[++i] = new HistoryObject("straight ",
        90, 58, 59, 50);
    hTable[++i] = new HistoryObject("wavy ",
        100, 58, 59, 50);
    hTable[++i] = new HistoryObject("black hair, ",
        75, 59, 60, 50);
    hTable[++i] = new HistoryObject("brown hair, ",
        100, 59, 60, 50);
    hTable[++i] = new HistoryObject("a one foot beard, ",
        25, 60, 61, 50);
    hTable[++i] = new HistoryObject("a two foot beard, ",
        60, 60, 61, 51);
    hTable[++i] = new HistoryObject("a three foot beard, ",
        90, 60, 61, 53);
    hTable[++i] = new HistoryObject("a four foot beard, ",
        100, 60, 61, 55);
    hTable[++i] = new HistoryObject("and a dark complexion.",
        100, 61, 0, 50);
    hTable[++i] = new HistoryObject("You have slime green eyes, ",
        60, 62, 63, 50);
    hTable[++i] = new HistoryObject("You have puke yellow eyes, ",
        85, 62, 63, 50);
    hTable[++i] = new HistoryObject("You have blue-bloodshot eyes, ",
        99, 62, 63, 50);
    hTable[++i] = new HistoryObject("You have glowing red eyes, ",
        100, 62, 63, 55);
    hTable[++i] = new HistoryObject("dirty ",
        33, 63, 64, 50);
    hTable[++i] = new HistoryObject("mangy ",
        66, 63, 64, 50);
    hTable[++i] = new HistoryObject("oily ",
        100, 63, 64, 50);
    hTable[++i] = new HistoryObject("sea-weed green hair, ",
        33, 64, 65, 50);
    hTable[++i] = new HistoryObject("bright red hair, ",
        66, 64, 65, 50);
    hTable[++i] = new HistoryObject("dark purple hair, ",
        100, 64, 65, 50);
    hTable[++i] = new HistoryObject("and green ",
        25, 65, 66, 50);
    hTable[++i] = new HistoryObject("and blue ",
        50, 65, 66, 50);
    hTable[++i] = new HistoryObject("and white ",
        75, 65, 66, 50);
    hTable[++i] = new HistoryObject("and black ",
        100, 65, 66, 50);
    hTable[++i] = new HistoryObject("ulcerous skin.",
        33, 66, 0, 50);
    hTable[++i] = new HistoryObject("scabby skin.",
        66, 66, 0, 50);
    hTable[++i] = new HistoryObject("leprous skin.",
        100, 66, 0, 50);

    System.out.println(String.format("Human: %d", Race.HUMAN.ordinal() * 3 + 1));
    System.out.println(String.format("Half-Elf: %d", Race.HALF_ELF.ordinal() * 3 + 1));
    System.out.println(String.format("Elf: %d", Race.ELF.ordinal() * 3 + 1));
    System.out.println(String.format("Halfling: %d", Race.HALFLING.ordinal() * 3 + 1));
    System.out.println(String.format("Gnome: %d", Race.GNOME.ordinal() * 3 + 1));
    System.out.println(String.format("Dwarf: %d", Race.DWARF.ordinal() * 3 + 1));
    System.out.println(String.format("Half Orc: %d", Race.HALF_ORC.ordinal() * 3 + 1));
    System.out.println(String.format("Half Troll: %d", Race.HALF_TROLL.ordinal() * 3 + 1));
    for (i = 0; i < hTable.length; i++) {
      System.out.println(i + "=" + hTable[i].text + " | " + hTable[i].next);
    }
  }

  public void generateHistory() {
    StringBuilder historyBuilder = new StringBuilder();
    int socialClass = new Dice(1, 4).roll();
    boolean flag = false;
    int historyPointer = 0;
    int currentPointer = 0;

    historyPointer = player.race.ordinal() * 3 + 1;

    do {
      flag = false;
      do {
        if (hTable[currentPointer].chart == historyPointer) {
          int testRoll = new Dice(1, 100).roll();
          while (testRoll > hTable[currentPointer].roll) {
            currentPointer++;
          }
          historyBuilder.append(hTable[currentPointer].text);
          socialClass += hTable[currentPointer].bonus - 50;
          if (historyPointer > hTable[currentPointer].next) {
            currentPointer = 0;
          }
          historyPointer = hTable[currentPointer].next;
          flag = true;
        } else {
          currentPointer++;
        }
      } while (!flag);
    } while(historyPointer >= 1);
    player.characterBackground = historyBuilder.toString();

    // Clip social class and assign to the player.
    if (socialClass > 100) {
      socialClass = 100;
    } else if (socialClass < 1) {
      socialClass = 1;
    }
    player.socialClass = socialClass;
  }

}

