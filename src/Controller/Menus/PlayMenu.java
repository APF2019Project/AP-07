package Controller.Menus;

import Controller.GameMode.Battle;
import Model.Player.Player;

public class PlayMenu extends Menu {
    public PlayMenu(){
        this.orders = new String[]{"Day", "Water", "Rail", "Zombie", "PvP"};
    }
    public void startDayGame(Player player1, Player player2) {
        Battle battle = new Battle(player1,player2);
        Menu.menuHandler.setCurrentMenu(Menu.collectionMenu);
    }

    public void startWaterGame(Player player1, Player player2) {
        Battle battle = new Battle(player1,player2);
        Menu.menuHandler.setCurrentMenu(Menu.collectionMenu);
    }

    public void startRailGame(Player player1, Player player2) {
        Battle battle = new Battle(player1,player2);
        Menu.menuHandler.setCurrentMenu(Menu.playMenu);
    }

    public void startZombieGame(Player player1, Player player2) {
        Battle battle = new Battle(player1,player2);
        Menu.menuHandler.setCurrentMenu(Menu.collectionMenu);
    }


}
