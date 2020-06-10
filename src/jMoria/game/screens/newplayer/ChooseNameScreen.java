package jMoria.game.screens.newplayer;

import jMoria.game.ResourcePackage;
import jMoria.game.screens.AbstractScreen;
import jMoria.game.screens.newplayer.common.NewPlayerRenders;
import java.util.regex.Pattern;

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
    gameResources.terminal.clearScreen();
    NewPlayerRenders.renderNameBlock(gameResources.terminal, gameResources.player);
    NewPlayerRenders.renderAgeBlock(gameResources.terminal, gameResources.player);
    NewPlayerRenders.renderStatBlock(gameResources.terminal, gameResources.player);
    NewPlayerRenders.renderBonusBlock(gameResources.terminal, gameResources.player);
    NewPlayerRenders.renderLevelBlock(gameResources.terminal, gameResources.player);
    NewPlayerRenders.renderHPBlock(gameResources.terminal, gameResources.player);
    NewPlayerRenders.renderMiscAbilitiesBlock(gameResources.terminal, gameResources.player);
    gameResources.terminal
        .writeLine(21, "   Enter your player's name  [press <RETURN> when finished]");
  }

  @Override
  public void handleKey(String key) {
    System.out.println("Received Key: " + key.toString());
    if ("ENTER".equals(key)) {
      if (gameResources.player.name.equals("")) {
        gameResources.player.name = "player";
        NewPlayerRenders.renderNameBlock(gameResources.terminal, gameResources.player);
//          gameResources.game.setCurrentScreen(new GameScreen(gameResources));
      }
    } else {
      handleNameInput(key);
    }

  }

  private static final Pattern ALPHANUMERIC = Pattern.compile("^[a-zA-Z0-9]+$");
  private final StringBuilder nameStringBuilder = new StringBuilder();

  private void handleNameInput(String s) {

    if (s.equals("BACK_SPACE")) {
      if (nameStringBuilder.length() > 0) {
        nameStringBuilder.deleteCharAt(nameStringBuilder.length() - 1);
      }
    }

    if (ALPHANUMERIC.matcher(s).matches()) {
      if (nameStringBuilder.length() < 12) {
        nameStringBuilder.append(s);
      }
    }

    gameResources.player.name = nameStringBuilder.toString();
    render();
  }
}
