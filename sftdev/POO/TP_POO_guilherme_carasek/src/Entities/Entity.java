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
}
