package Itens;

import Entities.Foes.Foe;
import Entities.Heros.Hero;
import Enums.InventoryMode;

public abstract class HeroItem {
    protected String name;
    protected String description;
    protected int value;
    protected int step;


    public HeroItem( int step ) {
        this.step = step;
    }

    /**
     * Scales the item's value and adds a tag according to the step
     */
    protected void scale () {
        if (this.step > 0) {
            this.name += " +" + Integer.toString(this.step);
            this.value += 2 * this.step;
        }
    };

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    /**
     * Item inspect will show user the description of the item, plus options based on the mode given.
     * In battle mode, must receive a Foe
     * @param hero
     * @param foe
     * @param mode
     * @returns true if the hero still has their turn(no item was used)
     */
    public abstract boolean inspect (InventoryMode mode, Hero hero, Foe foe );

    /**
     * Item inspect will show user the description of the item, plus options based on the mode given.
     * In battle mode, must receive a Foe
     * @param mode
     * @return
     */
    public abstract boolean inspect ( InventoryMode mode, Hero hero );

}
