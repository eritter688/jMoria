package jMoria.game.enums;

public enum Classes
{
	Warrior("Warrior"),
	Mage("Mage"),
	Priest("Priest"),
	Rogue("Rogue"),
	Ranger("Ranger"),
	Paladin("Paladin");

	String playerClass;
	
	Classes(String playerClass)
	{
		this.playerClass = playerClass;
	}
	
	String showPlayerClass()
	{
		return playerClass;
	}

}
