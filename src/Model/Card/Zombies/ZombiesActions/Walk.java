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
        System.out.println("walk");
        while (i < zombie.getSpeed()) {
            System.out.println("while");
            if ((y > 0 && battle.getMap().getCell(x, y - 1).getPlant() == null)) {
                System.out.println("if");
                y--;
            }
            if (y>0 && battle.getMap().getCell(x,y-1).getPlant()!=null && zombie.getActionsOfAnEvent().contains(new StealPlant())){
                System.out.println("if2 instant killllllllll");
                y--;
                battle.getMap().getCell(x,y).getPlant().setHealthPoint(0);
            }
            i++;
        }
        zombie.setCell(battle.getMap().getCell(x, y));
        battle.getMap().getCell(x, y).getZombies().add(zombie);
        System.out.println("endWhile");
    }

}
