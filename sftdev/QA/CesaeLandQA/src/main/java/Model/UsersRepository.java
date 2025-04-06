package Model;

import Domain.User;
import Tools.CSVReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class UsersRepository {
    private ArrayList<User> usersList;

    public UsersRepository (String filePath) throws FileNotFoundException {
        this.usersList = CSVReader.readLoginsFileToArray(filePath);
    }

    public ArrayList<User> getUsersList() {
        return this.usersList;
    }
}
