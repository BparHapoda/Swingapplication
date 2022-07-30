public class MenuPunkt {
    String name;
    MenuAction menuAction;

    public MenuPunkt(String name, MenuAction menuAction) {
        this.name = name;
        this.menuAction = menuAction;
    }

    public String getName() {
        return name;
    }


    public interface MenuAction {
        public void actionRun();
    }
}
