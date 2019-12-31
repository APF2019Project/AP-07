package Model.Card.Event;

import Model.Card.Plants.Plant;
import Model.Map.Map;
import Model.Map.UnknownCell;

public class NearestCell extends Event {
    @Override
    public boolean check(Plant plant, Map map, int d)
    {
        for(UnknownCell[] i : map.getUnknownCells())
        {
            for(UnknownCell j : i)
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
