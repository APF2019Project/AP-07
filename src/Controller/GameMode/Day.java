package Controller.GameMode;

import Model.Map.LandCell;
import Model.Map.Map;

public class Day extends GameMode {

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
    public void generateSun() {

    }

    @Override
    public Map generateMap() {
        Map m = new Map();
        for (int i = 0; i < Map.HEIGHT; i++) {
            for (int j = 0; j < Map.WIDTH; j++) {
                m.setLandCell(i, j, new LandCell());
            }
        }
        return m;
    }
}
