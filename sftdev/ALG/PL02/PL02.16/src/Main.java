import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       //dada uma serie de 20 valores inteiros, calcula e escreve a média aritmética

        Scanner in = new Scanner(System.in);

        int t=1; double s=0;
        while (t<=20){
            System.out.println("insira o "+t+"º número");
            int n = in.nextInt();
            s = (s+n);
            t++;
        }
        System.out.println("média: "+(s/(t-1)));
    }
}