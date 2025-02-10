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

    /**
     * Abstract method for a weapon's basic attack.
     * @returns an int array with [0]=damage, [1]=damage over time, [2]=healing.
     */
    public abstract int[] basicAttack();

    /**
     * Abstract method for a weapon's special attack.
     * @returns an int array with [0]=damage, [1]=damage over time, [2]=healing.
     */
    public abstract int[] specialAttack();
}
