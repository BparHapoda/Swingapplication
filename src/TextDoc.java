import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class TextDoc implements Serializable {

    @Serial
    private static final long serialVersionUID = 6850662765961184140L;
    private char[] text;
    private String author;
    private LocalDate date;

    public TextDoc() {
        date = LocalDate.now();
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String inputString() {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        return string;
    }

    public void createTextDoc() {


        System.out.println("¬ведите автора");
        author = inputString();

        inputText();

    }

    public String inputText() {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String text;
        StringBuffer sb = new StringBuffer();
        while (true) {
            try {
                if ((text = bufferedReader.readLine()).equals("ESC")) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            sb.append(text);
        }
        return sb.toString();
    }


}
