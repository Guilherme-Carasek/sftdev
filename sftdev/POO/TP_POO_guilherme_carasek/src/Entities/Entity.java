package Entities;

public abstract class Entity {
    protected String name;
    protected int maxHp = 0;
    protected int currentHp;
    protected int strenght = 0;
    protected int agility = 0;
    protected int[] damageOverTime = new int[2];
    protected int scrap = 0;

}
