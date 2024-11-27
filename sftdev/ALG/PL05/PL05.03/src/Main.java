import java.util.Scanner;
import java.util.Random;

public class Main {
    //3. Jogo dos 21 fósforos: 2 utilizadores devem, alternadamente, retirar entre 1 e 4 fósforos de um total de 21, sendo
    //que o utilizador que ficar com o último fósforo perde. Deve criar a aplicação para que permita jogarem 2
    //utilizadores um contra o outro ou um utilizador contra o computador (começando em primeiro ou segundo lugar).

    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();

    public static void main(String[] args) {
        String regras = "2 utilizadores devem, alternadamente, retirar entre 1 e 4 fósforos de um total de 21, " +
                "sendo que o utilizador que ficar com o último fósforo perde.";

        int opcao=1;
        while (opcao!=0){
            System.out.println("Jogo dos 21 fósforos\n1.PvsP\n2.PvsC\n3.Regras\n0.Sair");
            opcao = in.nextInt();
            switch (opcao){
                case 0:break;
                case 1: DoisJogadores();break;
                case 2: UmJogador();break;
                case 3:
                    System.out.println(regras);break;
                default:
                    System.out.println("Opção inválida, selecione uma opção de 0 a 3");
            }
        }
    }

    private static void DoisJogadores(){
        int quantidadeFosforos = 21;
        int deltaFosforos;
        while (quantidadeFosforos>0){
            System.out.println("Fósforos: "+quantidadeFosforos+"\nJogador 1: retire entre 1 e 4 fósforos");
            deltaFosforos = in.nextInt();
            while (deltaFosforos>quantidadeFosforos||deltaFosforos<1||deltaFosforos>4){
                System.out.println("Jogador 1: por favor retire uma quantidade válida de fósforos");
                deltaFosforos = in.nextInt();
            }
            quantidadeFosforos -= deltaFosforos;
            if (quantidadeFosforos==1){
                System.out.println("Jogador 1 ganhou!");
                return;
            }
            if (quantidadeFosforos==0){
                System.out.println("Jogador 2 ganhou!");
                return;
            }System.out.println("Fósforos: "+quantidadeFosforos+"\nJogador 2: retire entre 1 e 4 fósforos");
            deltaFosforos = in.nextInt();
            while (deltaFosforos>quantidadeFosforos||deltaFosforos<1||deltaFosforos>4){
                System.out.println("Jogador 2: por favor retire uma quantidade válida de fósforos");
                deltaFosforos = in.nextInt();
            }
            quantidadeFosforos -= deltaFosforos;
            if (quantidadeFosforos==1){
                System.out.println("Jogador 2 ganhou!");
                return;
            }
            if (quantidadeFosforos==0){
                System.out.println("Jogador 1 ganhou!");
                return;
            }
        }
    }

    private static void UmJogador(){

    }




}