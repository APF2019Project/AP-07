package Cell;

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
    public static Cell getEnum(String input) {
        switch (input) {
            case "water":
                return Cell.WATER;
            case "land":
                return Cell.LAND;
            case "lilypad":
                return Cell.LILYPAD;
        }
        return null;
    }
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
