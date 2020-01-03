package Model.Card.Event;

import Controller.GameMode.Battle;
import Model.Card.Plants.Plant;
import Model.Map.Map;

public class Valid extends Event {
    @Override
    public boolean check(Plant plant, Battle battle, int d) {
        return true;
    }
}
