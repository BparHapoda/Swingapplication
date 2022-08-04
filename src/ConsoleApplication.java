import java.io.File;

public class ConsoleApplication {
    String name;

    public ConsoleApplication() {

    }

    public void run() {
        Menu menu = createMenuApplication();
        Storage storage = new TextCollect("Коллекция текстовых файлов", new File("c:"));
        //  storage.view();
        menu.run();

    }

    public Menu createMenuApplication() {
        Menu menu = new Menu("Главное ме;ню :");
        menu.add("Добавить текстовый документ", storage -> storage.add());
        menu.add("Открыть текстовый документ", System.out::println);
        menu.add("Поиск по документу", System.out::println);
        menu.add("Поиск и замена", System.out::println);
        menu.add("Задать текстовую папку коллекции", System.out::println);
        menu.add("Показать коллекцию", (storage) -> storage.view());
        menu.add("Показать свойства файла", System.out::println);
        menu.add("Сортировка коллекции", System.out::println);
        menu.add("Выход", System.out::println);
        return menu;
    }


}