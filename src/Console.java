import java.util.ArrayList;

public class Console {
    private ArrayList<Page> pages;
    private final int line;
    private final int symbolsInLine;

    public Console(int line, int symbolsInLine) {
        this.line = line;
        this.symbolsInLine = symbolsInLine;
        this.pages = new ArrayList<>();
    }

    public void create(Character[] text) {

        int lineCounter = 0;

        ArrayList<Character> page = new ArrayList<>();
        int number = 0;
        int i = 0;
        int start = 0;
        int finish = 0;
        while (i < text.length) {
            number++;
            start = i;
            if ((start + symbolsInLine) > text.length) {
                finish = text.length;
            } else {
                finish = start + symbolsInLine;
            }
            for (int j = start; j < finish; j++) {
                page.add(text[j]);
                i++;
                if (text[j] == '\n') {
                    i++;
                    lineCounter++;
                    break;
                }

            }
            lineCounter++;

            if (lineCounter == line) {
                this.pages.add(new Page(page, number));
                page.clear();
                lineCounter = 0;
            }
        }

    }

    public ArrayList<Page> getPages() {
        return pages;
    }
}
