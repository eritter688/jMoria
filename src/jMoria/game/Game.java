package jMoria.game;

import jMoria.ui.Terminal;

// TODO Adapt for starting a saved game.
public class Game {

    private Terminal terminal;

    public Game(Terminal terminal)
    {
        this.terminal = terminal;
    }

    public void run()
    {
        newGame();
    }

    public void newGame() {
        NewGame newGameSequence = new NewGame(terminal);
        newGameSequence.run();
    }

    // TODO Must be agnostic to JavaFX...
    public void receiveKeyInput(String key) {
        System.out.println("GAME RECEIVED KEY: " + key);
    }

}
