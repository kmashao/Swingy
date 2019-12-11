package co.za.wethinkcode.swingy.model.characters.heroes;

import co.za.wethinkcode.swingy.model.characters.Hero;
import co.za.wethinkcode.swingy.model.characters.HeroBuild;

public class Witcher implements HeroBuild {

	private Hero hero;

	public Witcher(String name) {
		this.hero = new Hero();
		hero.setName(name);
		hero.setSymbol('H');
	}

	public void heroClass() {
		hero.setClass("Witcher");
	}

	public void heroLevel() { hero.setLevel(1); }

	public void heroExperience() {
		hero.setExperience(1000);
	}

	public void heroAttack() {
		hero.setAttack(120);
	}

	public void heroDefense() {
		hero.setDefense(50);
	}

	public void heroHitPoints() {
		hero.setHitPoints(150);
	}

	public Hero getHero() {
		return hero;
	}
}
