import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //6.  Programa que recebe o valor do quilo de um produto e da quantidade de quilos consumida
        // e retorna o valor a ser pago

        Scanner in = new Scanner(System.in);

        System.out.println("qual o preço por quilo?");
        double precokg = in.nextDouble();

        //sout
        System.out.println("quantos quilos consumiu?");
        double peso = in.nextDouble();

        System.out.println("deves pagar " + (precokg*peso));
    }
}