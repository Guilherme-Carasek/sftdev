import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        //4. Crie um programa que peça 5 números ao utilizador, armazene-os num array e depois pergunte ao utilizador
        //por um número. Informe se o número está ou não no array

        int tamanho = 5;
        int[] listaNumeros = new int[tamanho];
        for (int i = 0; i < tamanho; i++){
            Scanner in = new Scanner(System.in);
            System.out.println("Insira um numero inteiro");
            if (in.hasNextInt()){
                listaNumeros[i] = in.nextInt();
            }else {
                System.out.println("Não é um inteiro");
                i--;
            }
        }
        System.out.println("Adivinhe um número inteiro:");
        if (in.hasNextInt()){
            int numeroAdivinhado = in.nextInt();
            for (int i = 0; i < listaNumeros.length; i++){
                if (numeroAdivinhado == listaNumeros[i]){
                    System.out.println("O número está na lista");
                    return;
                }
            }
            System.out.println("O número não está na lista");
            return;
        }else {
            System.out.println("Não é um inteiro");
        }
    }
}