import java.util.ArrayList;

public class Console {
    private ArrayList<Page> pages = new ArrayList<>();
    private final int line;
    private final int symbolsInLine;
    int index = 1;

    public Console(int line, int symbolsInLine) {
        this.line = line;
        this.symbolsInLine = symbolsInLine;

    }

    public void create(Character[] text) {

        int lineCounter = 0;


        ArrayList<String> page = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        int number = 1;
        int i = 0;
        int start = 0;
        int finish = 0;
        while (i < text.length) {

            start = i;
            if ((start + symbolsInLine) > text.length) {
                finish = text.length;
            } else {
                finish = start + symbolsInLine;
            }
            for (int j = start; j < finish; j++) {
                stringBuilder.append(text[j]);
                i++;
                if (text[j] == '\n') {
                    i++;
                    lineCounter++;
                    page.add(stringBuilder.toString());
                    stringBuilder.delete(0, stringBuilder.length());
                }

            }
            page.add(stringBuilder.toString());
            stringBuilder.delete(0, stringBuilder.length());
            lineCounter++;

            if (lineCounter == line || i == text.length) {


                pages.add(new Page(page, number));
                number++;


                ArrayList<String> temp = new ArrayList<>();
                page = temp;
                lineCounter = 0;
            }
        }

    }

    public void outputPageText() {
        printPage(1);
        Menu menu2 = new Menu("Открытие файла", true);
        menu2.add("предъидущая страница", () -> {
            index--;
            printPage(index);
        });
        menu2.add("следующая страница", () -> {
            index++;
            printPage(index);
        });
        menu2.run();


    }

    public void printPage(int numberPage) {
        System.out.println(pages.get(0).getNumber());
        pages.stream().filter(page -> page.getNumber() == numberPage).forEach(Page::print);
    }
}
