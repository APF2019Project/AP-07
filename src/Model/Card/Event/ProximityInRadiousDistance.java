package Model.Card.Event;

import Model.Card.Plants.Plant;
import Model.Map.Map;

public class ProximityInRadiousDistance extends Event {
    @Override
    public boolean check(Plant plant, Map map, int d) {
        if(map.getCell(plant.getCell().x , plant.getCell().y).getZombies().size() > 0)
        {
            return true;
        }
        return false;
    }
}
