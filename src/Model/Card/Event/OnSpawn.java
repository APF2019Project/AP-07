package Model.Card.Event;

import Model.Card.Plants.Plant;
import Model.Map.Map;

//for checking that if the thing is in the map or not
public class OnSpawn extends Event {
    @Override
    public boolean check(Plant plant, Map map, int d) {
        for (int i = 0; i < map.getUnknownCells().length; i++) {
            if (map.getCell(plant.getCell().x, plant.getCell().y).x == plant.getCell().x &&
                    map.getCell(plant.getCell().x, plant.getCell().y).y == plant.getCell().y) {
                if (map.getCell(plant.getCell().x, plant.getCell().y).getZombies().size() > 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
