package Model.Card.Zombies.ZombiesActions;

import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;

import java.util.Random;

public class AppearInCell extends Action {

    @Override
    public void doAction(Plant plant, Battle battle, int d) {

    }

    @Override
    public void doAction(Zombie zombie, Battle battle, int d) {
        Random random = new Random();
        int x = (int) (Math.random() * (7) )+2;
        int y = (int) (Math.random() * (20)) +2;
        battle.getMap().getCell(x,y).getPlant().setHealthPoint(0);
        zombie.setHealthPoint(0);
    }
}
