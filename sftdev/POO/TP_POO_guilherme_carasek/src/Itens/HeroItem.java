package Itens;

public abstract class HeroItem {
    protected String name;
    protected int value;
    protected int step;

    public HeroItem( int step ) {
        this.step = step;
    }

    protected abstract void scale ();

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
