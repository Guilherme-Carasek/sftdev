import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //4. Ler a base e altura de um triângulo e calcular a sua área

        Scanner in = new Scanner(System.in);

        System.out.println("insira a base do triângulo");
        double b = in.nextDouble();

        System.out.println("insira a altura do triângulo");
        double h = in.nextDouble();

        double a = b*h/2;
        System.out.println("a área do triângulo é "+a);
    }
}