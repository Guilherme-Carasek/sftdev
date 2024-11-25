import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //3. crie um algoritmo que apos ler dois numeros inteiros apresenta sua diferença

        Scanner in = new Scanner(System.in);

        System.out.println("insira um número inteiro");
        int n1 = in.nextInt();

        System.out.println("insira outro número inteiro");
        int n2 = in.nextInt();

        int dif =  Math.abs(n1 - n2);
        System.out.println ("a diferença é " + dif);


    }
}