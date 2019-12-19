package Model.Card.Plants.PlantsActions;

import Model.Card.Plants.Plant;
import Model.Map.Cell;

import java.util.ArrayList;

public class Burst extends Plant {

    public Burst(String name, int AP, int HP, Cell cell, int sun, int cooldown) {
        super(name, AP, HP, cell, sun, cooldown);
    }

    public void burst(ArrayList<Cell> targetArea){

    }

}
