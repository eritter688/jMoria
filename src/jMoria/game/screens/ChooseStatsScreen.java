package jMoria.game.screens;

import jMoria.game.ResourcePackage;
import jMoria.game.player.Player;
import jMoria.game.player.PlayerCreator;
import jMoria.game.screens.statics.PlayerCreationRenders;
import jMoria.ui.Terminal;

public class ChooseStatsScreen extends AbstractScreen {

    private PlayerCreator pc;

    public ChooseStatsScreen(ResourcePackage gameResources) {
        super(gameResources);
    }

    @Override
    public void init() {
        pc = new PlayerCreator(gameResources);
    }

    @Override
    public void render() {
        Terminal t = gameResources.terminal;
        Player p = gameResources.player;

        t.clearScreen();

        pc.rollPlayerValues();
        PlayerCreationRenders.renderAll(t, p);

        t.writeLine(21, "  Hit space to reroll or ESC to accept characteristics:");
    }

  @Override
  public void handleKey(String key) {

    if (!this.listening) {
      return;
    }

    if (key.equals("SPACE")) {
      render();
    } else if (key.equals("ESCAPE")) {
      // move to the town and start the game!!
        // TODO
        // Needs to go to choose class, then choose name before this!!
        gameResources.game.setCurrentScreen(new GameScreen(gameResources));
      //System.out.println("TO TOWN!!");
    }
  }
}
