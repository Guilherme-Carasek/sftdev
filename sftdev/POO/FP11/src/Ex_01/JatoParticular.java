package Ex_01;

import Ex_01.Enums.Arma;
import Ex_01.Enums.CategoriaJato;
import Ex_01.Enums.Instalacoes;

import java.util.ArrayList;

public class JatoParticular extends Aviao{
    protected int lotacao;
    protected double capacidadeBagagemCm3;
    protected CategoriaJato categoria;
    protected ArrayList<Instalacoes> instalacoes;

    public JatoParticular(int numeroSerie, String modelo, int anoFabrico, double pesoKg, double fuselagemM,
                          double envAsasM, double caldaM, int quantMotores, double autonomiaKm, double maxVelocidadeKmpH,
                          double precoEur, int lotacao, double capacidadeBagagemCm3, CategoriaJato categoria) {
        super(numeroSerie, modelo, anoFabrico, pesoKg, fuselagemM, envAsasM, caldaM, quantMotores, autonomiaKm,
                maxVelocidadeKmpH, precoEur);
        this.lotacao = lotacao;
        this.capacidadeBagagemCm3 = capacidadeBagagemCm3;
        this.categoria = categoria;
        this.instalacoes = new ArrayList<Instalacoes>();
    }

    public void adicionarInstalacao(Instalacoes novaInstalacao){
        this.instalacoes.add(novaInstalacao);
    }

    public ArrayList<Instalacoes> getInstalacoes() {
        return this.instalacoes;
    }

    public void imprimirInstalacoes(){
        System.out.println("**** " + super.modelo + "**** Instalações ****");
        for ( Instalacoes instalacao : this.instalacoes ) {
            System.out.println(instalacao);
        }
    }

    public boolean removerInstalacao(int index) {
        if (this.instalacoes.size() <= index) return false;
        this.instalacoes.remove(index);
        return true;
    }

    @Override
    public void imprimirDetalhes() {
        super.imprimirDetalhes();
        System.out.println( "Lotação: " + this.lotacao + " passageiros" );
        System.out.println( "Capacidade de bagagem: " + this.capacidadeBagagemCm3 + "cm3" );
        System.out.println( "Categoria: " + this.categoria );
        this.imprimirInstalacoes();
    }
}
