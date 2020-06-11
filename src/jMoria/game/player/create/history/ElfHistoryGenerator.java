package jMoria.game.player.create.history;

import java.util.ArrayList;
import java.util.List;

public class ElfHistoryGenerator extends AbstractHistoryGenerator {

  public List<HistoryObject> ancestry_one = new ArrayList<>();
  public List<HistoryObject> ancestry_two = new ArrayList<>();
  public List<HistoryObject> ancestry_three = new ArrayList<>();
  public List<HistoryObject> eyes = new ArrayList<>();
  public List<HistoryObject> hair_one = new ArrayList<>();
  public List<HistoryObject> hair_two = new ArrayList<>();
  public List<HistoryObject> complexion = new ArrayList<>();

  public ElfHistoryGenerator() {

    ancestry_one.add(new HistoryObject("You are one of several children ", 50));
    ancestry_one.add(new HistoryObject("You are the only child ", 55));
    historyList.add(ancestry_one);

    ancestry_two.add(new HistoryObject("of a Green-Elf ", 50));
    ancestry_two.add(new HistoryObject("of a Grey-Elf ", 55));
    ancestry_two.add(new HistoryObject("of a High-Elf ", 60));
    historyList.add(ancestry_two);

    ancestry_three.add(new HistoryObject("Ranger.  ", 80));
    ancestry_three.add(new HistoryObject("Archer.  ", 90));
    ancestry_three.add(new HistoryObject("Warrior.  ", 110));
    ancestry_three.add(new HistoryObject("Mage.  ", 125));
    ancestry_three.add(new HistoryObject("Prince.  ", 140));
    ancestry_three.add(new HistoryObject("King.  ", 145));
    historyList.add(ancestry_three);

    eyes.add(new HistoryObject("You have light grey eyes, ", 50));
    eyes.add(new HistoryObject("You have light blue eyes, ", 50));
    eyes.add(new HistoryObject("You have light green eyes, ", 50));
    historyList.add(eyes);

    hair_one.add(new HistoryObject("straight ", 50));
    hair_one.add(new HistoryObject("wavy ", 50));
    historyList.add(hair_one);

    hair_two.add(new HistoryObject("black hair, ", 50));
    hair_two.add(new HistoryObject("brown hair, ", 50));
    hair_two.add(new HistoryObject("blond hair, ", 50));
    hair_two.add(new HistoryObject("silver hair, ", 50));
    historyList.add(hair_two);

    complexion.add(new HistoryObject("and a fair complexion.", 50));
    historyList.add(complexion);

  }

}
