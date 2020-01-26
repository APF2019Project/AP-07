package Model.Card.Plants.PlantsActions;

import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;

import java.io.IOException;

public class KillNearest extends Action {

    @Override
    public void doAction(Plant plant, Battle battle, int d) {
        double MinRad = 100;
        Cell nearestCell=null;
        int X = 0;
        int Y = 19;
        if (plant.getHP() > 0) {
            for (Cell[] i : battle.getMap().getCells()) {
                for (Cell cell : i) {
                    if (!cell.getZombies().isEmpty()) {
                        if (calculateDistance(plant.getCell(), cell) < MinRad) {
                            X = cell.x();
                            Y = cell.y();
                            MinRad = calculateDistance(plant.getCell(), cell);
                            nearestCell=cell;
                        }
                    }
                }
            }
        }
        nearestCell.getZombies().get(0).setHealthPoint(0);
    }

    @Override
    public void doAction(Zombie zombie, Battle battle, int d) throws IOException {

    }

    public double calculateDistance(Cell cell, Cell cell1) {
        return  Math.sqrt(((cell.y() - cell1.y()) * (cell.x() - cell1.x())) +
                ((cell.y() - cell1.y()) * (cell.x() - cell1.x())));
    }

}
