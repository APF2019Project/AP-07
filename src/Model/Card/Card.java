package Model.Card;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;

import java.util.ArrayList;

public class Card {

    protected String name;
    protected int id;
    protected static int uniqueId = 0;
    protected int AP;//attack point
    protected int HP;
    protected Cell cell;
    protected int coin;
    protected static ArrayList<Plant> plants = new ArrayList<>();
    protected static ArrayList<Zombie> zombies = new ArrayList<>();

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public static int getUniqueId() {
        return uniqueId;
    }

    public int getAP() {
        return AP;
    }

    public int getHP() {
        return HP;
    }

    public Cell getCell() {
        return cell;
    }

    public int getCoin() {
        return coin;
    }


    public static ArrayList<Plant> getPlants() {
        return plants;
    }

    public static ArrayList<Zombie> getZombies() {
        return zombies;
    }

    public static void addToPlants(Plant plant){
        plants.add(plant);
    }

    public static void addToZombies(Zombie zombie){
        zombies.add(zombie);
    }
}
