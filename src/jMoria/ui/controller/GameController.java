package jMoria.ui.controller;

import jMoria.game.Game;
import jMoria.ui.Terminal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.TextFlow;

// TODO Adapt for starting a saved game.
public class GameController extends AbstractController {

    @FXML
    private TextFlow terminalArea;

    private Game gameInstance;
    private Terminal terminal;

    private Set<KeyCode> notLetterOrDigit = new HashSet<>();

    @Override
    public void initialize() {
        this.terminal = new Terminal(terminalArea);
        this.terminal.dummyTerminal();
        this.gameInstance = new Game(terminal);
        this.gameInstance.newGame();
        Collections.addAll(
            notLetterOrDigit,
            KeyCode.SLASH,
            KeyCode.PERIOD,
            KeyCode.COMMA,
            KeyCode.SEMICOLON,
            KeyCode.QUOTE,
            KeyCode.OPEN_BRACKET,
            KeyCode.CLOSE_BRACKET,
            KeyCode.BACK_SLASH,
            KeyCode.MINUS,
            KeyCode.EQUALS,
            KeyCode.BACK_QUOTE
        );
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

        String keyToGame;

        if (e.getCode().isLetterKey() || e.getCode().isDigitKey())
        {
            keyToGame = e.getText();
        }
        else if (notLetterOrDigit.contains(e.getCode()))
        {
            keyToGame = e.getText();
        }
        else
        {
            keyToGame = e.getCode().toString();
        }

        gameInstance.receiveKeyInput(keyToGame);
    }
}
