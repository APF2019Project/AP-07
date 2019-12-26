package Model.Shop;
import Model.Card.Event.*;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import java.util.ArrayList;

public class Shop {
    //it is the whole zombies and plants
    private ArrayList<Plant> plants = new ArrayList<>();
    private ArrayList<Zombie> zombies = new ArrayList<>();

    public void buyPlants(ArrayList<Plant> plants) {

    }

    public void buyZombies(ArrayList<Zombie> zombies) {

    }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

}
