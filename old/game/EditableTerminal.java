package jMoria.game;

import jMoria.game.enums.Screens;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public interface EditableTerminal
{	
	public void setGame(Game game);
	
	public Game getGame();

	public void setScreenID(Screens ID);
	
	public Screens getScreenID();
	
	public void setColor(Color c);
	
	public Color getColor();
	
	public void setFont(Font f);
	
	public Font getFont();
	
	
	public void receiveInput(KeyEvent e);

	
	public void clearScreen();
	
	public void clearRow(int row);
		
	public void clearRect(int fromRow, int fromCol, int toRow, int toCol);


	public void moveCursor(int row, int col);
	
	
	public void print(String s);
	
	public void parsePrint(String s);

	
	public void printRect(int fromRow, int fromCol, int toRow, int toCol);
	
	public void parsePrintRect(int fromRow, int fromCol, int toRow, int toCol);
}
