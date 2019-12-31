package Controller.Menus;

import Model.Card.Plants.PlantsActions.PlantsAction;
import Model.Card.Zombies.ZombiesActions.ZombiesAction;

import java.io.IOException;

public class Menu {
    public static LoginMenu loginMenu = new LoginMenu();
    public static CollectionMenu collectionMenu = new CollectionMenu();
    public static PlayMenu playMenu = new PlayMenu();
    public static LeaderBoard leaderBoard = new LeaderBoard();
    public static MainMenu mainMenu = new MainMenu();
    public static ProfileMenu profileMenu = new ProfileMenu();
    public static ShopMenu shopMenu = new ShopMenu();
    public static MenuHandler menuHandler = new MenuHandler();
    public static GameMenu gameMenu = new GameMenu();

    public String[] getOrders() {
        return orders;
    }

    protected String[] orders;
    public static void help() {
        for (String x : menuHandler.getCurrentMenu().getOrders()) {
            System.out.println(x);
        }
    }

    public static void init() throws IOException {
        menuHandler.setCurrentMenu(loginMenu);
        PlantsAction.setPlantsActions();
        ZombiesAction.setZombiesActions();
    }
}