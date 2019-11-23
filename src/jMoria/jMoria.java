package jMoria;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.util.List;

public class jMoria extends Application {

    private static String TITLE = "jMoria v0.1";
    private static int WIDTH = 1024;
    private static int HEIGHT = 768;

    @Override
    public void start(Stage primaryStage) {

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

        Scene titleScene = new Scene(asciiArea, WIDTH, HEIGHT);
        titleScene.setFill(Color.BLACK);

        primaryStage.setTitle(TITLE);
        primaryStage.setResizable(false);
        primaryStage.setScene(titleScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
