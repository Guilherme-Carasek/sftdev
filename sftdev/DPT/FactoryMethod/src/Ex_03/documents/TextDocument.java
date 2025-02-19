package Ex_03.documents;

import Ex_03.Document;



public class TextDocument extends Document {
    public TextDocument(String name, String author){
        this.name = name;
        this.author = author;
        this.extension = ".docx";
    }


    @Override
    public void open() {
        System.out.println("A abrir o documento de texto " + this.name+this.extension);
    }

    @Override
    public void save() {
        System.out.println("A gravar alterações de " + this.author);
    }

    @Override
    public void close() {
        System.out.println("A fechar documento de texto");
    }
}
