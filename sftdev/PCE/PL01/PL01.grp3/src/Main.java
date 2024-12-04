import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int[] numerosLista = new int[5];
        int opcao = 1;
        while (opcao != 0){
            System.out.println("\n1. Gravar números");
            System.out.println("2. Ordenar de forma crescente");
            System.out.println("3. Ordenar de forma decrescente");
            System.out.println("4. Mostrar números");
            System.out.println("0. Sair");
            opcao = in.nextInt();
            switch (opcao){
                case 0:break;
                case 1:
                    numerosLista = GravarNumeros();break;
                case 2:
                    Arrays.sort(numerosLista);break;
                case 3: break;
                case 4: MostrarNumeros(numerosLista);
            }
        }
    }
    private static int[]
    GravarNumeros(){
        int[] numerosLista = new int[5];
        for (int i = 0; i < numerosLista.length; i++){
            System.out.println("Insira o "+(i+1)+"º número:");
            numerosLista[i] = in.nextInt();
        }
    return numerosLista;}

    private static void MostrarNumeros(int[] numerosLista){
        for (int i = 0;i < numerosLista.length; i++){
            System.out.print(numerosLista[i]+",\t");
        }
    }
}