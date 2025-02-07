package Itens.Equipable.Weapon;

public class CoachGun extends Weapon{
    public CoachGun(int step) {
        super(step);
        this.name = "Coach Gun";
        this.strength = 10;
        super.scale();
    }
}
