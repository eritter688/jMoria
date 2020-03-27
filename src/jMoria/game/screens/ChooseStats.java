package jMoria.game.screens;

import jMoria.game.ResourcePackage;
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
    t.clearScreen();
    t.writeLine(3, "  Name     :");
    t.writeLine(4, "  Race     : " + gameResources.player.race.getRace());
    t.writeLine(5, "  Sex      : " + gameResources.player.sex.getSex());
    t.writeLine(6, "  Class    :");

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
    t.writeLine(10, "   + To Hit   :      0");
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
