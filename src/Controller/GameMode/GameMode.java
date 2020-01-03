package Controller.GameMode;

import Model.Card.Zombies.Zombie;
import Model.Map.Map;
import Model.Player.Profile;

import java.io.IOException;
import java.util.ArrayList;

public abstract class GameMode {
    //players that it is 0 (gardener) or 1 (zombie) are set in the menu
    private Battle battle;
    private int waveCounter = 0;
    private boolean canWave = true;
    private ArrayList<Zombie> waveZombies = new ArrayList<>();
    protected boolean landMower[] = new boolean[6];

    public abstract void wave() throws IOException;

    public abstract boolean canWave();

    public abstract boolean handleWin(Profile profile);

    public abstract void updateCollection() throws IOException;

    public abstract void getAvailableCards();

    public abstract void generateSun(Battle battle);

    public abstract Map generateMap();

    public ArrayList<Zombie> getWaveZombies() {
        return waveZombies;
    }

    public int getWaveCounter() {
        return waveCounter;
    }

    public void setWaveCounter(int waveCounter) {
        this.waveCounter += waveCounter;
    }

    public boolean CanWave() {
        return canWave;
    }

    public boolean checkState() {
        return false;
    }

    public Battle getBattle() {
        return battle;
    }

    public void setBattle(Battle battle) {
        this.battle = battle;
    }

    //chamanzan
    public boolean landMower(int i) {
        if (landMower[i]) {
            landMower[i] = false;
            for (int k = 0; k < getBattle().getMap().cells[i].length; k++) {
                //todo
                //maybe lead to error
                getBattle().getMap().cells[i][k].getZombies().clear();
            }
            return true;
        }
        return false;
    }

}
