import java.io.File;

public class ConsoleApplication {

    public ConsoleApplication() {

    }

    public void run() {
        File file = new File("textcollection.tcol");
        Storage storage = new TextCollection();
        if (file.exists()) {
            storage = storage.open();
        } else {
            System.out.println("C������� ����� ��������� ��������� ������,����� �� �������� �����.");
            storage.setRoot();
        }
      Menu menu = createMenuApplication(storage);
        menu.run();

    }

    public Menu createMenuApplication(Storage storage) {
        Menu menu = new Menu("������� ���� :", false);
        menu.add("�������� ��������� ��������", storage::add);
        menu.add("������� ��������� ��������", () -> storage.openFileFromCollection(storage));

        menu.add("������ �������� ����� ���������", storage::setRoot);
        menu.add("�������� ���������", storage::view);
        menu.add("�������� �������� �����", () -> storage.showFileAtributes(storage));
        menu.add("���������� ���������", System.out::println);
        menu.add("�����", () -> {
            storage.save();
            menu.setExit(true);
        });
        return menu;
    }


}