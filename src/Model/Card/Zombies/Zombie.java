package Model.Card.Zombies;

import Model.Card.Card;
import Model.Card.Plants.PeaOrProjectile;
import Model.Card.Zombies.ZombiesActions.ZombiesAction;
import Model.Map.Cell;
import Model.Map.LandCell;
import Model.Map.Map;
import Model.Map.UnknownCell;

import java.util.ArrayList;


public class Zombie extends Card {
    private Cell cell;

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
    private int health = 0;
    private int speed;
    private PeaOrProjectile peaOrProjectile;
    //kind of thing that hurts it
    private ArrayList<ZombiesAction> actions = new ArrayList<>();
    public PeaOrProjectile getPeaOrProjectile() {
        return peaOrProjectile;
    }

    public void walk() {

    }
    public void setHealth(int hp)
    {
        this.health += hp;
    }
    public int getHealth() {
        return this.health;
    }

    public int getSpeed() {
        return this.speed;
    }
}