package Model.Card.Plants.PlantsActions;

import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

public class Burst extends Action {
    @Override
    public void doAction(Plant plant, Map map, int d) {
        for (int i = 0; i < map.getUnknownCells().length; i++) {
            if (map.getCell(plant.getCell().x, plant.getCell().y).x == plant.getCell().x) {
                if (map.getCell(plant.getCell().x, plant.getCell().y).zombies.size() > 0) {
                    Zombie zombie1 = map.getCell(plant.getCell().x, plant.getCell().y).zombies.get(0);
                    //1 deletion in loop in ok
                    map.getCell(plant.getCell().x, plant.getCell().y).zombies.remove(zombie1);
                }
            }
        }
    }

    @Override
    public void doAction(Zombie zombie, Map map, int d) {

    }
}
