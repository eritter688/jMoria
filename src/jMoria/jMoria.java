package jMoria;

import javafx.application.Application;
import javafx.stage.Stage;

public class jMoria extends Application {

    protected static String TITLE = "jMoria v0.1";
    protected static int WIDTH = 1024;
    protected static int HEIGHT = 768;

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle(TITLE);
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        primaryStage.setResizable(false);

        var sceneManager = new SceneManager(primaryStage);
        sceneManager.setScene(SceneManager.jMoriaScene.SPLASH);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
