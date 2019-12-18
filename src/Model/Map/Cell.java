package Model.Map;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;

import java.util.ArrayList;

public abstract class Cell{
    int x;
    int y;
    protected Plant plant;
    ArrayList<Zombie> zombies;

    abstract boolean canBePlanted(Plant plant);
    abstract boolean canBeZombied(Zombie zombie);
    abstract void removePlant();
    abstract public void plant(Plant plant);

    void moveZombies(){
    }

    void removeDeadZombie(Zombie zombie){

    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    public void setZombies(ArrayList<Zombie> zombies) {
        this.zombies = zombies;
    }
}
