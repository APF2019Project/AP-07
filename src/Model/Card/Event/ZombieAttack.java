package Model.Card.Event;

import Model.Card.Plants.Plant;
import Model.Map.Map;

public class ZombieAttack extends Event {
    @Override
    public boolean check(Plant plant, Map map, int d) {
        return false;
    }
}
