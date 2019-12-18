package Model.Map;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Snorkel;
import Model.Card.Zombies.Zombie;

public class LandCell extends Cell {
    @Override
    boolean canBePlanted(Plant plant) {
        if(!plant.getName().equals("Tangle Kelp"))
        {
            return true;
        }
        return false;
    }

    @Override
    boolean canBeZombied(Zombie zombie) {
        if(!(zombie instanceof Snorkel))
        {
            return true;
        }
        return false;
    }

    @Override
    public void plant(Plant plant) {
        if(canBePlanted(plant))
        {
            this.setPlant(plant);
        }
    }

    @Override
    void removePlant() {
        Plant tempPlant = this.getPlant();
        if(tempPlant != null)
        {
            this.setPlant(null);
        }
    }
}
