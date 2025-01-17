package Ex_03;

public class Marisco {
    private String especie;
    private double pesoKg;
    private double precoEurPorKg;

    public Marisco(String especie, double pesoKg, double precoEurPorKg) {
        this.especie = especie;
        this.pesoKg = pesoKg;
        this.precoEurPorKg = precoEurPorKg;
    }

    public String getEspecie() {
        return especie;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public double getPrecoEurPorKg() {
        return precoEurPorKg;
    }
}
