package Map;

import Plants.Plant;
import Zombies.Zombie;

public class WaterCell extends Cell {

    Plant lilypad;

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
