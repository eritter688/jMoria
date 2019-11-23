package jMoria;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import jMoria.game.EditableTerminal;
import jMoria.game.Game;
import jMoria.game.enums.Screens;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Terminal implements EditableTerminal {

	private Game game;
	private Screens ID;
	
	private Color color = Color.WHITE;
	private Font font = Font.font("Monospaced", 14);
	
	private Point2D cursorLocation;
	private int cursorIndex;
	
	private TextFlow fxGameWindow;
	private List<Node> nodes = new ArrayList(2025);
	
	public Terminal(TextFlow gameArea)
	{
		initialize(gameArea);
	}
	
	// 80 cols * 25 rows = 2000
	// plus end of line markers = 2025
	public void initialize(TextFlow gameArea)
	{
		this.fxGameWindow = gameArea;
		
		for (int i = 0; i < 2025; i++)
		{
			Text t = new Text();
			t.setFill(color);
			t.setFont(font);
			t.setText(" ");
			/*
			 * may need to add fixed dimensions to text
			 * will see with testing
			 */
			nodes.add(t);
		}
		setLineEnders();
				
		gameArea.getChildren().addAll(nodes);
	}

	@Override
	public void setGame(Game game)
	{
		this.game = game;
	}
	
	@Override
	public Game getGame()
	{
		return this.game;
	}
	
	@Override
	public void setScreenID(Screens ID)
	{
		this.ID = ID;
	}

	@Override
	public Screens getScreenID()
	{
		return this.ID;
	}

	@Override
	public void setColor(Color c)
	{
		this.color = c;
	}

	@Override
	public Color getColor()
	{
		return this.color;
	}

	@Override
	public void setFont(Font f)
	{
		this.font = f;
	}

	@Override
	public Font getFont()
	{
		return this.font;
	}
	
	@Override
	public void receiveInput(KeyEvent e)
	{
		game.receiveInput(e);
	}

	@Override
	public void clearScreen()
	{
		for (int i = 0; i < 2025; i++)
		{
				((Text) nodes.get(i)).setText(" ");
		}
		setLineEnders();
	}

	@Override
	public void clearRow(int row)
	{
		// TODO Auto-generated method stub
		// dont need this yet
		moveCursor(row, 0);
		ListIterator<Node> listIterator = nodes.listIterator(cursorIndex);
		
		for (int i = 0; i < 80; i++)
		{
			Text t = (Text)listIterator.next();
			t.setText(" ");
		}
		
		
	}

	@Override
	public void clearRect(int fromRow, int fromCol, int toRow, int toCol)
	{
		// TODO Auto-generated method stub
		// dont need this yet
		
	}

	@Override
	public void moveCursor(int row, int col)
	{
		Point2D p = new Point2D(col, row);
		this.cursorLocation = p;
		this.cursorIndex = calculateCursorIndex(p);
	}

	@Override
	public void print(String s)
	{
		ListIterator<Node> listIterator = nodes.listIterator(cursorIndex);

		int len = s.length();
		for (int i = 0; i < len; i++)
		{
			Text t = (Text)listIterator.next();
			t.setText(String.valueOf(s.charAt(i)));
		}
	}

	@Override
	public void parsePrint(String s)
	{
		// TODO Auto-generated method stub
		// dont need this yet
		
	}

	@Override
	public void printRect(int fromRow, int fromCol, int toRow, int toCol)
	{
		// TODO Auto-generated method stub
		// dont need this yet
		
	}

	@Override
	public void parsePrintRect(int fromRow, int fromCol, int toRow, int toCol)
	{
		// TODO Auto-generated method stub
		
	}
	
	private int calculateCursorIndex(Point2D p)
	{
		int x = (int)p.getX(); //column
		int y = (int)p.getY(); //row
		
		return (y*81)+x;  //I think this should do it. 
	}

	 /*
	 80: 0 			1052: 0
	 161: 0 		1133: 0
	 242: 0 		1214: 0
	 323: 0 		1295: 0
	 404: 0 		1376: 0
	 485: 0 		1457: 0
	 566: 0 		1538: 0
	 647: 0 		1619: 0
	 728: 0 		1700: 0
	 809: 0 		1781: 0
	 890: 0 		1862: 0
	 971: 0 		1943: 0
	 1052: 0 		2024: 0
	*/
	// (i+1)%81
	/*
	 * this is great and all being hardcoded it saves
	 * 2025 comparisons. I dont like it. I should
	 * do the calculations once during initialization
	 * and then save these values into their own list
	 * then the below will iterate over that list for indices
	 * 
	 */
	private void setLineEnders()
	{
		((Text) nodes.get(80)).setText("\n");
		((Text) nodes.get(161)).setText("\n");
		((Text) nodes.get(242)).setText("\n");
		((Text) nodes.get(323)).setText("\n");
		((Text) nodes.get(404)).setText("\n");
		((Text) nodes.get(485)).setText("\n");
		((Text) nodes.get(566)).setText("\n");
		((Text) nodes.get(647)).setText("\n");
		((Text) nodes.get(728)).setText("\n");
		((Text) nodes.get(809)).setText("\n");
		((Text) nodes.get(890)).setText("\n");
		((Text) nodes.get(971)).setText("\n");
		((Text) nodes.get(1052)).setText("\n");
		((Text) nodes.get(1133)).setText("\n");
		((Text) nodes.get(1214)).setText("\n");
		((Text) nodes.get(1295)).setText("\n");
		((Text) nodes.get(1376)).setText("\n");
		((Text) nodes.get(1457)).setText("\n");
		((Text) nodes.get(1538)).setText("\n");
		((Text) nodes.get(1619)).setText("\n");
		((Text) nodes.get(1700)).setText("\n");
		((Text) nodes.get(1781)).setText("\n");
		((Text) nodes.get(1862)).setText("\n");
		((Text) nodes.get(1943)).setText("\n");
		//2024 is probably redundant
		((Text) nodes.get(2024)).setText("\n");
	}


}
