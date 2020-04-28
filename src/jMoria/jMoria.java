package jMoria;

import jMoria.ui.SceneManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 * jMoria - Application Start
 * <p>
 * Set the basic attributes for the primary JavaFX stage and load the sceneManager.
 * <p>
 * Window size is restricted to 800x600.
 */
public class jMoria extends Application {

  protected static final int MAJOR_VERSION = 0;
  protected static final int MINOR_VERSION = 1;

  protected static final String TITLE = String.format("jMoria v%d.%d",
      MAJOR_VERSION,
      MINOR_VERSION);
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

    SceneManager sceneManager = new SceneManager(primaryStage);
    sceneManager.start();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
