package Entities.Heros;

import Entities.Entity;
import Entities.Foes.Foe;
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
//                else in.reset();
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
//                else in.reset();
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
        System.out.println("******** " + this.heroClass + " ********");
        System.out.println("Level " + this.level + "(" + this.xpToLevel + "Xp to level up)");
        System.out.println("Max HP: " + this.maxHp);
        System.out.println("Strenght: " + this.strenght);
        System.out.println("Agility: " + this.agility);
    }

    /**
     * Receives an int amount of XP gained, if hero levels, allocates stats and determines XP for next level.
     * @param xpGained
     */
    public void gainXp ( int xpGained ) {
        if ( xpGained >= this.xpToLevel ) {
            xpGained -= this.xpToLevel;
            this.level++;
            this.maxHp += 10; this.currentHp += 10;
            allocateStats(1);
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
     * Sells item from inventory at half value(rounds down).
     * @param itemToSell
     */
    public void sellItem(HeroItem itemToSell) {
        this.scrap += itemToSell.getValue() / 2;
        this.inventory.remove(itemToSell);
    }

    /**
     * Fights a foe until someone perishes.
     * @param foe
     * @return 3 to exit the room after combat.
     */
    public int fight(Foe foe) {
        Scanner in = new Scanner(System.in);

        while (this.currentHp > 0 && foe.getCurrentHp() > 0){
            System.out.println(this.name + ": " + this.currentHp );
        }

        return 3;
    }
}
