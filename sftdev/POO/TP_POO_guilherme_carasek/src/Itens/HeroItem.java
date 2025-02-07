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
}
