import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //pedir dois numeros e devolver a soma

        Scanner in = new Scanner(System.in);


        System.out.println("insira um número decimal");
        double n1 = in.nextDouble();

        System.out.println("insira um número inteiro");
        int n2 = in.nextInt();

        double soma = n1 + n2;
        System.out.println("a soma é " + soma);



    }
}