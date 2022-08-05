import java.io.*;
import java.util.Scanner;

public class TextCollection implements Storage {
    String name;
    File file;

    public TextCollection(String name, File file) {
        this.name = name;
        this.file = file;
    }

    @Override
    public void add() {
        TextDoc textDoc = new TextDoc();
        System.out.println("¬ведите автора :");
        textDoc.setAuthor(textDoc.inputString());
        System.out.println("¬ведите текст  :");
        textDoc.setText(textDoc.inputText().toCharArray());
        System.out.println("¬ведите название файла  :");
        StringBuilder fileName = new StringBuilder(file.toString());
        fileName.append(textDoc.inputString());
        fileName.append(".tdoc");
        try {
            FileOutputStream fos = new FileOutputStream(fileName.toString());
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(textDoc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void remove() {

    }

    public void view() {
        for (File fileItem : file.listFiles()) {
            System.out.println(fileItem);
        }


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
        System.out.println("¬ведите путь к коллекции текстовых файлов:");
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

    }

    @Override
    public void open() {

    }
}
