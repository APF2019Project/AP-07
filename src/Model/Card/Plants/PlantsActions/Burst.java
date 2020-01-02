package Model.Card.Plants.PlantsActions;

import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Map.Map;

public class Burst extends Action {
    @Override
    public void doAction(Plant plant, Map map, int d) {
        Cell cell = plant.getCell();
        int x = cell.x;
        for (int i=0;i<Map.getWIDTH()+4;i++){
            for (Zombie z:map.getCell(x,i).zombies) {
                z.setHP(0);
            }
        }
    }


    @Override
    public void doAction(Zombie zombie, Map map, int d) {

    }
}
