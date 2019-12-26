package Model.Card.Event;

import Model.Card.Plants.Plant;
import Model.Map.Map;

//for shooting
public class InTheSameRow extends Event {

    @Override
    public boolean check(Plant plant, Map map, int d) {
        for (int i = 0; i < map.getUnknownCells().length; i++) {
            if (map.getCell(plant.getCell().x, plant.getCell().y).x == plant.getCell().x) {
                if(map.getCell(plant.getCell().x, plant.getCell().y).zombies.size()>0){
                    return true;
                }
            }
        }
        return false;
    }
}