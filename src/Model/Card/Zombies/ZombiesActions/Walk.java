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
        //todo
        //maybe bazi jaha motefavet gereftim x o y ha ro va +- ha shoono
        if (zombie.getCell().x < Map.getWIDTH() && zombie.getCell().y < Map.getHEIGHT()) {
            if (map.getCell(zombie.getCell().x + zombie.getSpeed(), zombie.getCell().y) != null) {
                zombie.setCell(map.getCell(zombie.getCell().x + zombie.getSpeed(), zombie.getCell().y));
                map.getCell(zombie.getCell().x, zombie.getCell().y).getZombies().add(zombie);
                map.getCell(zombie.getCell().x, zombie.getCell().y + 1).getZombies().remove(zombie);
            }
        }
    }
}
