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
        int MinRad = 19;
        int X = 0;
        int Y = 19;
        for(UnknownCell[] i : map.getUnknownCells())
        {
            for(UnknownCell j : i)
            {
                if(j.zombies.size() > 0)
                {
                    if(radious( plant.getCell() , j ) < MinRad)
                    {
                        X = j.x;
                        Y = j.y;
                        MinRad = radious( plant.getCell() , j );
                    }
                }
            }
        }
        map.getCell(X , Y).zombies.set(0,null);
    }

    @Override
    public void doZombieAction(Zombie zombie, Map map) {

    }
}
