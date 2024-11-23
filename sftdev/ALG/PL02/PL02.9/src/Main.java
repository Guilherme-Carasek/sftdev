import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //recebe 4 valores e retorna o menor entre eles

        Scanner in = new Scanner(System.in);

        System.out.println("insira um número inteiro");
        int na = in.nextInt();

        System.out.println("insira outro número inteiro");
        int nb = in.nextInt();
        if (nb<na) {na=nb;}

        System.out.println("insira outro número inteiro");
        nb = in.nextInt();
        if (nb<na) {na=nb;}

        System.out.println("insira outro número inteiro");
        nb = in.nextInt();
        if (nb < na) {na=nb;}

        System.out.println("o número "+na+" é o menor");
        }
    }