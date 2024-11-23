import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //verifica se o número é impar

        Scanner in = new Scanner(System.in);

        System.out.println("insira um número inteiro");
        int num = in.nextInt();

        if (num%2==0){
            System.out.println("o número não é ímpar");
        }
        else {
            System.out.println("o número é ímpar");
        }

        }
    }