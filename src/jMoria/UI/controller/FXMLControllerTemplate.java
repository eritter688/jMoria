package jMoria.UI.controller;

import java.net.URL;
import java.util.ResourceBundle;

import jMoria.UI.SceneManager;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;

public abstract class FXMLControllerTemplate {

    @FXML
    protected URL location;
    @FXML
    protected ResourceBundle resources;

    private SceneManager sceneManager;
    private EventHandler<KeyEvent> keyEventHandler = this::handleKeys;

    @FXML
    public abstract void initialize();

    public abstract void init();
    public abstract void stop();

    public abstract void handleKeys(KeyEvent e);

    public final void setSceneManager(SceneManager sceneManager)
    {
        this.sceneManager = sceneManager;
    }

    public final SceneManager getSceneManager()
    {
        return this.sceneManager;
    }

}
