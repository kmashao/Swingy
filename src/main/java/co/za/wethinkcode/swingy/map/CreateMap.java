package co.za.wethinkcode.swingy.map;

import co.za.wethinkcode.swingy.hero.*;

public class CreateMap {

    private int mapSize;
    private char[][] map;
    private int heroLvl;
    private int xHero;
    private int yHero;

    public CreateMap(Hero hero){

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

                if (i == xHero && k == yHero)
                    map[i][k] = 'H';
            }
        }

    }

    public void printMap(){
        for (int i = 0; i < mapSize; i++){
            for (int k = 0; k < mapSize; k++)
                System.out.print(map[i][k]);
            System.out.println();
        }
    }



}
