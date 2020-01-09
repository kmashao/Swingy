package za.co.wethinkcode.swingy.model.characters.villains;

import za.co.wethinkcode.swingy.model.characters.Hero;
import za.co.wethinkcode.swingy.model.characters.HeroBuild;

public class Beserker implements HeroBuild {
    private Hero beserker;

    public Beserker(){
        this.beserker = new Hero();
        this.beserker.setName("Carnage");
    }

    public void heroClass() {
        beserker.setClass("Beserker");
    }

    public void heroLevel() {
        beserker.setLevel(1);
    }

    public void heroExperience() {
        beserker.setExperience(900);
    }

    public void heroAttack() {
        beserker.setAttack(200);
    }

    public void heroDefense() {
        beserker.setDefense(10);
    }

    public void heroHitPoints() {
        beserker.setHitPoints(400);
    }

    public Hero getHero() {
        return beserker;
    }
}
