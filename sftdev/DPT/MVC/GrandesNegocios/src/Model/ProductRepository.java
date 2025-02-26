package Model;

import Domain.Product;
import Domain.Sale;
import Tools.CSVReader;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ProductRepository {
    private ArrayList<Product> productsList = new ArrayList<>();


    public ProductRepository() throws FileNotFoundException {
        ArrayList<Sale> salesList = CSVReader.readSalesFileToArray("Files/minimercado.csv");
        for (Sale sale : salesList) {
            for (Product product : productsList){
                if (sale.getProduct().equals(product.getName())){
                    break;
                }
                productsList.add(new Product(sale.getCategory(), sale.getProduct(), sale.getUnitPrice()));
            }
        }
    }

    public ArrayList<Product> getProductsList() {
        return this.productsList;
    }
}
