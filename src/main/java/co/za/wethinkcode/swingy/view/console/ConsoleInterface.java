package co.za.wethinkcode.swingy.view.console;

import co.za.wethinkcode.swingy.Main;
import co.za.wethinkcode.swingy.view.Display;
import sun.nio.cs.ext.ISO2022_CN;

import java.util.Scanner;

public class ConsoleInterface implements Display {
	public void DisplayStart() {

		System.out.println("/*******************************************\n" +
				"*            WELCOME TO THE GAME         *" +
				"*******************************************/");

	}

	public void DisplayHeroSelect(){

		Scanner scan = Main.getScanner();
		System.out.println("Enter your hero's name");
		String name = scan.nextLine();
		System.out.println("Select a number to choose class\n" +
				"   Class       Attack      Defense     HP\n" +
				"1. Witcher     120         50          150\n" +
				"2. Mage        75          100         50\n" +
				"3. Fighter     120         50          200\n");



	}

	public void DisplayHeroName() {

	}

	public void DisplayStats() {

	}

	public void DisplayIntro() {

	}
}
