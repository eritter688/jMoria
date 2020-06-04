package jMoria.game.screens.playercreation;

import static java.util.EnumSet.allOf;

import jMoria.game.ResourcePackage;
import jMoria.game.player.Player;
import jMoria.game.player.enums.Race;
import jMoria.game.screens.AbstractScreen;
import jMoria.game.screens.playercreation.statics.PlayerCreationRenders;
import jMoria.ui.Terminal;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ChooseRaceScreen extends AbstractScreen {

  private final EnumSet<Race> races = allOf(Race.class);
  private final Map<String, Race> choiceMap = new HashMap<>();

  public ChooseRaceScreen(ResourcePackage gameResources) {
    super(gameResources);
    Iterator<Race> raceIterator = races.iterator();
    for (int index = 0; index < races.size(); index++) {
      choiceMap.put(PlayerCreationRenders.choiceKeys[index], raceIterator.next());
    }
  }

  @Override
  public void init() {
    gameResources.terminal.clearScreen();
  }

  @Override
  public void render() {
    Terminal t = gameResources.terminal;
    Player p = gameResources.player;

    PlayerCreationRenders.renderPersonalStats(t, p);

    t.writeLine(19, "  Choose a race:");
    PlayerCreationRenders.renderChoices(t, races);

  }

  @Override
  public void handleKey(String key) {
    if (this.listening && choiceMap.containsKey(key)) {
      gameResources.player.race = choiceMap.get(key);
      gameResources.game.setCurrentScreen(new ChooseSexScreen(gameResources));
    }
  }
}
