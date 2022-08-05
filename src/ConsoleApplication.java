import java.io.File;

public class ConsoleApplication {
    String name;

    public ConsoleApplication() {

    }

    public void run() {
        Menu menu = new Menu("Text collection");

        Storage storage = new TextCollection("��������� ��������� ������", new File("d:"));
        menu = createMenuApplication(storage);
        menu.run();

    }

    public Menu createMenuApplication(Storage storage) {
        Menu menu = new Menu("������� ���� :");
        menu.add("�������� ��������� ��������", () -> {
            storage.add();
        });
        menu.add("������� ��������� ��������", System.out::println);
        menu.add("����� �� ���������", System.out::println);
        menu.add("����� � ������", System.out::println);
        menu.add("������ �������� ����� ���������", storage::setRoot);
        menu.add("�������� ���������", storage::view);
        menu.add("�������� �������� �����", System.out::println);
        menu.add("���������� ���������", System.out::println);
        menu.add("�����", System.out::println);
        return menu;
    }


}