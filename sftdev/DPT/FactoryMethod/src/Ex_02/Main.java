package Ex_02;

public class Main {
    public static void main(String[] args) {
        Taco tacoDeCarne = Cozinha.fazerTaco("carne");
        Taco tacoDeFrango = Cozinha.fazerTaco("frango");
        Taco tacoVegetariano = Cozinha.fazerTaco("vegetariano");


        tacoDeCarne.bake();
        tacoDeCarne.prepare();
        tacoDeCarne.box();
        tacoDeFrango.bake();
        tacoDeFrango.prepare();
        tacoDeFrango.box();
        tacoVegetariano.bake();
        tacoVegetariano.prepare();
        tacoVegetariano.box();
    }
}
