package jMoria.game.screens.newplayer;

import static jMoria.game.screens.newplayer.common.NewPlayerRenders.renderAgeBlock;
import static jMoria.game.screens.newplayer.common.NewPlayerRenders.renderBonusBlock;
import static jMoria.game.screens.newplayer.common.NewPlayerRenders.renderCharacterBackgroundBlock;
import static jMoria.game.screens.newplayer.common.NewPlayerRenders.renderNameBlock;
import static jMoria.game.screens.newplayer.common.NewPlayerRenders.renderStatBlock;

import jMoria.game.ResourcePackage;
import jMoria.game.player.create.PlayerCreator;
import jMoria.game.screens.AbstractScreen;

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
    renderNameBlock(gameResources.terminal, gameResources.player);
    renderAgeBlock(gameResources.terminal, gameResources.player);
    renderStatBlock(gameResources.terminal, gameResources.player);
    renderBonusBlock(gameResources.terminal, gameResources.player);
    renderCharacterBackgroundBlock(gameResources.terminal, gameResources.player);
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
