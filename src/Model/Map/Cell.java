package Model.Map;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import java.util.ArrayList;

public class Cell {
    public int x;
    public int y;
    //in each cell we have just 1 plant but not only 1 zombie
    public Plant plant;
    public ArrayList<Zombie> zombies;
    public boolean water;
    public boolean LilyPad;

//     boolean canBePlanted(Plant plant);
//     boolean canBeZombied(Zombie zombie);
//     void removePlant();
//     public void plant(Plant plant);

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

    public void removePlant() {

    }

    public boolean canBePlanted() {
        if (this.water) {
            if (this.LilyPad) {
                if (this.plant == null)
                    return true;
            }
        }
        return true;
    }

}
