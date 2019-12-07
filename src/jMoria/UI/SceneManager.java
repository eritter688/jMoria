package jMoria.UI;

import jMoria.UI.controller.FXMLControllerTemplate;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class SceneManager extends StackPane {

    private Stage primaryStage;
    private FXMLControllerTemplate primaryController;

    private HashMap<jMoriaScene, Node> scenes = new HashMap<>();
    private HashMap<jMoriaScene, FXMLControllerTemplate> controllers = new HashMap<>();

    public enum jMoriaScene {
        GAME("game.fxml"),
        MENU("menu.fxml"),
        SPLASH("splash.fxml");

        private final String fxmlFile;

        jMoriaScene(String fxmlFile) {
            this.fxmlFile = fxmlFile;
        }

        String getFXMLFile() {
            return this.fxmlFile;
        }
    }

    public SceneManager(Stage primaryStage) {
        super();
        System.out.println("scenemanager constructor");
        this.primaryStage = primaryStage;
        //this.setStyle("-fx-background-color: #000000");
        this.setStyle("-fx-background-color: #D2691E");
        this.primaryStage.setScene(new Scene(this, primaryStage.getWidth(), primaryStage.getHeight()));
        this.setScene(jMoriaScene.SPLASH);
        this.primaryStage.show();
    }

    protected void setScene(jMoriaScene scene) {
        System.out.println("set scene");
        // Lazy load the fxml/controller pair.
        if (!scenes.containsKey(scene)) {
            loadScene(scene, scene.getFXMLFile());
        }
        // Set the scene!
        if (primaryController != null) {
            primaryController.stop();
        }
        if(!this.getChildren().isEmpty()) {
            this.getChildren().remove(0);
        }
        this.getChildren().add(0, scenes.get(scene));
        primaryController = controllers.get(scene);
        primaryController.init();
    }

    private void loadScene(jMoriaScene scene, String fxmlFile) {
        System.out.println("load scene");
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/jMoria/UI/fxml/" + fxmlFile));
            System.out.println(loader.getLocation());
            Parent root = loader.load();
            FXMLControllerTemplate controller = loader.getController();
            scenes.put(scene, root);
            controllers.put(scene, controller);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
