package jMoria.ui.controller;

import jMoria.game.Game;
import jMoria.ui.Terminal;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.TextFlow;


// TODO Adapt for starting a saved game.
public class GameController extends AbstractController {

    @FXML
    private TextFlow terminalArea;

    private Game gameInstance;
    private Terminal terminal;

    @Override
    public void initialize() {
        this.terminal = new Terminal(terminalArea);
        this.terminal.dummyTerminal();
        this.gameInstance = new Game(terminal);
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

        System.out.println("UI RECEIVED KEY");
        gameInstance.receiveKeyInput(e);

    }
}
