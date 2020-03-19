package jMoria.ui.controller;

import jMoria.ui.Terminal;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextFlow;

import java.util.concurrent.TimeUnit;

public class GameController extends AbstractController {

//    @FXML
//    private TextFlow terminalArea;

    int fsize = 10;

    @FXML
    private TextFlow terminalArea;

    private Terminal terminal;

    @Override
    public void initialize() {
        // System.out.println(this.terminalArea.toString());
    }

    @Override
    public void start() {
        this.terminal = new Terminal(terminalArea);
        this.terminal.dummyTerminal();

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
        switch(e.getCharacter())
        {
            case "u":
                fsize++;
                this.terminal.changeFontSize(fsize);
                break;
            case "d":
                fsize--;
                this.terminal.changeFontSize(fsize);
                break;
        }

    }
}
