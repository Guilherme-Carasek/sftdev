package Entities;

import Entities.Heros.Hero;
import Itens.Equipable.BodyArmor.CultistDuster;
import Itens.Equipable.BodyArmor.HunterTrenchcoat;
import Itens.Equipable.BodyArmor.ScrapperBodyPlate;
import Itens.Equipable.Consumable.DragonHeart;
import Itens.Equipable.Helmet.CultistHat;
import Itens.Equipable.Helmet.HunterShroud;
import Itens.Equipable.Helmet.ScrapperHelmet;
import Itens.Equipable.Weapon.CoachGun;
import Itens.Equipable.Weapon.HuntingRifle;
import Itens.Equipable.Weapon.Shotgun;
import Itens.HeroItem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Vendor {
    private ArrayList<HeroItem> stock;

    public Vendor() {
        this.stock = new ArrayList<>();
    }

    /**
     * Greets hero.
     * @return String
     */
    public String greet() {
        return "Oh Traveler! Need anything?";
    }

    /**
     * Returns dialogue when the player chooses to talk.
     * @return String
     */
    public String talk(int counter) {
        switch (counter) {
            default:
                return null;
            case 0:
                return "Name's Reggie, I've been looking for someone";
            case 1:
                return "I have lots I don't need";

        }
    }


    /**
     * Generates 10 random items in the vendor stock array, based on hero class.
     * TODO add new items, add potions
     * @param hero
     * @param step
     */
    public void generateStock(Hero hero, int step) {

        String heroType = hero.getClass().getSimpleName();
        Random rd = new Random();

        while (this.stock.size() < 10) {

            int heroItemToCreate = rd.nextInt(1, 6);
            int stepVariance = rd.nextInt(step - 2, step + 2);

            switch (heroType) {

                case "ExCultist":

                    switch (heroItemToCreate) {

                        case 1: // BodyArmor
                            CultistDuster cultistDuster = new CultistDuster(stepVariance);
                            this.stock.add(cultistDuster);
                            break;

                        case 2: // Helmet
                            CultistHat cultistHat = new CultistHat(stepVariance);
                            this.stock.add(cultistHat);
                            break;

                        case 3: // Weapon
                            CoachGun coachGun = new CoachGun(stepVariance);
                            this.stock.add(coachGun);
                            break;

                        case 4: // Potion
                            DragonHeart dragonHeart = new DragonHeart(stepVariance);
                            this.stock.add(dragonHeart);
                            break;

                        case 5: // InstantWeapon
                            break;
                    }
                    break;

                case "Hunter":
                    switch (heroItemToCreate) {

                        case 1: // BodyArmor
                            HunterTrenchcoat hunterTrenchcoat = new HunterTrenchcoat(stepVariance);
                            this.stock.add(hunterTrenchcoat);
                            break;

                        case 2: // Helmet
                            HunterShroud hunterShroud = new HunterShroud(stepVariance);
                            this.stock.add(hunterShroud);
                            break;

                        case 3: // Weapon
                            HuntingRifle huntingRifle = new HuntingRifle(stepVariance);
                            this.stock.add(huntingRifle);
                            break;

                        case 4: // Potion
                            DragonHeart dragonHeart = new DragonHeart(stepVariance);
                            this.stock.add(dragonHeart);
                            break;

                        case 5: // InstantWeapon
                            break;
                    }
                    break;

                case "Scrapper":

                    switch (heroItemToCreate){

                        case 1: // BodyArmor
                            ScrapperBodyPlate scrapperBodyPlate = new ScrapperBodyPlate(stepVariance);
                            this.stock.add(scrapperBodyPlate);
                            break;

                        case 2: // Helmet
                            ScrapperHelmet scrapperHelmet = new ScrapperHelmet(stepVariance);
                            this.stock.add(scrapperHelmet);
                            break;

                        case 3: // Weapon
                            Shotgun shotgun = new Shotgun(stepVariance);
                            this.stock.add(shotgun);
                            break;

                        case 4: // Potion
                            DragonHeart dragonHeart = new DragonHeart(stepVariance);
                            this.stock.add(dragonHeart);
                            break;

                        case 5: // Grenade
                            break;
                    }
                    break;
            }

        }

    }

    /**
     * Display list of stocked items, with indexes starting from 1.
     */
    public void displayStock(Hero hero){
        Scanner in = new Scanner(System.in);


        int choice = -2;
        while (choice != -1){
            System.out.println("You have " + hero.getScrap() + " scrap.");
            int counter = 0;
            // Scanner in = new Scanner(System.in);
            for ( HeroItem itemToShow : this.stock ){
                System.out.println(++counter + ". " + itemToShow.getName() + ": " + itemToShow.getValue() + " scrap.");
            }
            System.out.println("0. Return");
            if (in.hasNextInt()) choice = in.nextInt() -1;
            if (choice >= 0 && choice < this.stock.size()){
                if (hero.buyItem(this.stock.get(choice))) this.removeFromStock(this.stock.get(choice));
            }
        }
    }

    public void removeFromStock(HeroItem itemToRemove){
        this.stock.remove(itemToRemove);
    }

}
