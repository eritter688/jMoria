package jMoria.game;

import jMoria.Terminal;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyEvent;

public class CharacterCreator
{
	private Player p;
	private EditableTerminal t;
	private CommandInterpreter c;
	
	public CharacterCreator(Player p)
	{
		this.p = p;
		t = Game.getInstance().getTerminal();
		c = Game.getInstance().getCommandInterpreter();
		create();
	}
	
	private void create()
	{
		drawRaceSelect();
		
		
		
		
		
		/*
		drawSexSelect();
		drawStatsSelect();
		drawClassSelect();
		*/
	}
	
	/*
	 * Race Selection
	 * 
	 */
	private void drawRaceSelect()
	{
		t.moveCursor(2, 1); t.print("Name       :");
		t.moveCursor(3, 1); t.print("Race       :");
		t.moveCursor(4, 1); t.print("Sex        :");
		t.moveCursor(5, 1); t.print("Class      :");

		t.moveCursor(20, 1); t.print("Choose a race: _");
		t.moveCursor(21, 1); t.print("a) Human     b) Half-Elf     c) Elf          d) Halfling     e) Gnome");
		t.moveCursor(22, 1); t.print("f) Dwarf     g) Half-Orc     h) Half-Troll");
	}
	
	public void doRaceSelect(KeyEvent e)
	{
		//accept input
		//check a-h
		//store on player
		//move forward on success
		String key = e.getCharacter();
		switch(key)
		{
		case "a":
		case "A":
		{
			
		}
		case "b":
		case "B":
		{
			
		}
		case "c":
		case "C":
		{
			
		}
		case "d":
		case "D":
		case "e":
		case "E":
		case "f":
		case "F":
		case "g":
		case "G":
		case "h":
		case "H":

		}
	}
	
	
	/*
	 * Sex Selection
	 * 
	 */
	private void drawSexSelect()
	{
		t.moveCursor(3, 14);
		// TODO pull val from enum
		String race = p.race.getRace();
		t.print(race);
		
		t.clearRow(20);
		t.clearRow(21);
		t.clearRow(22);
		
		t.moveCursor(20, 1); t.print("Choose a sex: _");
		t.moveCursor(21, 1); t.print("m) Male      f) Female");
	}
	
	public void doSexSelect(KeyEvent e)
	{
		//accept input
		//check m/f
		//store on player
		//move forward on success		
	}
	
	/*
	 * Stat Selection
	 * 
	 */
	private void drawStatsSelect()
	{
		t.clearRow(20);
		t.clearRow(21);
		
		t.moveCursor(2, 40); t.print("Age          :          STR :");
		t.moveCursor(3, 40); t.print("Height       :          INT :");
		t.moveCursor(4, 40); t.print("Weight       :          WIS :");
		t.moveCursor(5, 40); t.print("Social Class :          DEX :");
		t.moveCursor(6, 40); t.print("                        CON :");
		t.moveCursor(7, 40); t.print("                        CHR :");

		
		t.moveCursor(9, 1);  t.print("+ To Hit    :");
		t.moveCursor(10, 1); t.print("+ To Damage :");
		t.moveCursor(11, 1); t.print("+ To AC     :");
		t.moveCursor(12, 1); t.print("  Total AC  :");
		
		t.moveCursor(14, 25); t.print("Character Background");
		
		t.moveCursor(20, 1); t.print("Hit space to reroll or ESC to accept characteristics: _");
		
	}

	private void drawStats()
	{
		//output the generated stats to screen
	}
	
	public void doStatsSelect(KeyEvent e)
	{
		//accept input
		//check space/esc
		//store on player
		//move forward on success				
	}
	
	
	/*
	 * Class Selection
	 * 
	 */
	private void drawClassSelect()
	{
		t.clearRow(20);
		
		t.moveCursor(20, 1); t.print("Choose a class: _");
		t.moveCursor(21, 1); t.print("a) Warrior   b) Mage      c) Priest    d) Rogue     e) Ranger");
		t.moveCursor(22, 1); t.print("f) Paladin");

	}
	
	public void doClassSelect(KeyEvent e)
	{
		//accept input
		//check a-f
		//store on player
		//move forward on success
	}
	
	
	/*
	 * Name Selection
	 * 
	 */
	private void drawNameSelect()
	{}

	public void doNameSelect(KeyEvent e)
	{
		//accept input
		//let the character enter a name
		//store on player
		//move forward on success
	}
	
	
	/*
	 * Character Creation Completed
	 * Go forth and slay!
	 * 
	 */
	
	private void done()
	{
		
	}
	
	
}

/*
	// TESTING //
	
	public void boundaryTest()
	{
		t.moveCursor(0, 0);
		t.print("A");
		t.moveCursor(24, 0);
		t.print("A");
		
		t.moveCursor(0, 79);
		t.print("A");
		t.moveCursor(24, 79);
		t.print("A");
	}
*/
