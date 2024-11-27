import java.util.Scanner;
import java.util.Random;

public class Main {
    //1. Crie um programa que irá gerar um número aleatório entre 1 e 50 permitindo de seguida ao utilizador fazer
    //sucessivas tentativas até acertar nesse número. Em cada tentativa errada é mostrado ao utilizador uma das
    //mensagens: “Tente um número maior” ou “Tente um número menor”. Quando o utilizador acertar no número
    //deve ser mostrado o número de tentativas gastas pelo utilizador

    static Random rnd = new Random();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int numeroAleatorio = rnd.nextInt(1,51);
        System.out.println("Tente adivinhar um número entre 1 e 50");
        int numeroEscolhido = in.nextInt();
        int numeroTentativas = 1;
        while(numeroEscolhido!=numeroAleatorio){
            if(numeroEscolhido<numeroAleatorio)
                System.out.println("Tente um número maior");
            else
                System.out.println("Tente um número menor");
            numeroEscolhido = in.nextInt();
            numeroTentativas++;
        }
        System.out.println("Acertou! Número de tentativas: "+numeroTentativas);
    }
}