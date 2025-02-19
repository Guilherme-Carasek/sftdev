package Ex_03.documents;

import Ex_03.Document;

public class Presentation extends Document {

    public Presentation(String name, String author){
        this.author = author;
        this.name = name;
        this.extension = ".pptx";
    }

    @Override
    public void open() {
        System.out.println("A abrir a apresentação "+this.name+this.extension);
    }

    @Override
    public void save() {
        System.out.println("A gravar alterações de " + this.author);
    }

    @Override
    public void close() {
        System.out.println("A fechar apresentação");
    }
}
