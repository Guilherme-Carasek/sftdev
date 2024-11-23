import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //26. Escreva um programa que converta um valor binário para decimal.

        Scanner in = new Scanner(System.in);

        System.out.println("insira um numero binário");
        int binario = in.nextInt();

        int res = 0;
        int grau = 1;
        while (binario>0){
            res = res+((binario%10)*grau);
            grau = grau*2;
            binario = binario/10;
        }
        System.out.println("o número equivale a: "+res);
    }
}