package Controller.Menus;

import Model.Player.Player;

public class GameMenu extends Menu {
    private static GameMenu ourInstance = new GameMenu();

    public static GameMenu getInstance() {
        return ourInstance;
    }

    private GameMenu() {
    }

    @Override
    public void init() {
        /*acc1 acc2*/
        //2 ta player az ruye account 1 o 2 besaz
        //makePlayer
    }

    public void makePlayer(Player first, Player second){

    }
}
