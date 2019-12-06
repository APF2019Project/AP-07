package Zombies;

import Cell.Cell;
import Plants.PeaOrProjectile;



public class Zombie {

    private int Health;
    private int Speed;
    private Cell walkAreaType;
    private PeaOrProjectile peaOrProjectile;
    //kind of thing that hurts it
    public void setHealth(int health)
    {
        this.Health = health;
    }
    public void setSpeed(int speed)
    {
        this.Speed = speed;
    }

    public void setWalkAreaType(Cell cell) {
        this.walkAreaType = cell;
    }

    public void setPeaOrProjectile(PeaOrProjectile peaOrProjectile) {
        this.peaOrProjectile = peaOrProjectile;
    }

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
        return this.Health;
    }

    public int getSpeed() {
        return this.Speed;
    }

    public Cell getWalkAreaType() {
        return this.walkAreaType;
    }

}
