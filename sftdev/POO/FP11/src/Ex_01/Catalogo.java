package Ex_01;

import java.util.ArrayList;

public class Catalogo {
    private ArrayList<Aviao> avioes;

    public void adquirirAviao( Aviao novoAviao ) {
        this.avioes.add(novoAviao);
    }

    public boolean venderAviao ( Aviao vendidoAviao ) {
        return (this.avioes.remove( vendidoAviao ));
    }

    public double calcularValor() {
        double valorTotal = 0;
        for ( Aviao unidade : this.avioes ) {
            valorTotal += unidade.getPrecoEur();
        }

        return valorTotal;
    }

    public void listarCatalogo() {
        System.out.println("****** Catálogo de aviões ******");
        for ( Aviao aviao : this.avioes ) {
            aviao.imprimirDetalhes();
            System.out.println("____________________________________________");
        }
    }
}
