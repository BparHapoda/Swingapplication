import java.io.File;
import java.io.IOException;

public class TextCollect implements Storage {
    String name;
    File file;

    public TextCollect(String name, File file) {
        this.name = name;
        this.file = file;
    }

    @Override
    public void add() {
        TextDoc.createTextDoc();
    }

    @Override
    public void remove() {

    }

    public void view() {
        File file = new File("c:");

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
}
