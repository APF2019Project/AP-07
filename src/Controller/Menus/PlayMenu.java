package Controller.Menus;

import Controller.GameMode.Battle;
import Controller.GameMode.Day;
import Controller.GameMode.GameMode;
import Model.Card.Plants.Plant;
import Model.Player.Player;

public class PlayMenu extends Menu {
    public PlayMenu(){
        this.orders = new String[]{"Day", "Water", "Rail", "Zombie", "PvP"};
    }
    public void startDayGame(Player player1, Player player2) {
        Battle battle = new Battle(player1,player2);
        Day dayMode = new Day();
    }
}
