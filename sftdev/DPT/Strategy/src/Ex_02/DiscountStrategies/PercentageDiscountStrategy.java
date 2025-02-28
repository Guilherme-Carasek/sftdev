package Ex_02.DiscountStrategies;

public class PercentageDiscountStrategy implements DiscountStrategy {
    private double percentDiscount;

    public PercentageDiscountStrategy(double percentDiscount) {
        this.percentDiscount = percentDiscount;
    }


    @Override
    public String calculateTotal(double baseAmount) {
        return "O total com deconto percentual é " + (baseAmount - (this.percentDiscount * baseAmount)) + "€";
    }
}
