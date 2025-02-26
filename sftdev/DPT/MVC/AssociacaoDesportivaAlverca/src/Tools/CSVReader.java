package Tools;

import Domain.Competicao;
import Domain.Jogador;
import Domain.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {

    public static ArrayList<User> lerFicheiroUsers(String path) throws FileNotFoundException {
        ArrayList<User> listaUsers = new ArrayList<>();
        Scanner scanner = new Scanner(new File(path));

        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] splitLine = linha.split(";");
            User newUser = new User(splitLine[0], splitLine[1], splitLine[2]);
            listaUsers.add(newUser);
        }

        return listaUsers;
    }

    public static ArrayList<Competicao> lerFicheiroCompeticoes(String path) {
        ArrayList<Competicao> listaCompeticoes = new ArrayList<>();
        //
        return listaCompeticoes;
    }

    public static ArrayList<Jogador> lerFicheiroJogadores(String path) throws FileNotFoundException {
        ArrayList<Jogador> listaJogadores = new ArrayList<>();
        Scanner scanner = new Scanner((new File(path)));

        scanner.nextLine();

        while (scanner.hasNextLine()){
            String linha = scanner.nextLine();
            String[] splitLine = linha.split(";");
            Jogador novoJogador = new Jogador(Integer.parseInt(splitLine[0]), splitLine[1], Integer.parseInt(splitLine[2]), splitLine[3], Integer.parseInt(splitLine[4]), Integer.parseInt(splitLine[5]), Integer.parseInt(splitLine[6]));
            listaJogadores.add(novoJogador);
        }

        return listaJogadores;
    }
}
