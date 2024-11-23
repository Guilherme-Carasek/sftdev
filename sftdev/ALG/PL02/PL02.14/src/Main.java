import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //lê 50 números, calcula e mostra a média aritmética (estrutura ENQUANTO)

        Scanner in = new Scanner(System.in);

        int t = 1;
        double s = 0;
        while (t <= 50) {
            System.out.println("insira o " + t + "º número");
            double n = in.nextDouble();
            s = (s + n);
            t++;
        }
        System.out.println("média: " + (s / 50));
    }
}