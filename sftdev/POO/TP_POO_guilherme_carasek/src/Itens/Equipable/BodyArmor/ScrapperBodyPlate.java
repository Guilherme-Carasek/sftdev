package Itens.Equipable.BodyArmor;

public class ScrapperBodyPlate extends BodyArmor{
    public ScrapperBodyPlate(int step) {
        super(step);
        this.name = "Scrapper Body Plate";
        this.value = 10;
        this.bonusHp = 20;
        this.bonusAgility = -2;
        super.scale();
    }
}
