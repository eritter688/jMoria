package jMoria.controller;

import jMoria.Terminal;
import jMoria.game.CommandInterpreter;
import jMoria.game.EditableTerminal;
import jMoria.game.Game;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.TextFlow;


public class GameController extends AbstractControllerTemplate
{
	
	@FXML
	private TextFlow gameArea;
	
	private Terminal t;

	@Override
	public void setContent()
	{
		t = new Terminal(gameArea);
		
		// TODO
		// this is testing only
		Game game = new Game((EditableTerminal)t);
		game.newGame();
	}

	@Override
	public void handleKeys(KeyEvent e)
	{
		if(super.isListening() == false)
			return;
		
		// TODO
		// need a hook here to go back to main menu

		t.receiveInput(e);
	}
	
}
