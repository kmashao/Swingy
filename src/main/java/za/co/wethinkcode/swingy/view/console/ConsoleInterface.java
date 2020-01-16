package za.co.wethinkcode.swingy.view.console;

import za.co.wethinkcode.swingy.Main;
import za.co.wethinkcode.swingy.control.Maps;
import za.co.wethinkcode.swingy.database.dbMethods;
import za.co.wethinkcode.swingy.model.characters.Hero;
import za.co.wethinkcode.swingy.model.characters.HeroBuild;
import za.co.wethinkcode.swingy.model.characters.HeroCreator;
import za.co.wethinkcode.swingy.model.characters.Validators;
import za.co.wethinkcode.swingy.model.characters.heroes.Fighter;
import za.co.wethinkcode.swingy.model.characters.heroes.Mage;
import za.co.wethinkcode.swingy.model.characters.heroes.Witcher;
import za.co.wethinkcode.swingy.model.characters.villains.*;
import za.co.wethinkcode.swingy.view.Display;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static org.hibernate.internal.util.collections.CollectionHelper.isEmpty;

public class ConsoleInterface implements Display {

	private Hero hero = null;
	private int exp;


	public void DisplayStart() {

		System.out.println(
					  "\n****************************************\n" +
						"*                                      *\n" +
						"*          WELCOME TO THE GAME         *\n" +
						"*                                      *\n" +
						"****************************************\n");

	}

	public void DisplayLoad() {
		System.out.println(
					  "\n****************************************\n" +
						"*                                      *\n" +
						"*          Choose an option            *\n" +
						"*                                      *\n" +
						"*          1. Load saved hero          *\n" +
						"*          2. Create new hero          *\n" +
						"*                                      *\n" +
						"****************************************\n");
	}

	public void DisplayHeroSelect() {

		int heroClass = 0;
		String name_ = null;
		HeroCreator heroCreator = null;


		Scanner scan = null;
		boolean invalid = true;
		while (invalid){
		try {
			scan = Main.getScanner();
			System.out.println("Enter your hero's name");
			name_ = scan.nextLine();
			System.out.println("Select a number to choose class\n" +
					"   Class       Attack      Defense     HP\n" +
					"1. Witcher     150         120         250\n" +
					"2. Mage        110         115         250\n" +
					"3. Fighter     140         95          300\n");
			if (!scan.hasNextInt())
				throw new Exception();
			heroClass = scan.nextInt();
			scan.nextLine();
			if ((heroClass < 1) || (heroClass > 3))
				throw new Exception();
		} catch (Exception e) {
			System.out.println("\nERROR\nInput should be 1, 2 or 3.");
			if (scan != null)
				scan.close();
			System.exit(1);
		} finally {
			if (heroClass == 1) {
				HeroBuild witcher = new Witcher(name_);
				heroCreator = new HeroCreator(witcher);
			} else if (heroClass == 2) {
				HeroBuild fighter = new Fighter(name_);
				heroCreator = new HeroCreator(fighter);
			} else if (heroClass == 3) {
				HeroBuild mage = new Mage(name_);
				heroCreator = new HeroCreator(mage);
			}

			assert heroCreator != null;
			heroCreator.createHero();
			hero = heroCreator.getHero();
		}
		invalid = validate(hero);
		}
	}

	private boolean validate(Hero hero_){

		dbMethods dbData = new dbMethods();
		Validators validate = new Validators();
		Validator validator = validate.validator();

		Set<ConstraintViolation<Hero>> violations = validator.validate(hero);
		if (!isEmpty(violations))
		{
			for (ConstraintViolation<Hero> violation : violations)
			{
				System.out.println(violation.getMessage());
			}
			return true;
		}
		else
		{
			dbData.addHero(hero_.getHeroName(), hero_.getHeroClass(), hero_.getHeroLevel(), hero_.getExperience(),
					hero_.getHitPoints(), hero_.getAttack(), hero_.getDefense());
			System.out.println("Hero Created");
			return false;
		}
	}

	@Override
	public void DisplayStats(Hero hero) {
		System.out.println("Stats are:");

		System.out.println("Name: " + hero.getHeroName());

		System.out.println("Class: " + hero.getHeroClass());

		System.out.println("Level: " + hero.getHeroLevel());

		System.out.println("Exp: " + hero.getExperience());

		System.out.println("Attack: " + hero.getAttack());

		System.out.println("Defense: " + hero.getDefense());

		System.out.println("HP: " + hero.getHitPoints());
	}

	public void run() {

		dbMethods dbMethods = new dbMethods();
		String status;
		String direction;
		Scanner sc;

		sc = Main.getScanner();
		this.DisplayStart();
		this.hero = this.DisplaySave();
		Maps map = new Maps(this.hero);

		while (true) {

			System.out.println("Choose a direction (N - north, S - south, E - east, W - west) : ");
			direction = sc.nextLine();

			if (map.metVill(direction))
			{
				if (ThreadLocalRandom.current().nextInt(0,10) <= 7)
				{
					if (metVillain())
					{
						System.out.println("you lost");
						break;
					}
					else
					{
						System.out.println("you won");
						System.out.println("Exp gained: " + exp);
						dbMethods.updateHero(this.hero.getHeroName(),this.hero.getHeroLevel(),this.hero.getExperience() + exp,this.hero.getHitPoints() + 15,
								this.hero.getAttack(),this.hero.getDefense());
					}
				}
				else
					System.out.println("Someone is lucky, you avoided the villain");
			}

			status = map.move(direction);

			if (status.equals("END"))
			{
				System.out.println("You finished the game gg");
				break;
			}
		}
	}


	@Override
	public Hero DisplaySave() {

		int load, heroChoice;
		dbMethods dbData = new dbMethods();
		Scanner scan;
		DisplayLoad();

		try {
			scan = Main.getScanner();
			load = scan.nextInt();
			scan.nextLine();

			while (load < 1 || load > 2)
			{
				System.out.println("invalid choice choose 1 or 2");
				load = scan.nextInt();
				scan.nextLine();
			}
			switch (load) {
				case 1:

					System.out.println("choose a hero by typing their id");
					dbData.selectAll();

					while (!scan.hasNextInt()){
						System.out.println("invalid choice pick a hero ID");
						scan.nextLine();
						}

					heroChoice = scan.nextInt();
					scan.nextLine();
					this.hero = dbData.getHerodb(heroChoice);
					break;

				case 2:
					DisplayHeroSelect();
					break;
			}
			System.out.println("this is your Hero");
			dbData.selectHero(this.hero.getHeroName());

			return this.hero;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}

	private Hero createVillain() {

		Hero villain;
		HeroCreator heroCreator = null;
		String[] villains = new String[]{"Serpent", "Goblin", "Beserker", "Wolf", "Panther"};
		String type = villains[ThreadLocalRandom.current().nextInt(villains.length)];
		switch (type){
			case "Serpent":
				HeroBuild serpent = new Serpent();
		 		heroCreator = new HeroCreator(serpent);
				break;
			case "Goblin":
				HeroBuild goblin = new Goblin();
				heroCreator = new HeroCreator(goblin);
				break;
			case  "Beserker":
				HeroBuild beserker = new Beserker();
				heroCreator = new HeroCreator(beserker);
				break;
			case "Panther":
				HeroBuild panther = new Panther();
				heroCreator = new HeroCreator(panther);
				break;
			case "Wolf":
				HeroBuild wolf = new Wolf();
				heroCreator = new HeroCreator(wolf);
				break;
			default:
				System.out.println("failed to create villain");
				break;

		}
		assert heroCreator != null;
		heroCreator.createHero();
		villain = heroCreator.getHero();
		System.out.println("This is your Enemy");
		DisplayStats(villain);
		return villain;
	}

	private boolean metVillain() {

		boolean result = false;
		Hero villain;
		villain = createVillain();
		exp = villain.getExperience();
		attacks(villain);
		boolean Fight = fightOrFlight(villain);
		while (Fight) {
			attacks(villain);
			Fight = fightOrFlight(villain);
		}
		if (this.hero.getHitPoints() <= 0 && (villain.getHitPoints() > 0))
			result = true;
		return result;
	}

	private void attacks(Hero enemy) {
		System.out.println("hero hp: " + this.hero.getHitPoints() + "\n");
		System.out.println("enemy hp: " + enemy.getHitPoints() + "\n");

		if (ThreadLocalRandom.current().nextInt(0, 10) >= 4){
			if (this.hero.getAttack() > enemy.getDefense())
			{
				enemy.setHitPoints(enemy.getHitPoints() - (this.hero.getAttack() - enemy.getDefense()));
				System.out.println(this.hero.getAttack());
				System.out.println(this.hero.getHeroName() + " hit " + enemy.getHeroName() +" 1\n");
			}
			else if (ThreadLocalRandom.current().nextInt(0, 10) <= 3)
			{
				enemy.setHitPoints(enemy.getHitPoints() - this.hero.getAttack());
				System.out.println(this.hero.getHeroName() + " hit " + enemy.getHeroName() + " 2\n");
			}
		}
		else {
			if (enemy.getAttack() > this.hero.getDefense())
			{
				this.hero.setHitPoints(this.hero.getHitPoints() - (enemy.getAttack() - this.hero.getDefense()));
				System.out.println(enemy.getAttack());
				System.out.println(enemy.getHeroName() + "hit" + this.hero.getHeroName() + " 1\n");
			}
			else if (ThreadLocalRandom.current().nextInt(0, 10) <= 2)
			{
				this.hero.setHitPoints(this.hero.getHitPoints() - enemy.getAttack());
				System.out.println(enemy.getHeroName() + " hit " + this.hero.getHeroName() + " 2\n");
			}
		}

		System.out.println("hero hp: " + this.hero.getHitPoints() + "\n");
		System.out.println("enemy hp: " + enemy.getHitPoints() + "\n");
	}

	private boolean fightOrFlight(Hero enemy) {
		while (enemy.getHitPoints() > 0 && this.hero.getHitPoints() > 0) {
			attacks(enemy);
		}
		return this.hero.getHitPoints() > 0 && enemy.getHitPoints() > 0;
	}
}
