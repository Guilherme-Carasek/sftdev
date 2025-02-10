package Itens.Equipable.Weapon;

public class Shotgun extends Weapon{
    public Shotgun(int step) {
        super(step);
        this.name = "Shotgun";
        this.strength = 8;
        super.scale();
    }

    @Override
    public int[] basicAttack() {
        return new int[]{this.strength, 0, 0};
    }

    @Override
    public int[] specialAttack() {
        return new int[]{this.strength, 0, this.strength};
    }
}
