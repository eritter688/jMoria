package jMoria.game.screens.playercreation;

import jMoria.game.ResourcePackage;
import jMoria.game.player.enums.Sex;
import jMoria.game.player.Player;
import jMoria.game.screens.AbstractScreen;
import jMoria.game.screens.playercreation.statics.PlayerCreationRenders;
import jMoria.ui.Terminal;

import java.util.Map;

import static java.util.Map.entry;

public class ChooseSexScreen extends AbstractScreen {

  private Map<String, Sex> choices = Map.ofEntries(entry("m", Sex.MALE), entry("f", Sex.FEMALE));

  public ChooseSexScreen(ResourcePackage gameResources) {
    super(gameResources);
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

    t.writeLine(19, "  Choose a sex:");
    t.writeLine(20, "  m) Male        f) Female");
  }

  @Override
  public void handleKey(String key) {
    if (this.listening && choices.containsKey(key)) {
      gameResources.player.sex = choices.get(key);
      gameResources.game.setCurrentScreen(new ChooseStatsScreen(gameResources));
    }
  }
}
