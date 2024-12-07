import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static ArrayList<String> alunosList = new ArrayList<>();
    static ArrayList<Double> trabalho1List = new ArrayList<>();
    static ArrayList<Double> trabalho2List = new ArrayList<>();
    static ArrayList<Double> exameList = new ArrayList<>();
    public static void main(String[] args) {
        // A aplicação deve conter um menu que permita:
        //1. Inserir, editar e eliminar alunos e notas (no formato numérico);
        //2. Imprimir os dados da turma (output acima – deve ser recalculado sempre que haja nova alteração);
        //3. Ler e gravar os dados em ficheiro.

        InicializarLists();
        int opcao = -1;
        while (opcao!=0){
            Scanner in = new Scanner(System.in);
            System.out.println("MENU");
            System.out.println("1.  Inserir, editar e eliminar alunos e notas");
            System.out.println("2.  Imprimir os dados da turma");
            System.out.println("3.  Ler e gravar os dados em ficheiro");
            System.out.println("0.  Sair");
            try {
                opcao = in.nextInt();
                switch (opcao) {
                    case 0:
                        break;
                    case 1:
                        Submenu1();
                        break;
                    case 2:
                        ImprimirDados();
                        break;
                    case 3:
                        Submenu2();
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } catch (InputMismatchException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static void InicializarLists(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("alunos.txt"));
            String alunos;
            while ((alunos = br.readLine()) != null){
                alunosList.add(alunos);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        try{
            BufferedReader br = new BufferedReader(new FileReader("trabalho1.txt"));
            String notaString;
            while ((notaString = br.readLine()) != null){
                double notaDouble = Double.parseDouble(notaString);
                trabalho1List.add(notaDouble);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        try{
            BufferedReader br = new BufferedReader(new FileReader("trabalho2.txt"));
            String notaString;
            while ((notaString = br.readLine()) != null){
                double notaDouble = Double.parseDouble(notaString);
                trabalho2List.add(notaDouble);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        try{
            BufferedReader br = new BufferedReader(new FileReader("exame.txt"));
            String notaString;
            while ((notaString = br.readLine()) != null){
                double notaDouble = Double.parseDouble(notaString);
                exameList.add(notaDouble);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private static void Submenu1(){
        int opcao = 1;
        while (opcao!=0){
            System.out.println("1.  Novo aluno");
            System.out.println("2.  Editar aluno");
            System.out.println("3.  Remover aluno");
            System.out.println("0.  Voltar");
            opcao = in.nextInt();
            switch (opcao){
                case 0:break;
                case 1: NovoAluno();break;
                case 2: EditarAluno();break;
                case 3: RemoverAluno();break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private static void NovoAluno(){
        Scanner in = new Scanner(System.in);
        System.out.println("Qual o nome do aluno que deseja adicionar?");
        alunosList.add(in.nextLine());
        while (true) try {
            in = new Scanner(System.in);
            System.out.println("Qual a nota de " + alunosList.getLast() + " no trabalho 1?");
            double temp = in.nextDouble();
            while (temp<0||temp>20){
                System.out.println("Insira uma nota de 0 a 20");
                temp = in.nextDouble();
            }
            trabalho1List.add(temp);
            break;
        } catch (InputMismatchException e){
            System.out.println("Insira um valor válido para a nota");
        }
        while (true) try {
            in = new Scanner(System.in);
            System.out.println("Qual a nota de " + alunosList.getLast() + " no trabalho 2?");
            double temp = in.nextDouble();
            while (temp<0||temp>20){
                System.out.println("Insira uma nota de 0 a 20");
                temp = in.nextDouble();
            }
            trabalho2List.add(temp);
            break;
        } catch (InputMismatchException e){
            System.out.println("Insira um valor válido para a nota");
        }
        while (true) try {
            in = new Scanner(System.in);
            System.out.println("Qual a nota de " + alunosList.getLast() + " no exame?");
            double temp = in.nextDouble();
            while (temp<0||temp>20){
                System.out.println("Insira uma nota de 0 a 20");
                temp = in.nextDouble();
            }
            exameList.add(temp);
            break;
        } catch (InputMismatchException e){
            System.out.println("Insira um valor válido para a nota");
        }
    }

    private static void EditarAluno(){
        System.out.println("Qual aluno deseja editar?");
        System.out.println("0. Voltar");
        // imprime lista de nomes para selecionar
        for (int i = 0; i < alunosList.size(); i++){
            System.out.println((i+1)+".\t"+alunosList.get(i));
        }
        int alunosIndex = 0; //var. para indexar o aluno desejado em todas as listas (-1 para que a primeira opção seja mostrada como 1, não 0)
        // valida a atribuição do int index, evitando posições inexistentes ou valores não inteiros. tambem retorna se 0 for selecionado
        try{
            alunosIndex = in.nextInt();
            if (alunosIndex == 0) return; //não retorna corretamente em casos específicos ???????????????????????????????????????????????????????????????
            else alunosIndex -= 1;
            if (alunosIndex<0 || alunosIndex>(alunosList.size()-1)){
                System.out.println("Opção inválida");
                EditarAluno();
            }
        } catch (InputMismatchException e){
            System.out.println("Opção inválida");
            EditarAluno();
        }
        // pergunta a nota do trabalho 1, valida e substitui no index escolhido
        while (true) try {
            in = new Scanner(System.in);
            System.out.println("Qual a nota de " + alunosList.get(alunosIndex) + " no trabalho 1?");
            double temp = in.nextDouble();
            while (temp<0||temp>20){
                System.out.println("Insira uma nota de 0 a 20");
                temp = in.nextDouble();
            }
            trabalho1List.set(alunosIndex, temp);
            break;
        } catch (InputMismatchException e){
            System.out.println("Insira um valor válido para a nota");
        }
        // pergunta a nota do trabalho 2, valida e substitui no index escolhido
        while (true) try {
            in = new Scanner(System.in);
            System.out.println("Qual a nota de " + alunosList.get(alunosIndex) + " no trabalho 2?");
            double temp = in.nextDouble();
            while (temp<0||temp>20){
                System.out.println("Insira uma nota de 0 a 20");
                temp = in.nextDouble();
            }
            trabalho2List.set(alunosIndex, temp);
            break;
        } catch (InputMismatchException e){
            System.out.println("Insira um valor válido para a nota");
        }
        // pergunta a nota do exame, valida e substitui no index escolhido
        while (true) try {
            in = new Scanner(System.in);
            System.out.println("Qual a nota de " + alunosList.get(alunosIndex) + " no exame?");
            double temp = in.nextDouble();
            while (temp<0||temp>20){
                System.out.println("Insira uma nota de 0 a 20");
                temp = in.nextDouble();
            }
            exameList.set(alunosIndex, temp);
            break;
        } catch (InputMismatchException e){
            System.out.println("Insira um valor válido para a nota");
        }
    }

    private static void RemoverAluno(){
        System.out.println("Qual aluno deseja remover?");
        System.out.println("0. Voltar");
        // imprime lista de nomes para selecionar
        for (int i = 0; i < alunosList.size(); i++){
            System.out.println((i+1)+".\t"+alunosList.get(i));
        }
        int alunosIndex = 0; //var. para indexar o aluno desejado em todas as listas (-1 para que a primeira opção seja mostrada como 1, não 0)
        // valida a atribuição do int index, evitando posições inexistentes ou valores não inteiros. tambem retorna se 0 for selecionado
        try{
            alunosIndex = (in.nextInt()-1);
            if (alunosIndex == -1)return;
            if (alunosIndex<0 || alunosIndex>(alunosList.size()-1)){
                System.out.println("Opção inválida");
                RemoverAluno();
            }
        } catch (InputMismatchException e){
            System.out.println("Opção inválida");
            RemoverAluno();
        }
        //remover das listas a posição selecionada
        alunosList.remove(alunosIndex);
        trabalho1List.remove(alunosIndex);
        trabalho2List.remove(alunosIndex);
        exameList.remove(alunosIndex);
    }

    private static void ImprimirDados(){

    }

    private static void Submenu2(){
        int opcao = 1;
        while (opcao!=0){
            System.out.println("1. Ler ou 2. Gravar dados em ficheiro:");
            try {
                opcao = in.nextInt();
                switch (opcao) {
                    case 0:
                        break;
                    case 1:
                        LerDados();
                    case 2:
                        GravarDados();
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static void LerDados() {
        System.out.println("Nome\t\tTrabalho 1\t\tTrabalho 2\t\tExame");
        try {
            BufferedReader brAlunos = new BufferedReader(new FileReader("alunos.txt"));
            BufferedReader brTrab1 = new BufferedReader(new FileReader("trabalho1.txt"));
            BufferedReader brTrab2 = new BufferedReader(new FileReader("trabalho2.txt"));
            BufferedReader brExame = new BufferedReader(new FileReader("exame.txt"));
            String alunosTemp;
            while ((alunosTemp = brAlunos.readLine()) != null){
                System.out.println(alunosTemp+"\t\t"+brTrab1.readLine()+"\t\t"+brTrab2.readLine()+"\t\t"+brExame.readLine());
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private static void GravarDados(){
        try{
            BufferedWriter bwAlunos = new BufferedWriter(new FileWriter("alunos.txt"));
            for (int i = 0; i < alunosList.size(); i++){
                bwAlunos.write(alunosList.get(i));
                bwAlunos.newLine();
            }
            bwAlunos.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        try{
            BufferedWriter bwTrab1 = new BufferedWriter(new FileWriter("trabaho1.txt"));
            for (int i = 0; i < trabalho1List.size(); i++){
                bwTrab1.write(String.valueOf(trabalho1List.get(i)));
                bwTrab1.newLine();
            }
            bwTrab1.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        try{
            BufferedWriter bwTrab2 = new BufferedWriter(new FileWriter("trabalho2.txt"));
            for (int i = 0; i < trabalho2List.size(); i++){
                bwTrab2.write(String.valueOf(trabalho2List.get(i)));
                bwTrab2.newLine();
            }
            bwTrab2.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        try{
            BufferedWriter bwExame = new BufferedWriter(new FileWriter("exame.txt"));
            for (int i = 0; i < exameList.size(); i++){
                bwExame.write(String.valueOf(exameList.get(i)));
                bwExame.newLine();
            }
            bwExame.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}