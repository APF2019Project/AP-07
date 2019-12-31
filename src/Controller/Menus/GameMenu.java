package Controller.Menus;

import Controller.GameMode.*;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Player.Player;

public class GameMenu extends Menu {
    public Day day;
    public Water water;
    public Rail rail;
    public ZombieGameMode zombieMode;
    public Player player1;
    public Player player2;
    public Battle battle;


    public void showHand() {
        for (Plant x : player1.getPlants()) {
            System.out.println(x.getName() + "\t" + x.getSun() + "\t" + x.getCooldown());
        }

    }
}
