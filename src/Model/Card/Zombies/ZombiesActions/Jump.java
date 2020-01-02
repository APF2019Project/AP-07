package Model.Card.Zombies.ZombiesActions;

import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;
import Model.Map.Cell;

public class Jump extends Action {

    @Override
    public void doAction(Plant plant, Map map, int d) {

    }

    @Override
    public void doAction(Zombie zombie, Map map, int d) {
        int x = zombie.getCell().x;
        int y = zombie.getCell().y;
        if (map.getCell(x , y-1).getPlant() != null) {
            if (zombie.getHP() > 0) {
                Cell cell = new Cell();
                map.getCell(zombie.getCell().x, zombie.getCell().y ).zombies.remove(zombie);
                zombie.setCell(map.getCell(x , y -2));
                map.getCell(zombie.getCell().x, zombie.getCell().y).zombies.add(zombie);
            }
        }
    }
}
