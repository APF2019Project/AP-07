package Model.Card;

import Model.Card.Event.*;
import Model.Card.Plants.Plant;
import Model.Card.Plants.PlantsActions.Burst;
import Model.Card.Plants.PlantsActions.ProduceSun;
import Model.Card.Plants.PlantsActions.Shoot;

import java.io.IOException;
import java.util.ArrayList;

public class Preprocess {
    public void preprocess() throws IOException {

        Event inTheSameRow = new InTheSameRow();
        Event OnSpawn = new OnSpawn();
        Event nearest = new NearestCell();
        Event proximityInRadiousDistanceOne = new ProximityInRadiousDistanceOne();
        Event nearRows=new NearRows();

        Action burst = new Burst();
        Action produceSun = new ProduceSun();
        Action shoot = new Shoot();

        ArrayList<Action> actions = new ArrayList<>();

        Plant peaShooter=Plant.makePlant("PeaShooter");
        actions.add(shoot);
        peaShooter.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, actions) {
        });

        Plant snowPea = Plant.makePlant("SnowPea");
        actions.clear();
        actions.add(shoot);
        snowPea.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, actions) {
        });

        Plant cabbagePult = Plant.makePlant("Cabbage-pult");
        actions.clear();
        actions.add(shoot);
        cabbagePult.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, actions) {
        });

        Plant repeater = Plant.makePlant("Repeater");
        actions.clear();
        actions.add(shoot);
        repeater.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, actions) {
        });

        Plant threepeater = Plant.makePlant("Threepeater");
        actions.clear();
        actions.add(shoot);
        threepeater.setActionsOfAnEvent(new ActionsOfAnEvent(nearRows, actions) {
        });

        Plant cactus = Plant.makePlant("Cactus");
        actions.clear();
        actions.add(shoot);
        cactus.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, actions) {
        });

        Plant gatlingPea = Plant.makePlant("GatlingPea");
        actions.clear();
        actions.add(shoot);
        gatlingPea.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, actions) {
        });

        Plant scaredyShroom = Plant.makePlant("Scaredy-shroom");
        actions.clear();
        actions.add(shoot);
        scaredyShroom.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, actions) {
        });

        Plant jalapeno = Plant.makePlant("Jalapeno");
        actions.clear();
        actions.add(burst);
        jalapeno.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, actions) {
        });


    }
}
