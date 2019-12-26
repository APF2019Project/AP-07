package Model.Card.Event;

import Model.Card.Plants.Plant;
import Model.Map.Map;
import java.util.ArrayList;

public abstract class Event {
    private static ArrayList<Event> events=new ArrayList<>();

    public static ArrayList<Event> getEvents() {
        return events;
    }

    public static void addToEvents(Event event) {
        events.add(event);
    }
    public abstract boolean check(Plant plant, Map map, int d);

}