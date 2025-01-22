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

    private double cargaLivre(){
        double cargaOcupada = 0;
        for (int i = 0; i < this.peixesPescados.size(); i++){
            cargaOcupada += (this.peixesPescados.get(i)).getPesoKg();
        }
        for (int i = 0; i < this.mariscosPescados.size(); i++){
            cargaOcupada += (this.mariscosPescados.get(i)).getPesoKg();
        }
        return ( this.capacidadeCargaKg - cargaOcupada );
    }

    public boolean pescarPeixe(Peixe peixePescado){
        if ( peixePescado.getPesoKg() > this.cargaLivre() ){
            return false;
        }
        else {
            this.peixesPescados.add(peixePescado);
            return true;
        }
    }

    public boolean pescarMarisco(Marisco mariscoPescado){

        if ( mariscoPescado.getPesoKg() > this.cargaLivre() ){
            return false;
        }
        else {
            this.mariscosPescados.add(mariscoPescado);
            return true;
        }
    }

    public void largarPeixe(int i){
        this.peixesPescados.remove(i);
    }
    public void largarMarisco(Marisco mariscoRemovido){
        this.mariscosPescados.remove(mariscoRemovido);
        System.out.println("Largou "+mariscoRemovido.getEspecie());
    }

    public double calcularTotal (){
        double valorTotalEur = 0;
        for (int i = 0; i < this.peixesPescados.size(); i++){
            valorTotalEur += (this.peixesPescados.get(i).getPesoKg() * this.peixesPescados.get(i).getPrecoEurPorKg());
        }
        for (int i = 0; i < this.mariscosPescados.size(); i++){
            valorTotalEur += (this.mariscosPescados.get(i).getPesoKg() * this.mariscosPescados.get(i).getPrecoEurPorKg());
        }

        return valorTotalEur;
    }

    public double salarioTripulacao(){
        return ( ( this.calcularTotal() * 0.6 ) / this.tripulacao );
    }
}
