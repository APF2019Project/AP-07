package Model.Card.Plants;

import Model.Card.Card;
import Model.Card.Plants.PlantsActions.PlantsAction;
import com.gilecode.yagson.YaGson;

import java.io.*;
import java.util.ArrayList;

public class Plant extends Card {

    private int sun;
    private int cooldown;
    private int ProducedSun;
    private int SpeedReduction;

    @Override
    public Plant makeCard(String name) throws IOException {
        YaGson yaGson = new YaGson();
        Plant plant=new Plant(name);
        File file = new File("Plants\\"+plant.getName());
        String string=Card.makeString(file);
        Plant plant1=yaGson.fromJson(string,Plant.class);
        String d = yaGson.toJson(plant1);
        plants.add(plant1);
        return plant1;
//        System.out.println(d);
//        System.out.println(plant1.getSun());
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

    private ArrayList<PlantsAction> plantsActions;
    private int Turn;

    public int getTurn() {
        return Turn;
    }

    public void setTurn(int turn) {
        Turn = turn;
    }

    public Plant(String name) {
        super();
        this.name=name;
        this.id=uniqueId;
        uniqueId++;
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