package jMoria.game.screens.newplayer;

import jMoria.game.ResourcePackage;
import jMoria.game.screens.AbstractScreen;
import jMoria.game.screens.newplayer.common.NewPlayerRenders;

public class ChooseNameScreen extends AbstractScreen {

  public ChooseNameScreen(ResourcePackage gameResources) {
    super(gameResources);
  }

  @Override
  public void init() {
    gameResources.terminal.clearScreen();
  }

  @Override
  public void render() {
    NewPlayerRenders.renderNameBlock(gameResources.terminal, gameResources.player);
    NewPlayerRenders.renderAgeBlock(gameResources.terminal, gameResources.player);
    NewPlayerRenders.renderStatBlock(gameResources.terminal, gameResources.player);
    NewPlayerRenders.renderBonusBlock(gameResources.terminal, gameResources.player);
    NewPlayerRenders.renderLevelBlock(gameResources.terminal, gameResources.player);
    NewPlayerRenders.renderHPBlock(gameResources.terminal, gameResources.player);
    NewPlayerRenders.renderMiscAbilitiesBlock(gameResources.terminal, gameResources.player);
    gameResources.terminal
        .writeLine(21, "  Enter your player's name  [press <RETURN> when finished]");
  }

  @Override
  public void handleKey(String key) {
    System.out.println("ON TO THE GaME!!");
  }
}
