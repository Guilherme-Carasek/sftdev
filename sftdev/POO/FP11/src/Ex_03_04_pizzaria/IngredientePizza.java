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

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
}
