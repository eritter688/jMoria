package jMoria.UI;

import jMoria.UI.controller.FXMLControllerTemplate;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SceneManager extends StackPane {

    private Stage primaryStage;
    private FXMLControllerTemplate primaryController;

    // Instead of storing these separately, I could combine them
    // with an inner class consisting of Node/Template as public members.
    // I miss Python Tuples...
    private HashMap<jMoriaScene, Node> scenes = new HashMap<>();
    private HashMap<jMoriaScene, FXMLControllerTemplate> controllers = new HashMap<>();

    public enum jMoriaScene {
        SPLASH,
        MENU,
        GAME;
    }

    public SceneManager(Stage primaryStage)
    {
        super();
        this.primaryStage = primaryStage;
        this.setStyle("-fx-background-color: #000000");
        //this.setStyle("-fx-background-color: #D2691E");
    }

    public void run() {
        primaryStage.setScene(new Scene(this, primaryStage.getWidth(), primaryStage.getHeight()));
        primaryStage.show();
    }

    protected void setScene(jMoriaScene scene) {

        // Lazy load the fxml/controller pair.
        if (!scenes.containsKey(scene)) {
            loadScene(scene);
        }
        // Set the scene!
        getChildren().remove(0);
        getChildren().add(0, scenes.get(scene));

    }

    private void loadScene(jMoriaScene scene) {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/jMoria/fxml" + ""));
            Parent root = loader.load();

            FXMLControllerTemplate controller = loader.getController();

            scenes.put(scene, root);
            controllers.put(scene, controller);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//
//
//
//
//
//
//
//
//    ////////////////////////////////
//    public void setScene(jMoriaScene scene)
//    {
//        switch(scene) {
//            case SPLASH:
//                System.out.println("splash");
//                break;
//            case GAME:
//                break;
//            case MENU:
//                break;
//            default:
//                break;
//        }
//    }
//
//    private void createSplashScreen()
//    {
//        TextFlow asciiArea = new TextFlow();
//        asciiArea.prefHeight(1024);
//        asciiArea.prefWidth(768);
//        asciiArea.setTextAlignment(TextAlignment.CENTER);
//
//        ASCIILoader loader = new ASCIILoader();
//        loader.setLocation("durindoor.txt");
//        loader.setFont(Font.font("Monospaced", 11.0));
//        loader.setColor(Color.CHARTREUSE);
//        List<Text> listOfTexts = loader.loadToTexts();
//        asciiArea.getChildren().addAll(0, listOfTexts);
//
//        Scene titleScene = new Scene(asciiArea, 1024, 768);
//        titleScene.setFill(Color.BLACK);
//    }
//
//    private void createGameScreen()
//    {
//        return;
//    }
//
//    private void createMenuScreen()
//    {
//        return;
//    }
}
