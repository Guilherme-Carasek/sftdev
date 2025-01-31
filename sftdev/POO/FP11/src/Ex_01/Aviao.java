package Ex_01;

public class Aviao {
    protected int numeroSerie;
    protected String modelo;
    protected int anoFabrico;
    protected double pesoKg;
    protected double fuselagemM;
    protected double envAsasM;
    protected double caldaM;
    protected int quantMotores;
    protected double autonomiaKm;
    protected double maxVelocidadeKmpH;
    protected double precoEur;

    public Aviao(int numeroSerie, String modelo, int anoFabrico, double pesoKg, double fuselagemM, double envAsasM,
                 double caldaM, int quantMotores, double autonomiaKm, double maxVelocidadeKmpH, double precoEur) {
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

    public double getPrecoEur() {
        return precoEur;
    }

    public void imprimirDetalhes() {
        System.out.println("****** "+this.modelo+" " + this.anoFabrico + " ******");
        System.out.println("Número de série: "+this.numeroSerie);
        System.out.println("Peso: " + this.pesoKg + "Kg");
        System.out.println("Comprimento da fuselagem: " + this.fuselagemM + "m");
        System.out.println("Envergadura: " + this.envAsasM + "m");
        System.out.println("Altura da calda: " + this.caldaM + "m");
        System.out.println(this.quantMotores + "motores");
        System.out.println(this.autonomiaKm + "Km de autonomia");
        System.out.println("Velocidade máxima: " + this.maxVelocidadeKmpH + "Km/h");
        System.out.println("Preço: " + this.precoEur + "€");
    }
}
