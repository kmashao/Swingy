package co.za.wethinkcode.swingy;

import co.za.wethinkcode.swingy.hero.*;

public class TestHeroCreator {
    public static void main(String[] args) {
        HeroBuild heroClass = new WitcherClass();

        HeroCreator heroCreator = new HeroCreator(heroClass);

        heroCreator.createHero();

        Hero witcher = heroCreator.getHero();

        System.out.println("HeroCreated");

        System.out.println(" ");

        System.out.println("Hero stats are:");

        System.out.println("Name: " + witcher.getHeroName());

        System.out.println("Class: " + witcher.getHeroClass());

        System.out.println("Level: " + witcher.getHeroLevel());

        System.out.println("Exp: " + witcher.getExperience());

        System.out.println("Attack: " + witcher.getAttack());

        System.out.println("Defense: " + witcher.getDefense());

        System.out.println("HP: " + witcher.getHitPoints());

    }
}
