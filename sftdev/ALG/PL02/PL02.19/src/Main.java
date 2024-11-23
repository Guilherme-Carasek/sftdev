import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //19. Crie um programa que permita converter um valor em horas
        // para segundos e mostre o valor em segundos

        Scanner in = new Scanner(System.in);

        System.out.println("insira o valor em horas:");
        int h = in.nextInt();
        int s = h * 3600;
        System.out.println(h + " horas equivalem a " + s + " segundos");
    }
}