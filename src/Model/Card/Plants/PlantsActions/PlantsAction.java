package Model.Card.Plants.PlantsActions;

import Model.Card.Event.Event;
import Model.Card.Zombies.Zombie;

import java.util.ArrayList;

public class PlantsAction {

    private ArrayList<Event> events=new ArrayList<>();

    private static ArrayList<PlantsAction> plantsActions=new ArrayList<>();

    private static ArrayList<Zombie> targetZombies=new ArrayList<>();

    //ino shak daram
    public void ScaredyShroom(int quantity,int turn,int defaultTurn,int distance) {

    }

    public static ArrayList<PlantsAction> getPlantsActions() {
        return plantsActions;
    }
}
