package Ex_01;

public class Aviao {
    protected int numeroSerie;
    protected String modelo;
    protected int anoFabrico;
    protected int pesoKg;
    protected int fuselagemM;
    protected int envAsasM;
    protected int caldaM;
    protected int quantMotores;
    protected int autonomiaKm;
    protected int maxVelocidadeKmpH;
    protected int precoEur;

    public Aviao(int numeroSerie, String modelo, int anoFabrico, int pesoKg, int fuselagemM, int envAsasM, int caldaM, int quantMotores, int autonomiaKm, int maxVelocidadeKmpH, int precoEur) {
        this.numeroSerie = numeroSerie;
        this.modelo = modelo;
        this.anoFabrico = anoFabrico;
        this.pesoKg = pesoKg;
        this.fuselagemM = fuselagemM;
        this.envAsasM = envAsasM;
        this.caldaM = caldaM;
        this.quantMotores = quantMotores;
        this.autonomiaKm = autonomiaKm;
        this.maxVelocidadeKmpH = maxVelocidadeKmpH;
        this.precoEur = precoEur;
    }
}
