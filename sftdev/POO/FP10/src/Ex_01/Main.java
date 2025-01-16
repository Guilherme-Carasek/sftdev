package Ex_01;

public class Main {
    public static void main(String[] args) {
        //Exemplo de teste: deve instanciar 6 músicas, adicionar as 6 à programação. De seguida troque a última com
        //a primeira. Seguidamente remova a número 3. Posteriormente calcule a duração da programação. Remova
        //todas as músicas e calcule de novo a duração.

        Musica musica1 = new Musica("In the end", "NuMetal", "Linkin Park", 160);
        Musica musica2 = new Musica("Bad guy", "Rap", "Eminem", 291);
        Musica musica3 = new Musica("The kids aren't alright", "Rock", "The Offspring", 153);
        Musica musica4 = new Musica("Ohne dich", "Industrial metal", "Rammstein", 311);
        Musica musica5 = new Musica("Pisces", "Progressive metal", "Jinjer", 282);
        Musica musica6 = new Musica("BFG Division", "Djent", "Mick Gordon",499 );


        MusicPlayer radio = new MusicPlayer();
        radio.adicionarMusica(musica1); radio.adicionarMusica(musica2);radio.adicionarMusica(musica3); radio.adicionarMusica(musica4);radio.adicionarMusica(musica5); radio.adicionarMusica(musica6);
        radio.imprimirRelatorio();
        radio.trocarMusica(musica1, musica6); radio.trocarMusica(5, musica1);
        radio.removerMusica(musica3);
        radio.imprimirRelatorio();
        radio.duracao();
        radio.removerTodas();
        radio.duracao();
    }
}
