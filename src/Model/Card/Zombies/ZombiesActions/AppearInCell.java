package Model.Card.Zombies.ZombiesActions;

import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

import java.util.Random;

public class AppearInCell extends Action {
    @Override
    public void doAction(Plant plant, Map map, int d) {

    }

    @Override
    public void doAction(Zombie zombie, Map map, int d) {
        Random random = new Random();
        int x = 5;
        int y = 18;
        while(map.getCell(x , y).plant == null)
        {
            x = random.nextInt(5);
            y = random.nextInt(18);
        }
        map.getCell(x,y).zombies.add(zombie);
        if (zombie.getHP() > 0) {
            map.getCell(x , y).plant = null;
            map.getCell(x , y).zombies.remove(zombie);
        }
    }
}
