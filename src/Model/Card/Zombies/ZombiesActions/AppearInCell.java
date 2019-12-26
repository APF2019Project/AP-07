package Model.Card.Zombies.ZombiesActions;

import Model.Card.Zombies.Zombie;
import Model.Map.UnknownCell;

public class AppearInCell extends ZombiesAction{
        public void appearInCell(UnknownCell cell, Zombie zombie){
                zombie.setCell(cell);
                cell.zombies.add(zombie);
        }
}
