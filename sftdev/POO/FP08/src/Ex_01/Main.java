package Ex_01;

import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args){
        Pessoa filipa = new Pessoa("Filipa",33,1.5);
        Pessoa andreia = new Pessoa("Andreia", 40, 1.8);

        System.out.println(filipa.getNome() + filipa.getIdade() + filipa.getAltura());
        System.out.println(andreia.getNome() + andreia.getIdade() + andreia.getAltura());
    }
}
