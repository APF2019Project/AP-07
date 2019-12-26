package Model.Card;

import Model.Card.Plants.Plant;
import Model.Map.Map;

public abstract class Action {

    public abstract void doAction(Plant plant, Map map, int d);

}
