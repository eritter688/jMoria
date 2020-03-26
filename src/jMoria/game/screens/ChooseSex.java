package jMoria.game.screens;

import jMoria.game.ResourcePackage;
import jMoria.game.enums.Sex;
import jMoria.game.living.Player;
import jMoria.ui.Terminal;

public class ChooseSex extends AbstractScreen {

  public ChooseSex(ResourcePackage gameResources) {
    super(gameResources);
  }

  @Override
  public void init() {
  }

  @Override
  public void render() {
    Terminal t = gameResources.terminal;
    t.writeLine(4, "  Race     : " + gameResources.player.race.getRace());
    t.writeLine(19, "  Choose sex:");
    t.writeLine(20, "  m) Male        f) Female");
    t.clearLine(21);
  }

  @Override
  public void handleKey(String key) {
    if (this.listening == Boolean.TRUE) {
      Player player = gameResources.player;
      switch (key) {
        case "m":
          player.sex = Sex.MALE;
          break;
        case "f":
          player.sex = Sex.FEMALE;
          break;
      }
      gameResources.game.setCurrentScreen(this);
    }
  }

}
