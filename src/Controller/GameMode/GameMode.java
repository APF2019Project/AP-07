package Controller.GameMode;

import Model.Map.Map;

public abstract class GameMode {

    public boolean checkState(){
        return false;
    }

    public void handleWin(){
    }

    public void updateCollection(){
    }

    public void getAvailableCards(){
    }

    public void generateSun(){
    }

    public Map generateMap(){
        return null;
    }

}
