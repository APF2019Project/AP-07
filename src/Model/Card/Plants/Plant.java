package Model.Card.Plants;

import Model.Card.Card;
import Model.Card.Plants.PlantsActions.PlantsAction;

import java.util.ArrayList;

public class Plant extends Card {

    private String name;
    private int sun;
    private int cooldown;
    private int health;
    private ArrayList<PlantsAction> plantsActions;

    public ArrayList<PlantsAction> getPlantsActions() {
        return plantsActions;
    }

    public void setPlantsActions(ArrayList<PlantsAction> plantsActions) {
        this.plantsActions = plantsActions;
    }


}
