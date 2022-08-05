import java.io.File;

public class ConsoleApplication {
    String name;

    public ConsoleApplication() {

    }

    public void run() {
        Menu menu = new Menu("Text collection");

        Storage storage = new TextCollection("Коллекция текстовых файлов", new File("d:"));
        menu = createMenuApplication(storage);
        menu.run();

    }

    public Menu createMenuApplication(Storage storage) {
        Menu menu = new Menu("Главное меню :");
        menu.add("Добавить текстовый документ", () -> {
            storage.add();
        });
        menu.add("Открыть текстовый документ", System.out::println);
        menu.add("Поиск по документу", System.out::println);
        menu.add("Поиск и замена", System.out::println);
        menu.add("Задать корневую папку коллекции", storage::setRoot);
        menu.add("Показать коллекцию", storage::view);
        menu.add("Показать свойства файла", System.out::println);
        menu.add("Сортировка коллекции", System.out::println);
        menu.add("Выход", System.out::println);
        return menu;
    }


}