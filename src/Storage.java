import java.io.IOException;

public interface Storage {
    public void add();

    public void remove();

    public void view();

    public void create() throws IOException;

    public void setRoot();

    public void save();

    public void open();
}
