import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //8. Crie um programa que irá gerar um número aleatório entre 1 e 50 permitindo de seguida ao utilizador fazer
        //sucessivas tentativas até acertar nesse número. Em cada tentativa errada é mostrado ao utilizador uma das
        //mensagens: “Tente um número maior” ou “Tente um número menor”. Quando o utilizador acertar no número
        //deve ser mostrado o número de tentativas gastas pelo utilizador.
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();

        int aleatorioNumero = rnd.nextInt(1,51);
        boolean acertou = false;
        int tentativas = 1;
        while (!acertou){
            in = new Scanner(System.in);
            int chuteNumero = -1;
            System.out.println("Adivinhe o número entre 1 e 50");
            while (chuteNumero < 1 || chuteNumero > 50) {
                while (true) {
                    if (in.hasNextInt()) {
                        chuteNumero = in.nextInt();
                        break;
                    } else {
                        in = new Scanner(System.in);
                        System.out.println("Valor inválido");
                    }
                }
                if (chuteNumero < 1 || chuteNumero > 50) System.out.println("Valor inválido");
            }
            if (chuteNumero == aleatorioNumero){ acertou = true; break;}
            else if (chuteNumero < aleatorioNumero){
                System.out.println("Tente um número maior");
            }
            else{
                System.out.println("Tente um número menor");
            }
            tentativas++;
        }
        System.out.println("Acertou em "+tentativas+" tentativas!");
    }
}