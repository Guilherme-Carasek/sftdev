import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //23. Crie um programa para multiplicar dois números
        // sem recurso ao operador multiplicação.

        Scanner in = new Scanner(System.in);

        System.out.println("insira o primeiro número");
        int x = in.nextInt();
        int xr = x;
        System.out.println("insira o segundo número");
        int y = in.nextInt();

        // adiciona o primeiro numero à si mesmo |Y| vezes
        // gera negativo apenas se X for negativo, Y não altera
        int c = 1;
        while (c < Math.abs(y)) {
            x = (x + xr);
            c++;
        }

        // SE Y for negativo, inverte o sinal do resultado
        if (y<0){
            x = x-(x+x);
        }

        System.out.println("o resultado da multiplicação é " + x);
    }
}