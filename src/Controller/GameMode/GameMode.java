package Controller.GameMode;
import Model.Card.Card;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Map.Map;
import Model.Player.Player;
import Model.Player.Profile;

import java.io.IOException;
import java.util.ArrayList;

public abstract class GameMode {
    //players that it is 0 (gardener) or 1 (zombie) are set in the menu

    private int waveCounter = 0;
    private boolean canWave = true;
    private ArrayList<Zombie> waveZombies = new ArrayList<>();
    protected boolean landMower[] = new boolean[6];
    public int lastTurnWaved=0;
    public Player player1 = new Player();
    public Player player2 = new Player();
    private Battle battle = new Battle(player1,player2);
    public abstract void wave() throws IOException;

    public abstract boolean canWave();

    public abstract boolean handleWin(Profile profile, Battle battle);

    public abstract void updateCollection() throws IOException;

    public abstract void generateSun(Battle battle);

    public abstract ArrayList<Card> getAvailableCards();

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
        battle = battle;
    }

    //chamanzan
    public boolean landMower(int i) {
        if (landMower[i]) {
            landMower[i] = false;
            for (int k = 0; k < battle.getMap().cells[i].length; k++) {
                //todo
                //maybe lead to error
                battle.getMap().cells[i][k].getZombies().clear();
            }
            return true;
        }
        return false;
    }

    public boolean zombieReachedToTheEnd(Battle battle) {
        for (int i =0;i<Map.getHEIGHT();i++){
            if (battle.getMap().getCell(i,1).getZombies().size() != 0)
                if(!landMower[i])
                    return true;
        }
        return false;
    }

    public boolean allZombiesAreDead(Profile profile, Battle battle) {
        boolean allZombisAreDead = true;
        ArrayList<Zombie> allZombies = new ArrayList<>();
        for (int i = 0; i < battle.getMap().getCells().length; i++) {
            for (int j = 0; j < battle.getMap().getCells()[i].length; j++) {
                for (int k = 0; k < battle.getMap().getCells()[i][j].getZombies().size(); k++) {
                    allZombies.addAll(battle.getMap().getCells()[i][j].getZombies());
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
            profile.setExternalCoins(battle.getPlayer(1).getNumberOfKilledZombies() * 10);
            return true;
        }
        return false;
    }

    public Map generateLandMap() {
        Map m = new Map();
        for (int i = 0; i < Map.getHEIGHT()+4; i++) {
            for (int j = 0; j < Map.getWIDTH()+4; j++) {
                m.setCell(i, j, new Cell(i, j, false));
            }
        }
        return m;
    }

    public Map generateWaterMap(){
        Map m=new Map();
        for (int i = 2; i < 4; i++) {
            for (int j = 0; j < Map.getWIDTH(); j++) {
                m.setCell(i, j, new Cell(i, j, true));
            }
        }
        for (int i = 4; i < 6; i++) {
            for (int j = 0; j < Map.getWIDTH(); j++) {
                m.setCell(i, j, new Cell(i, j, false));
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < Map.getWIDTH(); j++) {
                m.setCell(i, j, new Cell(i, j, false));
            }
        }
        return m;
    }


    public void generateZombies() throws IOException {
        int zombieNumber = (int) (Math.random() * (12 + 1));
        int randomPlace = (int) (Math.random() * ((Map.getHEIGHT()) + 1));
        Zombie zombie = Zombie.makeZombie(Zombie.getZombies().get(zombieNumber).getName());
        zombie.setCell(generateMap().getCell(randomPlace, 21));
        generateMap().getCell(randomPlace, 21).addZombie(zombie);
//        getWaveZombies().add(z);
    }


    public void setLastTurnWaved(int lastTurnWaved) {
        this.lastTurnWaved += lastTurnWaved;
    }
}
