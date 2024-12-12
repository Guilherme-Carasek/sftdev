import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        //1. Crie um programa que leia 10 números inteiros do utilizador e determine:
        //a. Quantos números são pares.
        //b. Quantos números são ímpares.
        //c. A soma de todos os números.
        //d. A média de todos os números.

        int quantidade = 10, pares = 0, impares = 0;
        double soma = 0;

        for (int i = 0; i < quantidade; i++){
            System.out.println("Insira o "+(i+1)+"º número:");
            int numero = in.nextInt();

            if (numero % 2 == 0) pares++;
            else impares++;
            soma += numero;
        }
        System.out.println("Pares: "+pares);
        System.out.println("Ímpares: "+impares);
        System.out.println("Soma: "+soma);
        System.out.println("Média: "+(soma/quantidade));
    }
}