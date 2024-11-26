import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();
    public static void main(String[] args) {
        System.out.println("Bem vindo à caza do sek");
        double deltaSaldo = 0, saldo = 100;
        System.out.println("Quem está a jogar?");
        String nomeJogador = in.nextLine();

        int opcao = 1;
        do {
            saldo += deltaSaldo;
            System.out.println(nomeJogador+"\nSaldo: €" + saldo);
            if (saldo < -69) {
                System.out.println("Seu saldo é baixo demais, por favor insira mais dinheiro");
                deltaSaldo = AdicionarSaldo();
                saldo += deltaSaldo;
                System.out.println(nomeJogador+"\nSaldo: €" + saldo);
            }
            System.out.println("Gostaria de perd... erm, jogar hoje nas 1.Loterias(€5), 2.Raspadinhas(2€) ou gostaria de 3.Adicionar Saldo?");
            System.out.println("A opção 'Sair' ainda está em desenvolvimento");
            opcao = in.nextInt();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    deltaSaldo = Loteria();
                    break;
                case 2:
                    deltaSaldo = RaspadinhaMenu();
                    break;
                case 3:
                    deltaSaldo = AdicionarSaldo();
                default:
                    System.out.println("Saída não é por aí");
            }
        } while (opcao != 0);
        System.out.println("Oh não, acabou o dinheiro ou a coragem?");
    }



    private static double Loteria() {
        System.out.println("Digite o número em que quer apostar(1000-9999)");
        int numAposta = in.nextInt();
        if(numAposta<1000||numAposta>9999){
            System.out.println("Número invalido");
            return 0;}
        int numPremiado = rnd.nextInt(1000, 10000);
        System.out.println("!!!!! O número premiado é "+numPremiado+" !!!!!");
        if ((numAposta%100)==(numPremiado%100)){
            System.out.println("Muito bom! Acertou os dois últimos números e ganhou €20,00");
            return 20;
        }
            else if ((numAposta%1000)==(numPremiado%1000)){
            System.out.println("!!! Parabens! Acertou os três últimos números e ganhaste €500,00");
            return 500;
        }
            else if (numAposta == numPremiado) {
            System.out.println("!!!!! NÃO ACREDITO! GANHASTE O GRANDE JACKPOT! €10.000,00 !!!!!");
            return 10000;
        }
            else {
            System.out.println("não foi desta vez, tente novamente");
                return -5;}
    }

    private static double RaspadinhaMenu() {
        System.out.println("Quer jogar Raspadinha da Sorte(press 1) ou Raspadinha Imbatível(press 2)? Voltar(press 0)");
        int opcao = in.nextInt();
        double deltaSaldo = 0;
        switch (opcao) {
            case 0:
                break;
            case 1:
                deltaSaldo = RaspadinhaDaSorte();
                break;
            case 2:
                deltaSaldo = RaspadinhaImbativel();
                break;
        }
        return deltaSaldo;
    }

    private static double RaspadinhaDaSorte() {
        System.out.println("Bem vindo a Raspadinha da Sorte! Escolha um ticket numerado(1-10)");
        int numTicket = in.nextInt();
        if (numTicket<1||numTicket>10){
            System.out.println("Não há tickets com este número.");
        return 0;}
        double valorPremio = -2;
        int n1 = rnd.nextInt(1,11);
        int n2 = rnd.nextInt(1,11);
        int n3 = rnd.nextInt(1,11);
        int n4 = rnd.nextInt(1,11);
        int n5 = rnd.nextInt(1,11);
        if (numTicket==n1){valorPremio+=100;}
        if (numTicket==n2){valorPremio+=1;}
        if (numTicket==n3){valorPremio+=1;}
        if (numTicket==n4){valorPremio+=10;}
        if (numTicket==n5){valorPremio+=10;}
        System.out.println("(("+numTicket+"))\n"+n1+"(€100)\n"+n2+"(€1)\n"+n3+"(€1)\n"+n4+"(€10)\n"+n5+"(€10)");
        System.out.println("Ganhaste €"+valorPremio);
        return valorPremio;
    }

    private static double RaspadinhaImbativel() {
        System.out.println("Bem vindo à Raspadinha Imbatível. Quantas raspadinhas queres comprar? (€2 cada)");
        int quantidadeRaspadinhas = in.nextInt();
        if (quantidadeRaspadinhas<1) return 0;
        int premioTotal=0;
        for (int contador=0;contador<quantidadeRaspadinhas;contador++){
            premioTotal-=2;
            int quantidadeAcertos = 0;
            int numPrincipal = rnd.nextInt(0,10);
            int n1 = rnd.nextInt(0,10);
            int n2 = rnd.nextInt(0,10);
            int n3 = rnd.nextInt(0,10);
            int n4 = rnd.nextInt(0,10);
            int n5 = rnd.nextInt(0,10);
            int n6 = rnd.nextInt(0,10);
            int n7 = rnd.nextInt(0,10);
            int n8 = rnd.nextInt(0,10);
            int n9 = rnd.nextInt(0,10);
            double valorPremio = rnd.nextInt(1,11);
            if (numPrincipal==n1)quantidadeAcertos++;
            if (numPrincipal==n2)quantidadeAcertos++;
            if (numPrincipal==n3)quantidadeAcertos++;
            if (numPrincipal==n4)quantidadeAcertos++;
            if (numPrincipal==n5)quantidadeAcertos++;
            if (numPrincipal==n6)quantidadeAcertos++;
            if (numPrincipal==n7)quantidadeAcertos++;
            if (numPrincipal==n8)quantidadeAcertos++;
            if (numPrincipal==n9)quantidadeAcertos++;
            System.out.println("((("+numPrincipal+"))) "+n1+"\t"+n2+"\t"+n3+"\t"+n4+"\t"+n5+"\t"+n6+"\t"+n7+"\t"+n8+"\t"+n9+"\t");
            if(quantidadeAcertos<1){
                System.out.println("Sem sorte! Tente outra vez");
            }
            else if(quantidadeAcertos==1||quantidadeAcertos==2){
                System.out.println("Quase ganhastes! Tente outra vez");
            }
            else {
                premioTotal+=valorPremio;
                System.out.println("Você ganhou! Seu prêmio é: "+valorPremio);
            }
        }
        return premioTotal;
    }

    private static double AdicionarSaldo() {
        System.out.println("Quanto deseja adicionar?");
        double deltaSaldo = in.nextDouble();
        if (deltaSaldo<0){
            System.out.println("Não pode adicionar um valor negativo ao seu saldo");
            return 0;
        }
    return deltaSaldo;}
}