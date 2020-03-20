package jMoria;

import jMoria.game.Game;
import jMoria.ui.SceneManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class jMoria extends Application {

    protected static final String TITLE = "jMoria v0.1";
    protected static final int WIDTH = 800;
    protected static final int HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) {

        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("JavaFX Version: " + System.getProperty("javafx.runtime.version"));

        primaryStage.setTitle(TITLE);
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(e -> Platform.exit());

        SceneManager sceneManager = new SceneManager(this, primaryStage);
        sceneManager.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
