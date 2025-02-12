package Entities.Foes;

public abstract class Tank extends Foe{

    public Tank(int step) {
        super();
        this.maxHp += 2;
        this.strenght += 0;
        this.agility += 0;
        super.scale(step);
    }
}
