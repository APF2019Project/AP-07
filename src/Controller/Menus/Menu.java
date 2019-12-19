package Controller.Menus;

import java.util.ArrayList;

public class Menu {
    //ba profile mizanim
    public static LoginMenu loginMenu = new LoginMenu();
    public static CollectionMenu collectionMenu = new CollectionMenu();
    public static GameMenu gameMenu = new GameMenu();
    public static LeaderBoard leaderBoard = new LeaderBoard();
    public static MainMenu mainMenu = new MainMenu();
    public static ProfileMenu profileMenu = new ProfileMenu();
    public static ShopMenu shopMenu = new ShopMenu();
    public static MenuHandler menuHandler = new MenuHandler();
    Menu parentMenu = null;
    Menu currentMenu = null;
    ArrayList<String> orders = new ArrayList<>();

    public void help() {
        for (String x : menuHandler.getCurrentMenu().orders) {
            System.out.println(x);
        }
    }

    public static void init() {
        menuHandler.setCurrentMenu(loginMenu);
    }
}