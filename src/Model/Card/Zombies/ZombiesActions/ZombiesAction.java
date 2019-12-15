package Model.Card.Zombies.ZombiesActions;

import Model.Card.Event.Event;

import java.util.ArrayList;

public class ZombiesAction {

    private ArrayList<Event> events=new ArrayList<>();
    private static ArrayList<ZombiesAction> zombiesActions=new ArrayList<>();

    public static ArrayList<ZombiesAction> getZombiesActions() {
        return zombiesActions;
    }
}
