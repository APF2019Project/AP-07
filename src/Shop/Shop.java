package Shop;

import Plants.Plants;
import Player.Player;
import Zombies.Zombie;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Plants> plants=new ArrayList<>();
    private ArrayList<Zombie> zombies=new ArrayList<>();

    public ArrayList<Plants> getPlants() {
        return plants;
    }

    public void buy_Plants(ArrayList<Plants> plants) {
        this.plants = plants;
    }

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    public void buy_Zombies(ArrayList<Zombie> zombies) {
        this.zombies = zombies;
    }

}
