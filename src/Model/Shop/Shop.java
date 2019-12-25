package Model.Shop;

import Model.Card.Action;
import Model.Card.ActionsOfAnEvent;
import Model.Card.Card;
import Model.Card.Event.Event;
import Model.Card.Event.InTheSameRow;
import Model.Card.Event.OnSpawn;
import Model.Card.Plants.Plant;
import Model.Card.Plants.PlantsActions.Burst;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

import java.io.IOException;
import java.util.ArrayList;

public class Shop {
    //it is the whole zombies and plants
    private ArrayList<Plant> plants=new ArrayList<>();
    private ArrayList<Zombie> zombies=new ArrayList<>();

    public void buyPlants(ArrayList<Plant> plants) {

    }

    public void buyZombies(ArrayList<Zombie> zombies) {

    }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    public void preprocess() throws IOException {
        Event inTheSameRow=new InTheSameRow();
        Event OnSpawn=new OnSpawn();
        Action burst=new Burst();
        Plant p= Plant.makePlant("Jalapeno");
        ArrayList<Action> actions=new ArrayList<>();
        actions.add(burst);
        p.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn ,actions) {
        });
    }
}
