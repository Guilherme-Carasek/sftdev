package Entities;

public abstract class Entity {
    protected String name;
    protected int maxHp = 0;
    protected int currentHp;
    protected int strenght = 0;
    protected int agility = 0;
    /**
     * damageOverTime[0] = damage every turn.
     * damageOverTime[1] = turns left.
     */
    protected int[] damageOverTime = new int[2];
    protected int scrap = 0;

    public String getName() {
        return this.name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getScrap() {
        return scrap;
    }

    public int getAgility(){
        return this.agility;
    }

    public int getStrenght(){ return this.strenght; }

    /**
     * Increases DoT damage per turn by given amount and updates turns to 3.
     * (Care for easily applyable DoTs, this can scale damage per turn infinitely)
     * @param dotDamage
     */
    public void updateDot(int dotDamage) {
        this.damageOverTime[0] += dotDamage;
        this.damageOverTime[1] = 3;
        System.out.println(this.name + " was set on fire!");
    }

    /**
     * Deals DoT damage, counts down countdown, if countdown reaches Zero resets.
     */
    public void countDownDot () {
        if (this.damageOverTime[1]-- > 0){
            this.currentHp -= this.damageOverTime[0];
            System.out.println(this.name + " has burned for " + this.damageOverTime[0] + " damage!");
            if ( this.damageOverTime[1] == 0 ) this.damageOverTime[0] = 0;
        }
    }
}
