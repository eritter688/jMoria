package jMoria.game;

import jMoria.game.screens.AbstractScreen;
import jMoria.ui.Terminal;

public class Game {

    private AbstractScreen currentScreen;
    private ResourcePackage gameResources;

    public Game(Terminal terminal) {
        this.gameResources = new ResourcePackage();
        this.gameResources.terminal = terminal;
    }

    public void init() {
        gameResources.terminal.clearScreen();
    }

    public void newGame() {
    }

    public void loadGame() {
    }

    public void receiveKeyInput(String key) {
        if (this.currentScreen != null) {
            currentScreen.handleKey(key);
        }
    }
}
