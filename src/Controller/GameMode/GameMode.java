package Controller.GameMode;
import Model.Card.Plants.Plant;

import Model.Card.Card;
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

    public abstract ArrayList<Card> getAvailableCards();

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

    public boolean zombieReachedToTheEnd() {
        for (int i = 0; i < getBattle().getMap().getCells().length; i++) {
            for (int j = 0; j < getBattle().getMap().getCells()[i].length; i++) {
                for (int k = 0; k < getBattle().getMap().getCells()[i][j].getZombies().size(); k++) {
                    if (getBattle().getMap().getCells()[i][j].getZombies().get(k).getCell().x() == Map.getWIDTH() + 1) {
                        if (landMower(i)) {
                            return false;
                        }

                    }
                }
            }
        }
        return true;
    }

    public boolean allZombiesAreDead(Profile profile) {
        boolean allZombisAreDead = true;
        ArrayList<Zombie> allZombies = new ArrayList<>();
        for (int i = 0; i < getBattle().getMap().getCells().length; i++) {
            for (int j = 0; j < getBattle().getMap().getCells()[i].length; i++) {
                for (int k = 0; k < getBattle().getMap().getCells()[i][j].getZombies().size(); k++) {
                    allZombies.addAll(getBattle().getMap().getCells()[i][j].getZombies());
                }
            }
        }

        for (int i = 0; i < allZombies.size(); i++) {
            if (allZombies.get(i).getHP() != 0) {
                allZombisAreDead = false;
            }
        }

        //numberOfKilledZombies=external coins
        if (allZombisAreDead) {
            profile.setExternalCoins(getBattle().getPlayer(0).getNumberOfKilledZombies() * 10);
            return true;
        }
        return false;
    }

}
