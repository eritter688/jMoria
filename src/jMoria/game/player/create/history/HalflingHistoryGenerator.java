package jMoria.game.player.create.history;

import java.util.ArrayList;
import java.util.List;

public class HalflingHistoryGenerator extends AbstractHistoryGenerator {

  public List<HistoryObject> ancestry_one = new ArrayList<>();
  public List<HistoryObject> ancestry_two = new ArrayList<>();
  public List<HistoryObject> ancestry_three = new ArrayList<>();
  public List<HistoryObject> eyes = new ArrayList<>();
  public List<HistoryObject> hair_one = new ArrayList<>();
  public List<HistoryObject> hair_two = new ArrayList<>();
  public List<HistoryObject> complexion = new ArrayList<>();

  public HalflingHistoryGenerator() {

    ancestry_one.add(new HistoryObject("You are one of several children of a Halfling ", 45));
    ancestry_one.add(new HistoryObject("You are the only child of a Halfling ", 55));

    ancestry_two.add(new HistoryObject("Bum.  ", 55));
    ancestry_two.add(new HistoryObject("Tavern Owner.  ", 80));
    ancestry_two.add(new HistoryObject("Miller.  ", 90));
    ancestry_two.add(new HistoryObject("Home Owner.  ", 100));
    ancestry_two.add(new HistoryObject("Burglar.  ", 110));
    ancestry_two.add(new HistoryObject("Warrior.  ", 115));
    ancestry_two.add(new HistoryObject("Mage.  ", 125));
    ancestry_two.add(new HistoryObject("Clan Elder.  ", 140));

    ancestry_three.add(new HistoryObject("You are the black sheep of the family.  ", 20));
    ancestry_three.add(new HistoryObject("You are a credit to the family.  ", 55));
    ancestry_three.add(new HistoryObject("You are a well liked child.  ", 60));

    eyes.add(new HistoryObject("You have dark brown eyes, ", 50));
    eyes.add(new HistoryObject("You have brown eyes, ", 50));
    eyes.add(new HistoryObject("You have hazel eyes, ", 50));
    eyes.add(new HistoryObject("You have green eyes, ", 50));
    eyes.add(new HistoryObject("You have blue eyes, ", 50));
    eyes.add(new HistoryObject("You have blue-gray eyes, ", 50));

    hair_one.add(new HistoryObject("straight ", 50));
    hair_one.add(new HistoryObject("wavy ", 50));
    hair_one.add(new HistoryObject("curly ", 50));

    hair_two.add(new HistoryObject("black hair, ", 50));
    hair_two.add(new HistoryObject("brown hair, ", 50));
    hair_two.add(new HistoryObject("auburn hair, ", 50));
    hair_two.add(new HistoryObject("red hair, ", 50));
    hair_two.add(new HistoryObject("blond hair, ", 50));

    complexion.add(new HistoryObject("and a very dark complexion.", 50));
    complexion.add(new HistoryObject("and a dark complexion.", 50));
    complexion.add(new HistoryObject("and an average complexion.", 50));
    complexion.add(new HistoryObject("and a fair complexion.", 50));
    complexion.add(new HistoryObject("and a very fair complexion.", 50));

    historyList.add(ancestry_one);
    historyList.add(ancestry_two);
    historyList.add(ancestry_three);
    historyList.add(eyes);
    historyList.add(hair_one);
    historyList.add(hair_two);
    historyList.add(complexion);

  }

}
