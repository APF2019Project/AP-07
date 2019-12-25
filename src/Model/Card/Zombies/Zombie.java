package Model.Card.Zombies;

import Model.Card.Card;
import Model.Card.Zombies.ZombiesActions.ZombiesAction;
import com.gilecode.yagson.YaGson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Zombie extends Card {

    private int armour;//if nothing...it is 0
    private int health;
    private int speed;
    private boolean pea;
    private int freezeTurns =0;
    private ArrayList<ZombiesAction> actions = new ArrayList<>();

    public static Zombie makeZombie(String name) throws IOException {
        YaGson yaGson = new YaGson();
        Zombie zombie = new Zombie(name);
        File file = new File("Zombies\\" + zombie.getName());
        String string = Card.makeString(file);
        Zombie zombie1 = yaGson.fromJson(string, Zombie.class);
        String d = yaGson.toJson(zombie1);
        zombies.add(zombie1);
        return zombie1;
//        System.out.println(d);
//        System.out.println(zombie1.getSpeed());
    }

    public static Zombie findZombie(String name) {
        for (Zombie x : zombies)
            if (x.name.equals(name))
                return x;
        return null;
    }

    public Zombie(String name) {
        this.name = name;
        this.id = uniqueId;
        uniqueId++;
    }

    public void addToZombiesActions(ZombiesAction action) {
        actions.add(action);
    }

    public ArrayList<ZombiesAction> getZombiesActions() {
        return actions;
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

    public void setSpeed(int speed) {
        this.speed += speed;
    }

    public int getArmour() {
        return armour;
    }

    public boolean isPea() {
        return pea;
    }

    public int getFreezeTurns() {
        return freezeTurns;
    }

    public void setFreezeTurns(int freezeTurns) {
        this.freezeTurns += freezeTurns;
    }

}
