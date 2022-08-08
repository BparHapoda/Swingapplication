import java.io.File;
import java.io.IOException;

public interface Storage {
    public void add();

    public void remove();

    public void view();

    public void create() throws IOException;

    public void setRoot();

    public void save();

    public Storage open();

    public void openFileFromCollection(Storage storage);


    public TextDoc openFile(File file);


}
