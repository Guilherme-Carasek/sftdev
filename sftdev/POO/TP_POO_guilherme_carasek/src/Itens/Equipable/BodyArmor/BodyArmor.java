package Itens.Equipable.BodyArmor;

import Entities.Foes.Foe;
import Entities.Heros.Hero;
import Enums.InventoryMode;
import Itens.Equipable.Armor;

import java.util.Scanner;

public abstract class BodyArmor extends Armor {
    public BodyArmor(int step) {
        super(step);
    }

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
                    hero.equipBodyArmor(this);
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
                    hero.equipBodyArmor(this);
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
                    hero.equipBodyArmor(this);
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
