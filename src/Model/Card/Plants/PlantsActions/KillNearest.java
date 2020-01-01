package Model.Card.Plants.PlantsActions;

import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;
import Model.Map.Cell;

public class KillNearest extends Action {
    public int calculateDistance(Cell p, Cell z) {
        return (int) Math.sqrt(((p.x - z.x) * (p.x - z.x)) + ((p.y - z.y) * (p.y - z.y)));
    }

    @Override
    public void doAction(Plant plant, Map map, int d) {
        int MinRad = 19;
        int X = 0;
        int Y = 19;
        if(plant.getHP()>0) {
            for (Cell[] i : map.getCells()) {
                for (Cell j : i) {
                    if (j.getZombies().size() > 0) {
                        if (calculateDistance(plant.getCell(), j) < MinRad) {
                            X = j.x;
                            Y = j.y;
                            MinRad = calculateDistance(plant.getCell(), j);
                        }
                    }
                }
            }
        }
        //todo
        map.getCell(plant.getCell().x, plant.getCell().y).getZombies().remove(map.getCell(X,Y));
        map.getCell(X, Y).getZombies().set(0, null);
    }

    @Override
    public void doAction(Zombie zombie, Map map, int d) {

    }

}
