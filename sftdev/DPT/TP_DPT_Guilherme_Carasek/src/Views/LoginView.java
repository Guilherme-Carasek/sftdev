package Views;

import Controllers.LoginController;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginView {
    LoginController loginController;

    public LoginView() throws FileNotFoundException {
        this.loginController = new LoginController();
    }

    public void startView() throws FileNotFoundException {
        Scanner in = new Scanner(System.in);

        int option;

        do {
            System.out.println("Bem vindo ao CESAELand!");
            System.out.println("1. Entrar como visitante");
            System.out.println("2. Fazer login");
            System.out.println("0. Sair");

            option = in.nextInt();

            switch (option){
                case 1:
                    GuestView guestView = new GuestView();
                    guestView.guestMenu();
                    break;
                case 2:
                    System.out.println("Nome de utilizador:");
                    String userName = in.next();

                    System.out.println("Password");
                    String password = in.next();

                    validateLogin(userName, password);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }while (option != 0);
    }

    private void validateLogin(String userName, String password) throws FileNotFoundException {
        String userType = loginController.accessType(userName, password);

        switch (userType){
            case "ADMIN":
                AdminView adminView = new AdminView();
                adminView.adminMenu();
                break;
            case "ENG":

                break;
            case "ERROR":
                System.out.println("Dados de login inválidos");
                break;
        }
    }
}
