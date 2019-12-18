package Model.Card.Zombies;

import Model.Card.Card;
import Model.Card.Plants.PeaOrProjectile;
import Model.Card.Zombies.ZombiesActions.ZombiesAction;

import java.util.ArrayList;


public class Zombie extends Card {

    private int health;
    private int speed;
    private PeaOrProjectile peaOrProjectile;
    //kind of thing that hurts it
    private ArrayList<ZombiesAction> actions = new ArrayList<>();

    public static ArrayList<Zombie> getZombies() {
        return zombies;
    }

    private static ArrayList<Zombie> zombies = new ArrayList<>();

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

    public static Zombie findZombie(String name) {
        for (Zombie x : zombies)
            if (x.name.equals(name))
                return x;
        return null;
    }

}
