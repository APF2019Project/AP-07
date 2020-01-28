package Model.Card.Zombies.ZombiesActions;

import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;

public class Walk extends Action {


    @Override
    public void doAction(Plant plant, Battle battle, int d) {

    }

    @Override
    public void doAction(Zombie zombie, Battle battle, int d) {
        int i = 0;
        int x = zombie.getCell().x();
        int y = zombie.getCell().y();
        while (i < zombie.getSpeed()) {
            if ((y > 0 && battle.getMap().getCell(x, y - 1).getPlant() == null)) {
                y--;
            }
            if (y>0 && battle.getMap().getCell(x,y-1).getPlant()!=null && zombie.getActionsOfAnEvent().contains(new StealPlant())){
                y--;
                battle.getMap().getCell(x,y).getPlant().setHealthPoint(0);
            }
            i++;
        }
        zombie.setCell(battle.getMap().getCell(x, y));
        battle.getMap().getCell(x, y).getZombies().add(zombie);
    }

}
