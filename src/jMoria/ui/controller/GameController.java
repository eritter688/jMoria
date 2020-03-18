package jMoria.ui.controller;

import jMoria.ui.Terminal;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class GameController extends AbstractController {

    @FXML
    public Pane terminalArea;

    public Terminal terminal;

    @Override
    public void initialize() {
        setUpTerminal();
    }

    private void setUpTerminal() {
        terminal = new Terminal();
        terminal.loadTestTerminal();
        terminalArea.getChildren().add(terminal);
    }

    @Override
    public void start() {
        //startEventHandling();
    }

    @Override
    public void stop() {
        //stopEventHandling();
    }

    @Override
    public void handleKeys(KeyEvent e) {
        // pass all key events down to the game engine
        // requires a bridge of some sort perhaps.
    }
}
