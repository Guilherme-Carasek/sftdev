package Ex_02;

import Ex_02.DiscountStrategies.DiscountStrategy;

public class PaymentProcessor {
    DiscountStrategy discountStrategy;

    public PaymentProcessor(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void calculateTotal(double baseAmount) {
        System.out.println(this.discountStrategy.calculateTotal(baseAmount));
    }
}
