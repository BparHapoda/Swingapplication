import java.util.Scanner;

public class ConsoleApplication {
    String name;

    public ConsoleApplication() {

    }

    public void run() {
        Menu menu = createMenuApplication();
        menu.run();

    }

    public static Menu createMenuApplication() {
        Menu menu = new Menu("Главное меню :");
        menu.add("Создать текстовый документ", () -> System.out.println("lll"));
        menu.add("Открыть текстовый документ", System.out::println);
        menu.add("Поиск по документу", System.out::println);
        menu.add("Поиск и замена", System.out::println);
        menu.add("Задать корневую папку коллекции", System.out::println);
        menu.add("Показать коллекцию", System.out::println);
        menu.add("Показать свойства файла", System.out::println);
        menu.add("Сортировка коллекции", System.out::println);
        menu.add("Выход", System.out::println);
        return menu;
    }
}