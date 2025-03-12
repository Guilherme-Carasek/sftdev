package Model;

import Domain.Attraction;
import Tools.CSVReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AttractionsRepository {
    ArrayList<Attraction> attractionList;

    public AttractionsRepository() throws FileNotFoundException {
        this.attractionList = CSVReader.readAttractionsFileToArray("files/Cesaeland_atracoes.csv");
    }

    public ArrayList<Attraction> getAttractionList() {
        return attractionList;
    }
}
