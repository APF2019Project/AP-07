package Model.Card.Plants.PlantsActions;

import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Map.Map;

import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class Magnet extends Action {
    @Override
    public void doAction(Plant plant, Battle battle, int d) {
        ArrayList<Zombie> zombies = new ArrayList<>();
        for(Cell[] i : battle.getMap().getCells())
        {
            for(Cell j : i)
            {
                if(j.x == plant.getCell().x && j.y - plant.getCell().y <8)
                {
                    zombies.addAll(j.zombies);
                }
            }
        }
        for(int i=0;i<zombies.size();i++){
            if(zombies.get(i).isIronHat()){
                zombies.get(i).setIronHat(false);
            }
        }
    }


    @Override
    public void doAction(Zombie zombie, Battle battle, int d) throws IOException {

    }
}
