package Views;

import Controllers.AdminController;
import Domain.Attraction;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdminView {
    AdminController adminController = new AdminController();

    public AdminView() throws FileNotFoundException {
        this.adminController = new AdminController();
    }

    public void  adminMenu() {
        Scanner in = new Scanner(System.in);
        int option;

        do {
            System.out.println("Bem vindo administrador");
            System.out.println("1. Consultar o total de todas as vendas");
            System.out.println("2. Consultar o total de lucro");
            System.out.println("3. Consultar o total de vendas e lucro por mês");
            System.out.println("4. Consultar a atração mais procurada por adultos");
            System.out.println("5. Consultar a atração mais procurada por crianças");
            System.out.println("6. Consultar a atração mais procurada");
            System.out.println("7. Consultar a atração mais lucrativa");
            System.out.println("8. Consultar a atração menos lucrativa");
            System.out.println("9. Consultar a atração com melhor preço/tempo");
            System.out.println("10. Adicionar novo login");
            System.out.println("0. Voltar");

            option = in.nextInt();

            switch (option){
                case 1:
                    printSalesTotal();
                    break;
                case 2:
                    printTotalProfit();
                    break;
                case 3:
                    printSalesProfitTable();
                    break;
                case 4:
                    printAdultsFavorite();
                    break;
                case 5:
                    printChildrenFavorite();
                    break;
                case 6:
                    printFavoriteAttraction();
                    break;
                case 7:
                    printMostProfitableAttraction();
                    break;
                case 8:
                    printLeastProfitableAttraction();
                    break;
                case 9:
                    printBestCostBenefitAttraction();
                    break;
                case 10:
                    createNewLogin();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

        } while (option != 0);
    }

    private void printSalesTotal() { }

    private void printTotalProfit() { }

    private void printSalesProfitTable() { }

    private void printAdultsFavorite() { }

    private void printChildrenFavorite() { }

    private void printFavoriteAttraction() { }

    private void printMostProfitableAttraction() { }

    private void printLeastProfitableAttraction() { }

    private void printBestCostBenefitAttraction() {
        Attraction bestCostBenefitAttraction = this.adminController.getBestDurationValueAttraction();

        System.out.println("A atração com maior duração por unidade de preço é a " + bestCostBenefitAttraction.getName()+":");
        System.out.println((bestCostBenefitAttraction.getDurationSeconds() / bestCostBenefitAttraction.getAdultPrice()) + "s/€");
    }

    private void createNewLogin() { }
}
