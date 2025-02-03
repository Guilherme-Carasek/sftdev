package Ex_03_04_pizzaria;

import Ex_03_04_pizzaria.Enums.UnidadeMedida;

public class Ingrediente {
    private String codigo;
    private String nome;
    private UnidadeMedida unidadeMedida;
    private double kcalPorUnidade;

    public Ingrediente(String codigo, String nome, UnidadeMedida unidadeMedida, double kcalPorUnidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.unidadeMedida = unidadeMedida;
        this.kcalPorUnidade = kcalPorUnidade;
    }

    public String getCodigo() {
        return codigo;
    }
}
