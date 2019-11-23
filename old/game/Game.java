package jMoria.game;

import java.io.File;

import javafx.scene.input.KeyEvent;

public class Game
{
	public static Game instance = null;
	public EditableTerminal terminal = null;

	public CommandInterpreter command = null;
	
	public Player player = null;
	//public Town town;
	//public Dungeon dungeon;
	
	
	public Game(EditableTerminal t)
	{
		Game.instance = this;

		t.setGame(this);
		this.terminal = t;
		
		init();
	}
	
	public static Game getInstance()
	{
		return instance;
	}
	
	public void init()
	{
		//load things
		this.command = new CommandInterpreter();
	}
	
	public EditableTerminal getTerminal()
	{
		return this.terminal;
	}
	
	public CommandInterpreter getCommandInterpreter()
	{
		return this.command;
	}
	
	public void newGame()
	{
		// create new character
		this.player = new Player();
		CharacterCreator creator = new CharacterCreator(this.player);
		//Town town = new Town();
		//Dungeon dungeon = new Dungeon();
		
		// dump him into town
		
		// go to the game loop
		gameLoop();
	}

	public void loadGame(File saveFile)
	{}

	private void saveGame()
	{}

	private void gameLoop()
	{}
	
	private void shutdown()
	{}
	
	public void receiveInput(KeyEvent e)
	{
		command.receiveEvent(e);
	}
	
}
