package Itens.Equipable.Helmet;

public class CultistHat extends Helmet{
    public CultistHat(int step) {
        super(step);
        this.name = "Cultist Hat";
        this.value = 10;
        this.bonusHp = 6;
        this.bonusAgility = 1;
        super.scale();
    }
}
