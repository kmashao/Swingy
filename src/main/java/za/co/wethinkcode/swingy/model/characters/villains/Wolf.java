package za.co.wethinkcode.swingy.model.characters.villains;

import za.co.wethinkcode.swingy.model.characters.Hero;
import za.co.wethinkcode.swingy.model.characters.HeroBuild;

public class Wolf implements HeroBuild {

    private Hero wolf;

    public Wolf(){
        this.wolf = new Hero();
        this.wolf.setName("Canine");
    }

    public void heroClass() {
        wolf.setClass("Wolf");
    }

    public void heroLevel() {
        wolf.setLevel(1);
    }

    public void heroExperience() {
        wolf.setExperience(800);
    }

    public void heroAttack() {
        wolf.setAttack(190);
    }

    public void heroDefense() {
        wolf.setDefense(145);
    }

    public void heroHitPoints() {
        wolf.setHitPoints(210);
    }

    public Hero getHero() {
        return wolf;
    }


}
