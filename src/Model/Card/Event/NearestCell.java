package Model.Card.Event;

import Controller.GameMode.Battle;
import Model.Card.Plants.Plant;
import Model.Map.Cell;
import Model.Map.Map;

public class NearestCell extends Event {
    @Override
    public boolean check(Plant plant, Battle battle, int d)
    {
        for(Cell[] i : battle.getMap().getCells())
        {
            for(Cell j : i)
            {
                if(j.getZombies().size() > 0)
                {
                    return true;
                }
            }
        }

        return false;
    }
}
