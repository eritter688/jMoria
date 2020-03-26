package jMoria.game.screens;

import jMoria.game.ResourcePackage;
import jMoria.game.enums.PlayerClass;
import jMoria.game.living.Player;
import jMoria.ui.Terminal;

public class ChooseClass extends AbstractScreen {

  public ChooseClass(ResourcePackage gameResources) {
    super(gameResources);
  }

  @Override
  public void init() {
  }

  @Override
  public void render() {
    Terminal t = gameResources.terminal;
    t.writeLine(19, "  Choose a class:");
    t.writeLine(20, "  a) Warrior     b) Mage        c) Priest      d) Rogue       e) Ranger");
    t.writeLine(21, "  f) Paladin");
  }

  @Override
  public void handleKey(String key) {
    if (this.listening == Boolean.TRUE) {
      Player player = gameResources.player;
      switch (key) {
        case "a":
          player.playerClass = PlayerClass.WARRIOR;
          break;
        case "b":
          player.playerClass = PlayerClass.MAGE;
          break;
        case "c":
          player.playerClass = PlayerClass.PRIEST;
          break;
        case "d":
          player.playerClass = PlayerClass.ROGUE;
          break;
        case "e":
          player.playerClass = PlayerClass.RANGER;
          break;
        case "f":
          player.playerClass = PlayerClass.PALADIN;
          break;
      }
      gameResources.game.setCurrentScreen(this);
    }

  }
}
