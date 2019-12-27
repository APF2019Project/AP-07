package Model.Card.Zombies.ZombiesActions;

import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

public class ShieldDefend extends Action {
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

    @Override
    public void doAction(Plant plant, Map map) {

    }

    @Override
    public void doZombieAction(Zombie zombie, Map map) {

    }
}
