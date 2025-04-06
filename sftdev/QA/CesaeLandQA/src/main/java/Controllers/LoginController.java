package Controllers;

import Domain.User;
import Model.UsersRepository;

import java.io.FileNotFoundException;

public class LoginController {
    UsersRepository usersRepository;

    public LoginController (String usersFilePath) throws FileNotFoundException {
        this.usersRepository = new UsersRepository(usersFilePath);
    }

    public String accessType(String userName, String password){
        String accessType = "ERROR";

        for (User currentUser : this.usersRepository.getUsersList()) {
            if ( currentUser.getUserName().equals(userName) && currentUser.getPassword().equals(password) ){
                accessType = currentUser.getUserType();
            }
        }

        return accessType;
    }
}
