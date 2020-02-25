package jMoria.ui.controller;

import javafx.application.Platform;
import jMoria.ui.ASCIILoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.List;

public class MainMenuController extends AbstractController {

    @FXML
    private TextFlow asciiArea;
    @FXML
    private VBox buttonArea;
    @FXML
    private Button newButton;
    @FXML
    private Button loadButton;
    @FXML
    private Button scoresButton;
    @FXML
    private Button creditsButton;
    @FXML
    private Button quitButton;

    @Override
    public void initialize() {
        setLeftContent();
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
        switch(e.getCharacter().toLowerCase())
        {
            case "n": // NEW GAME
                System.out.println("NEW");
                break;
            case "l": // LOAD GAME
                System.out.println("LOAD");
                break;
            case "s": // SCORES
                System.out.println("SCORES");
                break;
            case "c": // CREDITS
                System.out.println("CREDS");
                break;
            case "q": // QUIT
                // TODO Is there any cleanup I need to do here?
                Platform.exit();
                break;
        }
    }

    private void setLeftContent()
    {
        ASCIILoader loader = new ASCIILoader();
        loader.setLocation("gandalf.txt");
        loader.setFont(Font.font("Monospaced", 12.0));
        loader.setColor(Color.CHARTREUSE);
        List<Text> listOfTexts = loader.loadToTexts();
        //TODO replace something like this with feature setTopPadding(int) in ASCIILoader
        Text t = new Text("\n\n\n\n\n\n");
        asciiArea.getChildren().add(t);
        asciiArea.getChildren().addAll(1, listOfTexts);
    }

}
