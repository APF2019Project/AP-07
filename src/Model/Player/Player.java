package Model.Player;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Shop.Collection;

import java.util.ArrayList;

public class Player {

    private int internalCoins;
    private int sun;

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    private ArrayList<Plant> plants=new ArrayList<>();
    private ArrayList<Zombie> zombies=new ArrayList<>();

    public Player(){
    }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public void setCollection(Collection collection) {

    }

    public int getSun() {
        return sun;
    }

    public void setSun(int sun) {
        this.sun += sun;
    }
}
