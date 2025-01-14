package Ex_03;

import java.util.Arrays;

public class Animal {
    private String nome;
    private String especie;
    private String paisOrigem;
    private double pesoKg;
    private String[] alimentacao;

    public Animal(String nome, String especie, String paisOrigem, double pesoKg, String[] alimentacao) {
        this.nome = nome;
        this.especie = especie;
        this.paisOrigem = paisOrigem;
        this.pesoKg = pesoKg;
        this.alimentacao = alimentacao;
    }

    public void comer(String alimento, double pesoG){
        for (int i = 0; i < this.alimentacao.length; i++){
            if(alimentacao[i].equals(alimento)){
                System.out.println("O animal comeu");
                this.pesoKg += (pesoG/1000);
                return;
            }
        }
        System.out.println("O animal não come "+alimento);
    }

    public void exibirDetalhes(){
        System.out.println(this.especie+" "+this.nome+"("+this.pesoKg+"Kg)");
    }
}


