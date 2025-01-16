package Ex_02;

import java.util.ArrayList;
import java.util.Random;

public class Sorteio {
    private int premio;
    private ArrayList<Pessoa> participantes = new ArrayList<>();

    public Sorteio(int premio) {
        this.premio = premio;
    }

    public boolean adicionarParticipante( Pessoa novoParticipante ){
        if (novoParticipante.getIdade() >= 18){
            this.participantes.add(novoParticipante);
            return true;
        }
        else return false;
    }

    public Pessoa sorteio(){
        Random rnd = new Random();
        int indexGanhador = rnd.nextInt(this.participantes.size());
        return this.participantes.get(indexGanhador);
    }

    public void imprimirListaParticipantes(){
        for (int i = 0; i < this.participantes.size(); i++){
            System.out.println("Participante "+(i+1)+": "+this.participantes.get(i).getNome()+" | "+this.participantes.get(i).getIdade()+" | "+this.participantes.get(i).getTelemovel()+" | "+this.participantes.get(i).getEmail());
        }
    }

}
