package Controllers;

import Domain.Attraction;
import Model.AttractionsRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GuestController {
    AttractionsRepository attractionsRepository;

    public GuestController() throws FileNotFoundException {
        this.attractionsRepository = new AttractionsRepository();
    }

    public ArrayList<Attraction> getListOfAttractions() {
        return this.attractionsRepository.getAttractionList();
    }
}
