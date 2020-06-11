package jMoria.game.player.create.history;

import java.util.ArrayList;
import java.util.List;

public class HalfElfHistoryGenerator extends AbstractHistoryGenerator {

  public List<HistoryObject> parentage = new ArrayList<>();
  public List<HistoryObject> ancestry_one = new ArrayList<>();
  public List<HistoryObject> ancestry_two = new ArrayList<>();
  public List<HistoryObject> ancestry_three = new ArrayList<>();
  public List<HistoryObject> eyes = new ArrayList<>();
  public List<HistoryObject> hair_one = new ArrayList<>();
  public List<HistoryObject> hair_two = new ArrayList<>();
  public List<HistoryObject> complexion = new ArrayList<>();

  public HalfElfHistoryGenerator() {

    parentage.add(new HistoryObject("Your mother was a Green-Elf.  ", 50));
    parentage.add(new HistoryObject("Your father was a Green-Elf.  ", 55));
    parentage.add(new HistoryObject("Your mother was a Grey-Elf.  ", 55));
    parentage.add(new HistoryObject("Your father was a Grey-Elf.  ", 60));
    parentage.add(new HistoryObject("Your mother was a High-Elf.  ", 65));
    parentage.add(new HistoryObject("Your father was a High-Elf.  ", 70));

    ancestry_one.add(new HistoryObject("You are the illegitimate and unacknowledged child ", 25));
    ancestry_one.add(new HistoryObject("You are the illegitimate but acknowledged child ", 35));
    ancestry_one.add(new HistoryObject("You are one of several children ", 45));
    ancestry_one.add(new HistoryObject("You are the first child ", 50));

    ancestry_two.add(new HistoryObject("of a Serf.  ", 65));
    ancestry_two.add(new HistoryObject("of a Yeoman.  ", 80));
    ancestry_two.add(new HistoryObject("of a Townsman.  ", 90));
    ancestry_two.add(new HistoryObject("of a Guildsman.  ", 105));
    ancestry_two.add(new HistoryObject("of a Landed Knight.  ", 150));
    ancestry_two.add(new HistoryObject("of a Titled Noble.  ", 130));
    ancestry_two.add(new HistoryObject("of a Royal Blood Line.  ", 140));

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

    historyList.add(parentage);
    historyList.add(ancestry_one);
    historyList.add(ancestry_two);
    historyList.add(ancestry_three);
    historyList.add(eyes);
    historyList.add(hair_one);
    historyList.add(hair_two);
    historyList.add(complexion);

  }

}
