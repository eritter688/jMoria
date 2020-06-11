package jMoria.game.player.create.history;

import java.util.ArrayList;
import java.util.List;

public class HalfTrollHistoryGenerator extends AbstractHistoryGenerator {

  public List<HistoryObject> ancestry_one = new ArrayList<>();
  public List<HistoryObject> ancestry_two = new ArrayList<>();
  public List<HistoryObject> family_status = new ArrayList<>();
  public List<HistoryObject> eyes = new ArrayList<>();
  public List<HistoryObject> hair_one = new ArrayList<>();
  public List<HistoryObject> hair_two = new ArrayList<>();
  public List<HistoryObject> complexion_one = new ArrayList<>();
  public List<HistoryObject> complexion_two = new ArrayList<>();

  public HalfTrollHistoryGenerator() {

    ancestry_one.add(new HistoryObject("Your mother was a Cave-Troll ", 20));
    ancestry_one.add(new HistoryObject("Your father was a Cave-Troll ", 25));
    ancestry_one.add(new HistoryObject("Your mother was a Hill-Troll ", 30));
    ancestry_one.add(new HistoryObject("Your father was a Hill-Troll ", 35));
    ancestry_one.add(new HistoryObject("Your mother was a Water-Troll ", 40));
    ancestry_one.add(new HistoryObject("Your father was a Water-Troll ", 45));
    historyList.add(ancestry_one);

    ancestry_two.add(new HistoryObject("Cook.  ", 60));
    ancestry_two.add(new HistoryObject("Warrior.  ", 55));
    ancestry_two.add(new HistoryObject("Shaman.  ", 65));
    ancestry_two.add(new HistoryObject("Clan Chief.  ", 80));
    historyList.add(ancestry_two);

    eyes.add(new HistoryObject("You have slime green eyes, ", 50));
    eyes.add(new HistoryObject("You have puke yellow eyes, ", 50));
    eyes.add(new HistoryObject("You have blue-bloodshot eyes, ", 50));
    eyes.add(new HistoryObject("You have glowing red eyes, ", 55));
    historyList.add(eyes);

    hair_one.add(new HistoryObject("dirty ", 50));
    hair_one.add(new HistoryObject("mangy ", 50));
    hair_one.add(new HistoryObject("oily ", 50));
    historyList.add(hair_one);

    hair_two.add(new HistoryObject("sea-weed green hair, ", 50));
    hair_two.add(new HistoryObject("bright red hair, ", 50));
    hair_two.add(new HistoryObject("dark purple hair, ", 50));
    historyList.add(hair_two);

    complexion_one.add(new HistoryObject("and green ", 50));
    complexion_one.add(new HistoryObject("and blue ", 50));
    complexion_one.add(new HistoryObject("and white ", 50));
    complexion_one.add(new HistoryObject("and black ", 50));
    historyList.add(complexion_one);

    complexion_two.add(new HistoryObject("ulcerous skin.", 50));
    complexion_two.add(new HistoryObject("scabby skin.", 50));
    complexion_two.add(new HistoryObject("leprous skin.", 50));
    historyList.add(complexion_two);

  }

}
