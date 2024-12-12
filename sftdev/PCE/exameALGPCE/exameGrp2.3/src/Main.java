import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //3. Crie um programa que leia o conteúdo de um ficheiro chamado entrada.txt e copie as linhas que contêm a palavra
        //"importante" para outro ficheiro chamado saida.txt. Terminado o programa apresente a quantidade de linhas
        //que continha a palavra “importante”
        List<String> linhas = new ArrayList<>();
        try {
            linhas = Files.readAllLines(Path.of("entrada.txt"));
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro");
        }
        String linhasImportante = "";
        int quantidadeLinhas = 0;
        for (int i = 0; i < linhas.size(); i++){
            if (!linhas.get(i).isEmpty()){
                String[] palavras = linhas.get(i).split(" ");
                for (int j = 0; j < palavras.length; j++){
                    if (palavras[j].equals("importante")){
                        linhasImportante += linhas.get(i);
                        linhasImportante += "\n";
                        quantidadeLinhas++;
                    }
                }
            }
        }
        System.out.println(quantidadeLinhas+" linhas continham 'importante'");

        try{
            Files.writeString(Path.of("saida.txt"),linhasImportante);
        }catch (IOException e){
            System.out.println("Erro ao gravar o ficheiro");
        }
    }
}