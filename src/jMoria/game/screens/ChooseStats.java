package jMoria.game.screens;

import jMoria.game.ResourcePackage;
import jMoria.game.living.Player;
import jMoria.game.statics.CharacterCreation;
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

    CharacterCreation.renderPersonalStats(t, p);
    CharacterCreation.renderHitACStats(t, p);
    CharacterCreation.renderPhyicalStats(t, p);
    CharacterCreation.renderPlayerStats(t, p);

    t.writeLine(19, "  Hit space to reroll or ESC to accept characteristics:");

  }

  @Override
  public void handleKey(String key) {

  }
}
