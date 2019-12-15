package Model.Card.Zombies;

import java.util.ArrayList;

public class ZombiesAction {

    private static ArrayList<ZombiesAction> zombiesActions=new ArrayList<>();

    public void appearInCell(){

    }

    public void StealPlant()
    {

    }

    public void jumpOverPlants(){

    }

    public void KillPlants(){

    }

    public void turnToNormalZombie(){

    }

    public void killPlantByOneImpact(){

    }

    //ino shak daram
    public void shieldDefend(){
//        public boolean isArmourOfMetal() {
//            return true;
//        }
//        private int ArmourHealth;
//    public void setArmourHealth(int armourHealth)
//    {
//        this.ArmourHealth = armourHealth;
//    }
        defend();
        beingAffected();
    }


    public void defend(){

    }
    public void beingAffected(){

    }

    public static ArrayList<ZombiesAction> getZombiesActions() {
        return zombiesActions;
    }

    public static void setZombiesActions(ArrayList<ZombiesAction> zombiesActions) {
        ZombiesAction.zombiesActions = zombiesActions;
    }
}
