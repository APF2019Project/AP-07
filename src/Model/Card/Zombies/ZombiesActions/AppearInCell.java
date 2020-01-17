package Model.Card.Zombies.ZombiesActions;

import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

import java.util.Random;

public class AppearInCell extends Action {

    @Override
    public void doAction(Plant plant, Battle battle, int d) {

    }

    @Override
    public void doAction(Zombie zombie,Battle battle, int d) {
        System.out.println("app");
        Random random = new Random();
        int x = 5;
        int y = 18;
        if (battle.getMap().getCell(x , y).getPlant() == null)
        {
            x = random.nextInt(5);
            y = random.nextInt(18);
        }
        battle.getMap().getCell(x,y).getZombies().add(zombie);
        if (zombie.getHP() > 0) {
            battle.getMap().getCell(x , y).setPlant(null);
            battle.getMap().getCell(x , y).getZombies().remove(zombie);
        }
    }
}
