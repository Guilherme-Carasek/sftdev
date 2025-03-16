package Controllers;

import Domain.Attraction;
import Domain.Sale;
import Model.AttractionsRepository;
import Model.SalesRepository;

import java.io.FileNotFoundException;
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

        // initialize return Array with minimum values
        String[][] nextMaintenances = { {"0", "default", "51"}, {"0", "default", "51"}, {"0", "default", "51"} };

        for (Attraction currentAttraction : attractionsList) {
            int totalTicketsSold = 0;
            for (Sale currentSale : salesList) {
                if (currentSale.getAttractionId() == currentAttraction.getId()) {
                    totalTicketsSold++;
                }
            }
            int ticketsBeforeNextMaintenance = Math.abs((totalTicketsSold % 50) - 50);
            if (ticketsBeforeNextMaintenance < Integer.parseInt(nextMaintenances[0][2])) {
                //if the current maintenance gets the priority spot on the array, shifts the others to the next spots
                nextMaintenances[2] = new String[]{nextMaintenances[1][0], nextMaintenances[1][1], nextMaintenances[1][2]};
                nextMaintenances[1] = new String[]{nextMaintenances[0][0], nextMaintenances[0][1], nextMaintenances[0][2]};
                // then add current maintenance to the array
                nextMaintenances[0][0] = String.valueOf(currentAttraction.getId());
                nextMaintenances[0][1] = currentAttraction.getName();
                nextMaintenances[0][2] = String.valueOf(ticketsBeforeNextMaintenance);
            } else if (ticketsBeforeNextMaintenance < Integer.parseInt(nextMaintenances[1][2])) {
                // same
                nextMaintenances[2] = new String[]{nextMaintenances[1][0], nextMaintenances[1][1], nextMaintenances[1][2]};
                //same
                nextMaintenances[1][0] = String.valueOf(currentAttraction.getId());
                nextMaintenances[1][1] = currentAttraction.getName();
                nextMaintenances[1][2] = String.valueOf(ticketsBeforeNextMaintenance);
            } else if (ticketsBeforeNextMaintenance < Integer.parseInt(nextMaintenances[2][2])) {
                //no need to shift positions, the last row is overwritten
                nextMaintenances[2][0] = String.valueOf(currentAttraction.getId());
                nextMaintenances[2][1] = currentAttraction.getName();
                nextMaintenances[2][2] = String.valueOf(ticketsBeforeNextMaintenance);
            }
        }

        return nextMaintenances;
    }

    public String[][] get3LastMaintenances() {
        String[][] lastMaintenances = { {"0", "default", "51"}, {"0", "default", "51"}, {"0", "default", "51"} };

        return lastMaintenances;
    }
}
