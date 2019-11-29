import Plants.Plants;
import Zombies.Zombie;

import java.util.ArrayList;

public class Cell {

    private boolean isWater;
    private boolean isLilyPad;
    private Plants plant;
    private ArrayList<Zombie> zombies;
    private Cell[][] map=new Cell[19][6];

    public boolean isWater() {
        return isWater;
    }

    public void setType(String type) {
        //booleane type morede nazaro true kon
    }

    public boolean isLilyPad() {
        return isLilyPad;
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

    public Cell[][] getMap() {
        return map;
    }

}
