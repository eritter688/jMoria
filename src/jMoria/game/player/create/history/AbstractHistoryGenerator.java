package jMoria.game.player.create.history;

import jMoria.game.utils.Math;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHistoryGenerator {

  public List<List<HistoryObject>> historyList = new ArrayList<>();

  public StringBuilder history = new StringBuilder();
  public int socialClass = 0;

  public HistoryObject pickOne(List<HistoryObject> list) {
    int index = Math.randInt(list.size());
    return list.get(index);
  }

  public void generateHistory() {
    for (List<HistoryObject> list : historyList) {
      HistoryObject historyObject = pickOne(list);
      history.append(historyObject.text);
      socialClass += historyObject.socialBonus;
    }
    System.out.println(history.toString());
  }
}
