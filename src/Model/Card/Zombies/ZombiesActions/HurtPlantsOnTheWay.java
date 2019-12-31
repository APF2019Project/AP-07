package Model.Card.Zombies.ZombiesActions;

import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

import java.util.ArrayList;

public class HurtPlantsOnTheWay extends Action {


    @Override
    public void doAction(Plant plant, Map map, int d) {

    }

    @Override
    public void doAction(Zombie zombie, Map map, int d) {
        ArrayList<Plant> plantsInARow = new ArrayList<>();
        for (int i = 0; i < Map.getWIDTH(); i++) {
            for (int j = 0; j < Map.getHEIGHT(); j++) {
                //todo
                //checking the x and y
                if (Map.unknownCells[i][j].getPlant().getCell().y == zombie.getCell().y) {
                    if (zombie.getHP() > 0) {
                        plantsInARow.add(Map.unknownCells[i][j].getPlant());
                    }
                }
            }
        }
        //todo
        //check the process of deleting not lead to null pointer exception
        for (int i = 0; i < plantsInARow.size(); i++) {
            Plant.getPlants().remove(plantsInARow.get(i));
        }
    }
}
