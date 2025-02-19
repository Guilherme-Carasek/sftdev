package Ex_03.documents;

import Ex_03.Document;

public class SpreadSheet extends Document {

    public SpreadSheet(String name, String author){
        this.name = name;
        this.author = author;
        this.extension = ".xlsx";
    }

    @Override
    public void open() {
        System.out.println("A abrir a folha de cálculo "+this.name+this.extension);
    }

    @Override
    public void save() {
        System.out.println("A gravar alterações de " + this.author);
    }

    @Override
    public void close() {
        System.out.println("A fechar folha de cálculo");
    }
}
