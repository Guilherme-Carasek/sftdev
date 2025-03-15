package Controllers;

import Domain.Attraction;
import Domain.Sale;
import Model.AttractionsRepository;
import Model.SalesRepository;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class EngController {
    AttractionsRepository attractionsRepository;
    SalesRepository salesRepository;

    public EngController() throws FileNotFoundException {
        this.attractionsRepository = new AttractionsRepository();
        this.salesRepository = new SalesRepository();
    }

    public String[][] getNextMaintenances() {
        ArrayList<Attraction> attractionsList = attractionsRepository.getAttractionList();
        ArrayList<Sale> salesList = salesRepository.getSalesList();
    }

    public String[][] get3LastMaintenances() {

    }
}
