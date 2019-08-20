package co.za.wethinkcode.swingy.map;

import co.za.wethinkcode.swingy.hero.*;

public class CreateMap {

	private int mapSize;
	private char[][] map;
	private static int xHero;
	private static int yHero;

	public CreateMap(Hero hero){

		int heroLvl;

		heroLvl = hero.getHeroLevel();
		mapSize = ((heroLvl - 1) * 5 + 10 - (heroLvl % 2));

	}

    /*public void placeHero(){

    }*/

	public void setMap(){

		xHero = mapSize/2;
		yHero = mapSize/2;

		map = new char[mapSize][mapSize];

		for(int i = 0; i < mapSize; i++){

			for(int k = 0; k < mapSize; k++) {

				map[i][k] = '*';
			}
		}

		printMap();

	}

	public void clearScreen()
	{
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	private void printMap(){
		for (int i = 0; i < mapSize; i++){
			for (int k = 0; k < mapSize; k++) {
				map[i][k] = '*';
				if (i == xHero && k == yHero)
					map[i][k] = 'H';
				System.out.print(" " + map[i][k] + " ");
			}
			System.out.println();
		}
	}

	public void navigate(String nav){

		switch (nav.toLowerCase()) {
			case "n":
				xHero -= 1;
				printMap();
				break;
			case "s":
				xHero += 1;
				printMap();
				break;
			case "w":
				yHero -= 1;
				printMap();
				break;
			case "e":
				yHero += 1;
				printMap();
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + nav);
		}
	}


}
