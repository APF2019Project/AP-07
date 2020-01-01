package Model.Card.Zombies.ZombiesActions;

import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

public class ShieldDefend extends Action {


    @Override
    public void doAction(Plant plant, Map map, int d) {

    }

    @Override
    public void doAction(Zombie zombie, Map map, int d) {
        if (zombie.getArmour() > 0 && zombie.getHP()>0) {
            for (int i = 0; i < map.cells.length; i++) {
                for (int j = 0; j < map.cells[i].length; j++) {
                    if (map.cells[i][j].getPlant() != null) {
                        if (!map.cells[i][j].getPlant().getPeaOrProjectile().isProjectile()) {
                            if (zombie.getArmour() > 0) {
                                zombie.setArmour(-1);
                            }
                        }
                        if (map.cells[i][j].getPlant().getPeaOrProjectile().isProjectile()) {
                            zombie.setHP(map.cells[i][j].getPlant().getAP());
                        }
                    }
                }
            }
        }

    }
}
