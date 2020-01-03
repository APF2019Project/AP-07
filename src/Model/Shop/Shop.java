package Model.Shop;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Player.Profile;

import java.util.ArrayList;

public class Shop {
    //it is the whole zombies and plants
    private ArrayList<Plant> plants = new ArrayList<>();
    private ArrayList<Zombie> zombies = new ArrayList<>();

    public void buyPlant(Plant plant, Profile profile) {
        if (profile.getExternalCoins() >= plant.getPrice()) {
            profile.setExternalCoins(-plant.getPrice());
            profile.getPurchasedPlants().add(plant.getName());
        }
    }

    public void buyZombie(Zombie zombie, Profile profile) {
        if (profile.getExternalCoins() >= zombie.getPrice()) {
            profile.setExternalCoins(-zombie.getPrice());
            profile.getPurchasedZombies().add(zombie.getName());
        }
    }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

}
