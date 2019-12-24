package Model.Map;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;

import java.util.ArrayList;

public abstract class Cell{
    public int x;
    public int y;
    protected Plant plant;
    public ArrayList<Zombie> zombies;

    abstract boolean canBePlanted(Plant plant);
    abstract boolean canBeZombied(Zombie zombie);
    abstract void removePlant();
    abstract public void plant(Plant plant);

    void removeDeadZombie(Zombie zombie, Map map){
        ArrayList<Zombie> tempZombies = new ArrayList<>();
        Cell thisCell = map.getCell(this.x , this.y);
        for(Zombie i : thisCell.zombies)
        {
            if(i.getHealth() == 0)
            {
                tempZombies.add(i);
            }
        }
        for(Zombie i : tempZombies)
        {
            thisCell.zombies.remove(i);
        }
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
