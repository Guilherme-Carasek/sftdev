package Itens.Equipable.Weapon;

public class Shotgun extends Weapon{
    public Shotgun(int step) {
        super(step);
        this.name = "Shotgun";
        this.strength = 8;
        super.scale();
    }
}
