package Model.Card.Zombies.ZombiesActions;

import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.*;

public class StealPlant extends Action {
    @Override
    public void doAction(Plant plant, Battle battle, int d) {

    }

    @Override
    public void doAction(Zombie zombie, Battle battle, int d) {
        System.out.println("steal");
        for (Cell[] i : battle.getMap().getCells()) {
            for (Cell j : i) {
                if (j.getPlant() != null) {
                    if (j == zombie.getCell()) {
                        if (zombie.getHP() > 0) {
                            battle.getMap().getCell(zombie.getCell().x(), zombie.getCell().y()).setPlant(null);
                        }
                    }
                }
            }
        }

    }
}
