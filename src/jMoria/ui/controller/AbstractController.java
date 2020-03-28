package jMoria.ui.controller;

import jMoria.ui.SceneManager;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class AbstractController {

    @FXML
    public URL location;
    @FXML
    public ResourceBundle resources;

    public SceneManager sceneManager;
    public EventHandler<KeyEvent> keyEventHandler = this::handleKeys;

    @FXML
    public abstract void initialize();

    public abstract void start();

    public abstract void stop();

    public abstract void handleKeys(KeyEvent e);

    public void startEventHandling() {
        sceneManager.getPrimaryStage().addEventHandler(KeyEvent.KEY_RELEASED, keyEventHandler);
    }

    public void stopEventHandling() {
        sceneManager.getPrimaryStage().removeEventHandler(KeyEvent.KEY_RELEASED, keyEventHandler);
    }
}
