import java.io.File;

public class ConsoleApplication {
    String name;

    public ConsoleApplication() {

    }

    public void run() {
        Menu menu = createMenuApplication();
        Storage storage = new TextCollect("��������� ��������� ������", new File("c:"));
        //  storage.view();
        menu.run();

    }

    public Menu createMenuApplication() {
        Menu menu = new Menu("������� ��;�� :");
        menu.add("�������� ��������� ��������", storage -> storage.add());
        menu.add("������� ��������� ��������", System.out::println);
        menu.add("����� �� ���������", System.out::println);
        menu.add("����� � ������", System.out::println);
        menu.add("������ ��������� ����� ���������", System.out::println);
        menu.add("�������� ���������", (storage) -> storage.view());
        menu.add("�������� �������� �����", System.out::println);
        menu.add("���������� ���������", System.out::println);
        menu.add("�����", System.out::println);
        return menu;
    }


}