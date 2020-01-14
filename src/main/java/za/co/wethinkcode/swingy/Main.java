package za.co.wethinkcode.swingy;

import za.co.wethinkcode.swingy.control.Controller;
import za.co.wethinkcode.swingy.model.characters.Hero;
import za.co.wethinkcode.swingy.view.console.ConsoleInterface;

import java.util.Scanner;

public	class Main {

	public static Hero hero;
    private static Scanner scanner = null;
	public static void main(String[] args) throws NumberFormatException {

		Controller controller = new Controller();
		controller.run();
	}

	public static Scanner getScanner() {
		if(scanner != null)
			return scanner;
		scanner = new Scanner(System.in);
			return scanner;
		}

}
