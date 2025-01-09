package Ex_02;

public class Cao {
    // atributos de instância
    private String nome;
    private String raca;
    private String latido = "au au au";

    //métodos(s) construtor
    public Cao(String nome, String raca){
        this.nome= nome;
        this.raca = raca;
    }

    //métodos de acesso (get e set)
    public void setLatido(String latido){
        this.latido = latido;
    }

    //métodos de instância
    public void ladrar(){
        System.out.println(this.latido);
    }

    public void ladrar(int quantidadeVezes){
        for (int i = 0; i < quantidadeVezes; i++){
            System.out.println(this.latido);
        }
    }

}
