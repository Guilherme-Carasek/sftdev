package Ex_03;

import java.util.ArrayList;

public class BarcoPesca {
    private String nome;
    private String cor, anoFabrico;
    private int tripulacao;
    private double capacidadeCargaKg;
    private Marca marca;
    private ArrayList<Peixe> peixesPescados = new ArrayList<>();
    private ArrayList<Marisco> mariscosPescados= new ArrayList<>();

    public BarcoPesca(String nome, String cor, String anoFabrico, int tripulacao, double capacidadeCargaKg, Marca marca) {
        this.nome = nome;
        this.cor = cor;
        this.anoFabrico = anoFabrico;
        this.tripulacao = tripulacao;
        this.capacidadeCargaKg = capacidadeCargaKg;
        this.marca = marca;
    }

    public boolean pescarPeixe(Peixe peixePescado){
        double cargaOcupada = 0;
        for (int i = 0; i < this.peixesPescados.size(); i++){
            cargaOcupada += (this.peixesPescados.get(i)).getPesoKg();
        }
        if ( (peixePescado.getPesoKg() + cargaOcupada) > this.capacidadeCargaKg ){
            return false;
        }
        else {
            this.peixesPescados.add(peixePescado);
            return true;
        }
    }
}
