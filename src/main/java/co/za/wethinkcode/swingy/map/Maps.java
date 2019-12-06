package co.za.wethinkcode.swingy.map;

import co.za.wethinkcode.swingy.model.characters.Hero;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Maps {

	private int mapSize;
	private static char[][] map;
	private static int xHero;
	private static int yHero;

	public Maps(Hero hero){

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
				villainCoord(map,mapSize - 2);
			}
		}

		printMap();
	//	System.out.println("\n" + mapSize);
	}

	public void clearScreen()
	{
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	private int printMap(){
		for (int i = 0; i < mapSize; i++){
			for (int k = 0; k < mapSize; k++) {
				map[i][k] = '*';
				if (i == xHero && k == yHero)
					map[i][k] = 'H';
				System.out.print(" " + map[i][k] + " ");
				if (xHero == 0 || yHero == 0 || xHero == mapSize - 1 || yHero == mapSize - 1){
					System.out.println("Reached the edge");
					return 2;
				}
			}
			System.out.println();
		}
		return 1;
	}

	public int navigate(@NotNull String nav){
		int oc = 1;

		switch (nav.toLowerCase()) {
			case "n":
				xHero -= 1;
				oc = printMap();
				break;
			case "s":
				xHero += 1;
				oc = printMap();
				break;
			case "w":
				yHero -= 1;
				oc = printMap();
				break;
			case "e":
				yHero += 1;
				oc = printMap();
				break;
			case "q":
					return 2;
			default:
				return oc;
		}
		return oc;
	}

	public void villainCoord(char[][] map, int mapEdge){
		Random random = new Random();
		int x,y;
		x = random.nextInt(mapEdge);
		y = random.nextInt(mapEdge);
		map[x][y] = 'V';
	}


}
