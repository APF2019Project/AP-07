package Model.Card.Zombies.ZombiesActions;

import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;
import Model.Map.Cell;

public class Jump extends Action {

    @Override
    public void doAction(Plant plant, Battle battle, int d) {

    }

    @Override
    public void doAction(Zombie zombie, Battle battle, int d) {
        int x = zombie.getCell().x;
        int y = zombie.getCell().y;
        if (battle.getMap().getCell(x , y-1).getPlant() != null) {
            if (zombie.getHP() > 0) {

                battle.getMap().getCell(zombie.getCell().x, zombie.getCell().y ).zombies.remove(zombie);
                zombie.setCell(battle.getMap().getCell(x , y -2));
                battle.getMap().getCell(zombie.getCell().x, zombie.getCell().y).zombies.add(zombie);
            }
        }
    }
}
