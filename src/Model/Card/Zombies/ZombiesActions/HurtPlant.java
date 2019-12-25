package Model.Card.Zombies.ZombiesActions;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Map.Map;
import Model.Map.UnknownCell;

public class HurtPlant {
    public void Hurt(Zombie zombie)
    {
        UnknownCell cell = zombie.getCell();
        int x = cell.x;
        int y = cell.y;
        UnknownCell targetCell = Map.getCell(x,y-1);
        Plant p = targetCell.getPlant();
        p.setHP(p.getHP()-zombie.getAP());
    }
}
