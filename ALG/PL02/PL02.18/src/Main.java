import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //18. Dado um conjunto de n números inteiros inseridos pelo utilizador, faça um algoritmo
        // que calcule a média dos valores maiores que 4.

        Scanner in = new Scanner(System.in);

        System.out.println("insira os valores inteiros (insira 0 para terminar)");

        int n=1;
        int c=0;
        double s=0;

        while (n!=0){
            n = in.nextInt();
            if (n>4){
                s=(s+n);
                c++;
            }
        }
        System.out.println("a média dos valores maiores que 4 é: "+(s/c));
    }
}