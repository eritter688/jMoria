package jMoria.game;

import javafx.scene.input.KeyEvent;

public class Game {

    public Game() {}

    public void newGame() {}

    public void loadGame() {}

    public void highScores() {}

    public void receiveKeyInput(KeyEvent key) {
        System.out.println("received " + key.toString());
    }

}
