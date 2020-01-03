package Controller.Menus;

import Controller.GameMode.Battle;
import Controller.GameMode.Rail;
import Model.Card.Card;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Map.Map;
import Model.Player.Player;

import java.io.IOException;

public class RailMenu extends Menu {
    public Rail rail;
    public Player player1;
    public Player player2;
    public Battle battle = new Battle(player1, player2);



    public void plant(String name, int x, int y, Rail rail) throws IOException {
        for (Card card : rail.getAvailableCards())
            if (card.getName().equalsIgnoreCase(name)) {
                battle.getMap().getCell(x,y).setPlant(Plant.makePlant(name));
                rail.getAvailableCards().remove(card);
                System.out.println("planted");
                return;
            }
        System.out.println("plant not found");
    }

    public void record(){
        System.out.println("killed zombies: " + rail.getRecord());
    }

    public void endTurn() {
//        for (int i = 2; i < Map.getHEIGHT() + 2; i++)
//            for (int j = 2; j < Map.getWIDTH() + 2; j++) {
//                if (battle.getMap().getCell(i, j).getPlant() != null)
//                    battle.getMap().getCell(i, j).getPlant().act(battle.getMap());
//                if (battle.getMap().getCell(i, j).getZombies().size() !=0)
//                    for (Zombie z : battle.getMap().getCell(i, j).getZombies())
//                        z.act(battle.getMap());
//            }
        for (Plant p : this.player1.getPlants()) {
            if (p.getLoading() != 0) {
                p.setLoading(p.getLoading()-1);
            }
        }
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

    public void remove(int x, int y) {
        Map map = battle.getMap();
        Cell cell = map.getCell(x, y);
        cell.removePlant();
    }
}
