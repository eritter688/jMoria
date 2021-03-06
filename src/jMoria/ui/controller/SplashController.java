package jMoria.ui.controller;

import jMoria.ui.ASCIILoader;
import jMoria.ui.SceneManager;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class SplashController extends AbstractController {

  @FXML
  private TextFlow asciiArea;
  @FXML
  private TextFlow keyField;

  @Override
  public void initialize() {
    setAsciiArea();
    setKeyField();
  }

  @Override
  public void start() {
    startEventHandling();
  }

  @Override
  public void stop() {
    stopEventHandling();
  }

  private void setAsciiArea() {
    ASCIILoader loader = new ASCIILoader();
    loader.setLocation("durindoor.txt");
    loader.setFont(Font.font("Monospaced", 10.0));
    loader.setColor(Color.CHARTREUSE);
    List<Text> listOfTexts = loader.loadToTexts();
    asciiArea.getChildren().addAll(0, listOfTexts);
  }

  private void setKeyField() {
    Text t = new Text(" <-- press any key to enter -->");
    t.setFill(Color.WHITE);
    t.setFont(Font.font("Monospaced", 12.0));
    keyField.getChildren().add(t);
  }

  @Override
  public void handleKeys(KeyEvent e) {
    sceneManager.setScene(SceneManager.jMoriaScene.MENU);
  }
}
