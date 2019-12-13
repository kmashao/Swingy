package co.za.wethinkcode.swingy;

import co.za.wethinkcode.swingy.map.Maps;
import co.za.wethinkcode.swingy.model.characters.Hero;
import co.za.wethinkcode.swingy.view.console.ConsoleInterface;

import java.util.Scanner;

public	class Main {

	public static Hero hero;
    public static Scanner scanner = null;
	public static String nav;
	public static void main(String[] args) throws NumberFormatException {

		scanner = new Scanner(System.in);

		ConsoleInterface console = new ConsoleInterface();
		hero = console.DisplaySave();
//		console.DisplayLoad();
	//	dbMethods dbMeth = new dbMethods();
	//	dbMeth.selectAll();
		Maps map = new Maps(hero);


//		for(int i = 1; i != 2;) {
//
//			System.out.println("navigate");
//			try {
//				nav = scanner.next();
//				i = map.navigate(nav);
//			}catch (IllegalStateException ise) {
//				String message = ise.getMessage();
//				System.out.println("Unexpected value " + message);
//			}
//		}
	//	System.out.println("------------------------------");
	}

		public static Scanner getScanner() {
			if(scanner != null)
				return scanner;
			scanner = new Scanner(System.in);
			return scanner;
		}

	}
