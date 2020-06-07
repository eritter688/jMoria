package jMoria.game.player.create.history;

import jMoria.game.utils.Math;
import java.util.ArrayList;
import java.util.List;

public class HumanHistoryGenerator {

  public class HistoryObject {

    String text;
    int socialBonus;

    public HistoryObject(String text, int socialBonus) {
      this.text = text;
      this.socialBonus = socialBonus;
    }
  }

  public List<HistoryObject> ancestry = new ArrayList<>();
  public List<HistoryObject> hair = new ArrayList<>();
  public List<HistoryObject> eyes = new ArrayList<>();

  public List<List> bigList = new ArrayList<>();

  public HumanHistoryGenerator() {
    ancestry.add(new HistoryObject("You are the blah", 5));
    ancestry.add(new HistoryObject("You are the other blah", 10));

    hair.add(new HistoryObject("blue hair", 5));
    hair.add(new HistoryObject("red hair", 10));

    eyes.add(new HistoryObject("hazel eyes", 10));
    eyes.add(new HistoryObject("green eyes", 10));

    bigList.add(ancestry);
    bigList.add(hair);
    bigList.add(eyes);

  }

  public HistoryObject pickOne(List<HistoryObject> list) {
    int index = Math.randInt(list.size());
    return list.get(index);
  }

  public String generateHistory() {
    StringBuilder history = new StringBuilder();
    for (List list : bigList) {
      history.append(pickOne(list).text);
    }
    System.out.println(history.toString());
    return history.toString();
  }
}
