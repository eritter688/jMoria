package jMoria;

import jMoria.UI.SceneManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class jMoria extends Application {

    protected static String TITLE = "jMoria v0.1";
    protected static int WIDTH = 800;
    protected static int HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle(TITLE);
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(e -> Platform.exit());

        var sceneManager = new SceneManager(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
