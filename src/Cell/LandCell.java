package Cell;

import Plants.Plant;
import Zombies.Zombie;

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
    void removePlant() {

    }
}