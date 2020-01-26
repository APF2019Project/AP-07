package Controller.Menus;

import Controller.GameMode.Battle;
import Controller.GameMode.Day;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Map.Map;
import Model.Player.Player;
import Model.Player.Profile;
import com.oracle.tools.packager.Platform;

import java.io.IOException;

public class GameMenu extends Menu {
    public Day day = new Day();
    public Player player1;
    public Player player2;
    public Battle battle = new Battle(player1, player2,day);



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
        Plant p1 =Plant.makePlant(name);
        if (battle.getMap().getCell(x, y).canBePlanted()) {
            for (Plant p : player1.getPlants()) {
                if (p.getName().equalsIgnoreCase(name)) {
                    if (p.getLoading() == 0 && p.getSun() <= player1.getSun()) {
                        battle.getMap().getCell(x, y).setPlant(p1);
                        p1.setCell(battle.getMap().getCell(x, y));
                        p.setLoading(p.getCooldown());
                        System.out.println("plant planted:)");
                        player1.setSun(player1.getSun()-p.getSun());

                    } else {
                        System.out.println("plant is not ready");
                    }

                    break;
                }
            }
        }
    }

    public void endTurn(Profile profile) throws IOException {
        day.wave(battle);
//        if (battle.getGameMode() instanceof Day) {
//            Day day = (Day) battle.getGameMode();
              day.setLastTurnGivingSuns(1);
//        }
//        else if (battle.getGameMode() instanceof Water) {
//            Water water = (Water) battle.getGameMode();
//            water.setLastTurnGivingSuns(1);
//        }
//        else if (battle.getGameMode() instanceof Rail) {
//            Rail rail = (Rail) battle.getGameMode();
//            rail.setLastTurnUpdatingRailCollection(1);
//        }
        
        battle.actAllMembers();
        day.generateSun(battle);
//        day.handleWin(profile,battle );
//        day.setLastTurnWaved(1);
//        day.updateCollection();
        battle.setCurrentTurn(1);
//        for (Plant p:player1.getPlants()) {
//            if (p.getLoading()!=0) {
//                p.setLoading(p.getLoading()-1);
//            }
//        }
////        System.out.println(player1.getSun());
        System.out.println(battle.getCurrentTurn());
    }


    public void showLawn() {
        for (Cell[] cells : battle.getMap().getCells()) {
            for (Cell cell : cells) {
                if (cell.getZombies().size() != 0) {
                    for (Zombie z : cell.getZombies()) {
                        System.out.println(z.getName() + "\t" + cell.x() + "," + cell.y() + "\t" + z.getHP()+ z.showIronHat());
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
