package za.co.wethinkcode.swingy.model.characters.heroes;

import za.co.wethinkcode.swingy.model.characters.Hero;
import za.co.wethinkcode.swingy.model.characters.HeroBuild;

public class Fighter implements HeroBuild {

	private Hero hero;

	public Fighter(String name){
		this.hero = new Hero();
		hero.setName(name);
	}

	public void heroClass() {
		hero.setClass("Fighter");
	}

	public void heroLevel() {
		hero.setLevel(1);
	}

	public void heroExperience() {
		hero.setExperience(1000);
	}

	public void heroAttack() {
		hero.setAttack(140);
	}

	public void heroDefense() {
		hero.setDefense(95);
	}

	public void heroHitPoints() {
		hero.setHitPoints(310);
	}

	public Hero getHero() {
		return hero;
	}
}
