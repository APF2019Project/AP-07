package Shop;

import Plants.Plant;
import Zombies.Zombie;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Plant> plants=new ArrayList<>();
    private ArrayList<Zombie> zombies=new ArrayList<>();

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public void buy_Plants(ArrayList<Plant> plants) {
        this.plants = plants;
    }

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    public void buy_Zombies(ArrayList<Zombie> zombies) {
        this.zombies = zombies;
    }

}
