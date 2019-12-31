package Controller.GameMode;

import Model.Map.LandCell;
import Model.Map.Map;

public class Day extends GameMode {

    @Override
    public void handleWin() {
        ///age cell zombie-- manfi beshe va chmnzn nbashe
        ////zombie wins
        ///age wave ++ bishtar az 3 beshe
        // plant wins
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
        for (int i = 0; i < Map.getHEIGHT(); i++) {
            for (int j = 0; j < Map.getWIDTH(); j++) {
                m.setLandCell(i, j, new LandCell());
            }
        }
        return m;
    }
}
