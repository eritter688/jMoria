package jMoria.game.screens.newplayer;

import jMoria.game.ResourcePackage;
import jMoria.game.player.enums.Race;
import jMoria.game.screens.AbstractScreen;
import jMoria.game.screens.newplayer.common.NewPlayerRenders;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ChooseRaceScreen extends AbstractScreen {

  private final EnumSet<Race> races = EnumSet.allOf(Race.class);
  private final Map<String, Race> choiceMap = new HashMap<>();

  public ChooseRaceScreen(ResourcePackage gameResources) {
    super(gameResources);
    Iterator<Race> raceIterator = races.iterator();
    for (int index = 0; index < races.size(); index++) {
      choiceMap.put(NewPlayerRenders.choiceKeys[index], raceIterator.next());
    }
  }

  @Override
  public void init() {
    gameResources.terminal.clearScreen();
  }

  @Override
  public void render() {
    NewPlayerRenders.renderNameBlock(gameResources.terminal, gameResources.player);
    gameResources.terminal.writeLine(19, "  Choose a race:");
    NewPlayerRenders.renderChoices(gameResources.terminal, races);
  }

  @Override
  public void handleKey(String key) {
    if (this.listening && choiceMap.containsKey(key)) {
      gameResources.player.race = choiceMap.get(key);
      gameResources.game.setCurrentScreen(new ChooseSexScreen(gameResources));
    }
  }
}
