package Controllers;

import Domain.Attraction;
import Model.AttractionsRepository;
import Model.CostsRepository;
import Model.SalesRepository;
import org.w3c.dom.Attr;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class AdminController {
    AttractionsRepository attractionsRepository;
    SalesRepository salesRepository;
    CostsRepository costsRepository;

    public AdminController(String attractionsFilePath, String salesFilePath, String costsFilePath) throws FileNotFoundException {
        this.attractionsRepository = new AttractionsRepository(attractionsFilePath);
        this.salesRepository = new SalesRepository(salesFilePath);
        this.costsRepository = new CostsRepository(costsFilePath);

    }

    public double getSalesTotal() {
        return 0;
    }

    public double getProfitsTotal() {
        return 0;
    }

    /**
     * Gets sales and profits, organized by month
     * @return ArrayList of table values, each an array of: [0] = month, [1] = total sales for the month, [2] = total profit for the month
     */
    public ArrayList<String[]> getSalesAndProfitsTable () {
        ArrayList<String[]> tableValues = new ArrayList<>();
        //organize each month into an array of strings, then add to ArrayList

        return tableValues;
    }

    public HashMap<Attraction, Integer> getAdultsFavoriteAttraction() {
        HashMap <Attraction, Integer> favoriteAttractionForAdults = new HashMap<>();
        //logic to verify the favorite attraction and assign it to the return variable

        return favoriteAttractionForAdults;
    }

    public HashMap<Attraction, Integer> getChilrenFavoriteAttraction() {
        HashMap <Attraction, Integer> favoriteAttractionForChildren = new HashMap<>();

        //logic to verify the favorite attraction and assign it to the return variable
        return favoriteAttractionForChildren;
    }

    public HashMap<Attraction, Integer> getFavoriteAttraction() {
        HashMap <Attraction, Integer> favoriteAttraction = new HashMap<>();
        //logic to verify the favorite attraction and assign it to the return variable
        return favoriteAttraction;
    }

    public HashMap<Attraction, Double> getMostProfitableAttraction() {
        HashMap<Attraction, Double> mostProfitableAttraction = new HashMap<>();
        // logic to decide the most profitable attraction and assign to the return variable
        return mostProfitableAttraction;
    }

    public HashMap<Attraction, Double> getLeastProfitableAttraction() {
        HashMap<Attraction, Double> leastProfitableAttraction = new HashMap<>();
        // logic to decide the least profitable attraction and assign to the return variable, with double total profits
        return leastProfitableAttraction;
    }

    public Attraction getBestDurationValueAttraction () {
        double bestDurationValue = 0;
        Attraction bestValueAttraction = new Attraction(0, "default", 0,0,0);

        for (Attraction currentAttraction : this.attractionsRepository.getAttractionList()) {
            double currentDurationValue = (currentAttraction.getDurationSeconds() / currentAttraction.getAdultPrice() );
            if (currentDurationValue > bestDurationValue) {
                bestDurationValue = currentDurationValue;
                bestValueAttraction = currentAttraction;
            }
        }
        return bestValueAttraction;
    }

    public void addNewLogin(String userTyper, String userName, String password) {
        //add new user login to file
    }
}
