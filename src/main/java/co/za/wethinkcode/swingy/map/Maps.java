package co.za.wethinkcode.swingy.map;

import co.za.wethinkcode.swingy.model.characters.Hero;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Maps {

	private int mapSize, level;
	private char[][] map;
	private int xHero, xVill;
	private int yHero, yVill;
	private Hero hero;

	public Maps(Hero hero){
		this.hero = hero;
		setMap(hero);
		placeVill();
		printMaps();
	}

    private boolean checkEdge(){
		return xHero == 0 || yHero == 0 || xHero == mapSize - 1 || yHero == mapSize -1;
	}

	private void setMap(@NotNull Hero hero){

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
	}

	public void clearScreen()
	{
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	private void printMaps(){
		for (int i = 0; i < mapSize; i++){
			for (int k = 0; k < mapSize; k++) {
				System.out.print(" " + this.map[i][k] + " ");
				}
			System.out.println();
		}
    }
    public boolean metVill(@NotNull String nav){
		boolean metVillain = false;
		switch (nav.toUpperCase()) {
			case "N":
				if (this.map[xHero - 1][yHero] == 'V')
						metVillain = true;
				break;
			case "S":
				if (this.map[xHero + 1][yHero] == 'V')
					metVillain = true;
				break;
			case "W":
				if(this.map[xHero][yHero -= 1] == 'V')
					metVillain = true;
				break;
			case "E":
				if(this.map[xHero][yHero += 1] == 'V')
					metVillain = true;
				break;
			default:
				break;
		}
		return metVillain;
	}

	private void villainCoord(@NotNull Maps maps){
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

	private void placeVill(){
		villainCoord(this);
	}

	private String navigation(@NotNull String direction){
		String status = null;
		while (true){
			if (checkEdge()){
				status = "END";
				return status;
			}
			else{
			switch (direction.toUpperCase()){
				case "N":
					if (checkEdge()){
						status = "END";
						return status;

					}
					this.map[--xHero][yHero] = 'H';
					this.map[xHero + 1][yHero] = '*';
					printMaps();
					status = "CONTINUE";
					return status;
				case "S":
					if (checkEdge()){
						status = "END";
						return status;
					}
					this.map[++xHero][yHero] = 'H';
					this.map[xHero - 1][yHero] = '*';
					printMaps();
					status = "CONTINUE";
					return status;
				case "E":
					if (checkEdge()){
						status = "END";
						return status;
					}
					this.map[xHero][++yHero] = 'H';
					this.map[xHero][yHero - 1] = '*';
					printMaps();
					status = "CONTINUE";
					return status;
				case "W":
					if (checkEdge()){
						status = "END";
						return status;
					}
					this.map[xHero][--yHero] = 'H';
					this.map[xHero][yHero + 1] = '*';
					printMaps();
					status = "CONTINUE";
					return status;
				default:
					System.out.println("Invalid answer ending game");
					System.exit(1);
			}}
			return status;
		}
	}

	private void levelUP(){
		System.out.println("You have leveled up");
    	this.hero.setLevel(++this.level);
    	this.setMap(this.hero);
    	placeVill();
    	printMaps();this.hero.setLevel(++level);
	}

	public String move (String direction){
    	String move = null;
		move = this.navigation(direction);
		if(move.equals("END")){
			if(this.hero.getHeroLevel() < 4) {
				clearScreen();
				levelUP();
				move = "CONTINUE";
			}
		}
    	return move;
	}

}
