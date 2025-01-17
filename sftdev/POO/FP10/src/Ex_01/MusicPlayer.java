package Ex_01;

import java.util.ArrayList;

public class MusicPlayer {
    private ArrayList<Musica> programacao = new ArrayList();

    public void adicionarMusica(Musica novaMusica){
        this.programacao.add(novaMusica);
    }

    public void trocarMusica (int i, Musica novaMusica){
        this.programacao.set(i, novaMusica);
    }
    public void trocarMusica ( Musica musicaATrocar, Musica novaMusica ){
        if (this.programacao.contains(musicaATrocar)){
            this.programacao.set(this.programacao.indexOf(musicaATrocar), novaMusica);
        }
    }

    public void removerMusica ( int i ){
        this.programacao.remove(i);
    }

    public void removerMusica (Musica musicaARemover){
        this.programacao.remove(musicaARemover);
    }

    public void removerTodas () {
        this.programacao.clear();
    }

    public void imprimirRelatorio (){
        for ( int i = 0; i < this.programacao.size(); i++ ){
            System.out.println("Música "+i+": "+this.programacao.get(i).getTitulo()+" | "+this.programacao.get(i).getGenero()+" | "+this.programacao.get(i).getArtista()+" | "+this.programacao.get(i).getDuracaoSegundos());
        }
    }

    /**
     * método para imprimir a duração total da programação
     */
    public void duracao (){
        int soma = 0;
        for ( int i = 0; i < this.programacao.size(); i++ ){
            soma += this.programacao.get(i).getDuracaoSegundos();
        }
        int totalSegundos = soma % 60;
        soma /= 60;
        int totalMinutos = soma % 60;
        soma /= 60;

        System.out.println("Duração da programação- "+soma+":"+totalMinutos+":"+totalSegundos);
    }
}
