import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//retorna o nome de um produto à partir de um código

        Scanner in = new Scanner(System.in);

        System.out.println("insira o código do produto:");
        String cod = in.nextLine();

        if (cod.equals("001")) {
            System.out.println("Parafuso");
        } else {
            if (cod.equals("002")) {
                System.out.println("Porca");
            } else {
                if (cod.equals("003")) {
                    System.out.println("Prego");
                } else {
                    System.out.println("Não definido");
                }
            }


        }
    }
}