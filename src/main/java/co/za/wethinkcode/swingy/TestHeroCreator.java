package co.za.wethinkcode.swingy;

import co.za.wethinkcode.swingy.hero.HeroBuild;
import co.za.wethinkcode.swingy.hero.HeroClasses;
import co.za.wethinkcode.swingy.hero.HeroCreator;
import co.za.wethinkcode.swingy.hero.Hero;

import co.za.wethinkcode.swingy.map.CreateMap;

import java.util.Scanner;

public class TestHeroCreator {
    public static void main(String[] args) throws NumberFormatException {



        Scanner scan = new Scanner(System.in);
        System.out.print("Enter hero name: ");
        String name_ = scan.nextLine();
        System.out.println("Navigate\n");
        String nav = scan.nextLine();
        System.out.println("Choose hero class: ");
        System.out.println("1. Witcher\n2. Mage\n3. Fighter");
        int class_ = scan.nextInt();



        HeroBuild heroClass = new HeroClasses(name_, class_);

        HeroCreator heroCreator = new HeroCreator(heroClass);

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

        System.out.println("-------------Map-------------");

        CreateMap map = new CreateMap(hero);
        map.setMap();
        map.navigate(nav);

        System.out.println("------------------------------");
    }
}
