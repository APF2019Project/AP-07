package Model.Card.Plants.PlantsActions;

import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class Magnet extends Action {
    @Override
    public void doAction(Plant plant, Map map, int d) {
        ArrayList<Zombie> zombies = new ArrayList<>();
        for (int i = 0; i < map.getUnknownCells().length; i++) {
            for (int j = 0; j < map.getUnknownCells()[i].length; j++) {
                if (!map.getUnknownCells()[i][j].getZombies().isEmpty()) {
                    if (abs(map.getUnknownCells()[i][j].x - plant.getCell().x) <= 1) {
                        if (abs(map.getUnknownCells()[i][j].x - plant.getCell().x) <= 1) {
                            if (abs(map.getUnknownCells()[i][j].y - plant.getCell().y) <= 1) {
                                zombies.addAll(map.getUnknownCells()[i][j].getZombies());
                            }
                        }
                    }
                }
            }
        }

        for(int i=0;i<zombies.size();i++){
            if(zombies.get(i).isIronHat()){
                zombies.get(i).setIronHat(false);
            }
        }

        //todo
        //ta 3 turn deactive mishe

    }

    @Override
    public void doAction(Zombie zombie, Map map, int d) {

    }

}
