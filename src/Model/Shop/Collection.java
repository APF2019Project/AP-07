package Model.Shop;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;

import java.util.ArrayList;

public class Collection {
//    Account account;

    private ArrayList<Plant> plants = new ArrayList<>();
    private ArrayList<Zombie> zombies = new ArrayList<>();

    public Collection(ArrayList<Plant> plants) {
        this.plants = plants;
    }

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public void addPlantToColection(Plant plant){
        plants.add(plant);
    }

    public void addZombieToColection(Zombie zombie){
        zombies.add(zombie);
    }

}


