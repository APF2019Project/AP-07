package Model.Card.Zombies.ZombiesActions;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.UnknownCell;

public class InstantKill {
    public void Kill(Zombie zombie)
    {
        /// evnte
        UnknownCell cell =  zombie.getCell();
        cell.plant(null);
    }
}
