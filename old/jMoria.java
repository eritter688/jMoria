package jMoria;

import javafx.application.Application;
import javafx.stage.Stage;

public class jMoria extends Application
{
	public static String name = "jMoria";
	public static String version = "0.0";

	public static jMoria instance = null;

	private SceneManager sceneManager;
	private ASCIILoader asciiLoader;

	
	public static void main(String[] args)
	{
		Application.launch(args);
	}

	public jMoria()
	{
		instance = this;
	}

	public static jMoria getInstance()
	{
		return instance;
	}
	
	@Override
	public void init()
	{
		Debug.dString("Init: Begin");
		try
		{
			Debug.dString("Load SceneManager");
			this.sceneManager = new SceneManager();
			
			Debug.dString("Load ASCIILoader");
			this.asciiLoader = new ASCIILoader();			
		} 
		catch (Exception e)
		{
			Debug.dString("Init: Failed...");
			e.printStackTrace();
		}
		Debug.dString("Init: Complete");
	}

	@Override
	public void start(Stage primaryStage)
	{
		Debug.dString("Start: Begin");

		this.sceneManager.init(primaryStage);

		Debug.dString("Start: Complete");
	}

	@Override
	public void stop()
	{
		Debug.dString("Stop: Begin");
		
		this.asciiLoader = null;
		this.sceneManager = null;
		
		Debug.dString("Stop: Complete");
		
		Debug.dString("Goodbye");
	}
	
	public ASCIILoader getAsciiLoader()
	{
		return this.asciiLoader;
	}
		
	public SceneManager getSceneManager()
	{
		return this.sceneManager;
	}
	
}
