import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        //2. Escreva um programa que leia números do utilizador até que ele insira um número negativo. Durante o ciclo:
        //a. Armazene os números em um array.
        //b. Após a interrupção do ciclo, mostre os números em ordem inversa.

        double numero = 1;
        ArrayList<Double> listaNumeros = new ArrayList<>();

        while (numero >= 0){
            Scanner in = new Scanner(System.in);
            System.out.println("Insira um número; insira um negativo para parar");
            if (in.hasNextDouble()){
                numero = in.nextDouble();
                if(numero>=0) {
                    listaNumeros.add(numero);
                }
            }else {
                System.out.println("Não é um número!");
            }
        }

        for (int i = (listaNumeros.size()-1); i >=0; i--){
            System.out.print(listaNumeros.get(i)+",\t");
        }
    }
}