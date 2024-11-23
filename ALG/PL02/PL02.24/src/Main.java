import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //24. Ler N números, determinar o maior, o menor e a média dos N números lidos.

        Scanner in = new Scanner(System.in);

        System.out.println("insira os valores; insira zero para terminar");
        int num = in.nextInt();
        int numg = num;
        int nump = num;
        int contador = 1;
        double soma = num;
        while (num != 0) {
            num = in.nextInt();
            if (num != 0) {
                soma = soma + num;
                if (num < nump) {
                    nump = num;
                }
                if (num > numg) {
                    numg = num;
                }
                contador++;
            }
        }
        System.out.println("O maior número é " + numg);
        System.out.println("O menor número é " + nump);
        System.out.println("A média é " + (soma / contador));
    }
}