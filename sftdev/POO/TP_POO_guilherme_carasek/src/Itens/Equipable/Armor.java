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
        super.scale();
        this.bonusHp += 2 * this.step;
        this.bonusAgility += 2 * this.step;

    }
}