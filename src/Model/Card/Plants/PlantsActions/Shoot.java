package Model.Card.Plants.PlantsActions;

import Model.Card.Plants.PeaOrProjectile;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;

public class Shoot extends PlantsAction {
    public void shoot(Plant plant, Zombie zombie, int turn, int defaultTurn) {
        //if the weapon is projectile it always hurt the zombie
        //if the weapon is pea and zombie does not have armour it always hurt the zombie
        if(plant.getPeaOrProjectile().isProjectile() || zombie.getArmour()==0) {
            zombie.setHP(plant.getAP());
            plant.setTurn(plant.getCooldown());
        }
        //if the weapon is pea and the zombie has armour it will hit the armour
        if(zombie.getArmour()!=0){

        }
    }

}
