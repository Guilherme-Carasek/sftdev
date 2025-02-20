package Entities.Heros;

import Entities.Entity;
import Entities.Foes.Foe;
import Enums.InventoryMode;
import Itens.Equipable.BodyArmor.BodyArmor;
import Itens.Equipable.Helmet.Helmet;
import Itens.Equipable.Weapon.Weapon;
import Itens.HeroItem;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Hero extends Entity {

    protected int level;
    protected int xpToLevel;
    protected Weapon weapon;
    protected Helmet helmet;
    protected BodyArmor bodyArmor;
    protected ArrayList<HeroItem> inventory;

    protected String description;
    protected String heroClass;

    public Hero (String name) {
        this.name = name;
        this.maxHp += 100;
        this.strenght += 10;
        this.agility +=10;
        this.level = 1;
        this.xpToLevel = 10;
        this.inventory = new ArrayList<HeroItem>();
        this.scrap = 0;
    }

    /**
     * Receives an int number of stats available to distribute between STRENGTH and AGILITY.
     * @param availableStats
     */
    protected void allocateStats(int availableStats) {
        Scanner in = new Scanner(System.in);
        this.showStats();
        System.out.println("You have " + availableStats + " points to allocate");
        System.out.println("How many points would you like to add to STRENGHT?");
        if (in.hasNextInt()){
            int pointsToAdd = in.nextInt();
            int counter = 0;
            while (pointsToAdd > availableStats || pointsToAdd < 0) {
                System.out.println("Please enter a valid amount");
                if (in.hasNextInt()) pointsToAdd = in.nextInt();
                if (counter++ > 5) pointsToAdd = 0;
            }
            this.strenght += pointsToAdd;
            availableStats -= pointsToAdd;
        }
        if(availableStats == 0) return;
        this.showStats();
        System.out.println("You have " + availableStats + " points to allocate");
        System.out.println("How many points would you like to add to AGILITY?");
        if (in.hasNextInt()){
            int pointsToAdd = in.nextInt();
            int counter = 0;
            while (pointsToAdd > availableStats || pointsToAdd < 0) {
                System.out.println("Please enter a valid amount");
                if (in.hasNextInt()) pointsToAdd = in.nextInt();
                if (counter++ > 5) pointsToAdd = 0;
            }
            this.agility += pointsToAdd;
            availableStats -= pointsToAdd;
        }
        if (availableStats > 0){
            System.out.println("You have unused stat points, they have been added to STRENGHT");
            this.strenght += availableStats;
        }
        this.showStats();
    }

    /**
     * Shows a hero's main stats (name, class, level, XPtoLevel, maxHP, STR, AGI)
     */
    public void showStats() {
        System.out.println("******** " + this.name + " ********");
        System.out.println("******** " + this.getClass().getSimpleName() + " ********");
        System.out.println("Level " + this.level + "(" + this.xpToLevel + "Xp to level up)");
        System.out.println("Max HP: " + this.maxHp);
        System.out.println("Strength: " + this.strenght);
        System.out.println("Agility: " + this.agility);
    }

    /**
     * Receives an int amount of XP gained, if hero levels, allocates stats and determines XP for next level.
     * @param xpGained
     */
    public void gainXp ( int xpGained ) {
        if ( xpGained >= this.xpToLevel ) {
            xpGained -= this.xpToLevel;
            System.out.println(this.name + " has leveled to " + ++this.level);
            this.maxHp += 10; this.currentHp += 10;
            allocateStats(2);
            //determine nextlevel XP
            this.xpToLevel = this.level * 10;
            gainXp(xpGained);
        }
        else {
            xpToLevel -= xpGained;
        }
    }

    /**
     * Increments hero's Scrap.
     * @param scrapGained
     */
    public void gainScrap ( int scrapGained ) {
        this.scrap += scrapGained;
    }

    /**
     * Equips a weapon from the inventory, stores the current weapon.
     * @param newWeapon
     */
    public void equipWeapon( Weapon newWeapon ){
        this.inventory.add(this.weapon);
        this.weapon = newWeapon;
        this.inventory.remove(newWeapon);
    }

    /**
     * Equips a body armor from inventory, stores the current, and updates bonus stats.
     * @param newBodyArmor
     */
    public void equipBodyArmor(BodyArmor newBodyArmor) {
        this.maxHp += newBodyArmor.getBonusHp(); this.currentHp += newBodyArmor.getBonusHp(); this.agility += newBodyArmor.getBonusAgility();

        this.currentHp -= this.bodyArmor.getBonusHp(); this.maxHp -= this.bodyArmor.getBonusHp(); this.agility -= this.bodyArmor.getBonusAgility();

        this.inventory.add(this.bodyArmor);
        this.bodyArmor = newBodyArmor;
        this.inventory.remove(newBodyArmor);
    }

    /**
     * Equips a helmet from inventory, stores the current, and updates bonus stats.
     * @param newHelmet
     */
    public void equipHelmet(Helmet newHelmet) {
        this.maxHp += newHelmet.getBonusHp(); this.currentHp += newHelmet.getBonusHp(); this.agility += newHelmet.getBonusAgility();

        this.currentHp -= this.helmet.getBonusHp(); this.maxHp -= this.helmet.getBonusHp(); this.agility -= this.helmet.getBonusAgility();

        this.inventory.add(this.helmet);
        this.helmet = newHelmet;
        this.inventory.remove(newHelmet);
    }

    /**
     * Adds item to inventory if hero has sufficient scrap. Else prints error message.
     * @param itemToBuy
     * @return
     */
    public boolean buyItem(HeroItem itemToBuy){
        if (this.scrap >= itemToBuy.getValue()){
            this.inventory.add(itemToBuy);
            this.scrap -= itemToBuy.getValue();
            return true;
        }
        else {
            System.out.println("Not enough scrap to buy this item!");
            return false;
        }
    }

    /**
     * Sells item from inventory at half value(rounds down).
     * @param itemToSell
     */
    public void sellItem(HeroItem itemToSell) {
        this.scrap += itemToSell.getValue() / 2;
        this.inventory.remove(itemToSell);
    }

    /**
     * Fights a foe until someone perishes.
     * @param foe - the enemy to fight
     * @return boolean - if the hero survives or not
     */
    public boolean fight(Foe foe) {
        Scanner in = new Scanner(System.in);
        int choice = -1;

        int specialUses = 1;

        while (this.currentHp > 0 && foe.getCurrentHp() > 0){
            System.out.println( this.name + ": " + this.currentHp + "/" + this.maxHp );
            System.out.println( foe.getName() + ": " + foe.getCurrentHp() + "/" + foe.getMaxHp() );
            System.out.println();

            if (this.agility < foe.getAgility()) { //foe acts first
                foe.countDownDot();
                if (foe.getCurrentHp() < 1) break;
                this.currentHp -= foe.getStrenght();
                System.out.println(foe.getName() + " attacked for " + foe.getStrenght());
            }
            //hero's turn

            //todo if foes can deal DoT, countdown here
            if (this.currentHp <= 0) {
                this.perish();
                return false;
            }

            boolean done = false;
            while (!done){
                System.out.println("1. Basic attack");
                System.out.println("2. Special attack (" + specialUses + "/1)");
                System.out.println("3. Inventory");
                if (in.hasNextInt()) choice = in.nextInt();
                switch (choice) {
                    default:
                        System.out.println("Invalid choice");break;
                    case 1:
                        updateStats(this.weapon.basicAttack(), foe);
                        done = true;
                        break;
                    case 2:
                        if( specialUses-- > 0 ){
                            updateStats(this.weapon.specialAttack(), foe);
                            done = true;
                        }else System.out.println("No special uses left!");
                        break;
                    case 3:
                        if(!this.seeInventory(InventoryMode.BATTLE, foe)){
                            done = true;
                        }
                        break;
                }
                if (this.agility >= foe.getAgility()) { //foe acts after hero
                    foe.countDownDot();
                    if (foe.getCurrentHp() < 1) break;
                    this.currentHp -= foe.getStrenght();
                    System.out.println(foe.getName() + " attacked for " + foe.getStrenght());
                }
            }
        }
        if (this.currentHp <= 0) {
            this.perish();
            return false;
        }
        System.out.println("You gained " + foe.getXp() + "Xp and " + foe.getScrap() + " Scrap");
        this.gainXp(foe.getXp());
        this.gainScrap(foe.getScrap());
        return true;
    }

    /**
     * Shows inventory and related options to player. Receives foe as parameter in combat mode.
     * @param inventoryMode
     * @param foe
     * @return boolean - if hero still has turn ( hero loses turn if they use or equip an item ).
     */
    public boolean seeInventory(InventoryMode inventoryMode, Foe foe) {
        Scanner in = new Scanner(System.in);
        int choice = -2;
        boolean hasTurn = true;
        while (choice != -1) {
            int itemCount = 0;
            for (HeroItem itemInInventory : this.inventory) {
                System.out.println(++itemCount + ". " + itemInInventory.getName());
            }
            System.out.println("0. Return");

            if ( in.hasNextInt() ) choice = in.nextInt() - 1;
            if (choice >= 0 && choice < this.inventory.size()){
                hasTurn = this.inventory.get(choice).inspect(inventoryMode, this, foe);
                if (!hasTurn) return false;
            }
        }
        return true;
    }

    public void seeInventory(InventoryMode inventoryMode){
        Scanner in = new Scanner(System.in);
        int choice = -2;
        while (choice != -1){
            int itemCount = 0;
            for (HeroItem itemInInventory : this.inventory) {
                System.out.println(++itemCount + ". " + itemInInventory.getName());
            }
            System.out.println("0. Return");

            if (in.hasNextInt()) choice = in.nextInt() -1;
            if (choice >= 0 && choice < this.inventory.size()) {
                this.inventory.get(choice).inspect(inventoryMode, this);
            }
        }
    }

    public void removeFromInventory(HeroItem itemToRemove) {
        this.inventory.remove(itemToRemove);
    }

    /**
     * Applies damage & DoT to foe, healing to self.
     * @param stats - Array of stats to update ( 0 -> Damage, 1 -> DoT, 2 -> Healing ).
     * @param foe
     */
    public void updateStats (int[] stats, Foe foe){
        if (stats[0] != 0){
            foe.takeDamage(stats[0]+this.strenght);
            System.out.println("from your attack!");
        }
        if (stats[1] != 0){
            foe.updateDot(stats[1]);
        }
        if (stats[2] != 0){
            this.currentHp += stats[2];
            if ( this.currentHp > this.maxHp){
                this.currentHp = this.maxHp;
                System.out.println(this.name + " healed to full!");
            }else System.out.println(this.name + " healed " + stats[2] + "Hp!");
        }
    }

    /**
     * TODO do stuff when hero perishes ( save .txt name/level/room ? ).
     */
    private void perish(){
        System.out.println(this.name + " has perished");
        System.out.println(" __     ______  _    _    _    _     __      ________    _____  ______ _____  _____  _____ _    _ ______ _____  \n" +
                " \\ \\   / / __ \\| |  | |  | |  | |   /\\ \\    / /  ____|  |  __ \\|  ____|  __ \\|_   _|/ ____| |  | |  ____|  __ \\ \n" +
                "  \\ \\_/ / |  | | |  | |  | |__| |  /  \\ \\  / /| |__     | |__) | |__  | |__) | | | | (___ | |__| | |__  | |  | |\n" +
                "   \\   /| |  | | |  | |  |  __  | / /\\ \\ \\/ / |  __|    |  ___/|  __| |  _  /  | |  \\___ \\|  __  |  __| | |  | |\n" +
                "    | | | |__| | |__| |  | |  | |/ ____ \\  /  | |____   | |    | |____| | \\ \\ _| |_ ____) | |  | | |____| |__| |\n" +
                "    |_|  \\____/ \\____/   |_|  |_/_/    \\_\\/   |______|  |_|    |______|_|  \\_\\_____|_____/|_|  |_|______|_____/ ");
    }
}
