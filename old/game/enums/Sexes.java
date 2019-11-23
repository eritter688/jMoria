package jMoria.game.enums;

public enum Sexes
{
	Female("Female"),
	Male("Male");
	
	String sex;
	
	Sexes(String sex)
	{
		this.sex = sex;
	}
	
	String showSex()
	{
		return sex;
	}
	
}
