package Model.Map;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;

import java.util.ArrayList;

public abstract class Cell{
    int x;
    int y;
    Plant plant;
    ArrayList<Zombie> zombies;

    abstract boolean canBePlanted(Plant plant);
    abstract boolean canBeZombied(Zombie zombie);
    abstract void removePlant();
    abstract public void plant(Plant plant);

    void moveZombies(){
    }

    void removeDeadZombie(Zombie zombie){

    }

}
