package Rooms;

import Entities.Heros.Hero;
import Entities.Vendor;
import Enums.InventoryMode;

import java.util.Scanner;

public class VendorRoom extends Room{
    @Override
    public String describe() {
        return "You hear a human voice coming from a dark building, is it another survivor?";
    }

    @Override
    public boolean enter(Hero hero, int step) {
        Scanner in = new Scanner(System.in);
        Vendor vendor = new Vendor();
        System.out.println(vendor.greet());
        vendor.generateStock(hero, step);

        int choice = -1, counter = 0;
        while (choice != 0){
            System.out.println("1. Talk");
            System.out.println("2. See wares");
            System.out.println("3. See inventory");
            System.out.println("0. Leave");
//            Scanner in = new Scanner(System.in);
            if (in.hasNextInt()) choice = in.nextInt();
            switch (choice){
                default: break;
                case 1:
                    System.out.println(vendor.talk(counter++));
                    break;
                case 2:
                    vendor.displayStock(hero);
                    break;
                case 3:
                    hero.seeInventory(InventoryMode.SHOP);
                    break;
            }
        }
        return true;
    }
}
