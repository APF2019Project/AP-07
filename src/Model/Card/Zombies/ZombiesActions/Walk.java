package Model.Card.Zombies.ZombiesActions;

import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Map.Map;

import java.util.ArrayList;

public class Walk extends Action {


    @Override
    public void doAction(Plant plant, Battle battle, int d) {

    }

    @Override
    public void doAction(Zombie zombie, Battle battle, int d) {
        int i = 0;
        int x = zombie.getCell().x();
        int y = zombie.getCell().y();
        System.out.println("walk");
        while (i < zombie.getSpeed()) {
            System.out.println("while");
            if ((y > 0 && battle.getMap().getCell(x, y - 1).getPlant() == null)||
                    (y>0 && battle.getMap().getCell(x,y-1).getPlant()!=null && zombie.getActionsOfAnEvent().contains(new StealPlant()))) {
                System.out.println("if");
                y--;
            }
            i++;
        }
        zombie.setCell(battle.getMap().getCell(x, y));
        battle.getMap().getCell(x, y).getZombies().add(zombie);
        System.out.println("endWhile");
    }

}
