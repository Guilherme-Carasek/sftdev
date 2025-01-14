package Ex_01;

public class Main {
    public static void main(String[] args) {
        Carro carro1 = new Carro("Lotus", "Elise", 2004, 200, 1800, TipoCombustivel.GASOLINA, 10);
        Carro carro2 = new Carro("Toyota", "Etios", 2014, 87, 1300, TipoCombustivel.GASOLINA, 6);

        carro1.corrida(carro2).exibirDetalhes();
        System.out.println("_____________________________");

        System.out.println(carro1.getAnoFabrico()+" "+carro1.getMarca()+" "+carro1.getModelo()+" consumiu "+ carro1.litrosParaDestino(97)+" litros na viagem de 97Km.");
        System.out.println(carro2.getAnoFabrico()+" "+carro2.getMarca()+" "+carro2.getModelo()+" consumiu "+ carro2.litrosParaDestino(97)+" litros na viagem de 97Km.");

        System.out.println("_____________________________");

        if (carro1.litrosParaDestino(97) > carro2.litrosParaDestino(97)) {
            carro1.exibirDetalhes();
            System.out.println("Gastou mais combustível");
        } else if (carro1.litrosParaDestino(97) < carro2.litrosParaDestino(97)) {
            carro2.exibirDetalhes();
            System.out.println("Gastou mais combustível");
        } else {
            System.out.println("Os carros gastaram o mesmo combustível");
        }
    }
}
