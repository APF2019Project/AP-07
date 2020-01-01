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
        for (int i = 0; i < Map.getWIDTH(); i++) {
            for (int j = 0; j < Map.getHEIGHT(); j++) {
                if (map.unknownCells[i][j].getPlant() != null) {
                    if (map.unknownCells[i][j] == zombie.getCell()) {
                        if (!zombie.getName().equals("Giga-gargantuar")) {
                            if (map.unknownCells[i][j].getPlant() .getHP() > 0) {
                                if (zombie.getHP() > 0) {
                                    map.unknownCells[i][j].getPlant().setHP(-zombie.getAP());
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
