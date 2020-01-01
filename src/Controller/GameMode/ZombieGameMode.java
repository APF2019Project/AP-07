package Controller.GameMode;

import Model.Map.Map;
import Model.Player.Profile;

public class ZombieGameMode extends GameMode {
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


    public void generateSun() {

    }

    @Override
    public Map generateMap() {
        return null;
    }
}
