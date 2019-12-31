package Controller.GameMode;

import Model.Card.Zombies.Zombie;
import Model.Map.Map;
import Model.Player.Player;

import java.util.ArrayList;

public abstract class GameMode {

    private int waveCounter = 0;
    private boolean canWave = true;
    private ArrayList<Zombie> waveZombies = new ArrayList<>();
    private Player player1, player2;

    public abstract void wave(Battle battle);

    public abstract boolean canWave();

    public abstract void handleWin();

    public abstract void updateCollection();

    public abstract void getAvailableCards();

    public abstract void generateSun(Battle battle);

    public abstract Map generateMap();

    //todo
    //check how to set players in different modes
//    public abstract void setPlayer1();
//
//    public abstract void setPlayer2();

    public ArrayList<Zombie> getWaveZombies() {
        return waveZombies;
    }

    public int getWaveCounter() {
        return waveCounter;
    }

    public void setWaveCounter(int waveCounter) {
        this.waveCounter += waveCounter;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public boolean CanWave() {
        return canWave;
    }

    public boolean checkState() {
        return false;
    }
}
