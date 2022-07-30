import java.util.ArrayList;
import java.util.List;

public class Menu {
    String name;
    List<MenuPunkt> menuList = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }

    public void add(String name, MenuPunkt.MenuAction menuAction) {

        menuList.add(new MenuPunkt(name, menuAction));
    }

    public void printMenu() {
        System.out.println(name);
        for (int i = 0; i < menuList.size(); i++) {
            System.out.print((i + 1) + "." + menuList.get(i).getName() + "\n");
        }
    }
}
