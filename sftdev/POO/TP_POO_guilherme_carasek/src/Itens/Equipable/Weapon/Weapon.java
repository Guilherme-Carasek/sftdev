package Itens.Equipable.Weapon;

import Entities.Foes.Foe;
import Entities.Heros.Hero;
import Enums.InventoryMode;
import Itens.HeroItem;

import java.util.Scanner;

public abstract class Weapon extends HeroItem {
    protected int strength;
    public Weapon(int step) {
        super(step);
    }

    @Override
    protected void scale() {
        super.scale();
        this.strength += 2 * this.step;

    }

    /**
     * Abstract method for a weapon's basic attack.
     * @returns an int array with [0]=damage, [1]=damage over time, [2]=healing.
     */
    public abstract int[] basicAttack();

    /**
     * Abstract method for a weapon's special attack.
     * @returns an int array with [0]=damage, [1]=damage over time, [2]=healing.
     */
    public abstract int[] specialAttack();

    @Override
    public boolean inspect(InventoryMode mode, Hero hero, Foe foe) {
        Scanner in = new Scanner(System.in);
        if (mode == InventoryMode.BATTLE) {
            int choice = -1;
            while (choice != 0) {
                System.out.println("******* " + this.name + " *******");
                System.out.println(this.description);
                System.out.println("1. Equip");
                System.out.println("0. Return");
                if (in.hasNextInt()) choice = in.nextInt();
                if (choice == 0) return true;
                if (choice == 1){
                    hero.equipWeapon(this);
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean inspect(InventoryMode mode, Hero hero) {
        Scanner in = new Scanner(System.in);
        if (mode == InventoryMode.CORRIDOR) {
            int choice = -1;
            while (choice != 0) {
                System.out.println("******* " + this.name + " *******");
                System.out.println(this.description);
                System.out.println("1. Equip");
                System.out.println("0. Return");
                if (in.hasNextInt()) choice = in.nextInt();
                if (choice == 0) return true;
                if (choice == 1){
                    hero.equipWeapon(this);
                    return true;
                }
            }
        } else if (mode == InventoryMode.SHOP) {
            int choice = -1;
            while (choice != 0) {
                System.out.println("******* " + this.name + " *******");
                System.out.println(this.description);
                System.out.println("1. Equip");
                System.out.println("2. Sell");
                System.out.println("0. Return");
                if (in.hasNextInt()) choice = in.nextInt();
                if (choice == 0) return true;
                if (choice == 1){
                    hero.equipWeapon(this);
                    return true;
                }
                if (choice == 2){
                    hero.sellItem(this);
                    return true;
                }
            }
        }
        return true;
    }
}
