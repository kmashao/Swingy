package co.za.wethinkcode.swingy.model.characters;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class HeroClasses implements HeroBuild {

	private Hero hero;

	@Min(value = 1, message = "Value must not be less than 1")
	@Max(value = 3, message = "Value must not be greater than 3")
	private int heroClass_;

	public HeroClasses(String name_, int class_) {
		this.hero = new Hero();
		this.hero.setName(name_);
		heroClass_ = class_;

	}


	/*@Override
	public void heroName() {

		hero.setName("Geralt");
	}*/

	@Override
	public void heroClass() throws NumberFormatException {

		switch(heroClass_) {

			case 1 :
				hero.setClass("Witcher");
				break;
			case 2 :
				hero.setClass("Mage");
				break;
			case 3 :
				hero.setClass("Fighter");
				break;
			default : throw new NumberFormatException(heroClass_ + " is not a valid class pick a correct number");


		}

	}

	@Override
	public void heroLevel() {

		hero.setLevel(1);
	}

	@Override
	public void heroExperience() {

		int xp = hero.getHeroLevel();
		hero.setExperience((xp * 1000)+((xp - 1)*(xp - 1)) *450);
	}

	@Override
	public void heroAttack(){
		switch (heroClass_){
			case 1 :
				hero.setAttack(30 * hero.getHeroLevel());
				break;

			case 2 :
				hero.setAttack(45 * hero.getHeroLevel());
				break;
			case 3 :
				hero.setAttack(55 * hero.getHeroLevel());
				break;

			default : System.out.println();
		}
	}

	@Override
	public void heroDefense(){

		switch (heroClass_) {
			case 1:
				hero.setDefense(15 * hero.getHeroLevel());
				break;

			case 2:
				hero.setDefense(10 * hero.getHeroLevel());
				break;
			case 3:
				hero.setDefense(13 * hero.getHeroLevel());
				break;

			default: System.out.println();

		}
	}

	@Override
	public void heroHitPoints(){

		switch (heroClass_) {
			case 1 :
				hero.setHitPoints(110 * hero.getHeroLevel());
				break;

			case 2 :
				hero.setHitPoints(90 * hero.getHeroLevel());
				break;
			case 3 :
				hero.setHitPoints(145 * hero.getHeroLevel());
				break;

			default: System.out.println();

		}
	}

	public Hero getHero() {
		return this.hero;
	}

}