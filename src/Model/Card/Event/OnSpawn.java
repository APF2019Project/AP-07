package Model.Card.Event;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;
import java.util.ArrayList;

//for checking that if the thing is in the map or not
public class OnSpawn extends Event{
    public void spawn(ArrayList<Zombie> zombies, Plant plant) {

    }

    @Override
    public boolean check(Plant plant, Map map) {
        return false;
    }
}
