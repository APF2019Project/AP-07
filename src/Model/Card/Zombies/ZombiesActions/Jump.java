package Model.Card.Zombies.ZombiesActions;

import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

public class Jump extends Action {

    @Override
    public void doAction(Plant plant, Map map, int d) {

    }

    @Override
    public void doAction(Zombie zombie, Map map, int d) {
        if(map.getCell(zombie.getCell().x , zombie.getCell().y -1).getPlant() != null)
        {
            zombie.setCell(map.getCell(zombie.getCell().x , zombie.getCell().y -2));
            map.getCell(zombie.getCell().x , zombie.getCell().y -2).zombies.add(zombie);
        }
    }
}
