package Controllers;

import Domain.Product;
import Model.ProductRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Set;

public class CustomerController {
    private ProductRepository productRepository;

    public CustomerController() throws FileNotFoundException {
        this.productRepository = new ProductRepository();
    }

    public ArrayList<Product> getAvailableProducts() {
        return productRepository.getProductsList();
    }
}
