package Model.Map;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Snorkel;
import Model.Card.Zombies.Zombie;

import java.util.ArrayList;

public class LandCell extends UnknownCell {
    public LandCell(int x, int y) {
        this.x = x;
        this.y = y;
        this.zombies = new ArrayList<>();
    }

    @Override
    public boolean canBePlanted(Plant plant) {
        if (!plant.getName().equals("TangleKelp")) {
            return true;
        }
        return false;
    }

    @Override
    public boolean canBeZombied(Zombie zombie) {
        if (this.plant == null && !(zombie.getName().equalsIgnoreCase("snorkelzombie") || zombie.getName().equalsIgnoreCase("dolphinriderzombie"))) {
            return true;
        }
        return false;
    }

    @Override
    public void plant(Plant plant) {
        if (canBePlanted(plant)) {
            this.setPlant(plant);
        }
    }

    @Override
    public void removePlant() {
        Plant tempPlant = this.getPlant();
        if (tempPlant != null) {
            this.setPlant(null);
        }
    }
}
