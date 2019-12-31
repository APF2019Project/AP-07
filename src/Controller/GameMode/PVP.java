package Controller.GameMode;

import Model.Map.LandCell;
import Model.Map.Map;

public class PVP extends GameMode {

    @Override
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
