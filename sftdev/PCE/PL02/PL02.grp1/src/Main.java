import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        int opcaoMenu = -1;
        while (opcaoMenu != 0){
            System.out.println("1. Ler o ficheiro");
            System.out.println("2. Ler o ficheiro como array");
            System.out.println("3. Gravar texto");
            System.out.println("4. Gravar em linhas");
            System.out.println("5. Trocar conteúdo do ficheiro 'test' pelo conteudo do ficheiro 'testB'");
            System.out.println("0. Sair");
            opcaoMenu = in.nextInt();
            switch (opcaoMenu){
                case 0: return;
                case 1: LerString(); break;
                case 2: LerArray(); break;
                case 3: GravarTexto(); break;
                case 4: GravarLinhas(); break;
                case 5: TrocarFicheiro(); break;
                default: System.out.println("Opção inválida"); break;
            }
        }
    }

    private static void LerString() {
        String linha;
        String testLinhas = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("test.txt"));
            while ((linha = br.readLine()) != null) {
                testLinhas += linha;
                testLinhas += ", ";
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(testLinhas);
    }

    private static void LerArray() {
        ArrayList<String> ficheiroArray = new ArrayList<>();
        String linha;
        try {
            BufferedReader br = new BufferedReader(new FileReader("test.txt"));
            while ((linha = br.readLine()) != null){
                ficheiroArray.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro");
        }
        System.out.println(ficheiroArray);
    }

    private static void GravarTexto(){
        Scanner in = new Scanner(System.in);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt",true));
            System.out.println("Escreva o texto que queres gravar");
            bw.newLine();
            bw.write(in.nextLine());
            bw.close();
        } catch (IOException e) {
            System.out.println("Erro ao gravar no ficheiro");
        }
    }

    private static void GravarLinhas(){
        System.out.println("Quantas linhas queres gravar?");
        String[] arrayLinhas = new String[in.nextInt()];
        Scanner in = new Scanner(System.in);

        for (int i=0; i< arrayLinhas.length;i++){
            System.out.println("Escreva a "+(i+1)+"ª linha:");
            arrayLinhas[i] = in.nextLine();
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt", true));
            for (int i = 0; i < arrayLinhas.length; i++){
                bw.newLine();
                bw.write(arrayLinhas[i]);
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Erro ao gravar no ficheiro");
        }
    }

    private static void TrocarFicheiro(){
        ArrayList<String> tempArray = new ArrayList<>();
        String linhas;
        try {
            BufferedReader br = new BufferedReader(new FileReader("test.txt"));
            while ((linhas= br.readLine()) != null){
                tempArray.add(linhas);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro 'test'");
        }

        try{
            BufferedReader br = new BufferedReader(new FileReader("testB.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt"));
            while ((linhas = br.readLine()) != null){
                bw.write(linhas);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e){
            System.out.println("Erro ao escrever no ficheiro 'test'");
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("testB.txt"));
            for (int i = 0; i < tempArray.size(); i++){
                bw.write(tempArray.get(i));
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Erro ao gravar no ficheiro");
        }
        System.out.println("done");
    }
}

