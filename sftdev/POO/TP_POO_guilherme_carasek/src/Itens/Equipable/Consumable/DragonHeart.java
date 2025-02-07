package Itens.Equipable.Consumable;

import Itens.HeroItem;

public class DragonHeart extends HeroItem {
    private int healing;

    public DragonHeart(int step) {
        super(step);
        this.name = "Dragon Heart";
        this.value = 50;
        this.healing = 50;
        this.scale();
    }

    @Override
    protected void scale() {
        super.scale();
        this.value += this.step;
        this.healing += this.step * 3;
    }
}
