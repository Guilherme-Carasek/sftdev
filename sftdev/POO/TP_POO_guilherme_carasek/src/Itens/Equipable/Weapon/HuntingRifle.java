package Itens.Equipable.Weapon;

public class HuntingRifle extends Weapon{
    public HuntingRifle(int step) {
        super(step);
        this.name = "Hunting Rifle";
        this.strength = 13;
        super.scale();
    }
}
