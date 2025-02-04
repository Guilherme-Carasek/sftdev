package Ex_03_04_pizzaria;

public class IngredientePizza {
    private Ingrediente ingrediente;
    private double quantidade;

    public IngredientePizza(Ingrediente ingrediente, double quantidade) {
        this.ingrediente = ingrediente;
        this.quantidade = quantidade;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public String getCodigoIngrediente(){
        return this.ingrediente.getCodigo();
    }

    public double getKcal(){
        return this.quantidade * this.ingrediente.getKcalPorUnidade();
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public void exibirDetalhes(){
        this.ingrediente.exibirDetalhes();
        System.out.print(" : " + this.quantidade);
        switch (this.ingrediente.getUnidadeMedida()){
            default -> { return; }
            case GRAMAS -> System.out.print(" g.");
            case LITROS -> System.out.print(" L.");
            case UNIDADES -> System.out.print(" uni.");
        }
    }

}
