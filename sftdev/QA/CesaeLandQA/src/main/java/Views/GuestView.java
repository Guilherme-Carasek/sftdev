package Views;

import Controllers.GuestController;
import Domain.Attraction;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GuestView {
    GuestController guestController;

    public GuestView(String attractionsFilePath) throws FileNotFoundException {
        this.guestController = new GuestController(attractionsFilePath);
    }

    public void guestMenu() {
        Scanner in = new Scanner(System.in);
        int option;

        do {
            System.out.println("1. Consultar atrações disponíveis");
            System.out.println("2. Consultar atrações favoritas");
            System.out.println("0. Sair");

            option = in.nextInt();

            switch (option) {
                case 1:
                    printAvailableAttractions();
                    break;
                case 2:
                    printFavoriteAttractions();
                    break;
                case 0:
                    System.out.println("Volte sempre");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

        } while (option != 0);
    }

    private void printAvailableAttractions() {
        ArrayList<Attraction> attractionList = this.guestController.getListOfAttractions();

        System.out.println("Atração  |  Preço adulto  |  Preço criança  |  Duração");
        for (Attraction currentAttraction : attractionList) {
            System.out.print(currentAttraction.getName());
            System.out.print("  |  ");
            System.out.print(currentAttraction.getAdultPrice());
            System.out.print("  |  ");
            System.out.print(currentAttraction.getChildPrice());
            System.out.print("  |  ");
            System.out.print(( currentAttraction.getDurationSeconds() / 60 ) + ":" + (currentAttraction.getDurationSeconds() % 60));
            System.out.println();
        }
    }

    private void printFavoriteAttractions() {

    }
}
