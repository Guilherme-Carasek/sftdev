import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static ArrayList<String> nomesLista = new ArrayList<>();
    static ArrayList<Integer> jogosJogados = new ArrayList<>();
    static ArrayList<Integer> jogosGanhados = new ArrayList<>();
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        LerDados();
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("1.Adicionar ouvinte");
            System.out.println("2.Remover ouvinte");
            System.out.println("3.Ver ranking");
            System.out.println("4.Jogar");
            System.out.println("5.Ler ficheiro");
            System.out.println("6.Gravar ficheiro");
            System.out.println("0.Sair");
            if (in.hasNextInt()) opcao = in.nextInt();
            if (opcao == 0) return;
            else if (opcao == 1) AdicionarOuvinte();
            else if (opcao == 2) RemoverOuvinte();
            else if (opcao == 3) VerRanking();
            //else if (opcao == 4) Jogar(); WIP
            else if (opcao == 5) LerDados();
            else if (opcao == 6) GravarDados();
            else System.out.println("Opção inválida");
        }
    }

    private static void LerDados(){
        try {
            nomesLista.clear();
            jogosJogados.clear();
            jogosGanhados.clear();
            List<String> linhas = Files.readAllLines(Path.of("dados.txt"));
            for (int i = 0; i < linhas.size(); i++){
                if (!linhas.get(i).isEmpty()){
                    String[] linhaDados = linhas.get(i).split(";");
                    try{
                        nomesLista.add(linhaDados[0]);
                        jogosJogados.add(Integer.parseInt(linhaDados[1]));
                        jogosGanhados.add(Integer.parseInt(linhaDados[2]));
                    }catch (NumberFormatException e){
                        System.out.println("Dados no formato incorreto");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro");
        }
    }

    private static void GravarDados(){
        String texto = "";
        for (int i = 0; i < nomesLista.size(); i++){
            texto += (nomesLista.get(i)+";"+jogosJogados.get(i)+";"+jogosGanhados.get(i));
            if (i < (nomesLista.size()-1)) texto += "\n";
        }
        try{
            Files.writeString(Path.of("dados.txt"), texto);
            System.out.println("Ficheiro gravado com sucesso");
        } catch (IOException e) {
            System.out.println("Erro ao gravar o ficheiro");;
        }
    }

    private static void AdicionarOuvinte(){
        Scanner in = new Scanner(System.in);
        System.out.println("Qual o nome do novo ouvinte?");
        String nome = in.nextLine();
        if (nomesLista.contains(nome)){
            System.out.println("Nome já existe, insira o nome com algum diferenciador");
            return;
        }
        nomesLista.add(nome);
        jogosJogados.add(0);
        jogosGanhados.add(0);
    }

    private static void RemoverOuvinte(){
        System.out.println("Qual ouvinte deseja remover?");
        for (int i = 0; i < nomesLista.size(); i++){
            System.out.println((i+1)+". "+nomesLista.get(i));
        }
        System.out.println("0.Voltar");
        int opcao = -2;
        if (in.hasNextInt()) opcao = in.nextInt()-1;
        else {System.out.println("Opção inválida");RemoverOuvinte();}
        if (opcao == -1) return;
        try{
            nomesLista.remove(opcao);
            jogosJogados.remove(opcao);
            jogosGanhados.remove(opcao);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Opção inválida");
        }
    }

    private static void VerRanking(){
        //imprimindo na ordem em que aparecem para teste
        for (int i = 0; i < nomesLista.size(); i++){
            System.out.println(nomesLista.get(i)+"\t"+jogosJogados.get(i)+"\t"+jogosGanhados.get(i));
        }
    }
}