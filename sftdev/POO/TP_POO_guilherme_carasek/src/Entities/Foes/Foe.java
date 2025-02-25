package Entities.Foes;

import Entities.Entity;

import Useful.TypeWritter;


public abstract class Foe extends Entity {
    protected int xp;

    public Foe() {
        this.maxHp = 8;
        this.strenght = 1;
        this.agility = 1;
        this.scrap = 1;
        this.xp = 1;
    }

    public int getXp() {
        return xp;
    }

    /**
     *
     * @param step
     */
    protected void scale(int step){
        //int that shows how many steps occurred in a set of 20(after that, difficulty graph should reset with a bump)
        int modTwenty = step%20;
        double percent = modTwenty * 0.05;
        //returns a difficulty graph that multiplies values by 5 at step '0', and peaks by 25x at step 18.
        // https://imgur.com/a/TGB0UpF
        double scaleFactor = 25*(0.5*(Math.pow(2, -50 * Math.pow(percent-0.4, 4))) + 0.95*(Math.pow(2, -100 * Math.pow(percent-0.9, 2)))) * ((step/20)+1);

        this.maxHp = (int) Math.round(this.maxHp * scaleFactor);
        this.currentHp = this.maxHp;
        this.strenght = (int) Math.round(this.strenght * scaleFactor);
        this.agility = (int) Math.round(this.agility * scaleFactor);
        this.scrap = (int) Math.round(this.scrap * scaleFactor);
        this.xp = (int) Math.round(this.xp * scaleFactor);
    }

    /**
     * Returns a "greet" to be displayed as the hero enters the room.
     * @return
     */
    public abstract String greet();

    /**
     * Returns text to be displayed when the hero tries to interact with foe.
     * Can be dialogue or just thoughts through the hero's mind.
     * @param counter
     * @return
     */
    public abstract String talk(int counter);

    public void takeDamage(int damage){
        this.currentHp -= damage;
        TypeWritter.type(this.name + " took " + damage + " ");
    }

}
