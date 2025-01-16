package Ex_02;

public class Pessoa {
    private String nome;
    private int idade;
    private String telemovel;
    private String email;

    public Pessoa(String nome, int idade, String telemovel, String email) {
        this.nome = nome;
        this.idade = idade;
        this.telemovel = telemovel;
        this.email = email;
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getTelemovel() {
        return telemovel;
    }

    public String getEmail() {
        return email;
    }
}
