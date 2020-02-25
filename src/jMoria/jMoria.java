package jMoria;

import jMoria.UI.SceneManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class jMoria extends Application {

    protected static final String TITLE = "jMoria v0.1";
    protected static final int WIDTH = 800;
    protected static final int HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle(TITLE);
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(e -> Platform.exit());

        SceneManager sceneManager = new SceneManager(primaryStage);
        sceneManager.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
