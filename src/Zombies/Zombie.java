package Zombies;

import Plants.PeaOrProjectile;
import javafx.scene.control.Cell;

public class Zombie {

    private int health;
    private int speed;
    private walkAreaType;
    private PeaOrProjectile peaOrProjectile;
    //kind of thing that hurts it

    public PeaOrProjectile getPeaOrProjectile() {
        return peaOrProjectile;
    }

    public void walk() {

    }

    public void attack() {

    }

    public void defend() {

    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public Cell getWalkAreaType() {
        return walkAreaType;
    }

}
