package Entities.Heros;

import Entities.Entity;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Hero extends Entity {

    protected int level;
    protected int xpToLevel;
    protected Weapon weapon;
    protected Helmet helmet;
    protected BodyArmor bodyArmor;
    protected ArrayList<HeroItem>;

    protected String description;

    public Hero () {
        this.maxHp += 100;
        this.strenght += 10;
        this.agility +=10;
        this.level = 1;
        this.xpToLevel = 10;
        this.allocateStats(30);

    }

    /**
     * receives an int number of stats available to distribute between STRENGHT and AGILITY
     * @param availableStats
     */
    private void allocateStats(int availableStats) {
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
    private void showStats() {
        System.out.println("******** " + this.name + " ********");
        System.out.println("******** " + this.heroClass + " ********");
        System.out.println("Level " + this.level + "(" + this.xpToLevel + "Xp to level up)");
        System.out.println("Max HP: " + this.maxHp);
        System.out.println("Strenght: " + this.strenght);
        System.out.println("Agility: " + this.agility);
    }

    /**
     * receives an int amount of XP gained, if hero levels, allocates stats and determines XP for next level
     * @param xpGained
     */
    public void gainXp ( int xpGained ) {

    }

}
