package co.za.wethinkcode.swingy;

import co.za.wethinkcode.swingy.view.console.ConsoleInterface;

import java.util.Scanner;

public	class Main {

    public static Scanner scanner = null;

	public static void main(String[] args) throws NumberFormatException {

		scanner = new Scanner(System.in);

		ConsoleInterface console = new ConsoleInterface();
		console.DisplayLoad();
//		console.DisplayLoad();
	//	dbMethods dbMeth = new dbMethods();
	//	dbMeth.selectAll();
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
