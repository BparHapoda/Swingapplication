import java.util.ArrayList;


public class Page {
    private int number;
    private ArrayList<Character> text = new ArrayList<>();


    public Page(ArrayList<Character> text, int number) {
        this.text = text;
        this.number = number;
    }

    public ArrayList<Character> getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Page{" +
                "text=" + text +
                '}';
    }

}
