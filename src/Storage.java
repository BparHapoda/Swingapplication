import java.io.File;


public interface Storage {
     void add();


    void view();


    void setRoot();

    void save();

    Storage open();

    void openFileFromCollection(Storage storage);


    TextDoc openFile(File file);


}
