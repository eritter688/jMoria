package jMoria.controller;

import java.net.URL;
import java.util.ResourceBundle;

import jMoria.SceneManager;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;

public abstract class AbstractControllerTemplate
{
	@FXML
	private URL location;
	@FXML
	private ResourceBundle resources;

	private SceneManager sceneManager;

	private EventHandler<KeyEvent> keyEventHandler = e -> handleKeys(e);
	private Boolean listening;
	
	public void initialize()
	{
		setContent();
		setListening(false);
	}

	public void init()
	{
		setListeners();
	}

	public void release()
	{
		clearListeners();
		setListening(false);
	}

	public final void setSceneManager(SceneManager sceneManager)
	{
		this.sceneManager = sceneManager;
	}
	
	public final SceneManager getSceneManager()
	{
		return this.sceneManager;
	}

	public final void setListeners()
	{
		this.sceneManager.getPrimaryStage().addEventHandler(KeyEvent.ANY, keyEventHandler);
	}

	public final void clearListeners()
	{
		this.sceneManager.getPrimaryStage().removeEventHandler(KeyEvent.ANY, keyEventHandler);
	}

	public final void setListening(Boolean listening)
	{
		this.listening = listening;
	}
	
	public final boolean isListening()
	{
		return this.listening;
	}

	// Controller Specific Tasks

	public abstract void setContent();
	
	public abstract void handleKeys(KeyEvent e);
			
	// Screen Transition   *** MUST call release() before making transition! ***

	public void changeScreen(String target)
	{
		release();
		this.sceneManager.setScreen(target);
		this.sceneManager.setListening(true);
	}

}
