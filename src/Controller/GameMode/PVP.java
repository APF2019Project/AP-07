package Controller.GameMode;

import Model.Map.UnknoenCell;
import Model.Map.Map;
import Model.Player.Profile;

public class PVP extends GameMode {

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
                m.setUnknownCell(i, j, new UnknoenCell(i,j));
            }
        }
        getBattle().setMap(m);
        return m;
    }
}
