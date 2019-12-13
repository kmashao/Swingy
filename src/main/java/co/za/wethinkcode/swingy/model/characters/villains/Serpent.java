package co.za.wethinkcode.swingy.model.characters.villains;

import co.za.wethinkcode.swingy.model.characters.Hero;
import co.za.wethinkcode.swingy.model.characters.HeroBuild;

public class Serpent implements HeroBuild {
	private Hero serpent;
	public Serpent(){
		this.serpent = new Hero();
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
	serpent.setAttack(85);
	}

	@Override
	public void heroDefense() {
	serpent.setDefense(70);
	}

	@Override
	public void heroHitPoints() {
	serpent.setHitPoints(130);
	}

	@Override
	public Hero getHero() {
		return serpent;
	}
}
