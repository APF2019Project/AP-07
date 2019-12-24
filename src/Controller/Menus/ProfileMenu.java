package Controller.Menus;

public class ProfileMenu extends Menu {
    public ProfileMenu() {
        this.orders = new String[] {"Change", "Delete", "Rename", "Create", "Help", "Exit"};
    }

    public void exit() {
        Menu.menuHandler.setCurrentMenu(Menu.mainMenu);
    }
}