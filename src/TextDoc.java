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

    public ArrayList<Integer> find(Character[] find) {
        ArrayList<Integer> found = new ArrayList<>();
        int index = 0;
        for (int i = index; i < text.length; i++) {
            if (findWord(i, find)) {
                System.out.println("нашел на месте " + i);
                found.add(i);
            }
        }
        return found;


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



    public void print(Character[] text) {
        Console console = new Console(2, 10);
        console.create(text);
        System.out.println(console.getPages().get(0).getText());


    }
}
