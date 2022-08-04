import java.io.IOException;

public class MenuPunkt {
    private String name;
    private MenuAction menuAction;

    public MenuPunkt(String name, MenuAction menuAction) {
        this.name = name;
        this.menuAction = menuAction;
    }

    public String getName() {
        return name;
    }


    @FunctionalInterface
    public interface MenuAction {
        public void actionRun() throws IOException;
    }

    public MenuAction getMenuAction() {
        return menuAction;
    }
}
