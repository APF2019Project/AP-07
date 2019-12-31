package Model.Card.Zombies.ZombiesActions;

import Model.Card.Action;
import Model.Card.ActionsOfAnEvent;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

import java.io.IOException;

public class TurnToNormalZombie extends Action {

    @Override
    public void doAction(Plant plant, Map map, int d) {

    }

    @Override
    public void doAction(Zombie zombie, Map map, int d) throws IOException {
        if(!zombie.getName().equals("Zombie"))
        {
            if(zombie.getHP()>0) {
                Zombie.getZombies().remove(zombie);
                //todo
                //this new Zombie should be added to cards and player hand
                Zombie zombie1 = new Zombie("Zombie");
                Zombie.addToZombies(zombie1);
            }
        }
    }
}
