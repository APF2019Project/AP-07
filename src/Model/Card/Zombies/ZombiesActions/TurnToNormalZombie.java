package Model.Card.Zombies.ZombiesActions;

import Model.Card.Zombies.Zombie;
import Model.Map.UnknownCell;

public class TurnToNormalZombie extends ZombiesAction {

    public void turnToNormalZombie(Zombie zombie){
        UnknownCell cell = zombie.getCell();
        // new miknim ye zomie mamoli to in cell
    }

}
