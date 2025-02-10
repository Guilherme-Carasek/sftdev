package Itens.Equipable.Weapon;

import Enums.InventoryMode;

public class HuntingRifle extends Weapon{
    public HuntingRifle(int step) {
        super(step);
        this.name = "Hunting Rifle";
        this.description = "The hunting rifle can snipe foes from afar \nSpecial: Scoped Shot";
        this.strength = 13;
        super.scale();
    }

    @Override
    public int[] basicAttack() {
        return new int[]{ (int) Math.round(this.strength*0.8), 0, 0 };
    }

    @Override
    public int[] specialAttack() {
        return new int[]{this.strength*2, 0, 0};
    }


}
