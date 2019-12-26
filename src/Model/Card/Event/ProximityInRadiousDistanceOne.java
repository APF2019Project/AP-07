package Model.Card.Event;

import Model.Card.Plants.Plant;
import Model.Map.Map;

public class ProximityInRadiousDistanceOne extends Event {
    @Override
    public boolean check(Plant plant, Map map, int d) {
        if(map.getCell(plant.getCell().x , plant.getCell().y).zombies.size() > 0)
        {
            return true;
        }
        return false;
    }
}
