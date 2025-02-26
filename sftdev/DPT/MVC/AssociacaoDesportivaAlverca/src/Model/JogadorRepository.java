package Model;

import Domain.Jogador;
import Tools.CSVReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class JogadorRepository {
    private ArrayList<Jogador> listaJogadores;

    public JogadorRepository() throws FileNotFoundException {
        this.listaJogadores = CSVReader.lerFicheiroJogadores("files/jogadores.csv");
    }

    public ArrayList<Jogador> getListaJogadores(){
        return this.listaJogadores;
    }
}
