package co.za.wethinkcode.swingy;

import co.za.wethinkcode.swingy.model.characters.*;

import co.za.wethinkcode.swingy.model.characters.heroes.Fighter;
import co.za.wethinkcode.swingy.model.characters.heroes.Mage;
import co.za.wethinkcode.swingy.model.characters.heroes.Witcher;
import co.za.wethinkcode.swingy.map.CreateMap;
import co.za.wethinkcode.swingy.database.*;
import co.za.wethinkcode.swingy.view.Display;
import co.za.wethinkcode.swingy.view.console.ConsoleInterface;

import java.util.Scanner;

public	class Main {

    public static Scanner scanner = null;

	public static void main(String[] args) throws NumberFormatException {

		String nav;
		HeroCreator heroCreator;

		scanner = new Scanner(System.in);
		System.out.print("Enter hero name: ");
		String name_ = scanner.nextLine();
		System.out.println("Choose hero class: \n");
		System.out.println("1. Witcher\n2. Mage\n3. Fighter");
		int class_ = scanner.nextInt();

		//  ConsoleInterface console = new ConsoleInterface();
		//  console.DisplayHeroSelect();
		switch (class_) {

			case 1:
				HeroBuild witcher = new Witcher(name_);
				heroCreator = new HeroCreator(witcher);
				break;

			case 2:
				HeroBuild fighter = new Fighter(name_);
				heroCreator = new HeroCreator(fighter);
				break;

			case 3:
				HeroBuild mage = new Mage(name_);
				heroCreator = new HeroCreator(mage);
				break;

			default:
				throw new NumberFormatException(class_ + " is not a valid class pick a correct number");
		}

		heroCreator.createHero();

		Hero hero = heroCreator.getHero();
		dbMethods dbData = new dbMethods();
		dbData.addHero(hero.getHeroName(), hero.getHeroClass(), hero.getHeroLevel(), hero.getExperience(),
				hero.getHitPoints(), hero.getAttack(), hero.getDefense());
		dbData.selectAll();

	}

	public static Scanner getScanner() {
		if(scanner != null)
			return scanner;
		scanner = new Scanner(System.in);
		return scanner;
	}

	//	System.out.println("-------------Map-------------");

		/*CreateMap map = new CreateMap(hero);
		map.setMap();
		for(int i = 1; i != 2;) {


			System.out.println("navigate");
			try {
				nav = scanner.next();
				i = map.navigate(nav);
			}catch (IllegalStateException ise){
				String message = ise.getMessage();
				System.out.println("Unexpected value " + message );
			}

		//	map.clearScreen();

		}
	//	System.out.println("------------------------------");
	}


		*/
	}
