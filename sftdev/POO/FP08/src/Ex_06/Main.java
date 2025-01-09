package Ex_06;

public class Main {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        System.out.println(calc.adicionar(1,2));
        System.out.println(calc.subtrair(8,3));
        System.out.println(calc.multiplicar( 64, 2 ));
        System.out.println(calc.dividir(9,0));
        System.out.println(calc.dividir(15,3));
    }
}
