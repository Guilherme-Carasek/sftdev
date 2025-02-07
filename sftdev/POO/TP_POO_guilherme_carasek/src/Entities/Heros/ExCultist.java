package Entities.Heros;

import Itens.Equipable.BodyArmor.CultistDuster;
import Itens.Equipable.Helmet.CultistHat;
import Itens.Equipable.Weapon.CoachGun;

public class ExCultist extends Hero{
    public ExCultist (String name, int statsGiven){
        super(name);
        this.maxHp += 50; this.currentHp = this.maxHp;
        this.strenght += 5;
        this.agility += 5;
        this.allocateStats(statsGiven);
        this.weapon = new CoachGun(0);
        this.helmet = new CultistHat(0);
        this.bodyArmor = new CultistDuster(0);
        this.description = "The Ex-Cultist is a generalist with access to a variety of tools";
        this.heroClass = "Ex-Cultist";
    }
}
