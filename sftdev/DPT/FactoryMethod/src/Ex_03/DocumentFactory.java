package Ex_03;

import Ex_03.documents.Presentation;
import Ex_03.documents.SpreadSheet;
import Ex_03.documents.TextDocument;

public class DocumentFactory {


    /**
     *
     * @param tipo - accepts types: text, presentation, spreadSheet
     * @param name
     * @param author
     * @return
     */
    static Document createDocument(String tipo, String name, String author){
        return switch (tipo) {
            default -> null;
            case "text" -> new TextDocument(name, author);
            case "presentation" -> new Presentation(name, author);
            case "spreadSheet" -> new SpreadSheet(name, author);
        };
    }
}
