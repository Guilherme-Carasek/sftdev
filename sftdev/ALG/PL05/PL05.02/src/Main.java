import java.util.Scanner;
import java.util.Random;

public class Main {
    //2. Jogo de adivinhar o número. O utilizador deve tentar adivinhar um número gerado de forma aleatória pelo
    //computador. Deve ser possível jogar em 3 níveis de dificuldade:
    //a. Número gerado entre 1 e 20 e que quando o utilizador efetua uma tentativa deve dizer se o número
    //gerado é maior ou menor do que o inserido pelo utilizador. No final deve apresentar o número de
    //tentativas;
    //b. Número gerado entre 1 e 20, semelhante ao anterior, mas em que o utilizador tem apenas 3 tentativas
    //para acertar. No final deve apresentar o número de tentativas;
    //c. Número gerado entre 1 e 20 em que em cada tentativa o computador apenas diz se o número inserido
    //pelo utilizador está perto (+2 ou -2 do que o número gerado), nem perto nem longe (entre +2 e +5 ou -
    //2 e -5) ou longe (+5 ou -5 que o número gerado). No final deve apresentar o número de tentativas.

    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();

    public static void main(String[] args) {
        System.out.println("Jogo de adivinhar o número:");
        int opcao=1;
        while (opcao!=0){
            System.out.println("Dificuldade:\n1.EASY\n2.STANDARD\n3.HARD");
            System.out.println("SAIR(press 0)");
            opcao = in.nextInt();
            switch (opcao){
                case 0: break;
                case 1: Easy(); break;
                case 2: Standard(); break;
                case 3: Hard(); break;
                default:
                    System.out.println("Opção invalida"); break;
            }
        }
    }

    private static void Easy(){
        int numeroAleatorio = rnd.nextInt(1,21);
        System.out.println("Tente adivinhar um número entre 1 e 20");
        int numeroEscolhido = in.nextInt();
        while (numeroEscolhido<1||numeroEscolhido>20){
            System.out.println("Número inválido, escolha um número entre 1 e 20");
            numeroEscolhido = in.nextInt();
        }
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

    private static void Standard(){
        int numeroAleatorio = rnd.nextInt(1,21);
        System.out.println("Tente adivinhar um número entre 1 e 20");
        int numeroEscolhido = in.nextInt();
        while (numeroEscolhido<1||numeroEscolhido>20){
            System.out.println("Número inválido, escolha um número entre 1 e 20");
            numeroEscolhido = in.nextInt();
        }
        int numeroTentativas = 1;
        while(numeroEscolhido!=numeroAleatorio){
            if(numeroEscolhido<numeroAleatorio)
                System.out.println("Tente um número maior");
            else
                System.out.println("Tente um número menor");
            numeroEscolhido = in.nextInt();
            numeroTentativas++;
            if (numeroTentativas==3&&numeroAleatorio!=numeroEscolhido){
                System.out.println("Errou e o número de tentativas esgotou, tente novamente");
                return;
            }
        }
        System.out.println("Acertou! Número de tentativas: "+numeroTentativas);
    }

    private static void Hard(){
        int numeroAleatorio = rnd.nextInt(1,21);
        System.out.println("Tente adivinhar um número entre 1 e 20");
        int numeroEscolhido = in.nextInt();
        while (numeroEscolhido<1||numeroEscolhido>20){
            System.out.println("Número inválido, escolha um número entre 1 e 20");
            numeroEscolhido = in.nextInt();
        }
        int numeroTentativas = 1;
        int valorDiferenca = 0;
        while(numeroEscolhido!=numeroAleatorio){
            valorDiferenca = Math.abs(numeroEscolhido-numeroAleatorio);
            if (valorDiferenca>5) System.out.println("Está longe(errou por mais de 5), tente novamente");
            else if (valorDiferenca>2) System.out.println("Está nem perto nem longe, tente novamente");
            else System.out.println("Está perto(errou por 1 ou 2), tente novamente");
            numeroEscolhido = in.nextInt();
            numeroTentativas++;
        }
        System.out.println("Acertou! Número de tentativas: "+numeroTentativas);
    }
}