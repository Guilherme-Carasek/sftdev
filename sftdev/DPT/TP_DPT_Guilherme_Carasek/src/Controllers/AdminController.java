package Controllers;

import Model.AttractionsRepository;
import Model.CostsRepository;
import Model.SalesRepository;

import java.io.FileNotFoundException;

public class AdminController {
    AttractionsRepository attractionsRepository;
    SalesRepository salesRepository;
    CostsRepository costsRepository;

    public AdminController() throws FileNotFoundException {
        this.attractionsRepository = new AttractionsRepository();
        this.salesRepository = new SalesRepository();
        this.costsRepository = new CostsRepository();
    }



}
