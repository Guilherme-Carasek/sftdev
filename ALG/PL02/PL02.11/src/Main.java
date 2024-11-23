import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //recebe 3 medidas de lados de um triângulo,
        //retorna o tipo do triângulo

        Scanner in = new Scanner(System.in);

        System.out.println("insira o primeiro lado do triângulo");
        double p1 = in.nextDouble();
        System.out.println("insira o segundo lado do triângulo");
        double p2 = in.nextDouble();
        System.out.println("insira o terceiro lado do triângulo");
        double p3 = in.nextDouble();

        if (p1 <= 0 || p2 <= 0 || p3 <= 0) {
            System.out.println("um triângulo com lado zero ou negativo é impossível");
        } else {
            if (p1 >= (p2 + p3) || p2 >= (p1 + p3) || p3 >= (p1 + p2)) {
                System.out.println("o triângulo é impossível");
            } else {

                if (p1 == p2 && p1 == p3) {
                    System.out.println("estes lados formam um triângulo equilátero");
                } else {
                    if (p1!=p2&&p1!=p3&&p2!=p3) {
                        System.out.println("estes lados formam um triângulo escaleno");
                    }
                    else {
                        System.out.println("estes lados formam um triângulo isóceles");
                    }
                }
            }
        }


    }
}