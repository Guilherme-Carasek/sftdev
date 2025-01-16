package Ex_02;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Joana", 13, "94112346", "mail.email");
        Pessoa pessoa2 = new Pessoa("Sandra", 18, "654651", "gmail");
        Pessoa pessoa3 = new Pessoa("Luis", 28,"9154653", "EEEEEEEmai");
        Pessoa pessoa4 = new Pessoa("Yuri", 31, "9412364", "pisqq@knmaiu.com");
        Pessoa pessoa5 = new Pessoa("Nome", 99, "numero", "email");

        Sorteio rifaCesae = new Sorteio(2000);
        rifaCesae.adicionarParticipante(pessoa1);
        rifaCesae.adicionarParticipante(pessoa2);
        rifaCesae.adicionarParticipante(pessoa3);
        rifaCesae.adicionarParticipante(pessoa4);
        rifaCesae.adicionarParticipante(pessoa5);
        rifaCesae.imprimirListaParticipantes();
        System.out.println((rifaCesae.sorteio()).getNome());


    }
}
