import java.util.ArrayList;
import java.util.StringTokenizer;

public class Console {
    private final ArrayList<Page> pages = new ArrayList<>();
    private final int line;
    private final int symbolsInLine;
    int index = 1;

    public Console(int line, int symbolsInLine) {
        this.line = line;
        this.symbolsInLine = symbolsInLine;

    }

    public void create(String text) {
        ArrayList<String> lines = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder textLine = new StringBuilder();

        StringTokenizer stringTokenizer = new StringTokenizer(text, " ");
        while (stringTokenizer.hasMoreTokens()) {
            stringBuilder.delete(0, stringBuilder.length());
            stringBuilder.append(stringTokenizer.nextToken());
            stringBuilder.append(" ");
            if (((textLine.length() + stringBuilder.length()) >= symbolsInLine) || !stringTokenizer.hasMoreTokens()) {
                textLine.append(stringBuilder);
                lines.add(textLine.toString());
                textLine.delete(0, textLine.length());
                //         textLine.append(stringBuilder);
            } else {
                textLine.append(stringBuilder);
                stringBuilder.delete(0, stringBuilder.length());
            }

            if (lines.size() == line || !stringTokenizer.hasMoreTokens()) {
                pages.add(new Page(lines, pages.size() + 1));
                lines = new ArrayList<>();
            }
        }

    }


    public void outputPageText() {
        printPage();
        Menu menu2 = new Menu("Открытие файла", true);
        menu2.add("предъидущая страница", () -> {
            index--;
            printPage();
        });
        menu2.add("следующая страница", () -> {
            index++;
            printPage();
        });
        menu2.add("Поиск по документу", System.out::println);
        menu2.add("Поиск и замена", System.out::println);
        menu2.add("Выход", () -> menu2.setExit(true));
        menu2.run();


    }

    public void printPage() {

        if (index < 1) {
            index = 1;
        }
        if (index > pages.size()) {
            index = pages.size();
        }
        pages.stream().filter(page -> page.getNumber() == index).forEach(Page::print);
    }
}
