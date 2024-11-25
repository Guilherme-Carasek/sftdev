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
            else if (opcao == 2){
                Lista();
            }
        }
        System.out.println("Goodbye");
    }
    private static void Calculadora() {
        int opcao = 1;
        while (opcao != 0) {
            System.out.println("Você está em 1-Calculadora:");
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
        System.out.println("Insira um número");
        double primeiroNumero = in.nextDouble();
        System.out.println("Insira outro número");
        double segundoNumero = in.nextDouble();
        System.out.println("A soma entre "+primeiroNumero+" e "+segundoNumero+" é "+(primeiroNumero+segundoNumero));
    }
    private static void Subtracao() {
        System.out.println("Insira um número");
        double primeiroNumero = in.nextDouble();
        System.out.println("Insira outro número");
        double segundoNumero = in.nextDouble();
        System.out.println(primeiroNumero+" - "+segundoNumero+" = "+(primeiroNumero-segundoNumero));
    }
    private static void Lista(){
        System.out.println("Aplicação 2- Lista:");
        System.out.println("Insira um número inteiro");
        int primeiroNumero = in.nextInt();
        System.out.println("Insira outro número inteiro");
        int segundoNumero = in.nextInt();
        if (primeiroNumero>segundoNumero){
            int temporario=primeiroNumero;
            primeiroNumero=segundoNumero;
            segundoNumero=temporario;
        }
        while (primeiroNumero<=segundoNumero){
            System.out.print(primeiroNumero+",");
            primeiroNumero++;
        }
        System.out.println(" ");
    }
}