package Views;

import Controllers.EngController;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class EngView {
    EngController engController;

    public EngView () throws FileNotFoundException {
        this.engController = new EngController();
    }

    public void engMenu () {
        Scanner in = new Scanner(System.in);
        int option;

        do {
            System.out.println("Bem vindo engenheiro");
            System.out.println("1. Consultar próximas revisões");
            System.out.println("2. Consultar histórico de revisões");
            System.out.println("0. Voltar");

            option = in.nextInt();

            switch (option) {
                default:
                    System.out.println("Opção inválida");
                    break;
                case 1:

                    break;
                case 2:

                    break;
                case 0:
                    break;
            }
        } while (option != 0);
    }

    public void printNextMaintenances() { }

    public void printMaintenanceHistory() { }
}
