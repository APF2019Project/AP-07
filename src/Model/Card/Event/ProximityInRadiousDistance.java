package Model.Card.Event;

import Model.Card.Plants.Plant;
import Model.Map.Map;

import static java.lang.Math.abs;

public class ProximityInRadiousDistance extends Event {
    @Override
    public boolean check(Plant plant, Map map, int d) {
        //if (d == 8) {
        for (int i = 0; i < map.getUnknownCells().length; i++) {
            for (int j = 0; j < map.getUnknownCells()[i].length; j++) {
                if (!map.getUnknownCells()[i][j].getZombies().isEmpty()) {
                    if (abs(map.getUnknownCells()[i][j].x - plant.getCell().x) <= 1) {
                        if (abs(map.getUnknownCells()[i][j].x - plant.getCell().x) <= 1) {
                            if (abs(map.getUnknownCells()[i][j].y - plant.getCell().y) <= 1) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        // }
        return false;
    }
}
