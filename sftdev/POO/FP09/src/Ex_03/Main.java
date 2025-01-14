package Ex_03;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Animal("Josefina", "Cabra", "Bolívia", 72, new String[]{"Grama", "Cenoura", "Erva"});

        animal1.exibirDetalhes();
        animal1.comer("Grama", 700);
        animal1.exibirDetalhes();
        animal1.comer("Carne", 1200);
        animal1.exibirDetalhes();
    }
}
