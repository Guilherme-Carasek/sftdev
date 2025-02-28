package Ex_02;

import Ex_02.DiscountStrategies.FlatDiscountStrategy;
import Ex_02.DiscountStrategies.NoDiscountStrategy;
import Ex_02.DiscountStrategies.PercentageDiscountStrategy;

public class Main {
    public static void main(String[] args) {

        PaymentProcessor paymentProcessor = new PaymentProcessor(new NoDiscountStrategy());
        paymentProcessor.calculateTotal(100);

        paymentProcessor = new PaymentProcessor(new FlatDiscountStrategy(10));
        paymentProcessor.calculateTotal(100);

        paymentProcessor = new PaymentProcessor(new PercentageDiscountStrategy(0.3));
        paymentProcessor.calculateTotal(100);
    }
}
