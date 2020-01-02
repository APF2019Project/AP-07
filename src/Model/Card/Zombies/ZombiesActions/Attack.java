package Model.Card.Zombies.ZombiesActions;

import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

//hamleye addi
public class Attack extends Action {
    @Override
    public void doAction(Plant plant, Map map, int d) {

    }

    @Override
    public void doAction(Zombie zombie, Map map, int d) {
        for (int i = 0; i < Map.getHEIGHT(); i++) {
            for (int j = 0; j < Map.getWIDTH(); j++) {
                if (map.cells[i][j].getPlant() != null) {
                    if (i == zombie.getCell().x && j == zombie.getCell().y -1) {
                        if (!zombie.getName().equals("Giga-gargantuar")) {
                            if (map.cells[i][j].getPlant() .getHP() > 0) {
                                if (zombie.getHP() > 0) {
                                    map.cells[i][j].getPlant().setHP(-zombie.getAP());
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
