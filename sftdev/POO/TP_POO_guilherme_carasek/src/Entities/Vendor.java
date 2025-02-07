package Entities;

import Entities.Heros.Hero;
import Itens.Equipable.BodyArmor.CultistDuster;
import Itens.Equipable.BodyArmor.HunterTrenchcoat;
import Itens.Equipable.BodyArmor.ScrapperBodyPlate;
import Itens.Equipable.Helmet.CultistHat;
import Itens.Equipable.Helmet.HunterShroud;
import Itens.Equipable.Helmet.ScrapperHelmet;
import Itens.Equipable.Weapon.CoachGun;
import Itens.Equipable.Weapon.HuntingRifle;
import Itens.Equipable.Weapon.Shotgun;
import Itens.HeroItem;

import java.util.ArrayList;
import java.util.Random;

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
    protected void generateStock(Hero hero, int step) {

        String heroType = hero.getClass().getSimpleName();
        Random rd = new Random();

        for (int i = 0; i < 10; i++) {

            int heroItemToCreate = rd.nextInt(1, 3);
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
                            break;

                        case 5: // Grenade
                            break;
                    }
                    break;
            }

        }

    }

}
