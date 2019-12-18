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
        Cell nextCell = Map.getCell(this.x , (this.y - 1));
        Cell thisCell = Map.getCell(this.x , this.y);
        ArrayList<Zombie> tempZombies = new ArrayList<>();
        for(Zombie i : thisCell.zombies)
        {
            if(nextCell.canBeZombied(i))
            {
                tempZombies.add(i);
            }
        }
        for(Zombie i : tempZombies)
        {
            thisCell.zombies.remove(i);
            nextCell.zombies.add(i);
        }
    }

    void removeDeadZombie(Zombie zombie){
        ArrayList<Zombie> tempZombies = new ArrayList<>();
        Cell thisCell = Map.getCell(this.x , this.y);
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
