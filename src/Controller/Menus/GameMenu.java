package Controller.Menus;

import Controller.GameMode.*;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;
import Model.Map.UnknownCell;
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
        for (Zombie x : player1.getZombies()) {
            System.out.println(x.getName() + "\t" + x.getHP());
        }
    }

    public void remove(int x, int y) {
        Map map = battle.getMap();
        UnknownCell cell = map.getCell(x, y);
        cell.removePlant();
    }

    public void endTurn() {
        for (int i=2;i<Map.getHEIGHT()+2;i++)
            for (int j=2;j<Map.getWIDTH()+2;j++) {
                battle.getMap().getCell(i,j).getPlant().act(battle.getMap());
                for (Zombie z:battle.getMap().getCell(i,j).getZombies())
                    z.act(battle.getMap());
            }

    }

    public void showLawn() {
        for (UnknownCell[] cells : battle.getMap().getUnknownCells()) {
            for (UnknownCell cell : cells) {
                for (Zombie z : cell.getZombies()) {
                    System.out.println(z.getName() + "\t" + cell.x + "," + cell.y + "\t" + z.getHP());
                }
                if (cell.getPlant() != null) {
                    Plant z = cell.getPlant();
                    System.out.println(z.getName() + "\t" + cell.x + "," + cell.y + "\t" + z.getHP());
                }
            }
        }
    }
}
