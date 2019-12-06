package jMoria.UI.controller;

import jMoria.UI.ASCIILoader;
import jMoria.UI.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.List;

public class SplashController extends FXMLControllerTemplate {

    @FXML
    private TextFlow asciiArea;
    private TextFlow keyField;

    @Override
    public void initialize() {
        setAsciiArea();
        setKeyField();
    }

    void setAsciiArea() {
        ASCIILoader loader = new ASCIILoader();
        loader.setLocation("durindoor.txt");
        loader.setFont(Font.font("Monospaced", 11.0));
        loader.setColor(Color.CHARTREUSE);
        List<Text> listOfTexts = loader.loadToTexts();
        asciiArea.getChildren().addAll(0, listOfTexts);
    }

    void setKeyField() {
        Text t = new Text("press any key to enter");
        t.setFill(Color.WHITE);
        t.setFont(Font.font("Monospaced", 14.0));
        keyField.getChildren().add(t);
    }

    @Override
    public void handleKeys(KeyEvent e) {
        // are we on or off? how should we look at that?
        //super.getSceneManager().setScene(SceneManager.jMoriaScene.MENU);
    }
}
