import java.io.*;
import java.util.Date;

public class TextDoc implements Serializable {

    @Serial
    private static final long serialVersionUID = 6850662765961184140L;
    private char[] text;
    private String author;
    private Date date;

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

    public String inputString() {
        String string = Main.scanner.next();
        return string;
    }

    public void createTextDoc() {


        System.out.println("¬ведите автора");
        author = inputString();

        try {
            inputText();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void inputText() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        OutputStream os = new FileOutputStream(reader.readLine());

        while (true) {
            String data = reader.readLine();
            if (data.equals("s")) {
                os.write(data.getBytes());
                break;
            } else {
                os.write((data + "\r\n").getBytes());
            }
        }
        os.close();
        reader.close();
    }


}
