import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        //6. Pedir ao utilizador um valor par, inferior a 100 e apresentar todos os inteiros múltiplos de 5, entre 0 e esse valor.
        //O pedido do valor deve manter-se até o utilizador introduzir um valor nas condições pretendidas.

        int valor = 1;
        while (valor <= 0 || valor >= 100 || (valor % 2) != 0) {
            Scanner in = new Scanner(System.in);
            System.out.println("Por favor insira um número par maior que 0 e menor que 100");
            while (true) {
                if (in.hasNextInt()) {
                    valor = in.nextInt();
                    break;
                } else{
                    in = new Scanner(System.in);
                    System.out.println("Valor fora das condições");
                }
            }
        }
        //System.out.println(valor);

        for (int i = 1; i < valor; i++){
            if ((i % 5) == 0){
                System.out.print(i+"\t");
            }
        }
    }
}