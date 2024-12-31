import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static ArrayList<String> distritos = new ArrayList<>();
    static ArrayList<Integer> inscritos = new ArrayList<>();
    static ArrayList<Integer> votantes = new ArrayList<>();
    static ArrayList<Integer> nulos = new ArrayList<>();
    static ArrayList<Integer> brancos = new ArrayList<>();
    static ArrayList<Integer> AD = new ArrayList<>();
    static ArrayList<Integer> PS = new ArrayList<>();
    static ArrayList<Integer> CH = new ArrayList<>();
    static ArrayList<Integer> IL = new ArrayList<>();
    static ArrayList<Integer> BE = new ArrayList<>();
    static ArrayList<Integer> outros = new ArrayList<>();
    static ArrayList<Integer> total = new ArrayList<>();

    public static void main(String[] args) {
        Leitura();
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("1.Ler ficheiro");
            System.out.println("2.Visualizar dados");
            System.out.println("3.Total de votantes por distrito");
            System.out.println("4.Total de votos em outros partidos");
            System.out.println("5.Partido com mais votos");
            System.out.println("6.");
            System.out.println("0.Sair");
            if (in.hasNextInt()) opcao = in.nextInt();
            if (opcao == 0) return;
            else if (opcao == 1) Leitura();
            else if (opcao == 2) Visualizacao();
            else if (opcao == 3) TotalPorDistrito();
            else if (opcao == 4) TotalOutros();
            else if (opcao == 5) PartidoMaisVotos();
            else if (opcao == 6) ;
            else System.out.println("Opção inválida");
        }
    }



    private static void Leitura() {
        try {
            distritos.clear();
            inscritos.clear();
            votantes.clear();
            nulos.clear();
            brancos.clear();
            AD.clear();
            PS.clear();
            CH.clear();
            IL.clear();
            BE.clear();
            List<String> linhas = Files.readAllLines(Path.of("distritos.txt"));
            for (int i = 0; i < linhas.size(); i++){
                if (!linhas.get(i).isEmpty()){
                    String[] linhaDados = linhas.get(i).split(";");
                    try{
                        distritos.add(linhaDados[0]);
                        inscritos.add(Integer.parseInt(linhaDados[1]));
                        votantes.add(Integer.parseInt(linhaDados[2]));
                        nulos.add(Integer.parseInt(linhaDados[3]));
                        brancos.add(Integer.parseInt(linhaDados[4]));
                        AD.add(Integer.parseInt(linhaDados[5]));
                        PS.add(Integer.parseInt(linhaDados[6]));
                        CH.add(Integer.parseInt(linhaDados[7]));
                        IL.add(Integer.parseInt(linhaDados[8]));
                        BE.add(Integer.parseInt(linhaDados[9]));
                        outros.add(0);
                        total.add(0);
                    }catch (NumberFormatException e){
                        System.out.println("Dados no formato incorreto");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro");
        }
    }

    private static void Visualizacao() {
        System.out.println("Distrito\t|\tInscritos\t|\tVotantes\t|\tNulos\t|\tBrancos\t|\tAD\t|\tPS\t|\tCH\t|\tIL\t|\tBE\t|\tOutros\t|\tTotal");
        for (int i = 0; i < distritos.size(); i++){
            System.out.println(distritos.get(i)+"\t|\t"+inscritos.get(i)+"\t|\t"+votantes.get(i)+"\t|\t"+nulos.get(i)
                    +"\t|\t"+brancos.get(i)+"\t|\t"+AD.get(i)+"\t|\t"+PS.get(i)+"\t|\t"+CH.get(i)+"\t|\t"+IL.get(i)+"\t|\t"
                    +BE.get(i)+"\t|\t"+outros.get(i)+"\t|\t"+total.get(i));
        }
    }

    private static void TotalPorDistrito(){
        int maior = 0;
        System.out.println("Distrito\t|\tTotal");
        for (int i = 0; i < distritos.size(); i++){
            total.set(i, (nulos.get(i)+ brancos.get(i)+ AD.get(i)+ PS.get(i)+ CH.get(i)+ IL.get(i)+ BE.get(i)+ outros.get(i)));
            System.out.println(distritos.get(i)+"\t|\t"+total.get(i));
            if (total.get(i)>maior){
                maior = total.get(i);
            }
        }
        System.out.println("Distrito com mais votos:");
        for (int i = 0; i < distritos.size(); i++){
            if (total.get(i) == maior){
                System.out.println(distritos.get(i)+" com "+total.get(i)+" votos no total.");
            }
        }
    }

    private static void TotalOutros(){
        System.out.println("Distrito\t|\tOutros");
        for (int i = 0; i < distritos.size(); i++){
            outros.set(i, (votantes.get(i)-( nulos.get(i)+ brancos.get(i)+ AD.get(i)+ PS.get(i)+ CH.get(i)+ IL.get(i)+ BE.get(i) )));
            System.out.println(distritos.get(i)+"\t|\t"+outros.get(i));
        }
    }

    private static void PartidoMaisVotos(){
        System.out.println("Partido com mais votos:");
        int ADtotal = 0;
        int PStotal = 0;
        int CHtotal = 0;
        int ILtotal = 0;
        int BEtotal = 0;
        int totalTotal = 0;
        for (int i = 0; i < distritos.size(); i++){
            ADtotal += AD.get(i);
            PStotal += PS.get(i);
            CHtotal += CH.get(i);
            ILtotal += IL.get(i);
            BEtotal += BE.get(i);
            totalTotal += votantes.get(i);
        }
        int maior = ADtotal;
        if (PStotal > maior)maior=PStotal;
        if (CHtotal > maior)maior=CHtotal;
        if (ILtotal > maior)maior=ILtotal;
        if (BEtotal > maior)maior=BEtotal;
        double porcentagem = (double) maior /totalTotal * 100;
        if (ADtotal == maior){
            System.out.println("AD - "+maior+" votos; "+porcentagem+"%.");
        }
        if (PStotal == maior){
            System.out.println("PS - "+maior+" votos; "+porcentagem+"%.");
        }
        if (CHtotal == maior){
            System.out.println("CH - "+maior+" votos; "+porcentagem+"%.");
        }
        if (ILtotal == maior){
            System.out.println("IL - "+maior+" votos; "+porcentagem+"%.");
        }
        if (BEtotal == maior){
            System.out.println("BE - "+maior+" votos; "+porcentagem+"%.");
        }



    }




}