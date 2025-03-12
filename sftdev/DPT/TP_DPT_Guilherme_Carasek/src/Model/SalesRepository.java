package Model;

import Domain.Sale;
import Tools.CSVReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SalesRepository {
    ArrayList<Sale> salesList;

    public SalesRepository() throws FileNotFoundException {
        this.salesList = CSVReader.readSalesFileToArray("files/Cesaeland_vendas");
    }

    public ArrayList<Sale> getSalesList() {
        return salesList;
    }
}
