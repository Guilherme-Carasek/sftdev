package Itens.Equipable.Weapon;

import Itens.HeroItem;

public abstract class Weapon extends HeroItem {
    protected int strength;
    public Weapon(int step) {
        super(step);
    }

    @Override
    protected void scale() {
        if (this.step > 0){
            this.name += " +" + Integer.toString(this.step);
            this.value += 2 * this.step;
            this.strength += 2 * this.step;
        }
    }

    //método para ataque básico

    //método abstrato para ataque especial
}
