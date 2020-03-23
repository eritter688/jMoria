package jMoria.game;

import jMoria.game.modules.AbstractModule;
import jMoria.game.modules.CharacterCreationModule;
import jMoria.ui.Terminal;

// TODO Adapt for starting a saved game.
public class Game {

    private Terminal terminal;
    private AbstractModule currentModule;

    public Game(Terminal terminal)
    {
        this.terminal = terminal;
    }

    public void run() {

        currentModule = new CharacterCreationModule(terminal);
        currentModule.init();
        currentModule.run();

    }

    public void receiveKeyInput(String key) {
        System.out.println("GAME RECEIVED KEY: " + key);
        currentModule.handleKey(key);
    }




//    public void run()
//    {
//        newGame();
//    }
//
//    public void newGame() {
//        NewGame newGameSequence = new NewGame(terminal);
//        newGameSequence.run();
//    }
}
