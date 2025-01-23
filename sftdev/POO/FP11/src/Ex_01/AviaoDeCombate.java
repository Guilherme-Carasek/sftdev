package Ex_01;

import Ex_01.Enums.Arma;

import java.util.ArrayList;

public class AviaoDeCombate extends Aviao{
    protected String paisOrigem;
    protected boolean camuflagem;
    protected ArrayList<Arma> armas;

    public AviaoDeCombate(int numeroSerie, String modelo, int anoFabrico, int pesoKg, int fuselagemM, int envAsasM, int caldaM, int quantMotores, int autonomiaKm, int maxVelocidadeKmpH, int precoEur, String paisOrigem, boolean camuflagem) {
        super(numeroSerie, modelo, anoFabrico, pesoKg, fuselagemM, envAsasM, caldaM, quantMotores, autonomiaKm, maxVelocidadeKmpH, precoEur);
        this.paisOrigem = paisOrigem;
        this.camuflagem = camuflagem;
    }

    public boolean adicionarArma(Arma armaNova){
        if ( this.armas.size() > 2 ) return false;
        this.armas.add(armaNova);
        return true;
    }
}
