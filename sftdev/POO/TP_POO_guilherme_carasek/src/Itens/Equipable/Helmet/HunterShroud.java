package Itens.Equipable.Helmet;

public class HunterShroud extends Helmet{
    public HunterShroud(int step) {
        super(step);
        this.name = "Hunter Shroud";
        this.value = 10;
        this.bonusHp = 2;
        this.bonusAgility = 3;
        super.scale();
    }
}
