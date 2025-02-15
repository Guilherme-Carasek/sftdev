package Entities;

public abstract class Entity {
    protected String name;
    protected int maxHp = 0;
    protected int currentHp;
    protected int strenght = 0;
    protected int agility = 0;
    protected int[] damageOverTime = new int[2];
    protected int scrap = 0;

    public String getName() {
        return name;
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

    public void updateDot(int dotDamage) {
        this.damageOverTime[0] += dotDamage;
        this.damageOverTime[1] = 3;
        System.out.println(this.name + " was set on fire!");
    }
}
