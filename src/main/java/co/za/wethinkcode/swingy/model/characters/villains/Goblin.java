package co.za.wethinkcode.swingy.model.characters.villains;

import co.za.wethinkcode.swingy.model.characters.Hero;
import co.za.wethinkcode.swingy.model.characters.HeroBuild;

public class Goblin implements HeroBuild {

	private Hero goblin;

	public Goblin(){
		this.goblin = new Hero();
	}

	public void heroClass() {
	goblin.setClass("Goblin");
	}

	public void heroLevel() {
	goblin.setLevel(1);
	}

	public void heroExperience() {
	goblin.setExperience(650);
	}

	public void heroAttack() {
	goblin.setAttack(80);
	}

	public void heroDefense() {
	goblin.setDefense(40);
	}

	public void heroHitPoints() {
	goblin.setHitPoints(95);
	}

	public Hero getHero() {
		return goblin;
	}
}
