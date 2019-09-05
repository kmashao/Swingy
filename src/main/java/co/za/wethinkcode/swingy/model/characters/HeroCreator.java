package co.za.wethinkcode.swingy.model.characters;

public class HeroCreator {

	private HeroBuild heroBuild;

	public HeroCreator(HeroBuild heroBuild) {
		this.heroBuild = heroBuild;
	}

	public Hero getHero() {
		return this.heroBuild.getHero();
	}

	public void createHero() {

		//this.heroBuild.heroName();

		this.heroBuild.heroClass();

		this.heroBuild.heroLevel();

		this.heroBuild.heroExperience();

		this.heroBuild.heroAttack();

		this.heroBuild.heroDefense();

		this.heroBuild.heroHitPoints();

	}

}