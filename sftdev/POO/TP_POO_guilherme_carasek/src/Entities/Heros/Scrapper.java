package Entities.Heros;

import Itens.Equipable.BodyArmor.ScrapperBodyPlate;
import Itens.Equipable.Helmet.ScrapperHelmet;
import Itens.Equipable.Weapon.Shotgun;

public class Scrapper extends Hero{
    public Scrapper (String name, int statsGiven){
        super(name);
        this.maxHp += 50; this.currentHp = this.maxHp;
        this.strenght += 10;
        this.agility += 0;
        this.allocateStats(statsGiven);
        this.weapon = new Shotgun(0);
        this.helmet = new ScrapperHelmet(0);
        this.bodyArmor = new ScrapperBodyPlate(0);
        this.description = "The Scrapper is";
        this.heroClass = "Scrapper";
    }
}
