import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();
    public static void main(String[] args) {
        int opcao = 1;
        while (opcao!=0){
            System.out.println("Digite o número do exercício(1-5); 0 para sair");
            opcao = in.nextInt();
            switch (opcao){
                case 0: break;
                case 1: Exercicio1();break;
                case 2: Exercicio2();break;
                case 3: Exercicio3();break;
                case 4: Exercicio4();break;
                case 5: Exercicio5();break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private static void Exercicio1(){
        //1. Crie um programa que utilize um array multidimensional que simule a tabuada de 10x10. Deve utilizar ciclos para
        //preenchimento do array e aquando da execução da aplicação escrever a todo o array.
        int[][] tabuada = new int[10][10];
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                tabuada[i][j] = (i+1)*(j+1);
                System.out.print(tabuada[i][j]+"\t");
            }
            System.out.println();
        }
    }

    private static void Exercicio2(){
        //2. Faça um programa que guarde um array multidimensional de 3x3 com números aleatórios e o apresente no ecrã.
        int[][] array = new int[3][3];
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                array[i][j] = rnd.nextInt(0,100);
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }
    }

    private static void Exercicio3(){
        //3. Altere a aplicação anterior permitindo ao utilizador preencher o array com os valores que pretender.
        int[][] array = new int[3][3];
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.println("Qual valor gostaria de inserir na "+(i+1)+"ª linha, "+(j+1)+"ª coluna?");
                array[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }
    }

    private static void Exercicio4(){
        //4. Altere a aplicação anterior permitindo ao utilizador escolher o número de linhas e colunas do array.
        System.out.println("Quantas linhas queres?");
        int linhasQuantidade = in.nextInt();
        System.out.println("Quantas colunas queres?");
        int colunasQuantidade = in.nextInt();
        int[][] array = new int[linhasQuantidade][colunasQuantidade];
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.println("Qual valor gostaria de inserir na "+(i+1)+"ª linha, "+(j+1)+"ª coluna?");
                array[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }
    }

    private static void Exercicio5(){
        //5. Acrescente a possibilidade de o utilizador calcular a soma e a média dos valores do array por linha, por coluna e
        //no total.
        System.out.println("Quantas linhas queres?");
        int linhasQuantidade = in.nextInt();
        System.out.println("Quantas colunas queres?");
        int colunasQuantidade = in.nextInt();
        int[][] array = new int[linhasQuantidade][colunasQuantidade];
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.println("Qual valor gostaria de inserir na "+(i+1)+"ª linha, "+(j+1)+"ª coluna?");
                array[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }
        int opcao = 1;
        while (opcao != 0){
            System.out.println("Queres saber a soma e média de 1.Linhas 2.Colunas 3.Total 0.Sair");
            opcao = in.nextInt();
            switch (opcao){
                case 0: break;
                case 1: MostrarCalculo(array, opcao);break;
                case 2: MostrarCalculo(array, opcao);break;
                case 3: MostrarTotal(array);break;
                default: System.out.println("Opção inválida");break;
            }
        }

    }

    private static void MostrarCalculo(int[][]array, int opcao){
        int lenght = 0, quantidade=0;
        if (opcao==1){
        System.out.println("Qual linha queres saber a soma e média?");lenght = array[0].length; quantidade=array.length;
        } else {
            System.out.println("Qual coluna queres saber a soma e média?"); lenght = array.length;quantidade= array[0].length;
        }
        int pointer = in.nextInt();
        if (pointer<1||pointer>quantidade){
            System.out.println("Valor inválido");
            return;
        }
        double soma = 0;
        for (int i = 0;i < lenght; i++){
            if (opcao==1) soma += array[(pointer-1)][i];
            else soma += array[i][(pointer-1)];
        }
        if(opcao==1)System.out.println(pointer+"ª linha:");
        else System.out.println(pointer+"ª coluna:");
        System.out.println("Soma= "+soma);
        System.out.println("Média= "+(soma/lenght));

        //imprime novamente o array para fácil visualização
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }
    }

    private static void MostrarTotal(int[][] array){
        double soma = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length;j++){
                soma += array[i][j];
            }
        }
        System.out.println("A soma total é: "+soma);
        System.out.println("A média de todos os números é: "+(soma/(array.length* array[0].length)));

        //imprime novamente o array para fácil visualização
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }
    }
}