package jMoria.game.screens;

import jMoria.game.ResourcePackage;
import jMoria.game.enums.Sex;
import jMoria.game.living.Player;
import jMoria.game.statics.CharacterCreation;
import jMoria.ui.Terminal;

import java.util.Map;

import static java.util.Map.entry;

public class ChooseSex extends AbstractScreen {

  private Map<String, Sex> choices = Map.ofEntries(entry("m", Sex.MALE), entry("f", Sex.FEMALE));

  public ChooseSex(ResourcePackage gameResources) {
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

    CharacterCreation.renderPersonalStats(t, p);

    t.writeLine(19, "  Choose a sex:");
    t.writeLine(20, "  m) Male        f) Female");
  }

  @Override
  public void handleKey(String key) {
    if (this.listening && choices.containsKey(key)) {
      gameResources.player.sex = choices.get(key);
      gameResources.game.setCurrentScreen(new ChooseStats(gameResources));
    }
  }
}
