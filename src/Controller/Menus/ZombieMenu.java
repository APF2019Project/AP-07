package Controller.Menus;

import Controller.GameMode.Battle;
import Controller.GameMode.ZombieGameMode;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Map.Map;
import Model.Player.Player;
import Model.Player.Profile;

import java.io.IOException;

public class ZombieMenu extends Menu {

    public ZombieGameMode zombieGameMode = new ZombieGameMode();
    public Player player1;
    public Player player2;
    public Battle battle = new Battle(player1, player2);

    public void showHand(){
        for (Zombie z: player2.getZombies()) {
            System.out.println(z.getName() +"\t" + z.getHP());
        }
    }

    public void showLanes() {
        for (int i=2;i< Map.getHEIGHT()+2;i++){
            String s = Integer.toString(i);
            for (Zombie z:battle.getMap().getCell(i,21).getZombies())
                s = s + "\t"+z.getName();
            System.out.println(s);
            s = null;
        }
    }

    public void putZombie(String name, int x) throws IOException {
        for (Zombie z:player2.getZombies()) {
            if (z.getName().equalsIgnoreCase(name)) {
                battle.getMap().getCell(x,21).addZombie(Zombie.makeZombie(name));
                break;
            }
        }
    }

    public void start(){
        while (true){////ta zamani ke round tamom she
                    for (int i = 2; i < Map.getHEIGHT() + 2; i++)
            for (int j = 2; j < Map.getWIDTH() + 2; j++) {
                if (battle.getMap().getCell(i, j).getPlant() != null)
                    battle.getMap().getCell(i, j).getPlant().act(battle);
                if (battle.getMap().getCell(i, j).getZombies().size() !=0)
                    for (Zombie z : battle.getMap().getCell(i, j).getZombies())
                        z.act(battle);
            }
            for (Plant p : this.player1.getPlants()) {
                if (p.getLoading() != 0) {
                    p.setLoading(p.getLoading()-1);
                }
            }


        }
    }

    public void showLawn(){
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
