package jMoria.game;

import jMoria.game.modules.AbstractModule;
import jMoria.game.modules.CharacterCreationModule;
import jMoria.ui.Terminal;

public class Game {

    private AbstractModule currentModule;
    private ResourcePackage gameResources;

    public Game(Terminal terminal) {
        this.gameResources = new ResourcePackage();
        this.gameResources.terminal = terminal;
    }

    public void run() {
        currentModule = new CharacterCreationModule(gameResources);
        currentModule.init();
        currentModule.run();
    }

    // how do I know if a module/screen is complete
    // if I'm waiting on input from the user??
    public void receiveKeyInput(String key) {
        if (this.currentModule != null) {
            currentModule.handleKey(key);
        }
    }
}
