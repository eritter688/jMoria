package jMoria.game;

import jMoria.game.living.Player;
import jMoria.game.screens.AbstractScreen;
import jMoria.game.screens.ChooseRace;
import jMoria.ui.Terminal;

public class Game {

    // TODO
    // Remove this before actually finalizing the game.
    public static final boolean DEBUG = true;
  public static final long RANDOM_SEED = 123456789L;

    private AbstractScreen currentScreen;
    private ResourcePackage gameResources;

    public Game(Terminal terminal) {
        this.gameResources = new ResourcePackage();
        this.gameResources.terminal = terminal;
    }

    private void init() {
        gameResources.game = this;
      gameResources.dice = new Dice();
      gameResources.terminal.clearScreen();
    }

    public void newGame() {
        init();
        gameResources.player = new Player();
        setCurrentScreen(new ChooseRace(gameResources));
    }

    public void loadGame() {
        init();
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
