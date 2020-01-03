package Model.Card.Plants;

import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.ActionsOfAnEvent;
import Model.Card.Card;
import Model.Card.Plants.PlantsActions.PlantsAction;
import Model.Player.Profile;
import com.gilecode.yagson.YaGson;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Plant extends Card {

    private int sun;
    private int cooldown;
    private int loading;
    private int ProducedSun;
    private int SpeedReduction;
    public boolean pea;
    private ArrayList<ActionsOfAnEvent> actionsOfAnEvent = new ArrayList<>();
    //zombie ra chand turn negah dare
    private int freeze;
    private int turn;

    public void setActionsOfAnEvent(ActionsOfAnEvent actionsOfAnEvent) {
        this.actionsOfAnEvent.add(actionsOfAnEvent);
    }

    public static Plant makePlant(String name) throws IOException {
        YaGson yaGson = new YaGson();
        Plant plant = new Plant(name);
        File file = new File("Plants\\" + plant.getName());
        String string = Card.makeString(file);
        Plant plant1 = yaGson.fromJson(string, Plant.class);
        String d = yaGson.toJson(plant1);
//        boolean q = false;
//        for (Plant p: plants)
//            if (p.getName().equalsIgnoreCase(plant1.getName()))
//                q = true;
//        if (!q)
//            plants.add(plant1);
//        plant1.setPrice();

        return plant1;
//        System.out.println(d);
//        System.out.println(plant1.getSun());
    }


    public static Plant findPlant(String name) {
        for (Plant plant : getPlants()) {
            if (plant.name.equalsIgnoreCase(name))
                return plant;
        }
        return null;
    }

    public Plant(String name) {
        super();
        this.name = name;
        this.id = uniqueId;
        uniqueId++;
        this.loading = 0;
    }

    public void act(Battle battle) {
        this.actionsOfAnEvent.forEach(e -> {
            int d = 0;//bayad taeen she be ezaye har plant vali
            if (e.getEvent().check(this, battle, d)) {//age shart barqharar bood
                for (Action action : e.getActions()) {
                    action.doAction(this, battle, d);//action o anjam bede
                }
            }
        });
    }

    public int getSpeedReduction() {
        return SpeedReduction;
    }

    public void setSpeedReduction(int speedReduction) {
        SpeedReduction = speedReduction;
    }

    public int getProducedSun() {
        return ProducedSun;
    }

    public void setProducedSun(int producedSun) {
        ProducedSun = producedSun;
    }

    public ArrayList<ActionsOfAnEvent> getActionsOfAnEvent() {
        return actionsOfAnEvent;
    }

    private ArrayList<PlantsAction> plantsActions;

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn += turn;
    }

    public void addToPlantsActions(PlantsAction action) {
        plantsActions.add(action);
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

    public int getFreeze() {
        return freeze;
    }


    public int getLoading() {
        return loading;
    }

    public void setLoading(int loading) {
        this.loading = loading;
    }

    @Override
    public void setPrice() {
        this.price=this.sun*this.cooldown*this.getHP()+1;
    }
}