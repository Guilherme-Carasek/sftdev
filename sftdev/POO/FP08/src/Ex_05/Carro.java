package Ex_05;

public class Carro {
    // atributos de instância
    private String marca;
    private String modelo;
    private int anoFabrico;

    //métodos(s) construtor
    public Carro(String marca, String modelo, int anoFabrico){
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabrico = anoFabrico;
    }

    //métodos de acesso (get e set)

    //métodos de instância
    public void ligar(){
        System.out.println("O carro está ligado");
    }

}
