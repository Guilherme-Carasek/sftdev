package Entities.Foes;

public abstract class Assassin extends Foe{
    public Assassin(int step) {
        super();
        this.maxHp += 0;
        this.strenght += 0;
        this.agility += 1;
        super.scale(step);
    }
}
