package Model.Map;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;

public class LandCell extends Cell {
    @Override
    boolean canBePlanted(Plant plant) {
        return false;
    }

    @Override
    boolean canBeZombied(Zombie zombie) {
        return false;
    }

    @Override
    public void plant(Plant plant) {

    }

    @Override
    void removePlant() {

    }
}
