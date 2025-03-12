package Tools;

import Domain.Attraction;
import Domain.Sale;
import Domain.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {

    public static ArrayList<User> readLoginsFileToArray(String filePath) throws FileNotFoundException {
        ArrayList<User> usersList = new ArrayList<User>();

        Scanner scanner = new Scanner(new File(filePath));

        scanner.nextLine();

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();

            String[] entries = line.split(",");

            usersList.add(new User(entries[0], entries[1], entries[2]));
        }
        return usersList;
    }

    public static ArrayList<Attraction> readAttractionsFileToArray(String filePath) throws FileNotFoundException {
        ArrayList<Attraction> attractionsList = new ArrayList<Attraction>();

        Scanner scanner = new Scanner(new File(filePath));

        scanner.nextLine();

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();

            String[] entries = line.split(";");

            attractionsList.add(new Attraction(
                    Integer.parseInt(entries[0]),
                    entries[1],
                    Double.parseDouble(entries[2]),
                    Double.parseDouble(entries[3]),
                    Integer.parseInt(entries[4]))
            );
        }

        return attractionsList;
    }

    public static ArrayList<Sale> readSalesFileToArray(String filePath) throws FileNotFoundException {
        ArrayList<Sale> salesList = new ArrayList<Sale>();
        Scanner scanner = new Scanner(new File(filePath));

        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] entries = line.split(";");

            salesList.add(new Sale(
                    Integer.parseInt(entries[0]),
                    entries[1],
                    entries[2].equals("adulto")
            ));
        }

        return salesList;
    }
}
