package jMoria.game.screens;

import jMoria.game.ResourcePackage;
import jMoria.game.player.enums.Class;
import jMoria.game.player.Player;
import jMoria.ui.Terminal;

public class ChooseClassScreen extends AbstractScreen {

  public ChooseClassScreen(ResourcePackage gameResources) {
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
    if (this.listening) {
      Player player = gameResources.player;
      switch (key) {
        case "a":
          player.playerClass = Class.WARRIOR;
          break;
        case "b":
          player.playerClass = Class.MAGE;
          break;
        case "c":
          player.playerClass = Class.PRIEST;
          break;
        case "d":
          player.playerClass = Class.ROGUE;
          break;
        case "e":
          player.playerClass = Class.RANGER;
          break;
        case "f":
          player.playerClass = Class.PALADIN;
          break;
      }
      gameResources.game.setCurrentScreen(this);
    }
  }
}
