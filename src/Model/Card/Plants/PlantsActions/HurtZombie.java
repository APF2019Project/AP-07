package Model.Card.Plants.PlantsActions;

import Model.Card.Zombies.Zombie;

public class HurtZombie extends PlantsAction {

    public void hurtZombie(Zombie zombie){
        zombie.setHealth(-1);
    }
}
