package Model.Card.Event;

import Controller.GameMode.Battle;
import Model.Card.Plants.Plant;

import static java.lang.StrictMath.abs;

public class NearRows extends Event {
    @Override
    public boolean check(Plant plant, Battle battle, int d) {
        for (int i = 0; i < battle.getMap().getCells().length; i++) {
            if (battle.getMap().getCell(plant.getCell().x(), plant.getCell().y()).x() == plant.getCell().x()) {
                if (abs(battle.getMap().getCell(plant.getCell().x(), plant.getCell().y()).y() - plant.getCell().y()) <= d) {
                    if (!battle.getMap().getCell(plant.getCell().x(), plant.getCell().y()).getZombies().isEmpty()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

