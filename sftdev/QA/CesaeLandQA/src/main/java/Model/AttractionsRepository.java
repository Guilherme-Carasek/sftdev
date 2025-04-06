package Model;

import Domain.Attraction;
import Tools.CSVReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AttractionsRepository {
    ArrayList<Attraction> attractionList;

    public AttractionsRepository(String filePath) throws FileNotFoundException {
        this.attractionList = CSVReader.readAttractionsFileToArray(filePath);
    }

    public ArrayList<Attraction> getAttractionList() {
        return attractionList;
    }
}
