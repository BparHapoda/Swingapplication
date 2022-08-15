import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class TextCollection implements Storage, Serializable {
    @Serial
    private static final long serialVersionUID = 5154197581460058884L;
    String name;
    File file;

    public TextCollection(String name, File file) {
        this.name = name;
        this.file = file;
    }

    public TextCollection() {
    }

    @Override
    public void add() {
        TextDoc textDoc = new TextDoc();
        System.out.println("������� ������ :");
        textDoc.setAuthor(textDoc.inputString());
        System.out.println("������� �����  :");


        try {
            String text = textDoc.inputText();
            textDoc.setText(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("������� �������� �����  :");
        StringBuilder fileName = new StringBuilder();
        fileName.append(file);
        fileName.append(textDoc.inputString());
        fileName.append(".tdoc");
        System.out.println(fileName);
        try (FileOutputStream fos = new FileOutputStream(fileName.toString());
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(textDoc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void view() {
        ArrayList<File> fileList = createFileList();
        for (File fileItem : fileList) {
            Character array[] = new Character[fileItem.toString().length()];
            for (int i = 0; i < fileItem.toString().length(); i++) {
                array[i] = fileItem.toString().charAt(i);
            }
            Stream.of(array).skip(2).forEach(System.out::print);
            System.out.print("\n");
        }
    }

    public ArrayList createFileList() {
        ArrayList<File> collection = new ArrayList<>();
        String regex = ".+tdoc$";
        for (File fileItem : file.listFiles()) {
            if (fileItem.toString().matches(regex))
                collection.add(fileItem);
        }
        return collection;

    }


    public void create() throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {

        this.file = file;
    }

    public void setRoot() {
        System.out.println("������� ���� � ��������� ��������� ������:");
        Scanner scanner = new Scanner(System.in);
        File dir;
        do {
            dir = new File(scanner.nextLine());
        }
        while (!dir.isDirectory() && !dir.exists());
        file = dir;
    }

    @Override
    public void save() {

        try (FileOutputStream fileOutputStream = new FileOutputStream("textcollection.tcol");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        ) {
            objectOutputStream.writeObject(this);
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }


    @Override
    public TextCollection open() {
        TextCollection textCollection;
        try (FileInputStream fileInputStream = new FileInputStream(new File("textcollection.tcol"));
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
            textCollection = (TextCollection) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException();
        }
        return textCollection;


    }

    @Override
    public void openFileFromCollection(Storage storage) {
        ArrayList<File> fileList = createFileList();
        Menu menu1 = new Menu("����� ���� ��������� ������� :", false);
        for (File x : fileList) {
            menu1.add(x.toString(), () -> {
                TextDoc textDoc = storage.openFile(x);
                textDoc.print(textDoc.getText());
            });
        }
        menu1.add("�����", () -> menu1.setExit(true));
        menu1.run();
    }


    @Override
    public TextDoc openFile(File file) {
        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
            TextDoc textDoc = (TextDoc) objectInputStream.readObject();
            return textDoc;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException();
        }

    }


}
