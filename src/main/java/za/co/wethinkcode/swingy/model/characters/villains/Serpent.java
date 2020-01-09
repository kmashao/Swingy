package za.co.wethinkcode.swingy.model.characters.villains;

import za.co.wethinkcode.swingy.model.characters.Hero;
import za.co.wethinkcode.swingy.model.characters.HeroBuild;

public class Serpent implements HeroBuild {
	private Hero serpent;
	public Serpent(){
		this.serpent = new Hero();
		this.serpent.setName("Slither");
	}
	@Override
	public void heroClass() {
	serpent.setClass("Serpent");
	}

	@Override
	public void heroLevel() {
	serpent.setLevel(1);
	}

	@Override
	public void heroExperience() {
	serpent.setExperience(900);
	}

	@Override
	public void heroAttack() {
	serpent.setAttack(130);
	}

	@Override
	public void heroDefense() {
	serpent.setDefense(100);
	}

	@Override
	public void heroHitPoints() {
	serpent.setHitPoints(250);
	}

	@Override
	public Hero getHero() {
		return serpent;
	}
}
