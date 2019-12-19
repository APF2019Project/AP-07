package Model.Card.Plants;

import Model.Card.Card;
import Model.Card.Plants.PlantsActions.PlantsAction;
import Model.Map.Cell;

import java.util.ArrayList;

public class Plant extends Card {

    private int sun;
    private int cooldown;
    private int health;
    private ArrayList<PlantsAction> plantsActions;

    public Plant(String name,int AP, int HP,Cell cell,int sun,int cooldown,int health) {
        this.name=name;
        this.AP=AP;
        this.HP=HP;
        this.id=uniqueId;
        uniqueId++;
        this.cell=cell;
        this.coin=coin;
        this.sun=sun;
        this.cooldown=cooldown;
        this.health=health;
    }

    public void addToPlantsActions(PlantsAction action) {
        plantsActions.add(action);
    }

    public static Plant findPlant(String name) {
        for (Plant x : getPlants()) {
            if (x.name.equals(name))
                return x;
        }
        return null;
    }

    public ArrayList<PlantsAction> getPlantsActions() {
        return plantsActions;
    }

    public int getSun() {
        return sun;
    }

    public void setSun(int sun) {
        this.sun = sun;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


}
