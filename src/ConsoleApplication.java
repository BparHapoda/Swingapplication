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
        Menu menu = new Menu("������� ���� :");
        menu.add("������� ��������� ��������", () -> System.out.println("lll"));
        menu.add("������� ��������� ��������", System.out::println);
        menu.add("����� �� ���������", System.out::println);
        menu.add("����� � ������", System.out::println);
        menu.add("������ �������� ����� ���������", System.out::println);
        menu.add("�������� ���������", System.out::println);
        menu.add("�������� �������� �����", System.out::println);
        menu.add("���������� ���������", System.out::println);
        menu.add("�����", System.out::println);
        return menu;
    }
}