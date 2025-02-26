package Domain;

import Model.SalesRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Product {
    private String type;
    private String name;
    private int stock = 1000;
    private double unitPrice;

    public Product(String type, String name, double unitPrice) {
        this.type = type;
        this.name = name;
        this.unitPrice = unitPrice;
        SalesRepository salesRepository = null;
        try {
            salesRepository = new SalesRepository();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for ( Sale sale : salesRepository.getSalesList()){
            if (this.name.equals(sale.getProduct())){
                this.stock -= sale.getUnitsSold();
            }
        }
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
