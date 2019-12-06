package co.za.wethinkcode.swingy.view.console;

import co.za.wethinkcode.swingy.Main;
import co.za.wethinkcode.swingy.database.dbMethods;
import co.za.wethinkcode.swingy.map.Maps;
import co.za.wethinkcode.swingy.model.characters.Hero;
import co.za.wethinkcode.swingy.model.characters.HeroBuild;
import co.za.wethinkcode.swingy.model.characters.HeroCreator;
import co.za.wethinkcode.swingy.model.characters.heroes.Fighter;
import co.za.wethinkcode.swingy.model.characters.heroes.Mage;
import co.za.wethinkcode.swingy.model.characters.heroes.Witcher;
import co.za.wethinkcode.swingy.view.Display;

import java.util.Scanner;

public class ConsoleInterface implements Display {
	
	private Hero hero = null;


	public void DisplayStart() {

		System.out.println(
						"\n/****************************************\n" +
						"*										*\n" +
						"*            WELCOME TO THE GAME		*\n" +
						"*										*\n" +
						"*****************************************/\n");

	}

	public void DisplayLoad(){
		System.out.println(
				"\n/********************************************\n" +
						"*											*\n" +
						"*			Choose an option				*\n" +
						"*											*\n" +
						"*			1. Load saved hero				*\n" +
						"*			2. Create new hero				*\n" +
						"********************************************/\n");
	}

	public void DisplayHeroSelect() {
		
		int heroClass = 0;
		String name_ = null;
		HeroCreator heroCreator = null;
		dbMethods dbData = new dbMethods();
	//	Validators validate = new Validators();
	//	Validator validator = validate.validator();
		
		Scanner scan = null;
		try {
			scan = Main.getScanner();
			System.out.println("Enter your hero's name");
			name_ = scan.nextLine();
			System.out.println("Select a number to choose class\n" +
					"   Class       Attack      Defense     HP\n" +
					"1. Witcher     120         50          150\n" +
					"2. Mage        75          100         50\n" +
					"3. Fighter     120         50          200\n");
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
//			Set<ConstraintViolation<Hero>> violations = validator.validate(hero);
//			for (ConstraintViolation<Hero> violation : violations) {
//				System.out.println(violation.getMessage());
//			}
			dbData.addHero(hero.getHeroName(), hero.getHeroClass(), hero.getHeroLevel(), hero.getExperience(),
					hero.getHitPoints(), hero.getAttack(), hero.getDefense());

			System.out.println("Hero Created");

		}
	}
		
		public void run(){

		Maps map = new Maps(this.hero);
		map.setMap();
		String nav = null;
		}
		
		public void DisplayHeroName() {
		
		}
		
		public void DisplayStats () {
			System.out.println("Hero stats are:");

			System.out.println("Name: " + hero.getHeroName());

			System.out.println("Class: " + hero.getHeroClass());

			System.out.println("Level: " + hero.getHeroLevel());

			System.out.println("Exp: " + hero.getExperience());

			System.out.println("Attack: " + hero.getAttack());

			System.out.println("Defense: " + hero.getDefense());

			System.out.println("HP: " + hero.getHitPoints());
		}

	@Override
	public Hero DisplaySave() {

		int load, heroChoice;
		dbMethods dbData = new dbMethods();
		Scanner scan;
		DisplayLoad();
		try{
			scan = Main.getScanner();
			load = scan.nextInt();
			scan.nextLine();
			while (load < 1 || load > 2) {
				System.out.println("invalid choice choose 1 or 2");
				load = scan.nextInt();
				scan.nextLine();
			}
			switch(load){
				case 1:
					System.out.println("choose a hero by typing their id");
					dbData.selectAll();
					if (!scan.hasNextInt())
						throw new Exception();
					heroChoice = scan.nextInt();
					scan.nextLine();
					hero = dbData.getHerodb(heroChoice);
					break;
				case 2:
					DisplayHeroSelect();
					break;
		}
			System.out.println("this is your Hero");
			dbData.selectHero(hero.getHeroName());
			return hero;
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}

	public void DisplayIntro () {
		
		}
	}
