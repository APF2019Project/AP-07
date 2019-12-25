package Model.Card.Zombies.ZombiesActions;

import Model.Card.Zombies.Zombie;
import Model.Map.Map;
import Model.Map.UnknownCell;

public class Jump extends ZombiesAction{
    public void jumpOverPlants(Zombie zombie){
        UnknownCell cell = zombie.getCell();
        zombie.setCell(Map.unknowncells[cell.x][cell.y-2]);
    }
}
