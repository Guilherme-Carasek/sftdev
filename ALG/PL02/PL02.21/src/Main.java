import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //21. Crie um programa que permita converter um valor em bytes para bits

        Scanner in = new Scanner(System.in);

        System.out.println("insira o número de bytes:");
        int by = in.nextInt();

        System.out.println(by+" bytes correspondem a "+(by*8)+" bits.");
    }
}