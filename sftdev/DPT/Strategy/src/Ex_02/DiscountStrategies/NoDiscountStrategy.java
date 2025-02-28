package Ex_02.DiscountStrategies;

public class NoDiscountStrategy implements DiscountStrategy {
    public NoDiscountStrategy() {
    }

    @Override
    public String calculateTotal(double baseAmount) {
        return "O valor total sem deconto é " + baseAmount + "€";
    }
}
