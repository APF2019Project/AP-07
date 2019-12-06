package Map;

import Plants.Plant;
import Zombies.Zombie;

import java.util.ArrayList;

public abstract class Cell{
    int x;
    int y;
    Plant plant;
    ArrayList<Zombie> zombies;

    abstract boolean canBePlanted(Plant plant);
    abstract boolean canBeZombied(Zombie zombie);

    abstract void removePlant();

    void moveZombies(){

    }

    void removeDeadZombie(Zombie zombie){

    }

}
