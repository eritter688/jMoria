package jMoria.game.screens;

import static java.util.Map.entry;

import jMoria.game.ResourcePackage;
import jMoria.game.enums.Sex;
import jMoria.game.statics.CharacterCreation;
import jMoria.ui.Terminal;
import java.util.Map;


public class ChooseSex extends AbstractScreen {

  private Map<String, Sex> choices = Map.ofEntries(
      entry("m", Sex.MALE),
      entry("f", Sex.FEMALE)
  );

  public ChooseSex(ResourcePackage gameResources) {
    super(gameResources);
  }

  @Override
  public void init() {
    gameResources.terminal.clearScreen();
  }

  @Override
  public void render() {
    CharacterCreation.renderPersonalStats(gameResources.terminal, gameResources.player);

    Terminal t = gameResources.terminal;
    t.writeLine(19, "  Choose a sex:");
    t.writeLine(20, "  m) Male        f) Female");
  }

  @Override
  public void handleKey(String key) {
    if (this.listening == Boolean.TRUE && choices.containsKey(key)) {
      gameResources.player.sex = choices.get(key);
      gameResources.game.setCurrentScreen(new ChooseStats(gameResources));
    }
  }
}
