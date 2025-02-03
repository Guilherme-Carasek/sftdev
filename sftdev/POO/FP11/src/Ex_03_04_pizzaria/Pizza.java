package Ex_03_04_pizzaria;

import Ex_03_04_pizzaria.Enums.TamanhoPizza;

import java.util.ArrayList;

public class Pizza {
    private String codigo;
    private String nome;
    private String descricao;
    private double preco;
    private TamanhoPizza tamanho;
    private ArrayList<IngredientePizza> listaIngredientes;


    /**
     * método construtor
     * @param codigo
     * @param nome
     * @param descricao
     * @param preco
     * @param tamanho
     */
    public Pizza(String codigo, String nome, String descricao, double preco, TamanhoPizza tamanho) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.tamanho = tamanho;
    }

    public boolean adicionarIngrediente(IngredientePizza ingredientePizzaNovo){
        if (this.listaIngredientes.size() < 5 ){
            this.listaIngredientes.add( ingredientePizzaNovo );
            return true;
        }
        return false;
    }

    /**
     * Recebe código do ingrediente à editar quantidade e a nova quantidade
     * @param codigoIngrediente
     * @param quantidadeNova
     */
    public void editarQuantidadeIngrediente ( String codigoIngrediente, double quantidadeNova ) {
        for (IngredientePizza ingredientePizza : this.listaIngredientes ) {
            if (ingredientePizza.getCodigoIngrediente().equals(codigoIngrediente)){
                ingredientePizza.setQuantidade( quantidadeNova );
                return;
            }
        }
    }

    public boolean removerIngrediente ( String codigoIngrediente ) {
        for ( IngredientePizza ingredientePizza : this.listaIngredientes ) {
            if ( ingredientePizza.getCodigoIngrediente().equals( codigoIngrediente )) {
                this.listaIngredientes.remove( ingredientePizza );
                return true;
            }
        }
        return false;
    }

}
