package Model.Card.Zombies.ZombiesActions;

import Model.Card.Zombies.Zombie;
import Model.Map.Map;
import Model.Map.UnknownCell;

public class Walk {
    public void walk(Zombie zombie) {
        UnknownCell cell = zombie.getCell();
        zombie.setCell(Map.unknowncells[cell.x][cell.y - zombie.getSpeed()]);
    }
}
