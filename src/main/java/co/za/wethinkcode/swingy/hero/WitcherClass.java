package co.za.wethinkcode.swingy.hero;

public class WitcherClass implements HeroBuild {

	private Hero hero;


	public WitcherClass() {
		this.hero = new Hero();

	}

	@Override
	public void heroName() {

		hero.setName("Geralt");
	}

	@Override
	public void heroClass() {

		hero.setClass("Witcher");

	}

	@Override
	public void heroLevel() {

		hero.setLevel(5);
	}

	@Override
	public void heroExperience() {

		hero.setExperience();
	}

	@Override
	public void heroAttack() {

		hero.setAttack(50);
	}

	@Override
	public void heroDefense() {

		hero.setDefense(90);
	}

	@Override
	public void heroHitPoints() {

		hero.setHitPoints(250);
	}

	public Hero getHero() {
		return this.hero;
	}

}