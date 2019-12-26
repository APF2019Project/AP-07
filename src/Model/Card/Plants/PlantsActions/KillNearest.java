package Model.Card.Plants.PlantsActions;

import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;
import Model.Map.UnknownCell;

public class KillNearest extends Action {
    public int radious(UnknownCell p , UnknownCell z)
    {
        return (int) Math.sqrt( ((p.x - z.x)*(p.x - z.x)) + ((p.y - z.y)*(p.y - z.y)));
    }
    @Override
    public void doAction(Plant plant, Map map) {

    }
}
