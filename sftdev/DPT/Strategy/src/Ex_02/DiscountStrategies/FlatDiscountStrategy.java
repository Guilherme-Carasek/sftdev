package Ex_02.DiscountStrategies;

public class FlatDiscountStrategy implements DiscountStrategy {
    private double flatDiscount;

    public FlatDiscountStrategy(double flatDiscount) {
        this.flatDiscount = flatDiscount;
    }


    @Override
    public String calculateTotal(double baseAmount) {
        return "O total com desconto fixo é " + (baseAmount - this.flatDiscount) + "€";
    }
}
