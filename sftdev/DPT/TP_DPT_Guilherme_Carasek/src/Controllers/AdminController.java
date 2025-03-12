package Controllers;

import Domain.Attraction;
import Model.AttractionsRepository;
import Model.CostsRepository;
import Model.SalesRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AdminController {
    AttractionsRepository attractionsRepository;
    SalesRepository salesRepository;
    CostsRepository costsRepository;

    public AdminController() throws FileNotFoundException {
        this.attractionsRepository = new AttractionsRepository();
        this.salesRepository = new SalesRepository();
        this.costsRepository = new CostsRepository();
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

    public Attraction getAdultsFavoriteAttraction() {
        Attraction favoriteAttractionForAdults;

        return favoriteAttractionForAdults;
    }

}
