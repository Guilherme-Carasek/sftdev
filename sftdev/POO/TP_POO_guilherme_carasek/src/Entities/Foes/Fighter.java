package Entities.Foes;

public abstract class Fighter extends Foe{
    public Fighter(int step) {
        super();
        this.maxHp += 0;
        this.strenght += 1;
        this.agility += 0;
        super.scale(step);
    }
}
