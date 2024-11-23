import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //lê 50 números e retorna a média (estrutura PARA)

        Scanner in = new Scanner(System.in);

        double s=0;
        for (int t=1;t<=50;t++){

            System.out.println("insira o "+t+"º número");
            int n = in.nextInt();
            s = s+n;
        }
        System.out.println("média:"+(s/50));
    }
}