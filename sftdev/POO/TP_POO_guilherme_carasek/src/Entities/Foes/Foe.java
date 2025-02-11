package Entities.Foes;

import Entities.Entity;

public abstract class Foe extends Entity {
    private int xp;

    public Foe(int step) {
        this.maxHp = 5;
        this.strenght = 1;
        this.agility = 1;
        this.scrap = 1;
        this.xp = 1;
    }

    protected void scale(int step){
        //int that shows how many steps occurred in a set of 20(after that, difficulty graph should reset with a bump)
        int modTwenty = step%20;
        double percent = modTwenty * 0.05;
        //returns a difficulty graph that multiplies values by 10 at step '0', and peaks by 50x at step 18.
        double scaleFactor = 50*(0.5*(Math.pow(2, -50 * Math.pow(percent-0.4, 4))) + 0.95*(Math.pow(2, -100 * Math.pow(percent-0.9, 2)))) * ((step/20)+1);

        this.maxHp = (int) Math.round(this.maxHp * scaleFactor);
        this.currentHp = this.maxHp;
        this.strenght = (int) Math.round(this.strenght * scaleFactor);
        this.agility = (int) Math.round(this.agility * scaleFactor);
        this.scrap = (int) Math.round(this.scrap * scaleFactor);
        this.xp = (int) Math.round(this.xp * scaleFactor);
    }
}
