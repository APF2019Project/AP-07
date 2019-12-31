package Model.Card.Zombies.ZombiesActions;

import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

public class StealPlant extends Action {
    @Override
    public void doAction(Plant plant, Map map, int d) {

    }

    @Override
    public void doAction(Zombie zombie, Map map, int d) {

        for (int i = 0; i < Map.getWIDTH(); i++) {
            for (int j = 0; j < Map.getHEIGHT(); j++) {
                if (Map.unknownCells[i][j].getPlant() != null) {
                    if (Map.unknownCells[i][j] == zombie.getCell()) {
                            if (Map.unknownCells[i][j].getPlant().getHP() > 0) {
                                if (zombie.getHP() > 0) {
                                    //todo
                                    //what will happen if the plants is stolen
                                    map.getCell(zombie.getCell().x, zombie.getCell().y ).setPlant(null);
                                    zombie.getStolenPlants().add(Map.unknownCells[i][j].getPlant());
                                }
                            }
                        }
                    }
                }
            }

    }
}
