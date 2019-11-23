package jMoria.game.enums;

public enum Races
{
	Human("Human"),
	HalfElf("Half-Elf"),
	Elf("Elf"),
	Halfling("Halfling"),
	Gnome("Gnome"),
	Dwarf("Dwarf"),
	HalfOrc("Half-Orc"),
	HalfTroll("Half-Troll");
	
	String race;
	
	Races(String race)
	{
		this.race = race;
	}
	
	public String getRace()
	{
		return race;
	}

}
