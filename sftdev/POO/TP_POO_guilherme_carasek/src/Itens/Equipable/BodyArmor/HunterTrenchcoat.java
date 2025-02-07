package Itens.Equipable.BodyArmor;

public class HunterTrenchcoat extends BodyArmor{
    public HunterTrenchcoat(int step) {
        super(step);
        this.name = "Hunter Trench Coat";
        this.value = 10;
        this.bonusHp = 3;
        this.bonusAgility = 5;
        super.scale();
    }
}
