import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static ArrayList<String> nomesLista = new ArrayList<>();
    static ArrayList<Integer> jogosJogados = new ArrayList<>();
    static ArrayList<Integer> jogosGanhados = new ArrayList<>();
    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();
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
            else if (opcao == 4) Jogar();
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
        /*for (int i = 0; i < nomesLista.size(); i++){
            System.out.println(nomesLista.get(i)+"\t"+jogosJogados.get(i)+"\t"+jogosGanhados.get(i));
        }*/

        if (nomesLista.size() == 0){
            System.out.println("Não há ouvintes registrados");
            return;
        }
        if (nomesLista.size() > 1) {
            //ciclo for para ordenar os ouvintes por maior número de acertos
            for (int i = 0; i < (nomesLista.size() - 1); i++) {
                for (int k = (i + 1); k < nomesLista.size(); k++) {
                    if (jogosGanhados.get(i) < jogosGanhados.get(k)){
                        String tempNome = nomesLista.get(k);
                        int tempJogados = jogosJogados.get(k);
                        int tempGanhados = jogosGanhados.get(k);
                        nomesLista.set(k,nomesLista.get(i));
                        jogosJogados.set(k,jogosJogados.get(i));
                        jogosGanhados.set(k,jogosGanhados.get(i));
                        nomesLista.set(i,tempNome);
                        jogosJogados.set(i,tempJogados);
                        jogosGanhados.set(i,tempGanhados);
                    }
                }
            }

            // ciclo for para ordenar os empates por menor número de jogos
            for (int i = 0; i < (nomesLista.size() - 1); i++) {
                for (int k = (i + 1); k < nomesLista.size(); k++) {
                    if (jogosGanhados.get(i) == jogosGanhados.get(k)){
                        if (jogosJogados.get(i) > jogosJogados.get(k)){
                            String tempNome = nomesLista.get(k);
                            int tempJogados = jogosJogados.get(k);
                            int tempGanhados = jogosGanhados.get(k);
                            nomesLista.set(k,nomesLista.get(i));
                            jogosJogados.set(k,jogosJogados.get(i));
                            jogosGanhados.set(k,jogosGanhados.get(i));
                            nomesLista.set(i,tempNome);
                            jogosJogados.set(i,tempJogados);
                            jogosGanhados.set(i,tempGanhados);
                        }
                    }
                }
            }
        }
        //ciclo for para imprimir o ranking de forma organizada
        System.out.println("#\t\tNome\t\tAcertos\t\tJogos");
        for (int i = 0; i < nomesLista.size(); i++){
            System.out.println((i+1)+"\t\t"+nomesLista.get(i)+"\t\t"+jogosGanhados.get(i)+"\t\t"+jogosJogados.get(i));
        }
    }

    private static void Jogar(){
        if (nomesLista.size() == 0){
            System.out.println("Não há ouvintes registrados para jogar");
            return;
        }
        //ciclo for adiciona a um arraylist até 5 numeros aleatorios validos e diferentes que indexam ouvintes da lista
        ArrayList<Integer> jogadores = new ArrayList<>();
        for (int i = 0; i < nomesLista.size() && i < 5; i++){
            jogadores.add(rnd.nextInt(0, nomesLista.size()));
            for (int k = i; k >= 0; k--){
                if (k != i && jogadores.get(i) == jogadores.get(k)){
                    jogadores.remove(i);
                    i--;
                }
            }
        }
        System.out.println("Jogadores selecionados para jogar:");
        for (int i = 0; i < jogadores.size(); i++){
            System.out.print(nomesLista.get(jogadores.get(i))+", ");
        }
        System.out.println();

        //selecionar o limite mínimo em gramas, e o peso do saco
        int pesoMinimo = rnd.nextInt(2000,5000);
        int pesoSaco = rnd.nextInt(pesoMinimo,(pesoMinimo + 151));

        //chamar cada ouvinte selecionado para jogar, guardar em um arraylist o modulo da diferença entre o palpite e o peso correto
        ArrayList<Integer> palpites = new ArrayList<>();
        for (int i = 0; i < jogadores.size(); i++){
            Scanner in = new Scanner(System.in);
            System.out.println("Jogador: "+nomesLista.get(jogadores.get(i))+"\n Adivinhe o peso do saco entre "+pesoMinimo+"g e "+(pesoMinimo+150)+"g.");
            if (in.hasNextInt()){
                int palpite = in.nextInt();
                if (palpite < pesoMinimo || palpite > (pesoMinimo+150)){
                    System.out.println("ANABELA MAS O SACO PESA ENTRE "+pesoMinimo+"g E "+(pesoMinimo+150)+"g!!!");
                    i--;
                }
                else{
                    palpites.add(Math.abs(palpite-pesoSaco));
                }
            }
            else{
                System.out.println("Digite um número válido");
                i--;
            }
        }
        //System.out.println(palpites);

        System.out.println("O peso do saco é: "+pesoSaco+"g!");

        //determinar o vencedor (ou vencedores, em caso de empate) e atualizar os dados de cada jogador
        if (jogadores.size() > 1){
            for (int i = 0; i < (jogadores.size() - 1); i++){
                for (int k = i + 1; k < jogadores.size(); k++){
                    if (palpites.get(i) > palpites.get(k)){
                        int tempJogador = jogadores.get(k);
                        int tempPalpite = palpites.get(k);
                        jogadores.set(k, jogadores.get(i));
                        palpites.set(k, palpites.get(i));
                        jogadores.set(i, tempJogador);
                        palpites.set(i, tempPalpite);
                    }
                }
            }
        }
        int palpiteVencedor = palpites.get(0);
        for (int i = 0; i < jogadores.size(); i++){
            int numeroJogos = jogosJogados.get(jogadores.get(i));
            numeroJogos++;
            jogosJogados.set(jogadores.get(i),numeroJogos);
            if (palpites.get(i) == palpiteVencedor){
                System.out.println(nomesLista.get(jogadores.get(i))+" ganhou com uma margem de "+palpiteVencedor+"g!");
                int numeroAcertos = jogosGanhados.get(jogadores.get(i));
                numeroAcertos++;
                jogosGanhados.set(jogadores.get(i), numeroAcertos);
            }
        }
    }
}