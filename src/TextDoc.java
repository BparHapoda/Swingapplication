import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class TextDoc implements Serializable {

    @Serial
    private static final long serialVersionUID = 6850662765961184140L;
    private char[] text;
    private String author;
    private Date date;
    private Long size;

    public TextDoc(char[] text, String author, Date date) {
        this.text = text;
        this.author = author;
        this.date = date;
    }

    public TextDoc() {
    }

    public char[] getText() {
        return text;
    }

    public void setText(char[] text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static TextDoc createTextDoc() {
        TextDoc textDoc = new TextDoc();
        textDoc.inputText();
        return textDoc;
    }

    public void inputText() {
        System.out.println("¬ведите текст:");
        String string = Main.scanner.next();
        text = string.toCharArray();
    }
}
