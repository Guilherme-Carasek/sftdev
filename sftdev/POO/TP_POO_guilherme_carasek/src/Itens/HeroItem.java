package Itens;

public abstract class HeroItem {
    protected String name;
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
     * Item inspect will show user the description of the item, plus options based on the parameter given.
     * Can receive Foe(when in battle), vendor(when in shop), no parameter(when in corridor)
     * @param foe
     * @returns true if the hero still has their turn(no item was used)
     */
    public abstract boolean inspect ( Foe foe );
    public abstract boolean inspect ( Vendor vendor );
    public abstract boolean inspect ();

}
