import Plants.Plants;
import Zombies.Zombie;

import java.util.ArrayList;

public enum Cell {
    WATER("water"),
    LAND("land"),
    LILYPAD("lilypad");

    private String cell;
    private Plants plant;
    private ArrayList<Zombie> zombies;

    Cell(String cell) {
        this.cell = cell;
    }

    public String Cell() {
        return cell;
    }

    public Plants getPlant() {
        return plant;
    }

    public void setPlant(Plants plant) {
        this.plant = plant;
    }

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    public void setZombies(Zombie zombie) {
        zombies.add(zombie);
    }


    }
