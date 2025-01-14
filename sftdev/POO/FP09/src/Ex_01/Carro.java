package Ex_01;

public class Carro {
    // atributos de instância
    private String marca;
    private String modelo;
    private int anoFabrico;
    private int potencia;
    private int cilindrada;
    private TipoCombustivel combustivel;
    private double consumo;

    //métodos(s) construtor

    public Carro(String marca, String modelo, int anoFabrico, int potencia, int cilindrada, TipoCombustivel combustivel, double consumo) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabrico = anoFabrico;
        this.potencia = potencia;
        this.cilindrada = cilindrada;
        this.combustivel = combustivel;
        this.consumo = consumo;
    }


    //métodos de acesso (get e set)
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnoFabrico() {
        return anoFabrico;
    }

    //métodos de instância
    public void ligar(){
        if (anoFabrico < 1995){
            if (combustivel == TipoCombustivel.DIESEL){
                System.out.println("Deita um pouco de fumo… Custa a pegar… O carro está ligado!\nVrum-vrum-vrum");
            }
            else{
                System.out.println("“Deita um pouco de fumo… Custa a pegar… O carro está ligado!”\n" + "“Vrum-vrum-vrum”");
            }
        }
        else{
            if (potencia < 250){
                System.out.println("“O carro está ligado!”\n" + "“Vruummmmmmm”");
            }
            else{
                System.out.println("“O carro está ligado!”\n" + "“VRUUMMMMMM”");
            }
        }
    }

    public Carro corrida ( Carro adversario ){
        if (this.potencia > adversario.potencia){
            return this;
        }
        if (this.potencia < adversario.potencia){
            return adversario;
        }
        else{
            if (this.cilindrada > adversario.cilindrada){
                return this;
            }
            if (this.cilindrada < adversario.cilindrada){
                return adversario;
            }
            else{
                if (this.anoFabrico > adversario.anoFabrico){
                    return this;
                }
                if (this.anoFabrico < adversario.anoFabrico){
                    return adversario;
                }
                else return null;
            }
        }
    }

    public double litrosParaDestino( int distancia ){
        return ( this.consumo * distancia / 100);
    }

    public void exibirDetalhes(){
        System.out.println("(" + this.anoFabrico + ")" + this.marca + " " + this.modelo);
    }
}