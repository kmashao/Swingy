package co.za.wethinkcode.swingy;

import co.za.wethinkcode.swingy.characters.*;

import co.za.wethinkcode.swingy.characters.heroes.Fighter;
import co.za.wethinkcode.swingy.characters.heroes.Mage;
import co.za.wethinkcode.swingy.characters.heroes.Witcher;
import co.za.wethinkcode.swingy.map.CreateMap;

import java.util.Scanner;

	class TestHeroCreator {

	public static void main(String[] args) throws NumberFormatException {

		String nav;
		HeroCreator heroCreator;

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter hero name: ");
		String name_ = scan.nextLine();
		System.out.println("Choose hero class: \n");
		System.out.println("1. Witcher\n2. Mage\n3. Fighter");
		int class_ = scan.nextInt();

		switch(class_){

			case 3:
				HeroBuild mage = new Mage(name_);
				heroCreator = new HeroCreator(mage);
				break;
			case 2:
				HeroBuild fighter = new Fighter(name_);
				heroCreator = new HeroCreator(fighter);
				break;
			case 1:
				HeroBuild witcher = new Witcher(name_);
				heroCreator = new HeroCreator(witcher);
				break;
			default: throw new NumberFormatException(class_ + " is not a valid class pick a correct number");
		}

		heroCreator.createHero();

		Hero hero = heroCreator.getHero();

		System.out.println("Hero Created");

		System.out.println(" ");

		System.out.println("Hero stats are:");

		System.out.println("Name: " + hero.getHeroName());

		System.out.println("Class: " + hero.getHeroClass());

		System.out.println("Level: " + hero.getHeroLevel());

		System.out.println("Exp: " + hero.getExperience());

		System.out.println("Attack: " + hero.getAttack());

		System.out.println("Defense: " + hero.getDefense());

		System.out.println("HP: " + hero.getHitPoints());

	//	System.out.println("-------------Map-------------");

		CreateMap map = new CreateMap(hero);
		map.setMap();
		for(int i = 1; i != 2;) {


			System.out.println("navigate");
			try {
				nav = scan.next();
				i = map.navigate(nav);
			}catch (IllegalStateException ise){
				String message = ise.getMessage();
				System.out.println("Unexpected value " + message );
			}

		//	map.clearScreen();

		}


	//	System.out.println("------------------------------");
	}
}
