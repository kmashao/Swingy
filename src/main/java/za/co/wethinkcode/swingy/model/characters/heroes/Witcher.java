package za.co.wethinkcode.swingy.model.characters.heroes;

import za.co.wethinkcode.swingy.model.characters.Hero;
import za.co.wethinkcode.swingy.model.characters.HeroBuild;

public class Witcher implements HeroBuild {

	private Hero hero;

	public Witcher(String name) {
		this.hero = new Hero();
		hero.setName(name);
	}

	public void heroClass() {
		hero.setClass("Witcher");
	}

	public void heroLevel() { hero.setLevel(1); }

	public void heroExperience() {
		hero.setExperience(1000);
	}

	public void heroAttack() {
		hero.setAttack(150);
	}

	public void heroDefense() {
		hero.setDefense(120);
	}

	public void heroHitPoints() {
		hero.setHitPoints(270);
	}

	public Hero getHero() {
		return hero;
	}
}
