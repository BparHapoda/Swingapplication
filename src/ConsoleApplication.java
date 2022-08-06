import java.io.File;

public class ConsoleApplication {
    String name;

    public ConsoleApplication() {

    }

    public void run() {
        Menu menu = new Menu("Text collection");
        File file = new File("textcollection.tcol");
        Storage storage = new TextCollection();
        if (file.exists()) {
            storage = storage.open();
        } else {
            System.out.println("C������� ����� ��������� ��������� ������,����� �� �������� �����.");
            storage.setRoot();
        }
        menu = createMenuApplication(storage);
        menu.run();

    }

    public Menu createMenuApplication(Storage storage) {
        Menu menu = new Menu("������� ���� :");
        menu.add("�������� ��������� ��������", () -> {
            storage.add();
        });
        menu.add("������� ��������� ��������", () -> storage.openFileFromCollection(storage));
        menu.add("����� �� ���������", System.out::println);
        menu.add("����� � ������", System.out::println);
        menu.add("������ �������� ����� ���������", storage::setRoot);
        menu.add("�������� ���������", storage::view);
        menu.add("�������� �������� �����", System.out::println);
        menu.add("���������� ���������", System.out::println);
        menu.add("�����", () -> {
            storage.save();
            menu.setExit(true);
        });
        return menu;
    }


}