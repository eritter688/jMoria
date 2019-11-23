package jMoria;

import java.io.IOException;
import java.util.HashMap;

import jMoria.controller.AbstractControllerTemplate;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SceneManager extends StackPane
{
	// Default Window Size
	private static int W = 800;
	private static int H = 600;

	private Stage primaryStage;
	private Scene primaryScene;
	
	private AbstractControllerTemplate screenController;

	private HashMap<String, Node> screens = new HashMap<>();
	private HashMap<String, AbstractControllerTemplate> controllers = new HashMap<>();

	public SceneManager()
	{
		super();
	}
	
	public void init(Stage stage)
	{
		//TODO
		//Testing game area alignment. Need contrast.
		//this.setStyle("-fx-background-color: #000000");
		this.setStyle("-fx-background-color: #D2691E");
		
		this.primaryStage = stage;
		this.primaryStage.setTitle(jMoria.name + " " + jMoria.version);
		this.primaryStage.setResizable(false);

		/*
		 * There are only a few app screens.
		 * Load them all and keep them in the background.
		 */
		loadAllScreens();

		this.primaryScene = new Scene(this, W, H);
		this.primaryStage.setScene(primaryScene);
		this.primaryStage.show();
		
		this.primaryStage.setOnCloseRequest(e -> Platform.exit());

		// App Is Running!
		setSplashScreen();
		this.screenController.setListening(true);
	}

	public Stage getPrimaryStage()
	{
		return primaryStage;
	}

	private void loadAllScreens()
	{
		loadScreen("splash", "splash.fxml");
		loadScreen("mainmenu", "mainmenu.fxml");
		loadScreen("game", "game.fxml");
	}

	private void addController(String name, AbstractControllerTemplate controller)
	{
		this.controllers.put(name, controller);
	}

	public AbstractControllerTemplate getController(String name)
	{
		return this.controllers.get(name);
	}

	private void addScreen(String name, Node screen)
	{
		this.screens.put(name, screen);
	}

	public Node getScreen(String name)
	{
		return this.screens.get(name);
	}

	private void loadScreen(String name, String fxmlFile)
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/res/fxml/" + fxmlFile));
			Parent root = loader.load();

			AbstractControllerTemplate controller = ((AbstractControllerTemplate) loader.getController());
			controller.setSceneManager(this);

			addScreen(name, root);
			addController(name, controller);
		} 
		catch (IOException e)
		{
			Debug.dString("FXML File Load Failed:");
			Debug.dString(fxmlFile);
			e.printStackTrace();
		}
	}

	private void setSplashScreen()
	{
		getChildren().add(0, getScreen("splash"));
		this.screenController = getController("splash");
		this.screenController.init();
	}

	public void setScreen(String name)
	{
		getChildren().remove(0);
		getChildren().add(0, getScreen(name));
		this.screenController = getController(name);
		this.screenController.init();
	}
	
	public void setListening(Boolean isListening)
	{
		this.screenController.setListening(isListening);
	}

}
