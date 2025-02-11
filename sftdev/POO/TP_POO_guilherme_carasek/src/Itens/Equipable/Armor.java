package Itens.Equipable;

import Entities.Heros.Hero;
import Enums.InventoryMode;
import Itens.HeroItem;

public abstract class Armor extends HeroItem {
    protected int bonusHp;
    protected int bonusAgility;

    public Armor( int step ) {
        super(step);
        this.description = "It's an armor item, no lore here...";
    }

    @Override
    protected void scale() {
        super.scale();
        this.bonusHp += 2 * this.step;
        this.bonusAgility += 2 * this.step;

    }

    public int getBonusHp() {
        return bonusHp;
    }

    public int getBonusAgility() {
        return bonusAgility;
    }
}