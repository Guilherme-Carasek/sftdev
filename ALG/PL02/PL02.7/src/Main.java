import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //7. Algoritmo que lê o nome de um automóvel e o preço de fábrica
        // e retorna o nome do automóvel e o preço final

        Scanner in = new Scanner(System.in);

        System.out.println("qual o nome do automóvel?");
        String nome = in.nextLine();

        System.out.println("qual o preço de fábrica do automóvel?");
        double precfab = in.nextDouble();

        System.out.println("o preço final de um "+nome+" é "+(precfab*1.73));

        // enumerar as variaveis taxas no início para que possam ser facilmente alteradas no futuro
    }
}