package Model.Card.Plants.PlantsActions;

import java.util.ArrayList;

public class PlantsAction {

    private static ArrayList<PlantsAction> plantsActions=new ArrayList<>();

    //ino shak daram
    public void ScaredyShroom(int quantity,int turn,int defaultTurn,int distance) {

    }

    public void setPlantsActions(){
//        having ArrayList of Actions to get to cads
//        Shoot shoot=new Shoot();
//        plantsActions.add(shoot);
    }

    public static ArrayList<PlantsAction> getPlantsActions() {
        return plantsActions;
    }
}
