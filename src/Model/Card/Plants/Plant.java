package Model.Card.Plants;
import Model.Card.Action;
import Model.Card.ActionsOfAnEvent;
import Model.Card.Card;
import Model.Card.Plants.PlantsActions.PlantsAction;
import Model.Map.Map;
import com.gilecode.yagson.YaGson;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Plant extends Card {

    private int sun;
    private int cooldown;
    private int ProducedSun;
    private int SpeedReduction;
    private PeaOrProjectile peaOrProjectile;
    private ArrayList<ActionsOfAnEvent> actionsOfAnEvent =new ArrayList<>();
    //zombie ra chand turn negah dare
    private int freeze;

    public ArrayList<ActionsOfAnEvent> getActionsOfAnEvent() {
        return actionsOfAnEvent;
    }

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
        plants.add(plant1);
        return plant1;
//        System.out.println(d);
//        System.out.println(plant1.getSun());
    }


    public static Plant findPlant(String name) {
        for (Plant plant : getPlants()) {
            if (plant.name.equals(name))
                return plant;
        }
        return null;
    }

    public Plant(String name) {
        super();
        this.name = name;
        this.id = uniqueId;
        uniqueId++;
    }

    public void act(Map map){
        this.actionsOfAnEvent.forEach(e ->{
            int d=0;//bayad taeen she be ezaye har plant vali
            if(e.getEvent().check(this , map, d)) {//age shart barqarar bood
                for (Action action : e.getActions()) {
                    action.doAction(this,map);//action o anjam bede
                }
            }
        });
    }

    public PeaOrProjectile getPeaOrProjectile() {
        return peaOrProjectile;
    }

    public void setPeaOrProjectile(PeaOrProjectile peaOrProjectile) {
        this.peaOrProjectile = peaOrProjectile;
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
        Turn += turn;
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

}