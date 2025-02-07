package Itens.Equipable.Weapon;

import Itens.HeroItem;

public abstract class Weapon extends HeroItem {
    protected int strength;
    public Weapon(int step) {
        super(step);
    }

    @Override
    protected void scale() {
        super.scale();
        this.strength += 2 * this.step;

    }

    //método para ataque básico

    //método abstrato para ataque especial
}
