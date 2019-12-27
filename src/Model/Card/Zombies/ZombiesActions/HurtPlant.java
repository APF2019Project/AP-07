package Model.Card.Zombies.ZombiesActions;

import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Map.Map;
import Model.Map.UnknownCell;

public class HurtPlant extends Action {

    @Override
    public void doAction(Plant plant, Map map) {

    }

    @Override
    public void doZombieAction(Zombie zombie, Map map) {
        while(map.getCell(zombie.getCell().x , zombie.getCell().y -1).getPlant().getHP() > 0)
        {
            map.getCell(zombie.getCell().x , zombie.getCell().y -1).getPlant().setHP(-zombie.getAP());
        }
    }
}
