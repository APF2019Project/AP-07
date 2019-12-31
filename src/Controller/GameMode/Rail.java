package Controller.GameMode;

import Model.Card.Zombies.Zombie;
import Model.Map.LandCell;
import Model.Map.Map;

public class Rail extends GameMode {

    @Override
    //dar asl wave nadare va be soorate tasadofi har chand turn zombie varede zamin mishe
    public void wave() {

    }

    @Override
    public boolean canWave() {
        return false;
    }

    @Override
    public void handleWin() {

    }

    @Override
    public void updateCollection() {

    }

    @Override
    public void getAvailableCards() {

    }

    @Override
    public void generateSun(Battle battle) {

    }

    @Override
    public Map generateMap() {
        Map m = new Map();
        for (int i = 0; i < Map.getHEIGHT(); i++) {
            for (int j = 0; j < Map.getWIDTH(); j++) {
                m.setUnknownCell(i, j, new LandCell());
            }
        }
        return m;
    }
}
