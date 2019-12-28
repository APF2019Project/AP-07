package Model.Card.Zombies.ZombiesActions;

import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

public class HurtPlantsOnTheWay extends Action {


    @Override
    public void doAction(Plant plant, Map map, int d) {

    }

    @Override
    public void doAction(Zombie zombie, Map map, int d) {
        while(map.getCell(zombie.getCell().x , zombie.getCell().y -1).getPlant().getHP() > 0)
        {
            map.getCell(zombie.getCell().x , zombie.getCell().y -1).getPlant().setHP(-zombie.getAP());
        }
    }
}
