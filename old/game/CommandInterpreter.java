package jMoria.game;

import java.util.Queue;

import jMoria.game.enums.Screens;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/*
 * 
 */
public class CommandInterpreter
{

	private Queue<KeyCode> cmdQueue;
	private Screens currentState;
	
	public CommandInterpreter()
	{}
	
	public void setState(Screens s)
	{
		this.currentState = s;
	}
	
	public void receiveEvent(KeyEvent k)
	{
		
	}
	
	public void addToQueue(KeyCode k)
	{
		
	}
	
	public void getNextCmd(KeyCode k)
	{
		
	}
	
	public void flushCmdQueue()
	{
	}
	
	
}
