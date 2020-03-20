package jMoria.game;

import jMoria.ui.Terminal;
import javafx.scene.input.KeyEvent;

public class Game {

    private Terminal terminal;

    public Game(Terminal terminal)
    {
        this.terminal = terminal;
    }

    public void newGame() {}

    public void receiveKeyInput(KeyEvent key) {
        System.out.println("GAME RECEIVED KEY");
    }

}
