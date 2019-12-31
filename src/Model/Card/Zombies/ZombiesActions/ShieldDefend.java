package Model.Card.Zombies.ZombiesActions;

import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

public class ShieldDefend extends Action {


    @Override
    public void doAction(Plant plant, Map map, int d) {

    }

    @Override
    public void doAction(Zombie zombie, Map map, int d) {
        if(zombie.getArmour()>0){
            for(int i=0;i<Map.unknownCells.length;i++) {
                for (int j = 0; j < Map.unknownCells[i].length; j++) {
                    if (Map.unknownCells[i][j].getPlant()!=null){
                        if(!Map.unknownCells[i][j].getPlant().getPeaOrProjectile().isProjectile()){
                            zombie.setArmour(0);
                        }
                        if(Map.unknownCells[i][j].getPlant().getPeaOrProjectile().isProjectile()){
                            zombie.setHP(-Map.unknownCells[i][j].getPlant().getAP());
                        }
                    }
                }
            }
        }

    }
}
