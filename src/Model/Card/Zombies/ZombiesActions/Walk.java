package Model.Card.Zombies.ZombiesActions;

import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

public class Walk extends Action {


    @Override
    public void doAction(Plant plant, Map map, int d) {

    }

    @Override
    public void doAction(Zombie zombie, Map map, int d) {
        if (zombie.getCell().x < Map.getHEIGHT() && zombie.getCell().y < Map.getWIDTH()) {
            if (map.getCell(zombie.getCell().x , zombie.getCell().y - zombie.getSpeed()).plant == null) {
                if (zombie.getHP() > 0) {
                    zombie.setCell(map.getCell(zombie.getCell().x + zombie.getSpeed(), zombie.getCell().y));
                    map.getCell(zombie.getCell().x, zombie.getCell().y).getZombies().add(zombie);
                    map.getCell(zombie.getCell().x, zombie.getCell().y + 1).getZombies().remove(zombie);
                }
            }
        }
    }
}
