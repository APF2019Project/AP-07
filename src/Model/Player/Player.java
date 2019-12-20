package Model.Player;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Shop.Collection;

import java.util.ArrayList;

public class Player {

    private int internalCoins;
    private ArrayList<Plant> plants=new ArrayList<>();
    private ArrayList<Zombie> zombies=new ArrayList<>();

    public Player(){

        plants.add(Plant.getPlants().get(0));
        plants.add(Plant.getPlants().get(1));
        plants.add(Plant.getPlants().get(7));
        plants.add(Plant.getPlants().get(8));
        plants.add(Plant.getPlants().get(10));
        plants.add(Plant.getPlants().get(19));
        plants.add(Plant.getPlants().get(21));

        zombies.add(Zombie.getZombies().get(0));
        zombies.add(Zombie.getZombies().get(1));
        zombies.add(Zombie.getZombies().get(3));
        zombies.add(Zombie.getZombies().get(4));
        zombies.add(Zombie.getZombies().get(6));
        zombies.add(Zombie.getZombies().get(7));
        zombies.add(Zombie.getZombies().get(10));

    }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

}
