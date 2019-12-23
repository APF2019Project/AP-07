package Controller.GameMode;

import Model.Map.Map;

public abstract class GameMode {

    public boolean checkState(){
        return false;
    }

    public abstract void handleWin();

    public abstract void updateCollection();

    public abstract void getAvailableCards();

    public abstract void generateSun();

    public abstract Map generateMap();

}
