package Itens.Equipable;

import Itens.HeroItem;

public abstract class Armor extends HeroItem {
    protected int bonusHp;
    protected int bonusAgility;

    public Armor( int step ) {
        super(step);
    }

    @Override
    protected void scale() {
        if (this.step > 0){
            this.name += " +" + Integer.toString(this.step);
            this.value += 2 * this.step;
            this.bonusHp += 2 * this.step;
            this.bonusAgility += 2 * this.step;
        }
    }
}