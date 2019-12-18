package Model.Card.Plants;

import Model.Card.Card;
import Model.Card.Plants.PlantsActions.PlantsAction;

import java.util.ArrayList;

public class Plant extends Card {

    private int sun;
    private int cooldown;
    private int health;
    private ArrayList<PlantsAction> plantsActions;

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



    public void setPlantsActions(ArrayList<PlantsAction> plantsActions) {
        this.plantsActions = plantsActions;
    }


}
