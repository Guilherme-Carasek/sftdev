package Ex_07;

public class Main {
    public static void main(String[] args) {
        Livro programacaoJava = new Livro("Programação em Java: princípios", "Vitor Santos", "Formação", 538, "5162-123-492");
        Livro curiosidadesFloresta = new Livro("Curiosidades da floresta", "Pedro", "Infantil", 76, "1039-356-123");

        programacaoJava.exibirDetalhes();
        curiosidadesFloresta.exibirDetalhes();
    }
}
