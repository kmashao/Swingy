package za.co.wethinkcode.swingy.model.characters.heroes;

import za.co.wethinkcode.swingy.model.characters.Hero;
import za.co.wethinkcode.swingy.model.characters.HeroBuild;

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
		hero.setAttack(110);
	}

	public void heroDefense() {
		hero.setDefense(115);
	}

	public void heroHitPoints() {
		hero.setHitPoints(280);
	}

	public Hero getHero() {
		return this.hero;
	}
}
