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

    t.writeLine(19, "  Hit space to reroll or ESC to accept characteristics:");

  }

  private void renderStats(Terminal t) {
    renderPhysicalStats(t);
    renderPlayerStats(t);
    renderHitACStats(t);
  }

  private void renderPhysicalStats(Terminal t) {
  }

  private void renderPlayerStats(Terminal t) {
  }

  private void renderHitACStats(Terminal t) {
    t.writeLine(10, "   + To Hit   :      02");
    t.writeLine(11, "   + To Damage:      0");
    t.writeLine(12, "   + To AC    :      0");
    t.writeLine(13, "     Total AC :      0");
  }

  private void renderCharacterBackground() {
  }

  @Override
  public void handleKey(String key) {

  }
}
