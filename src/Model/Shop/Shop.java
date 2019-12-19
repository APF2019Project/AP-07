package Model.Shop;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Plant> plants=new ArrayList<>();
    private ArrayList<Zombie> zombies=new ArrayList<>();

    public void buy_Plants(ArrayList<Plant> plants) {

    }

    public void buy_Zombies(ArrayList<Zombie> zombies) {

    }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }
}
