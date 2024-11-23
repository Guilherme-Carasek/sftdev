import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //20. Crie um programa que permita converter
        //um valor em dias para anos, semanas e dias.

        Scanner in = new Scanner(System.in);

        System.out.println("insira o número de dias");
        int d = in.nextInt();
        int dr = d;
        int y = 0;
        int w = 0;

        if (d > 364) {
            y = (d / 365);
            d = d % 365;
        }
        if (d > 6) {
            w = (d / 7);
            d = d % 7;
        }

        System.out.println(dr + " dias equivalem a " + y + " anos, " + w + " semanas e " + d + " dias.");
    }
}