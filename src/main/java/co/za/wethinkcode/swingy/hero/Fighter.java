package co.za.wethinkcode.swingy.hero;

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
		hero.setClass("Fighter");
	}

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
		hero.setHitPoints(200);
	}

	public Hero getHero() {
		return hero;
	}
}
