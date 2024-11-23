import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Qual o seu nome?");
        System.out.println ("olá "+in.nextLine()+"!");
        /*
        não guarda a informação
        otws usa String variável = in.nextLine();
         */
    }
}
