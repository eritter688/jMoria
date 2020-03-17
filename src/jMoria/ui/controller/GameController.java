package jMoria.ui.controller;

import javafx.scene.input.KeyEvent;

public class GameController extends AbstractController {

    @Override
    public void initialize() {
    }

    @Override
    public void start() {
        startEventHandling();
    }

    @Override
    public void stop() {
        stopEventHandling();
    }

    @Override
    public void handleKeys(KeyEvent e) {
        // pass all key events down to the game engine
        // requires a bridge of some sort perhaps.
    }
}
