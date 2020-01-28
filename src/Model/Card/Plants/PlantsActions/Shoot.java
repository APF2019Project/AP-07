package Model.Card.Plants.PlantsActions;

import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.Plants.PeaOrProjectile;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;

public class Shoot extends Action {
    @Override
    public void doAction(Plant plant, Battle battle, int d) {
        PeaOrProjectile pea;
        if (plant.getHP() > 0) {

            if(plant.getName().equalsIgnoreCase("split pea")) {
                battle.getPeas().add(new PeaOrProjectile(plant));
                pea = new PeaOrProjectile(plant);
                pea.setBackward(true);
                battle.getPeas().add(pea);
            }
            else {
                for (int i=0;i<plant.getPeaAmount();i++){
                    battle.getPeas().add(new PeaOrProjectile(plant));
                }
            }
        }
    }

    @Override
    public void doAction(Zombie zombie, Battle battle, int d) {
    }
}
