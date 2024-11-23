import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //recebe dois valores e retorna o maior

        Scanner in = new Scanner(System.in);

        System.out.println("insira um número inteiro");
        int n1 = in.nextInt();

        System.out.println("insira outro numero inteiro");
        int n2 = in.nextInt();

        if (n1 > n2) {
            System.out.println("o primeiro numero é o maior: " + n1);
        } else {
            if (n2 > n1) {
                System.out.println("o segundo numero é o maior: " + n2);
            } else {
                System.out.println("os dois números são iguais");
            }

        }

    }
}