package Model.Card.Plants.PlantsActions;

import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Map.Map;

import java.io.IOException;

public class Burst extends Action {
    @Override
    public void doAction(Plant plant, Battle battle, int d) {

        Cell cell = plant.getCell();
        int x = cell.x();
        int y = cell.y();

        if (plant.getName().equalsIgnoreCase("Jalapeno")) {
            for (int i = 0; i < Map.getWIDTH() + 4; i++) {
                for (Zombie z : battle.getMap().getCell(x, i).getZombies()) {
                    z.setHealthPoint(0);
                }
            }
            plant.setHealthPoint(0);
        }

        if (plant.getName().equalsIgnoreCase("CherryBomb")) {

            for (Zombie z : battle.getMap().getCell(x - 1, y).getZombies()) {
                z.setHealthPoint(0);
            }
            for (Zombie z : battle.getMap().getCell(x + 1, y).getZombies()) {
                z.setHealthPoint(0);
            }
            for (Zombie z : battle.getMap().getCell(x - 1, y + 1).getZombies()) {
                z.setHealthPoint(0);
            }
            for (Zombie z : battle.getMap().getCell(x, y + 1).getZombies()) {
                z.setHealthPoint(0);
            }
            for (Zombie z : battle.getMap().getCell(x + 1, y + 1).getZombies()) {
                z.setHealthPoint(0);
            }
            for (Zombie z : battle.getMap().getCell(x - 1, y - 1).getZombies()) {
                z.setHealthPoint(0);
            }
            for (Zombie z : battle.getMap().getCell(x, y - 1).getZombies()) {
                z.setHealthPoint(0);
            }
            for (Zombie z : battle.getMap().getCell(x + 1, y - 1).getZombies()) {
                z.setHealthPoint(0);
            }
            plant.setHealthPoint(0);
        }
    }

    @Override
    public void doAction(Zombie zombie, Battle battle, int d) throws IOException {

    }

}
