package Ex_02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instancia;
    private String ficheiroNome;

    private Logger(String ficheiroNome){
        this.ficheiroNome = ficheiroNome;
        criarFicheiro(ficheiroNome);
    }
    public static Logger getInstance(String ficheiroNome){
        if (instancia == null){
            instancia = new Logger(ficheiroNome);
        }
        return instancia;
    }
    private void criarFicheiro(String ficheiroNome){
        File ficheiro = new File(ficheiroNome);
        try {
            ficheiro.createNewFile();
        } catch (IOException e) {
            System.out.println("Erro ao criar ficheiro");;
        }
    }
    public void log(String novoLog){
        try{
            FileWriter fw = new FileWriter(ficheiroNome, true);
            fw.write(novoLog+"\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Erro ao gravar ao ficheiro");;
        }
    }
}
