package Model.Card.Plants.PlantsActions;

import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.Plants.PeaOrProjectile;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

public class Shoot extends Action {
    @Override
    public void doAction(Plant plant, Battle battle, int d) {
        if (plant.getHP() > 0) {
            if(plant.pea)
            {
                PeaOrProjectile pea = new PeaOrProjectile(plant.getAP() , false);
                pea.setX(plant.getCell().x);
                pea.setY(plant.getCell().y);

            }
            else
            {
                PeaOrProjectile projectile = new PeaOrProjectile(plant.getAP() , true);
                projectile.setX(plant.getCell().x);
                projectile.setY(plant.getCell().y);
            }
        }
    }

    @Override
    public void doAction(Zombie zombie, Map map, int d) {
    }
}
