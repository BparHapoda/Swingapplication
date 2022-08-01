import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class TextFile implements Serializable {

    @Serial
    private static final long serialVersionUID = 6850662765961184140L;
    private Character text[];
    private String author;
    private Date date;
    private Long size;

    public TextFile(Character[] text, String author, Date date) {
        this.text = text;
        this.author = author;
        this.date = date;
    }

    public Character[] getText() {
        return text;
    }

    public void setText(Character[] text) {
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

}
