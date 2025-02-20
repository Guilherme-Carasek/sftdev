package Itens.Equipable.Helmet;

import Entities.Foes.Foe;
import Entities.Heros.Hero;
import Enums.InventoryMode;
import Itens.Equipable.Armor;

import java.util.Scanner;

public abstract class Helmet extends Armor {
    public Helmet(int step) {
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
                System.out.println("Bonus HP: " + this.bonusHp + "\nBonus Agility: " + this.bonusAgility);
                System.out.println("1. Equip");
                System.out.println("0. Return");
                if (in.hasNextInt()) choice = in.nextInt();
                if (choice == 0) return true;
                if (choice == 1){
                    hero.equipHelmet(this);
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
                System.out.println("Bonus HP: " + this.bonusHp + "\nBonus Agility: " + this.bonusAgility);
                System.out.println("1. Equip");
                System.out.println("0. Return");
                if (in.hasNextInt()) choice = in.nextInt();
                if (choice == 0) return true;
                if (choice == 1){
                    hero.equipHelmet(this);
                    return true;
                }
            }
        } else if (mode == InventoryMode.SHOP) {
            int choice = -1;
            while (choice != 0) {
                System.out.println("******* " + this.name + " *******");
                System.out.println(this.description);
                System.out.println("Bonus HP: " + this.bonusHp + "\nBonus Agility: " + this.bonusAgility);
                System.out.println("1. Equip");
                System.out.println("2. Sell");
                System.out.println("0. Return");
                if (in.hasNextInt()) choice = in.nextInt();
                if (choice == 0) return true;
                if (choice == 1){
                    hero.equipHelmet(this);
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
