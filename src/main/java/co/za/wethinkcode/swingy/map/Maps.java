package co.za.wethinkcode.swingy.map;

import co.za.wethinkcode.swingy.model.characters.Hero;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Maps {

	private int mapSize, level, noc;
	private char[][] map;
	private int xHero, xVill;
	private int yHero, yVill;

	public Maps(){

	}

	public void addVills(){

	}

    /*public void placeHero(){

    }*/

	public void setMap(Hero hero){

		level = hero.getHeroLevel();
		mapSize = ((level - 1) * 5 + 10 - (level % 2));

		xHero = mapSize/2;
		yHero = mapSize/2;

		map = new char[mapSize][mapSize];

		for(int i = 0; i < mapSize; i++){

			for(int k = 0; k < mapSize; k++) {
				map[i][k] = '*';
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
		Random rand = new Random();
		xVill = rand.nextInt(mapSize - 2);
		yVill = rand.nextInt(mapSize - 2);
		for (int i = 0; i < mapSize; i++){
			//villainCoord(mapSize - 2);
			for (int k = 0; k < mapSize; k++) {
				map[i][k] = '*';
				if (i == xHero && k == yHero)
					map[i][k] = 'H';
				if (i == xVill && k == yVill)
						map[i][k] = 'V';
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

	public void villainCoord(int mapEdge){
		Random random = new Random();

		xVill = random.nextInt(mapEdge);
		yVill = random.nextInt(mapEdge);
		if (this.map[xVill][yVill] != 'H' || this.map[xVill][yVill] != 'V')
			this.map[xVill][yVill] = 'V';
	}




}
