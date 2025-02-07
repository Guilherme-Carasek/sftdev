package Itens.Equipable.Helmet;

public class ScrapperHelmet extends Helmet{
    public ScrapperHelmet(int step) {
        super(step);
        this.name = "Scrapper Helmet";
        this.value = 10;
        this.bonusHp = 15;
        this.bonusAgility = -1;
        super.scale();
    }
}
