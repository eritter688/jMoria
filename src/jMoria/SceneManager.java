package jMoria;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.util.List;

public class SceneManager extends StackPane {

    private Stage primaryStage;

    public enum jMoriaScene {
        SPLASH,
        MENU,
        GAME;
    }

    public SceneManager(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
    }

    public void setScene(jMoriaScene scene)
    {
        switch(scene) {
            case SPLASH:
                System.out.println("splash");
                break;
            case GAME:
                break;
            case MENU:
                break;
            default:
                break;
        }
    }

    private void createSplashScreen()
    {
        TextFlow asciiArea = new TextFlow();
        asciiArea.prefHeight(1024);
        asciiArea.prefWidth(768);
        asciiArea.setTextAlignment(TextAlignment.CENTER);

        ASCIILoader loader = new ASCIILoader();
        loader.setLocation("durindoor.txt");
        loader.setFont(Font.font("Monospaced", 11.0));
        loader.setColor(Color.CHARTREUSE);
        List<Text> listOfTexts = loader.loadToTexts();
        asciiArea.getChildren().addAll(0, listOfTexts);

        Scene titleScene = new Scene(asciiArea, 1024, 768);
        titleScene.setFill(Color.BLACK);
    }

    private void createGameScreen()
    {
        return;
    }

    private void createMenuScreen()
    {
        return;
    }
}
