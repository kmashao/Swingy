package co.za.wethinkcode.swingy.model.characters.heroes;

import co.za.wethinkcode.swingy.model.characters.Hero;
import co.za.wethinkcode.swingy.model.characters.HeroBuild;

public class Mage implements HeroBuild {

	private Hero hero;

	public Mage(String name){
		this.hero = new Hero();
		hero.setName(name);
	}

	public void heroClass() {
		hero.setClass("Mage");
	}

	public void heroLevel() { hero.setLevel(1); }

	public void heroExperience() {
		hero.setExperience(1000);
	}

	public void heroAttack() {
		hero.setAttack(75);
	}

	public void heroDefense() {
		hero.setDefense(100);
	}

	public void heroHitPoints() {
		hero.setHitPoints(50);
	}

	public Hero getHero() {
		return this.hero;
	}
}
