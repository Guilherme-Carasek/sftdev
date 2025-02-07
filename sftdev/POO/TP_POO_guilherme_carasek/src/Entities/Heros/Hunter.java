package Entities.Heros;

import Itens.Equipable.BodyArmor.HunterTrenchcoat;
import Itens.Equipable.Helmet.HunterShroud;
import Itens.Equipable.Weapon.HuntingRifle;

public class Hunter extends Hero{
    public Hunter (String name, int statsGiven){
        super(name);
        this.maxHp += 0; this.currentHp = this.maxHp;
        this.strenght += 10;
        this.agility += 25;
        this.allocateStats(statsGiven);
        this.weapon = new HuntingRifle(0);
        this.helmet = new HunterShroud(0);
        this.bodyArmor = new HunterTrenchcoat(0);
        this.description = "The hunter specializes in precise shots to unsuspecting enemies";
        this.heroClass = "Hunter";
    }
}
