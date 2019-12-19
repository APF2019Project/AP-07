package Model.Card.Zombies;

import Model.Card.Card;
import Model.Card.Plants.PeaOrProjectile;
import Model.Card.Zombies.ZombiesActions.ZombiesAction;
import Model.Map.Cell;
import Model.Map.LandCell;
import Model.Map.Map;
import Model.Map.UnknownCell;

import Model.Map.Cell;
import java.util.ArrayList;

public class Zombie extends Card {

    private int health;
    private int speed;
    private PeaOrProjectile peaOrProjectile;
    private ArrayList<ZombiesAction> actions = new ArrayList<>();

    public void addToZombiesActions(ZombiesAction action) {
        actions.add(action);
    }

    public ArrayList<ZombiesAction> getZombiesActions() {
        return actions;
    }

    public Zombie(String name, int AP, int HP, Cell cell, int health, int speed, PeaOrProjectile peaOrProjectile) {
        this.name = name;
        this.AP = AP;
        this.HP = HP;
        this.id = uniqueId;
        uniqueId++;
        this.cell = cell;
        this.coin = coin;
        this.health = health;
        this.speed = speed;
        this.peaOrProjectile = peaOrProjectile;
    }

    //kind of thing that hurts it
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

    public static Zombie findZombie(String name) {
        for (Zombie x : zombies)
            if (x.name.equals(name))
                return x;
        return null;
    }

}