package Entities.Foes;

public abstract class Boss extends Foe{
    public Boss(int step){
        super();
        this.maxHp += 5;
        this.strenght += 2;
        this.agility += 2;
        this.scrap += 4;
        this.xp += 4;
        super.scale(step);
    }
}
