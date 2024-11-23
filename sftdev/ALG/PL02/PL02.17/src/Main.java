import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Adapte o exercício anterior considerando que se a média obtida for maior que 8
        // deverá ser atribuída 10 para a média

        Scanner in = new Scanner(System.in);

        int t=1; double s=0;
        while (t<=20){
            System.out.println("insira o "+t+"º número");
            int n = in.nextInt();
            s = (s+n);
            t++;
        }
        double m = (s/(t-1));
        if (m>8){
            System.out.println("a média é 10");
        }
        else {
            System.out.println("a média é "+m);
        }
    }
}