package Ex_03;

public class Main {
    public static void main(String[] args) {
        Document fp01 = DocumentFactory.createDocument("text", "Ficha prática Factory", "Vitor");
        Document aula03 = DocumentFactory.createDocument("presentation", "Aula 03 - Factory Method", "Vitor");
        Document notasAlunos = DocumentFactory.createDocument("spreadSheet", "Notas Softdev", "Vitor");

        fp01.open();
        fp01.save();
        fp01.close();
        aula03.open();
        aula03.save();
        aula03.close();
        notasAlunos.open();
        notasAlunos.save();
        notasAlunos.close();
    }
}
