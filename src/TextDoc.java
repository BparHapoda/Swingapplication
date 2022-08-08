import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class TextDoc implements Serializable {

    @Serial
    private static final long serialVersionUID = 6850662765961184140L;
    private Character[] text;
    private String author;
    private LocalDate date;

    public TextDoc() {
        date = LocalDate.now();
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String inputString() {
        String string = "";
        Scanner scanner = new Scanner(System.in);
        string = scanner.nextLine();
        return string;
    }

    public Character[] toCharacterArray(String string) {
        Character array[] = new Character[string.length()];
        for (int i = 0; i < string.length(); i++) {
            array[i] = string.charAt(i);
        }
        return array;
    }

    public String inputText() throws IOException {

        StringBuffer sb = new StringBuffer();
        String text;
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        while (true) {
            text = bufferedReader.readLine();
            if (text.equals("ESC")) {
                break;
            }
            sb.append(text);
        }


        return sb.toString();
    }

    public void print(Character[] text) {
        int x = 0;
        int y = 100;
        int z = 10;
        int a;
        int stat = 0;
        while (true) {
            x = stat;
            for (int i = 0; i < z; i++) {
                Stream.of(text).skip(x).limit(y).forEach(System.out::print);
                x = x + y;
                System.out.print("\n");
            }

            Scanner scanner = new Scanner(System.in);
            while (true) {
                a = scanner.nextInt();

                if ((a != 0) || (a != 9)) {
                    break;
                }
            }

            if (a == 0) {
                stat = stat + y * z;
                if (stat > text.length - y * z) {
                    stat = text.length - y * z;
                }
            } else if (a == 9) {
                stat -= y * z;
                if (stat < 0) {
                    stat = 0;
                }
            } else if (a == 1) {
                break;
            }
        }
    }

}
