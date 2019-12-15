package Model.Card.Plants;

import Model.Card.Zombies.Zombie;
import javafx.scene.control.Cell;

import java.util.ArrayList;

public class PlantsAction {

    private static ArrayList<PlantsAction> plantsActions=new ArrayList<>();

    public void speedReduce(Zombie zombie){
        //kahesh sorate zombie
    }

    public void shoot(int turn , int quantity,int defaultTurn){

    }

    public void hurtZombie(Zombie zombie){

    }

    public void giveSun(int suns){
        //int sunProduced;
    }


    public void burst(Cell[][] targetArea, int x, int y, int turn) {

    }

    public void proximity(int distance,int load, boolean isTall, int damage, boolean mine, boolean isMagnet) {

    }

    public void ScaredyShroom(int quantity,int turn,int defaultTurn,int distance) {

    }

    public static ArrayList<PlantsAction> getPlantsActions() {
        return plantsActions;
    }

    public static void setPlantsActions(ArrayList<PlantsAction> plantsActions) {
        PlantsAction.plantsActions = plantsActions;
    }

    public void Kill(Controller.GameMode.Zombie firstZombie){

    }
}
