package Ex_05;

import java.sql.Array;

public class Agenda {
    private int numeroPaginas;
    private Pessoa[] pessoas = new Pessoa[numeroPaginas];

    public Agenda(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public boolean adicionarPessoa(Pessoa pessoaNova){
        for (int i = 0; i < pessoas.length; i++) {
            if ( pessoas[i] == null ){
                pessoas[i] = pessoaNova;
                return true;
            }
        }
        return false;
    }


}
