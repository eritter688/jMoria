package jMoria.ui.controller;

import jMoria.ui.Terminal;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;

public class GameController extends AbstractController {

    @FXML
    private StackPane terminalArea;

    private Terminal terminal;

    @Override
    public void initialize() {

    }

    @Override
    public void start() {
        // set up the terminal here
        terminal = new Terminal();
        terminal.dummyTerminal();
        //terminalArea.chi;

        startEventHandling();
    }

    @Override
    public void stop() {
        stopEventHandling();
    }

    @Override
    public void handleKeys(KeyEvent e) {

        // send all the things down to the actual game here
        // via some sort of bridge?
        // use the jMoria class as that bridge?
        System.out.println("GAME RECEIVED KEY");

    }
}
