package Model;

import Domain.Costs;
import Tools.CSVReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CostsRepository {
    ArrayList<Costs> costsList;

    public CostsRepository() throws FileNotFoundException {
        this.costsList = CSVReader.readCostsFileToArray("files/Cesaeland_custos.csv");
    }

    public ArrayList<Costs> getCostsList() {
        return costsList;
    }
}
