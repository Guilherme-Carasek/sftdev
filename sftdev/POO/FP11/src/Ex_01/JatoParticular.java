package Ex_01;

import Ex_01.Enums.CategoriaJato;
import Ex_01.Enums.Instalacoes;

import java.util.ArrayList;

public class JatoParticular extends Aviao{
    protected int lotacao;
    protected int capacidadeBagagemCm3;
    protected CategoriaJato categoria;
    protected ArrayList<Instalacoes> instalacoes;

    public JatoParticular(int numeroSerie, String modelo, int anoFabrico, int pesoKg, int fuselagemM, int envAsasM, int caldaM, int quantMotores, int autonomiaKm, int maxVelocidadeKmpH, int precoEur, int lotacao, int capacidadeBagagemCm3, CategoriaJato categoria) {
        super(numeroSerie, modelo, anoFabrico, pesoKg, fuselagemM, envAsasM, caldaM, quantMotores, autonomiaKm, maxVelocidadeKmpH, precoEur);
        this.lotacao = lotacao;
        this.capacidadeBagagemCm3 = capacidadeBagagemCm3;
        this.categoria = categoria;
    }

    public void adicionarInstalacao(Instalacoes novaInstalacao){
        this.instalacoes.add(novaInstalacao);
    }
}
