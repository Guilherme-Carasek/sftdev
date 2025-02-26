package Views;

import Controllers.JogadorController;
import Domain.Jogador;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class JogadorView {
    JogadorController jogadorController;
    public JogadorView() throws FileNotFoundException {
        this.jogadorController = new JogadorController();
    }

    public void jogadorMenu() {
        {

            Scanner input = new Scanner(System.in);
            int menuOption;

            do {
                System.out.println("\nOlá jogador");
                System.out.println("1. Ver todos jogadores");
                System.out.println("2. Ver competições que Alverca ganhou");
                System.out.println("3. Ver competições que Alverca marcou mais golos");
                System.out.println("0. Sair");
                System.out.print("Escolha: ");

                menuOption = input.nextInt();

                switch (menuOption) {
                    case 1: // ver jogadores
                        ArrayList<Jogador> listaJogadores = jogadorController.getTodosJogadores();
                        for (Jogador jogador : listaJogadores){
                            System.out.println();
                            System.out.println(jogador.getNome());
                        }
                        break;

                    case 2: // Ver competições que Alverca ganhou
                        break;

                    case 3: //Ver competições que Alverca marcou mais golos
                        break;

                    case 0: // Exit
                        break;


                    default: // Invalid Option
                        System.out.println("\uD83D\uDEA8 Invalid Option \uD83D\uDEA8");
                }
            }while(menuOption!=0);
        }
    }
}
