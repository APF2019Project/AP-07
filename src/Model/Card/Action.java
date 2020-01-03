package Model.Card;

import Controller.GameMode.Battle;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

import java.io.IOException;

public abstract class Action {

    //PlantsActions
    public abstract void doAction(Plant plant, Battle battle, int d);
    //ZombiesActions
    public abstract void doAction(Zombie zombie, Battle battle, int d) throws IOException;
}
