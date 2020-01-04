package Model.Card;

import Controller.GameMode.Battle;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

import java.io.IOException;

public class Action {

    //PlantsActions
    public void doAction(Plant plant, Battle battle, int d){}
    public  void doAction(Zombie zombie, Battle battle, int d) throws IOException{}
}
