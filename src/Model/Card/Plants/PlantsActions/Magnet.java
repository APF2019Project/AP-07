package Model.Card.Plants.PlantsActions;

import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import java.io.IOException;
import java.util.ArrayList;

public class Magnet extends Action {
    @Override
    public void doAction(Plant plant, Battle battle, int d) {
        ArrayList<Zombie> zombies = new ArrayList<>();
        for(Cell[] i : battle.getMap().getCells())
        {
            for(Cell j : i)
            {
                if(j.x() == plant.getCell().x() && j.y() - plant.getCell().y() <8)
                {
                    zombies.addAll(j.getZombies());
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
