package Controller.GameMode;

import Model.Card.Card;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;
import Model.Player.Player;
import Model.Player.Profile;

import java.io.IOException;
import java.util.ArrayList;

public abstract class GameMode {
    //players that it is 0 (gardener) or 1 (zombie) are set in the menu
    private Battle battle;
    private int waveCounter = 0;
    private boolean canWave = true;
    private ArrayList<Zombie> waveZombies = new ArrayList<>();

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

}
