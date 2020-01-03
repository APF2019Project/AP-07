package Model.Card.Zombies.ZombiesActions;

import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

public class Walk extends Action {


    @Override
    public void doAction(Plant plant, Battle battle, int d) {

    }

    @Override
    public void doAction(Zombie zombie, Battle battle, int d) {
        if (zombie.getCell().x < Map.getHEIGHT() && zombie.getCell().y < Map.getWIDTH()) {
            if (battle.getMap().getCell(zombie.getCell().x , zombie.getCell().y - zombie.getSpeed()).plant == null) {
                if (zombie.getHP() > 0) {
                    zombie.setCell(battle.getMap().getCell(zombie.getCell().x + zombie.getSpeed(), zombie.getCell().y));
                    battle.getMap().getCell(zombie.getCell().x, zombie.getCell().y).getZombies().add(zombie);
                    battle.getMap().getCell(zombie.getCell().x, zombie.getCell().y + 1).getZombies().remove(zombie);
                }
            }
        }
    }
}
