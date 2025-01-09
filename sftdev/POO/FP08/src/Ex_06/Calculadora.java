package Ex_06;

public class Calculadora {
    // atributos de instância
    //métodos(s) construtor
    public Calculadora(){

    }

    //métodos de acesso (get e set)
    //métodos de instância
    public double adicionar ( double numero1, double numero2 ){
        return numero1 + numero2;
    }

    public double subtrair(double numero1, double numero2){
        return numero1 - numero2;
    }

    public double multiplicar(double numero1, double numero2){
        return numero1 * numero2;
    }

    public double dividir (double numero1, double numero2){
        if (numero2 == 0){
            System.out.print("Não é possível dividir por 0");
            return 0;
        }
        return numero1 / numero2;
    }
}
