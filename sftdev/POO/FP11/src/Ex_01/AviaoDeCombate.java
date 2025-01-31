package Ex_01;

import Ex_01.Enums.Arma;

import java.util.ArrayList;

public class AviaoDeCombate extends Aviao{
    protected String paisOrigem;
    protected boolean camuflagem;
    protected ArrayList<Arma> armas;

    public AviaoDeCombate(int numeroSerie, String modelo, int anoFabrico, double pesoKg, double fuselagemM, double envAsasM,
                          double caldaM, int quantMotores, double autonomiaKm, double maxVelocidadeKmpH, double precoEur,
                          String paisOrigem, boolean camuflagem) {
        super(numeroSerie, modelo, anoFabrico, pesoKg, fuselagemM, envAsasM, caldaM, quantMotores, autonomiaKm,
                maxVelocidadeKmpH, precoEur);
        this.paisOrigem = paisOrigem;
        this.camuflagem = camuflagem;
        this.armas = new ArrayList<Arma>();
    }

    public boolean adicionarArma(Arma armaNova){
        if ( this.armas.size() > 2 ) return false;
        this.armas.add(armaNova);
        return true;
    }

    public ArrayList<Arma> getArmas (){
        return this.armas;
    }

    public void imprimirArmas(){
        System.out.println("**** "+super.modelo+"**** Armas ****");
        for ( Arma arma : this.armas ) {
            System.out.println(arma);
        }
    }

    /**
     * Remove a arma no index indicado
     * @param index
     * @return true or false
     */
    public boolean removerArma (int index){
        if (this.armas.size() <= index) return false;
        this.armas.remove(index);
        return true;
    }

    @Override
    public void imprimirDetalhes() {
        super.imprimirDetalhes();
        System.out.println("País de origem: " + this.paisOrigem);
        if (this.camuflagem) System.out.println("Camuflado");
        else System.out.println("Sem camuflagem");
        this.imprimirArmas();
    }

}
