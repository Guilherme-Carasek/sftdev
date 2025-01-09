package Ex_04;

public class Circulo {
    //atributos de instância
    private double raio;

    //métodos(s) construtor
    public Circulo(double raio){
        this.raio = raio;
    }

    //métodos de acesso (get e set)
    //métodos de instância
    public double area(){
        return (Math.PI * Math.pow(this.raio,2));
    }

    public double circunferencia(){
        return (2 * Math.PI * this.raio);
    }
}
