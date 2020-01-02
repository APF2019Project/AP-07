package Model.Card.Zombies.ZombiesActions;

import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.*;

public class StealPlant extends Action {
    @Override
    public void doAction(Plant plant, Map map, int d) {

    }

    @Override
    public void doAction(Zombie zombie, Map map, int d) {

        for (Cell[] i : map.getCells()) {
            for (Cell j : i) {
                if (j.getPlant() != null) {
                    if (j == zombie.getCell()) {
                            if (j.getPlant().getHP() > 0) {
                                if (zombie.getHP() > 0) {
                                    map.getCell(zombie.getCell().x, zombie.getCell().y ).setPlant(null);
                                    zombie.getStolenPlants().add(j.getPlant());
                                }
                            }
                        }
                    }
                }
            }

    }
}
