package Model.Card.Zombies.ZombiesActions;

import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;
import Model.Map.UnknownCell;

public class Walk extends Action {

    @Override
    public void doAction(Plant plant, Map map) {

    }

    @Override
    public void doZombieAction(Zombie zombie, Map map) {
        zombie.setCell(map.getCell(zombie.getCell().x , zombie.getCell().y -1));
        map.getCell(zombie.getCell().x , zombie.getCell().y).zombies.add(zombie);
    }
}
