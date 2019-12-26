package Model.Card.Plants.PlantsActions;

import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

public class Shoot extends Action {
    @Override
    public void doAction(Plant plant, Map map, int d) {
        for (int i = 0; i < map.getUnknownCells().length; i++) {
            if (map.getCell(plant.getCell().x, plant.getCell().y).x == plant.getCell().x) {
                if (map.getCell(plant.getCell().x, plant.getCell().y).zombies.size() > 0) {
                    Zombie zombie = map.getCell(plant.getCell().x, plant.getCell().y).zombies.get(0);
                    //if the weapon is projectile it always hurt the zombie
                    //if the weapon is pea and zombie does not have armour it always hurt the zombie
                    if (plant.getPeaOrProjectile().isProjectile() || zombie.getArmour() == 0) {
                        zombie.setHP(-plant.getAP() * plant.getPeaOrProjectile().getDamage());
                        plant.setTurn(plant.getCooldown());
                        zombie.setSpeed(-plant.getSpeedReduction());
                        zombie.setFreezeTurns(plant.getFreeze());
                    }
                    //if the weapon is pea and the zombie has armour it will hit the armour
                    if (zombie.getArmour() != 0) {
                    }
                }
            }
        }
    }
}
