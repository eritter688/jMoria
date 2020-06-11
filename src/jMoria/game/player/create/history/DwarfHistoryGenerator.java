package jMoria.game.player.create.history;

import java.util.ArrayList;
import java.util.List;

public class DwarfHistoryGenerator extends AbstractHistoryGenerator {

  public List<HistoryObject> ancestry_one = new ArrayList<>();
  public List<HistoryObject> ancestry_two = new ArrayList<>();
  public List<HistoryObject> family_status = new ArrayList<>();
  public List<HistoryObject> eyes = new ArrayList<>();
  public List<HistoryObject> hair_one = new ArrayList<>();
  public List<HistoryObject> hair_two = new ArrayList<>();
  public List<HistoryObject> beard = new ArrayList<>();
  public List<HistoryObject> complexion = new ArrayList<>();

  public DwarfHistoryGenerator() {

    ancestry_one.add(new HistoryObject("You are one of two children of a Dwarven ", 40));
    ancestry_one.add(new HistoryObject("You are the only child of a Dwarven ", 50));
    historyList.add(ancestry_one);

    ancestry_two.add(new HistoryObject("Thief.  ", 60));
    ancestry_two.add(new HistoryObject("Prison Guard.  ", 75));
    ancestry_two.add(new HistoryObject("Miner.  ", 90));
    ancestry_two.add(new HistoryObject("Warrior.  ", 110));
    ancestry_two.add(new HistoryObject("Priest.  ", 130));
    ancestry_two.add(new HistoryObject("King.  ", 150));
    historyList.add(ancestry_two);

    family_status.add(new HistoryObject("You are the black sheep of the family.  ", 10));
    family_status.add(new HistoryObject("You are a credit to the family.  ", 50));
    family_status.add(new HistoryObject("You are a well liked child.  ", 55));
    historyList.add(family_status);

    eyes.add(new HistoryObject("You have dark brown eyes, ", 50));
    eyes.add(new HistoryObject("You have glowing red eyes, ", 60));
    historyList.add(eyes);

    hair_one.add(new HistoryObject("straight ", 50));
    hair_one.add(new HistoryObject("wavy ", 50));
    historyList.add(hair_one);

    hair_two.add(new HistoryObject("black hair, ", 50));
    hair_two.add(new HistoryObject("brown hair, ", 50));
    historyList.add(hair_two);

    beard.add(new HistoryObject("a one foot beard, ", 50));
    beard.add(new HistoryObject("a two foot beard, ", 51));
    beard.add(new HistoryObject("a three foot beard, ", 53));
    beard.add(new HistoryObject("a four foot beard, ", 55));
    historyList.add(beard);

    complexion.add(new HistoryObject("and a dark complexion.", 50));
    historyList.add(complexion);

  }

}
