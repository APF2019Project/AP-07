package Controller.GameMode;

import Model.Map.Cell;
import Model.Map.Map;
import Model.Player.Profile;

public class PVP extends GameMode {

    public PVP(){
    }

    @Override
    public void wave() {

    }

    @Override
    public boolean canWave() {
        return false;
    }

    @Override
    public boolean handleWin(Profile profile) {
return true;
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
                m.setCell(i, j, new Cell(i,j));
            }
        }
        return m;
    }
}
