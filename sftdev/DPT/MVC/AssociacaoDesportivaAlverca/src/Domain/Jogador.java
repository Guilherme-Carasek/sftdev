package Domain;

public class Jogador {
    private int numero;
    private String nome;
    private int idade;
    private String nacionalidade;
    private int ranking_defesa;
    private int ranking_ataque;
    private int valor_compra;

    public Jogador(int numero, String nome, int idade, String nacionalidade, int ranking_defesa, int ranking_ataque, int valor_compra) {
        this.numero = numero;
        this.nome = nome;
        this.idade = idade;
        this.nacionalidade = nacionalidade;
        this.ranking_defesa = ranking_defesa;
        this.ranking_ataque = ranking_ataque;
        this.valor_compra = valor_compra;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public int getRanking_defesa() {
        return ranking_defesa;
    }

    public int getRanking_ataque() {
        return ranking_ataque;
    }

    public int getValor_compra() {
        return valor_compra;
    }
}
