import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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

    public void find(Character[] find) {
        ArrayList<Integer> found = new ArrayList<>();
        int index = 0;
        System.out.println(text.length);
        for (int i = index; i < text.length; i++) {
            if (findWord(i, find)) {
                System.out.println("нашел на месте " + i);
                found.add(i);
            }
        }
        System.out.println("нашел " + found.size() + " слов");


    }

    public boolean findWord(int i, Character[] findArray) {
        int count = 0;
        for (int j = 0; j < findArray.length; j++) {
            if (text[i].equals(findArray[j])) {
                count++;
                i++;
            }
        }
        if (count == findArray.length) {
            return true;
        } else {
            return false;
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
            } else if (a == 2) {
                System.out.println("¬ведите слово дл€ поиска :");
                String string = inputString();
                find(toCharacterArray(string));
            }
        }
    }
}
