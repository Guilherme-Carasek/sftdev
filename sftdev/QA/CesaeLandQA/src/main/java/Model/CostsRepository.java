package Model;

import Domain.Costs;
import Tools.CSVReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CostsRepository {
    ArrayList<Costs> costsList;

    public CostsRepository(String filePath) throws FileNotFoundException {
        this.costsList = CSVReader.readCostsFileToArray(filePath);
    }

    public ArrayList<Costs> getCostsList() {
        return costsList;
    }
}
