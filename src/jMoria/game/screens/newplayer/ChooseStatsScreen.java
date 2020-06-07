package jMoria.game.screens.newplayer;

import jMoria.game.ResourcePackage;
import jMoria.game.player.create.PlayerCreator;
import jMoria.game.screens.AbstractScreen;
import jMoria.game.screens.newplayer.common.NewPlayerRenders;

public class ChooseStatsScreen extends AbstractScreen {

  public PlayerCreator playerCreator;

  public ChooseStatsScreen(ResourcePackage gameResources) {
    super(gameResources);
  }

  @Override
  public void init() {
    gameResources.terminal.clearScreen();
    this.playerCreator = new PlayerCreator(gameResources.player);
    playerCreator.roll();
  }

  @Override
  public void render() {
    NewPlayerRenders.renderNameBlock(gameResources.terminal, gameResources.player);
    NewPlayerRenders.renderAgeBlock(gameResources.terminal, gameResources.player);
    NewPlayerRenders.renderStatBlock(gameResources.terminal, gameResources.player);
    NewPlayerRenders.renderBonusBlock(gameResources.terminal, gameResources.player);
    NewPlayerRenders.renderCharacterBackgroundBlock(gameResources.terminal, gameResources.player);
    gameResources.terminal
        .writeLine(20, "   Hit space to reroll or ESC to accept characteristics:");
  }

  @Override
  public void handleKey(String key) {

    if (!this.listening) {
      return;
    }

    if (key.equals("SPACE")) {
      playerCreator.roll();
      render();
    } else if (key.equals("ESCAPE")) {
      gameResources.game.setCurrentScreen(new ChooseClassScreen(gameResources));
    }
  }
}
