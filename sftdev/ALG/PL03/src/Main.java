import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 1;
        while (opcao != 0) {
            System.out.println("Selecione uma opção:");
            System.out.println("1-Calculadora");
            System.out.println("2-Lista");
            System.out.println("0-Sair");
            opcao = in.nextInt();
            if (opcao == 1) {
                Calculadora();
            }
        }
        System.out.println("Goodbye");


    }
    private static void Calculadora() {
        int opcao = 1;
        while (opcao != 0) {
            System.out.println("Você está em: Calculadora:");
            System.out.println("1-Soma");
            System.out.println("2-subtração");
            System.out.println("0-Voltar");
            opcao = in.nextInt();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    Soma();
                case 2:
                    Subtracao();
            }
        }

    }

    private static void Soma() {
    }

    private static void Subtracao() {
    }

}