import java.io.IOException;

public class MenuPunkt {
    private final String name;
    private final MenuAction menuAction;

    public MenuPunkt(String name, MenuAction menuAction) {
        this.name = name;
        this.menuAction = menuAction;
    }

    public String getName() {
        return name;
    }


    @FunctionalInterface
    public interface MenuAction {
        void actionRun() throws IOException;
    }

    public MenuAction getMenuAction() {
        return menuAction;
    }
}
