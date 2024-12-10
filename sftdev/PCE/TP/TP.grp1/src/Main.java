import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();

    public static void main(String[] args) {
        int opcao = -1;
        while (opcao != 0) {
            Scanner in = new Scanner(System.in);
            System.out.println("1.Simular um sorteio");
            System.out.println("2.Comprar chaves");
            System.out.println("3.Comprar chaves aleatórias");
            System.out.println("4.Simular jogos até ganhar");
            System.out.println("0.Sair");
            if (in.hasNextInt()) opcao = in.nextInt();
            if (opcao == 0) return;
            else if (opcao == 1) ImprimirSorteio(SortearChave());
            else if (opcao == 2) CriarBoletim(false);
            else if (opcao == 3) CriarBoletim(true);
            else if (opcao == 4) SimularPremio();
            else System.out.println("Opção inválida");
        }
    }

    private static int[] SortearChave() {
        int[] chaveSorteada = new int[7];
        for (int i = 0; i < chaveSorteada.length; i++) {
            if (i < 5) {
                chaveSorteada[i] = rnd.nextInt(1, 51);
                for (int j = i; j >= 0; j--) {
                    if (i != j && chaveSorteada[i] == chaveSorteada[j]) i--;
                }
            }
            else{
                chaveSorteada[i] = rnd.nextInt(1, 13);
                for (int j = i; j >= 5; j--){
                    if (i != j && chaveSorteada[i] == chaveSorteada[j]) i--;
                }
            }
        }
        return chaveSorteada;
    }

    private static void ImprimirSorteio(int[] chaveSorteada) {
        System.out.println("A chave premiada é:");
        System.out.println("Números:");
        for (int i = 0; i < chaveSorteada.length; i++){
            System.out.print(chaveSorteada[i]+"\t");
            if (i==4){
                System.out.println("\nEstrelhas:");
            }
        }
        System.out.println("\n");
    }

    private static int[][] CriarBoletim(Boolean aleatorio){
        System.out.println("Quantas chaves queres comprar?");
        int numeroChaves = 1;
        try {
            numeroChaves = in.nextInt();
            while (numeroChaves < 1 || numeroChaves > 5) {
                System.out.println("Pode preencher entre 1 e 5 chaves de cada vez");
                numeroChaves = in.nextInt();
            }
        }catch (InputMismatchException e){
            System.out.println("Escolha um número entre 1 e 5");
            CriarBoletim(aleatorio);
        }

        //array [numero de linhas(chaves) desejadas] [5 numeros + 2 estrelas em cada linha]
        int[][] boletim = new int[numeroChaves][7];

        if (aleatorio) {
            for (int i = 0; i < boletim.length; i++) {
                for (int j = 0; j < boletim[i].length; j++) {
                    if (j < 5) {
                        boletim[i][j] = rnd.nextInt(1, 51);
                        // ciclo for k verifica que não está repetido
                        for (int k = j; k >= 0; k--) {
                            if (k != j && boletim[i][k] == boletim[i][j]) j--;
                        }
                    } else {
                        boletim[i][j] = rnd.nextInt(1, 13);
                        for (int k = j; k >= 5; k--) {
                            if (k != j && boletim[i][k] == boletim[i][j]) j--;
                        }
                    }
                }
            }
            //imprime o boletim gerado aleatoriamente
            System.out.println("boletim:");
            for (int i = 0; i < boletim.length; i++) {
                System.out.println();
                for (int j = 0; j < boletim[i].length; j++) {
                    System.out.print(boletim[i][j] + "\t");
                }
            }
            System.out.println();
        }

        else {
            for (int i = 0; i < boletim.length; i++) {
                for (int j = 0; j < boletim[i].length; j++) {
                    System.out.println((i + 1) + "ª chave:");
                    if (j < 5) {
                        System.out.println("Insira o " + (j + 1) + "º número");
                        try {
                            boletim[i][j] = in.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println(e.getMessage());
                            j--;
                        }
                        while (boletim[i][j] < 1 || boletim[i][j] > 50) {
                            System.out.println("Insira um número entre 1 e 50");
                            try {
                                boletim[i][j] = in.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println(e.getMessage());
                                j--;
                            }
                        }
                        // ciclo for k verifica que não está repetido
                        for (int k = j; k >= 0; k--) {
                            if (k != j && boletim[i][k] == boletim[i][j]) {
                                System.out.println("Insira um número não repetido");
                                j--;
                            }
                        }
                    } else {
                        System.out.println("Insira a " + (j - 4) + "ª estrelha");
                        try {
                            boletim[i][j] = in.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println(e.getMessage());
                            j--;
                        }
                        while (boletim[i][j] < 1 || boletim[i][j] > 12) {
                            System.out.println("Insira uma estrelha entre 1 e 12");
                            try {
                                boletim[i][j] = in.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println(e.getMessage());
                                j--;
                            }
                        }
                        for (int k = j; k >= 5; k--) {
                            if (k != j && boletim[i][k] == boletim[i][j]) {
                                System.out.println("Insira uma estrelha não repetida");
                                j--;
                            }
                        }
                    }
                }
            }
        }

        //imprimir o boletim para testes:
        /*System.out.println("boletim:");
        for (int i = 0; i < boletim.length; i++){
            System.out.println();
            for (int j = 0; j < boletim[i].length; j++){
                System.out.print(boletim[i][j]+"\t");
            }
        }
        System.out.println();*/

        CompararBoletim(boletim);
        return boletim;
    }

    private static void CompararBoletim(int[][] boletim){
        //gerar uma chave premiada e imprimir
        int[] chavePremiada = SortearChave();
        ImprimirSorteio(chavePremiada);

        // comparar valor do boletim com a chave sorteada:
        for (int i = 0; i < boletim.length; i++){
            int estrelasAcertadas=0, numerosAcertados=0;
            System.out.println((i+1)+"ª chave:");
            //verificando os acertos da chave "i":
            for (int j = 0; j < boletim[i].length; j++){
                if (j < 5){
                    for (int k = 0; k < 5; k++){
                        if (boletim[i][j] == chavePremiada[k]) numerosAcertados++;
                    }
                }
                else{
                    for (int k = 5; k < 7; k++){
                        if (boletim[i][j] == chavePremiada[k]) estrelasAcertadas++;
                    }
                }
            }
            ImprimirPremio(numerosAcertados,estrelasAcertadas);
        }
    }

    private static void ImprimirPremio(int numerosAcertados, int estrelasAcertadas){
        if (numerosAcertados==0 && estrelasAcertadas==0) System.out.println("não acertou nenhum número ou estrelha, tente novamente");
        else if (numerosAcertados==5 && estrelasAcertadas==2) System.out.println("Acertou 5 números e 2 estrelhas! Ganhou o primeiro prêmio!");
        else if (numerosAcertados==5 && estrelasAcertadas==1) System.out.println("Acertou 5 números e 1 estrelha! Ganhou o segundo prêmio!");
        else if (numerosAcertados==5 && estrelasAcertadas==0) System.out.println("Acertou 5 números! Ganhou o terceiro prêmio!");
        else if (numerosAcertados==4 && estrelasAcertadas==2) System.out.println("Acertou 4 números e 2 estrelhas! Ganhou o quarto prêmio!");
        else if (numerosAcertados==4 && estrelasAcertadas==1) System.out.println("Acertou 4 números e 1 estrelha! Ganhou o quinto prêmio!");
        else if (numerosAcertados==3 && estrelasAcertadas==2) System.out.println("Acertou 3 números e 2 estrelhas! Ganhou o sexto prêmio!");
        else if (numerosAcertados==4 && estrelasAcertadas==0) System.out.println("Acertou 4 números! Ganhou o sétimo prêmio!");
        else if (numerosAcertados==2 && estrelasAcertadas==2) System.out.println("Acertou 2 números e 2 estrelhas! Ganhou o oitavo prêmio!");
        else if (numerosAcertados==3 && estrelasAcertadas==1) System.out.println("Acertou 3 números e 1 estrelha! Ganhou o nono prêmio!");
        else if (numerosAcertados==3 && estrelasAcertadas==0) System.out.println("Acertou 3 números! Ganhou o décimo prêmio!");
        else if (numerosAcertados==1 && estrelasAcertadas==2) System.out.println("Acertou 1 número e 2 estrelhas! Ganhou o décimo primeiro prêmio!");
        else if (numerosAcertados==2 && estrelasAcertadas==1) System.out.println("Acertou 2 números e 1 estrelha! Ganhou o décimo segundo prêmio!");
        else if (numerosAcertados==2 && estrelasAcertadas==0) System.out.println("Acertou 2 números! Ganhou o décimo terceiro prêmio!");
        else System.out.println("Acertou "+numerosAcertados+" números e "+estrelasAcertadas+" estrelhas, não ganhou nenhum prêmio");


    }

    private static void SimularPremio(){
        //reusa a função que retorna uma chave aleatória
        int[] suaChave = SortearChave();
        int i = 0;
        boolean ganhou = false;
        while (!ganhou){
            int[] chaveSorteada = SortearChave();
            int numerosAcertados = 0, estrelasAcertadas = 0;
            for (int j = 0; j < suaChave.length; j++){
                if (j < 5){
                    for (int k = 0; k < 5; k++){
                        if (suaChave[j] == chaveSorteada[k]) numerosAcertados++;
                    }
                }
                else{
                    for (int k = 5; k < 7; k++){
                        if (suaChave[j] == chaveSorteada[k]) estrelasAcertadas++;
                    }
                }
            }
            i++;
            if (numerosAcertados==5 && estrelasAcertadas==2) {
                System.out.println("Jogo #"+i+":");
                System.out.println("Sua chave:");
                for (int j = 0; j < suaChave.length; j++){
                    System.out.print(suaChave[j]+"\t");
                    if (j==4) System.out.print("||\t");
                }
                System.out.println("\nChave premiada:");
                for (int j = 0; j < chaveSorteada.length; j++){
                    System.out.print(chaveSorteada[j]+"\t");
                    if (j==4) System.out.print("||\t");
                }
                System.out.println("\nNúmeros acertados: "+numerosAcertados);
                System.out.println("Estrelhas acertadas: "+estrelasAcertadas);
                System.out.println("Foi preciso "+i+" tentativas para ganhar!");
                ganhou = true;
            }
            //imprime sua chave, a sorteada e os acertos a cada x tentativas
            else if (i%10000==0){
                System.out.println("Jogo #"+i+":");
                System.out.println("Sua chave:");
                for (int j = 0; j < suaChave.length; j++){
                    System.out.print(suaChave[j]+"\t");
                    if (j==4) System.out.print("||\t");
                }
                System.out.println("\nChave premiada:");
                for (int j = 0; j < chaveSorteada.length; j++){
                    System.out.print(chaveSorteada[j]+"\t");
                    if (j==4) System.out.print("||\t");
                }
                System.out.println("\nNúmeros acertados: "+numerosAcertados);
                System.out.println("Estrelhas acertadas: "+estrelasAcertadas);
            }
        }
    }
}