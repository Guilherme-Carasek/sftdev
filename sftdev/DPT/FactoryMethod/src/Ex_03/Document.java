package Ex_03;

public abstract class Document {
    protected String name;
    protected String author;
    protected String extension;

    public abstract void open();

    public abstract void save();

    public abstract void close();

}
