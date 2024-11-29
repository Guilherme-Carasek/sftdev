import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();

    public static void main(String[] args) {
        System.out.println("Grupo 1");
        System.out.println("1.Exercício 1");
        System.out.println("2.Exercício 2");
        System.out.println("3.Exercício 3");
        System.out.println("4.Exercício 4");
        System.out.println("5.Exercício 5");
        System.out.println("6.Exercício 6");
        System.out.println("7.Exercício 7");
        System.out.println("8.Exercício 8");
        int opcao = in.nextInt();
        switch (opcao) {
            case 1:
                exercicio1();
                break;
            case 2:
                exercicio2();
                break;
            case 3:
                exercicio3();
                break;
            case 4:
                exercicio4();
                break;
            case 5:
                exercicio5();
                break;
            case 6:
                exercicio6();
                break;
            case 7:
                exercicio7();
                break;
            case 8:
                exercicio8();
                break;
            default:
                break;
        }
    }

    private static void exercicio1() {
        //1. Faça um programa que peça ao utilizador três notas, guarde-as num vetor e apresente a média final lendo as
        //notas do vetor.

        double[] notasArray = new double[3];
        for (int i = 0; i < notasArray.length; i++) {
            System.out.println("Insira uma nota");
            notasArray[i] = in.nextDouble();
        }
        double somaNotas = 0;
        for (int i = 0; i < notasArray.length; i++) {
            somaNotas += notasArray[i];
        }
        System.out.println("A média final é:" + (somaNotas / notasArray.length));
    }

    private static void exercicio2() {
        //2. Faça um programa que guarde num vetor os nomes de pelo menos 10 alunos da turma. Deve permitir ao
        //utilizador ao inserir o número do aluno (índice do vetor) indicar qual o nome do mesmo.
        in = new Scanner(System.in);

        String[] alunosLista = new String[10];
        for (int i = 0; i < alunosLista.length; i++) {
            System.out.println("Insira o nome do aluno número" + (i + 1));
            alunosLista[i] = in.nextLine();
        }
        int opcao = 1;
        while (opcao != 0) {
            System.out.println("Qual aluno queres saber o nome? (0 para sair)");
            opcao = in.nextInt();
            if (opcao == 0) break;
            System.out.println("Aluno " + opcao + ": " + alunosLista[(opcao - 1)]);
        }
    }

    private static void exercicio3() {
        //3. Faça um programa que receba 10 valores inteiros e os coloque em um vetor. Em seguida exiba-os em ordem
        //inversa à ordem de entrada.

        int[] valoresLista = new int[10];
        for (int i = 0; i < valoresLista.length; i++) {
            System.out.println("Insira um valor inteiro");
            valoresLista[i] = in.nextInt();
        }
        System.out.println("Ordem inversa:");
        for (int i = valoresLista.length - 1; i >= 0; i--) {
            System.out.printf(valoresLista[i] + "\t");
        }
    }

    private static void exercicio4() {
        //4. Faça um programa que utilize uma estrutura de repetição para ler 50 números armazenando-os em um vetor e
        //calcule e exiba a média aritmética deles. Em seguida o programa deve apresentar todos os valores armazenados
        //no vetor que sejam menores que a média.

        double valoresLista[] = new double[50];
        double soma = 0;
        for (int i = 0; i < valoresLista.length; i++) {
            System.out.println("Insira um valor");
            valoresLista[i] = in.nextInt();
            soma += valoresLista[i];
        }
        double media = (soma / valoresLista.length);
        System.out.println("A média é: " + media);
        System.out.println("Os valores menores que a média são:");
        for (int i = 0; i < valoresLista.length; i++) {
            if (valoresLista[i] < media) {
                System.out.println((i + 1) + ". " + valoresLista[i]);
            }
        }
    }

    private static void exercicio5() {
        //5. Faça um programa que ordene de forma crescente e decrescente um vetor. Sugere-se pesquisa na internet pelo
        //tópico: “java bubble sort”.

        System.out.println("Insira 10 valores desordenados:");
        int valoresLista[] = new int[10];
        for (int i = 0; i < valoresLista.length; i++) {
            System.out.println((i + 1) + ".");
            valoresLista[i] = in.nextInt();
        }
        for (int i = 0; i < (valoresLista.length - 1); i++) {
            for (int j = (i + 1); j < valoresLista.length; j++) {
                if (valoresLista[i] > valoresLista[j]) {
                    int temp = valoresLista[i];
                    valoresLista[i] = valoresLista[j];
                    valoresLista[j] = temp;
                }
            }
        }
        System.out.println("Em ordem crescente:");
        for (int i = 0; i < valoresLista.length; i++) {
            System.out.printf(valoresLista[i] + "\t");
        }
        for (int i = 0; i < (valoresLista.length - 1); i++) {
            for (int j = (i + 1); j < valoresLista.length; j++) {
                if (valoresLista[i] < valoresLista[j]) {
                    int temp = valoresLista[i];
                    valoresLista[i] = valoresLista[j];
                    valoresLista[j] = temp;
                }
            }
        }
        System.out.println("\nEm ordem decrescente:");
        for (int i = 0; i < valoresLista.length; i++) {
            System.out.printf(valoresLista[i] + "\t");
        }
    }

    private static void exercicio6() {
        //6. Faça um programa que peça ao utilizador um conjunto de nomes e os guarda num vetor. De seguida sorteie uma
        //posição do vetor e escreva o nome que está nessa posição.
        Scanner in = new Scanner(System.in);

        String[] listaNomes = new String[5];
        System.out.println("Insira " + listaNomes.length + " nomes:");
        for (int i = 0; i < listaNomes.length; i++) {
            System.out.println((i + 1) + ".");
            listaNomes[i] = in.nextLine();
        }
        System.out.println("O sorteado é: " + listaNomes[(rnd.nextInt(0, listaNomes.length))]);
    }

    private static void exercicio7() {
        //7. Faça um programa que peça ao utilizador um conjunto de nomes. Sempre que o utilizador insere um nome deve
        //inserir num outro vetor a 1ª letra de cada nome. Permita ao utilizador escrever o conteúdo de cada vetor.
        //Sugere-se a utilização de um menu
    }

    private static void exercicio8() {
        //8. Altere o exercício anterior ordenando os vetores
    }
}