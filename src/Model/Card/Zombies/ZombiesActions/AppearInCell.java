package Model.Card.Zombies.ZombiesActions;

import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;
import Model.Map.UnknownCell;

import java.util.Random;

public class AppearInCell extends Action {
        @Override
        public void doAction(Plant plant, Map map) {

        }

        @Override
        public void doZombieAction(Zombie zombie, Map map) {
                Random r = new Random();
                int x = 5;
                int y = 18;
                while(map.getCell(x , y).getPlant() == null)
                {
                        x= r.nextInt(5);
                        y = r.nextInt(18);
                }
                zombie.setCell(map.getCell(x , y));
                map.getCell(x , y).zombies.add(zombie);
        }
}
