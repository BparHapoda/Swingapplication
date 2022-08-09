import java.io.*;
import java.time.LocalDate;
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

    public void find(Character[] text) {
        int index = 0;
        System.out.println("¬ведите текст дл€ поиска : ");
        String find = inputString();
        char[] findArray = find.toCharArray();
        for (int i = index; i < text.length; i++) {

        }


    }

    public void printPage(int startSymbol, int linesInPage, int symbolsInLine) {
        for (int i = 0; i < linesInPage; i++) {
            Stream.of(text).skip(startSymbol).limit(symbolsInLine).forEach(System.out::print);
            startSymbol = startSymbol + symbolsInLine;
            System.out.print("\n");
        }

    }

    public void print(Character[] text) {
        int startSymbol = 0;
        int symbolsInLine = 100;
        int linesInPage = 10;
        int a;
        int begin = 0;
        while (true) {
            startSymbol = begin;
            printPage(startSymbol, linesInPage, symbolsInLine);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                a = scanner.nextInt();

                if ((a != 0) || (a != 9)) {
                    break;
                }
            }

            if (a == 0) {
                begin = begin + symbolsInLine * linesInPage;
                if (begin > text.length - symbolsInLine * linesInPage) {
                    begin = text.length - symbolsInLine * linesInPage;

                }
            } else if (a == 9) {
                begin -= symbolsInLine * linesInPage;
                if (begin < 0) {
                    begin = 0;
                }
            } else if (a == 1) {
                break;
            }
        }
    }
}
