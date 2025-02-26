package Controllers;

import Domain.Jogador;
import Model.JogadorRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class JogadorController {
    JogadorRepository jogadorRepository;

    public JogadorController() throws FileNotFoundException {
        this.jogadorRepository = new JogadorRepository();
    }

    public ArrayList<Jogador> getTodosJogadores(){
        return jogadorRepository.getListaJogadores();
    }
}
