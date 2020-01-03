package Controller.Menus;

import Controller.GameMode.Battle;
import Controller.GameMode.Water;
import Controller.Menus.Menu;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Map.Map;
import Model.Player.Player;
import Model.Player.Profile;

import java.io.IOException;

public class WaterModeMenu extends Menu {
    public Water waterMode = new Water();
    public Player player1;
    public Player player2;
    public Battle battle = new Battle(player1, player2);


    public void showHand() {
        for (Plant x : player1.getPlants()) {
            System.out.println(x.getName() + "\t" + x.getSun() + "\t" + x.getCooldown());
        }
    }

    public void remove(int x, int y) {
        Map map = battle.getMap();
        Cell cell = map.getCell(x, y);
        cell.removePlant();
    }

    public void plant(String name, int x, int y) throws IOException {
        if (battle.getMap().getCell(x,y).canBePlanted()) {
            for (Plant p:player1.getPlants()){
                if (p.getName().equalsIgnoreCase(name)){
                    if (p.getLoading() == 0) {
                        battle.getMap().getCell(x,y).setPlant(Plant.makePlant(name));
                        p.setLoading(p.getCooldown());
                        System.out.println("plant planted:)");

                    }
                    else {
                        System.out.println("plant is not ready");
                    }

                    break;
                }
            }
        }
        else if (name.equalsIgnoreCase("lilypad"))
            battle.getMap().getCell(x,y).setLilyPad();
    }

    public void showLawn() {
        for (Cell[] cells : battle.getMap().getCells()) {
            for (Cell cell : cells) {
                if (cell.getZombies().size() != 0) {
                    for (Zombie z : cell.getZombies()) {
                        System.out.println(z.getName() + "\t" + cell.x() + "," + cell.y() + "\t" + z.getHP());
                    }
                }
                if (cell.getPlant() != null) {
                    Plant z = cell.getPlant();
                    System.out.println(z.getName() + "\t" + cell.x() + "," + cell.y() + "\t" + z.getHP());
                }
            }
        }
    }

}
