package Itens.Equipable.Consumable;

import Entities.Foes.Foe;
import Entities.Heros.Hero;
import Enums.InventoryMode;
import Itens.HeroItem;

import java.util.Scanner;

public class DragonHeart extends HeroItem {
    private int healing;

    public DragonHeart(int step) {
        super(step);
        this.name = "Dragon Heart";
        this.description = "Clawbone was the start of it all. He led us~more specifically, he led Dr. Harsgaard --down a path of discovery that nearly ended in our annihilation Obviously, we should never have set one foot on that path, but you try telling that to the genius who thinks they're about to change the world.";
        this.value = 50;
        this.healing = 50;
        this.scale();
    }

    @Override
    protected void scale() {
        super.scale();
        this.value += this.step;
        this.healing += this.step * 3;
    }

    @Override
    public boolean inspect(InventoryMode mode, Hero hero, Foe foe) {
        Scanner in = new Scanner(System.in);
        if (mode == InventoryMode.BATTLE) {
            int choice = -1;
            while (choice != 0) {
                System.out.println("******* " + this.name + " *******");
                System.out.println(this.description);
                System.out.println("1. Use");
                System.out.println("0. Return");
                if (in.hasNextInt()) choice = in.nextInt();
                if (choice == 0) return true;
                if (choice == 1){
                    hero.updateStats(new int[]{0,0,this.healing}, foe);
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean inspect(InventoryMode mode, Hero hero) {
        return false;
    }
}
