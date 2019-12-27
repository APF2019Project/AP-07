package Model.Card;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

public abstract class Action {

    public abstract void doAction(Plant plant,Map map);
    public abstract void doZombieAction(Zombie zombie , Map map);
}
