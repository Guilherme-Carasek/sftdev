package Itens.Equipable.Weapon;

public class CoachGun extends Weapon{
    public CoachGun(int step) {
        super(step);
        this.name = "Coach Gun";
        this.description = "Versatile weapon\nSpecial sets enemies on fire";
        this.value = 10;
        this.strength = 10;
        super.scale();
    }

    @Override
    public int[] basicAttack() {
        return new int[]{this.strength, 0, 0};
    }

    @Override
    public int[] specialAttack() {
        return new int[]{this.strength/2, this.strength/2, 0};
    }


}
