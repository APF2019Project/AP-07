package Controller.Menus;

import Controller.GameMode.*;
import Model.Card.Zombies.Zombie;
import Model.Player.Player;
import Model.Player.Profile;
import com.gilecode.yagson.YaGson;

import java.util.ArrayList;

public class PlayMenu extends Menu {
    public PlayMenu() {
        this.orders = new String[]{"Day", "Water", "Rail", "ZombieGameMode", "PvP"};
    }

    public void startDayGame(Player player1, Player player2) {
        Day day=new Day();
        Battle battle = new Battle(player1, player2,day);
        Menu.menuHandler.setCurrentMenu(Menu.collectionMenu);
    }

    public void startWaterGame(Player player1, Player player2) {
        Water water=new Water();
        Battle battle = new Battle(player1, player2,water);
        Menu.menuHandler.setCurrentMenu(Menu.collectionMenu);
    }

    public void startRailGame(Player player1, Player player2) {
        Rail rail = new Rail();
        Battle battle = new Battle(player1, player2,rail);
        Menu.menuHandler.setCurrentMenu(Menu.railMenu);
        Menu.railMenu.player1 = player1;
        Menu.railMenu.player2 = player2;
        Menu.railMenu.rail = rail;
        Menu.railMenu.battle = battle;
    }

    public void startZombieGame(Player player1, Player player2) {
        ZombieGameMode zombieGameMode=new ZombieGameMode();
        Battle battle = new Battle(player1, player2,zombieGameMode);
        Menu.menuHandler.setCurrentMenu(Menu.collectionMenu);
    }

    public void exit() {
        Menu.menuHandler.setCurrentMenu(Menu.mainMenu);
    }
}
