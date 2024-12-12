import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //7. Pretende-se criar uma aplicação que calcule os N primeiros números da sucessão de Fibonacci, sendo que o
        //utilizador deve indicar quantos elementos (N) pretende que sejam apresentados.
        //NOTA: a Sucessão de Fibonacci, é uma sequência de números inteiros, começando normalmente por 0 e 1, na
        //qual, cada termo subsequente corresponde à soma dos dois anteriores (ver:
        //https://pt.wikipedia.org/wiki/Sequ%C3%AAncia_de_Fibonacci)
        Scanner in = new Scanner(System.in);

        System.out.println("Quantos números de Fibonacci queres ver?");
        int quantidade = 0;
        while (quantidade <= 0) {
            while (true) {
                if (in.hasNextInt()) {
                    quantidade = in.nextInt();
                    break;
                } else {
                    in = new Scanner(System.in);
                    System.out.println("Valor inválido");
                }
            }
            if (quantidade>0) break;
            System.out.println("Valor inválido");
        }
        //System.out.println(quantidade);

        ArrayList<Integer> fibonacci = new ArrayList<>();
        for (int i = 0; i < quantidade; i++){
            if (i<2){
                System.out.print(i+"\t");
                fibonacci.add(i);
            }else{
                int proxNumero = (fibonacci.get(i-1)+ fibonacci.get(i-2));
                System.out.print(proxNumero+"\t");
                fibonacci.add(proxNumero);
            }
            if (((i+1) % 12) == 0) System.out.println();
        }
    }
}


