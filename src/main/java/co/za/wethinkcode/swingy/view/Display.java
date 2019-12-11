package co.za.wethinkcode.swingy.view;

import co.za.wethinkcode.swingy.model.characters.Hero;

public interface Display{
	public void DisplayStart();
	public void DisplayHeroSelect();
	public void DisplayHeroName();
	public void DisplayStats(Hero hero);
	public Hero DisplaySave();
	public void DisplayLoad();
	public void run();
}