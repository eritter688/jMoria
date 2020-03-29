package jMoria.game.screens;

import jMoria.game.ResourcePackage;
import jMoria.game.living.Player;
import jMoria.game.screens.statics.PlayerCreationRenders;
import jMoria.ui.Terminal;

public class ChooseStats extends AbstractScreen {

  public ChooseStats(ResourcePackage gameResources) {
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
      PlayerCreationRenders.renderHitACStats(t, p);
      PlayerCreationRenders.renderPhyicalStats(t, p);
      PlayerCreationRenders.renderPlayerStats(t, p);
      PlayerCreationRenders.renderCharacterBackground(t, p);

      t.writeLine(21, "  Hit space to reroll or ESC to accept characteristics:");
  }

  @Override
  public void handleKey(String key) {

    if (!this.listening) {
      return;
    }

    if (key.equals("SPACE")) {
      // roll again
      render();
    } else if (key.equals("ESCAPE")) {
      // move to the town and start the game!!
      System.out.println("escape");
    }
  }
}
