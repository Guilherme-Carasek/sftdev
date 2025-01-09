package Ex_03;

public class Retangulo {
    // atributos de instância
    private double largura;
    private double altura;

    //métodos(s) construtor
    public Retangulo( double largura, double altura ){
        this.largura = largura;
        this.altura = altura;
    }

    //métodos de acesso (get e set)

    //métodos de instância
    public double area(){
        return (this.largura * this.altura);
    }

    public double perimetro(){
        return ((this.largura * 2) + (this.altura * 2));
    }

}
