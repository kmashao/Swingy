package za.co.wethinkcode.swingy.model.characters.villains;

import za.co.wethinkcode.swingy.model.characters.Hero;
import za.co.wethinkcode.swingy.model.characters.HeroBuild;

public class Panther implements HeroBuild {

    private Hero panther;

    public Panther(){
        this.panther = new Hero();
        this.panther.setName("Pantheos");
    }

    public void heroClass() {
        panther.setClass("Panther");
    }

    public void heroLevel() {
        panther.setLevel(1);
    }

    public void heroExperience() {
        panther.setExperience(800);
    }

    public void heroAttack() {
        panther.setAttack(110);
    }

    public void heroDefense() {
        panther.setDefense(45);
    }

    public void heroHitPoints() {
        panther.setHitPoints(450);
    }

    public Hero getHero() {
        return panther;
    }

}
