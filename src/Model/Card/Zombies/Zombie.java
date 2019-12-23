package Model.Card.Zombies;
import Model.Card.Card;
import Model.Card.Zombies.ZombiesActions.ZombiesAction;
import Model.Map.Cell;

import java.util.ArrayList;

public class Zombie extends Card {
    public int getArmour() {
        return armour;
    }

    public boolean isPea() {
        return pea;
    }

    private int armour;
    private int health;
    private int speed;
    private boolean pea;
    private ArrayList<ZombiesAction> actions = new ArrayList<>();

    public void addToZombiesActions(ZombiesAction action) {
        actions.add(action);
    }

    public ArrayList<ZombiesAction> getZombiesActions() {
        return actions;
    }

    public Zombie(String name, int AP, int HP, Cell cell, int health, int speed, int armour, boolean pea) {
        this.name = name;
        this.AP = AP;
        this.HP = HP;
        this.id = uniqueId;
        uniqueId++;
        this.cell = cell;
        this.coin = coin;
        this.health = health;
        this.speed = speed;
        this.armour = armour;
        this.pea = pea;
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
