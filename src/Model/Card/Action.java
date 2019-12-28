package Model.Card;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

public abstract class Action {

    //PlantsActions
    public abstract void doAction(Plant plant, Map map, int d);
    //ZombiesActions
    public abstract void doAction(Zombie zombie, Map map, int d);
}
