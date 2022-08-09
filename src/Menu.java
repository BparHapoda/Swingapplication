
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final String name;
    private boolean exit;
    private final List<MenuPunkt> menuList = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }

    public void add(String name, MenuPunkt.MenuAction menuAction) {

        menuList.add(new MenuPunkt(name, menuAction));
    }



    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public void printMenu() {
        System.out.println(name);
        for (int i = 0; i < menuList.size(); i++) {
            System.out.print((i + 1) + "." + menuList.get(i).getName() + "\n");
        }
    }

    public Integer inputNumber() {
        int number = 0;
        Scanner scanner = new Scanner(System.in);

        try {

            number = scanner.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("¬ведите номер пункта меню");
        }

            return number;

    }

    public Integer inputMenuNumber() {
        Integer number;
        do {
            number = inputNumber();
        }
        while (number < 1 || number > menuList.size());
        return number - 1;
    }

    public void run() {

        while (!exit) {
            printMenu();
            menuList.get(inputMenuNumber()).getMenuAction().actionRun();
        }
    }
}
