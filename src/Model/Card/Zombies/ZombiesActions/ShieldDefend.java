package Model.Card.Zombies.ZombiesActions;

import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

public class ShieldDefend extends Action {


    @Override
    public void doAction(Plant plant, Battle battle, int d) {

    }

    @Override
    public void doAction(Zombie zombie, Battle battle, int d) {
        if (zombie.getArmour() > 0 && zombie.getHP()>0) {
            for (int i = 0; i < battle.getMap().cells.length; i++) {
                for (int j = 0; j < battle.getMap().cells[i].length; j++) {
                    if (battle.getMap().cells[i][j].getPlant() != null) {
                        if (!battle.getMap().cells[i][j].getPlant().pea) {
                            if (zombie.getArmour() > 0) {
                                zombie.setArmour(-1);
                            }
                        }
                        if (battle.getMap().cells[i][j].getPlant().pea) {
                            zombie.setHP(-battle.getMap().cells[i][j].getPlant().getAP());
                        }
                    }
                }
            }
        }

    }
}
