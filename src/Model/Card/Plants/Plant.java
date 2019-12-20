package Model.Card.Plants;

import Model.Card.Card;
import Model.Card.Plants.PlantsActions.PlantsAction;
import Model.Map.Cell;
import java.util.ArrayList;

public class Plant extends Card {

    private int sun;
    private int cooldown;
    private ArrayList<PlantsAction> plantsActions;
    private int Turn;

    public int getTurn() {
        return Turn;
    }

    public void setTurn(int turn) {
        Turn = turn;
    }

    public Plant(String name, int AP, int HP, Cell cell, int sun, int cooldown) {
        this.name=name;
        this.AP=AP;
        this.HP=HP;
        this.id=uniqueId;
        uniqueId++;
        this.cell=cell;
        this.coin=coin;
        this.sun=sun;
        this.cooldown=cooldown;
    }

    public void addToPlantsActions(PlantsAction action) {
        plantsActions.add(action);
    }

    public static Plant findPlant(String name) {
        for (Plant plant : getPlants()) {
            if (plant.name.equals(name))
                return plant;
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

}