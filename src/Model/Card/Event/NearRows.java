package Model.Card.Event;

import Model.Card.Plants.Plant;
import Model.Map.Map;

import static java.lang.StrictMath.abs;

public class NearRows extends Event {
    @Override
    public boolean check(Plant plant, Map map, int d) {
        for (int i = 0; i < map.getUnknownCells().length; i++) {
            if (map.getCell(plant.getCell().x, plant.getCell().y).x == plant.getCell().x) {
                if (abs(map.getCell(plant.getCell().x, plant.getCell().y).y - plant.getCell().y) <= d) {
                    if (!map.getCell(plant.getCell().x, plant.getCell().y).getZombies().isEmpty()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

