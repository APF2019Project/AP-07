package Model.Card.Plants.PlantsActions;

import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

public class Burst extends Action {
    @Override
    public void doAction(Plant plant, Map map, int d) {
        if(plant.getHP()>0) {
            for (int i = 0; i < map.getCells().length; i++) {
                for (int j = 0; j<map.getCells()[i].length; i++){
                    if(map.getCells()[i][j]==plant.getCell()){
                        if (!map.getCells()[i][j].getZombies().isEmpty()) {
                            Zombie zombie1 = map.getCell(plant.getCell().x, plant.getCell().y).getZombies().get(0);
                            //1 deletion in loop in ok
                            map.getCell(plant.getCell().x, plant.getCell().y).getZombies().remove(zombie1);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void doAction(Zombie zombie, Map map, int d) {

    }
}
