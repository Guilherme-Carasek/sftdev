package Domain;

public class Product {
    private String type;
    private String name;
    private double unitPrice;

    public Product(String type, String name, double unitPrice) {
        this.type = type;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
