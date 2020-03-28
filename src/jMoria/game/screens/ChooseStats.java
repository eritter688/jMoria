package jMoria.game.screens;

import jMoria.game.ResourcePackage;
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

    CharacterCreation.renderPersonalStats(gameResources.terminal, gameResources.player);

    Terminal t = gameResources.terminal;

    t.writeLine(19, "  Hit space to reroll or ESC to accept characteristics:");

    renderStats(t);
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
