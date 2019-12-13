package co.za.wethinkcode.swingy.map;

import co.za.wethinkcode.swingy.model.characters.Hero;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Maps {

	private int mapSize, level, noc;
	private char[][] map;
	private int xHero, xVill;
	private int yHero, yVill;

	public Maps(Hero hero){
		setMap(hero);
		placeVill();
		printMaps();
	}

    /*public void placeHero(){

    }*/

    public boolean checkEdge(){
    	boolean reached = false;



    	return reached;
	}

	public void setMap(Hero hero){

		level = hero.getHeroLevel();
		mapSize = ((level - 1) * 5 + 10 - (level % 2));

		xHero = mapSize/2;
		yHero = mapSize/2;

		this.map = new char[mapSize][mapSize];

		for(int x = 0; x < mapSize; x++){

			for(int y = 0; y < mapSize; y++) {
				this.map[x][y] = '*';
			}
			System.out.println("");
		}
		this.map[xHero][yHero] = 'H';
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
				this.map[i][k] = '*';
				if (i == xHero && k == yHero)
					map[i][k] = 'H';
				if (i == xVill && k == yVill)
						this.map[i][k] = 'V';
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

	public void printMaps(){
		for (int i = 0; i < mapSize; i++){
			for (int k = 0; k < mapSize; k++) {
				System.out.print(" " + this.map[i][k] + " ");
				}
			System.out.println();
		}
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

	public void villainCoord(Maps maps){
		Random random = new Random();
		for (int x = 2; x < maps.mapSize - 1; x++) {
			for (int y = 2; y < maps.mapSize - 1; y++) {
				xVill = random.nextInt(maps.mapSize - 1);
				yVill = random.nextInt(maps.mapSize - 1);
				if (maps.map[xVill][yVill] != 'H' && maps.map[xVill][yVill] != 'V' && xVill != 0 && yVill != 0)
					maps.map[xVill][yVill] = 'V';
			}
		}
	}

	public void placeVill(){
		villainCoord(this);
	}




}
