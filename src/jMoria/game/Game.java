package jMoria.game;

import jMoria.game.living.Player;
import jMoria.game.screens.AbstractScreen;
import jMoria.ui.Terminal;

public class Game {

    private AbstractScreen currentScreen;
    private ResourcePackage gameResources;

    public Game(Terminal terminal) {
        this.gameResources = new ResourcePackage();
        this.gameResources.terminal = terminal;
    }

    private void init() {
        gameResources.game = this;
        gameResources.terminal.clearScreen();
    }

    public void newGame() {
        init();
        gameResources.player = new Player();
    }

    public void loadGame() {
        init();
    }

    public void saveGame() {
    }

    public void setCurrentScreen(AbstractScreen screen) {
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
