package jMoria.game;

import jMoria.game.player.Player;
import jMoria.game.screens.AbstractScreen;
import jMoria.game.screens.playercreation.ChooseRaceScreen;
import jMoria.ui.Terminal;

public class Game {

  public static final boolean DEBUG = true;

  private AbstractScreen currentScreen;
  private final ResourcePackage gameResources;

  public Game(Terminal terminal) {
    this.gameResources = new ResourcePackage();
    this.gameResources.game = this;
    this.gameResources.terminal = terminal;
    this.gameResources.terminal.clearScreen();
  }

  public void newGame() {
    gameResources.player = new Player();
    setCurrentScreen(new ChooseRaceScreen(gameResources));
  }

  public void loadGame() {
  }

  public void saveGame() {
  }

  public void setCurrentScreen(AbstractScreen screen) {
    if (currentScreen != null) {
      currentScreen.stopListening();
    }
    currentScreen = screen;
    currentScreen.init();
    currentScreen.render();
    currentScreen.startListening();
  }

  public void receiveKeyInput(String key) {
    if (currentScreen != null) {
      currentScreen.handleKey(key);
    }
  }
}
