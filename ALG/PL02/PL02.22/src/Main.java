import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //22. Crie um programa que permita converter um valor em Megabytes para Bytes.

        Scanner in = new Scanner(System.in);

        System.out.println("insira o número de megabytes:");
        int mb = in.nextInt();

        System.out.println(mb +" megabytes correspondem a "+(mb *1000000)+" bytes.");
    }
}