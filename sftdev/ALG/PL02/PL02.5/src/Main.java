import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //5. programa recebe um valor à ser pago, o valor de um produto e retorna o troco

        Scanner in = new Scanner(System.in);

        System.out.println("insira o valor pago");
        double pagamento = in.nextDouble();

        System.out.println("insira o preço do produto");
        double preco = in.nextDouble();

        double troco = pagamento-preco;
        System.out.println("o seu troco é "+troco);

        // usar if/else, Math.abs() para apresentar diversas possibilidades
        // (não há troco / valor pago é menor que o preço)
    }
}