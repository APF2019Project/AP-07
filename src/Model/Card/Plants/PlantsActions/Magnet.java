package Model.Card.Plants.PlantsActions;

import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class Magnet extends Action {
    @Override
    public void doAction(Plant plant, Battle battle, int d) {
        ArrayList<Zombie> zombies = new ArrayList<>();


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
