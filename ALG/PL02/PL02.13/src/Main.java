import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//retorna o nome de um produto à partir de um código com estrutura LER CASO

        Scanner in = new Scanner(System.in);

        System.out.println("insira o código do produto:");
        String cod = in.nextLine();

        switch(cod){
            case "001":
                System.out.println("001-Parafuso");
                break;
            case "002":
                System.out.println("002-Porca");
                break;
            case "003":
                System.out.println("003-Prego");
                break;
            default:
                System.out.println("não definido");
                break;
        }
    }
}