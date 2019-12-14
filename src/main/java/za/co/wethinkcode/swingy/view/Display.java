package za.co.wethinkcode.swingy.view;

import za.co.wethinkcode.swingy.model.characters.Hero;

public interface Display{
	public void DisplayStart();
	public void DisplayHeroSelect();
	public void DisplayStats(Hero hero);
	public Hero DisplaySave();
	public void DisplayLoad();
	public void run();
}