package Ex_07;

public class Livro {
    // atributos de instância
    private String titulo;
    private String autor;
    private String categoria;
    private int numeroPaginas;
    private String isbn;

    //métodos(s) construtor
    public Livro (String titulo, String autor, String categoria, int numeroPaginas, String isbn){
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
    }

    //métodos de acesso (get e set)

    //métodos de instância
    public void exibirDetalhes(){
        System.out.println("************ "+this.titulo+" ************");
        System.out.println(this.autor+" | "+this.categoria);
        System.out.println(this.numeroPaginas+" páginas | ISBN: "+this.isbn);
        System.out.println();
    }

}
