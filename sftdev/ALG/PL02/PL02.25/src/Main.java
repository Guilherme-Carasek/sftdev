import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //25. Elabore uma função que dado um ano verifique se ele é ou não bissexto.

        Scanner in = new Scanner(System.in);
        System.out.println("indique um ano:");
        int ano = in.nextInt();
        boolean bissexto;

        if (ano % 4 == 0){
            bissexto = true;
        }
        else{
            bissexto=false;
        }

        if (ano%100==0){
            bissexto=false;
        }

        if (ano%400==0){
            bissexto=true;
        }

        if(bissexto){
            System.out.println("O ano é bissexto (366 dias)");
        }
        else{
            System.out.println("o ano não é bissexto(365 dias)");
        }
    }
}