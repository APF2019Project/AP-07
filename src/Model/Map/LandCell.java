package Model.Map;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Snorkel;
import Model.Card.Zombies.Zombie;

public class LandCell extends UnknownCell {
    @Override
    public boolean canBePlanted(Plant plant) {
        if(!plant.getName().equals("TangleKelp") && plant.getCell().x%2==0)
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean canBeZombied(Zombie zombie) {
        if(this.plant == null && !(zombie.getName().equalsIgnoreCase("snorkelzombie") || zombie.getName().equalsIgnoreCase("dolphinriderzombie")))
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
    public void removePlant() {
        Plant tempPlant = this.getPlant();
        if(tempPlant != null)
        {
            this.setPlant(null);
        }
    }
}
