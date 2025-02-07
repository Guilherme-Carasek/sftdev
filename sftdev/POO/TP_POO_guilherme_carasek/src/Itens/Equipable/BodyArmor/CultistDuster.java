package Itens.Equipable.BodyArmor;

public class CultistDuster extends BodyArmor{
    public CultistDuster(int step) {
        super(step);
        this.name = "Cultist Duster";
        this.value = 10;
        this.bonusHp = 9;
        this.bonusAgility = 1;
        super.scale();
    }
}
