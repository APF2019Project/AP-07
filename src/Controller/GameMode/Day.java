package Controller.GameMode;

import Model.Card.Card;
import Model.Map.Map;
import Model.Player.Profile;

import java.util.ArrayList;

public class Day extends GameMode {

    private int lastTurnUpdatingDaySuns = 0;
    private int lastTurnlastZombieKilled;
    int random = (int) (Math.random() * ((2 - 1) + 1)) + 1;

    public Day() {
        //player is gardner
        getBattle().getPlayer(0).setSun(2);
        for (int i = 0; i < landMower.length; i++) {
            landMower[i] = true;
        }
    }

    @Override
    public void wave() {
        if (canWave()) {
            int numberOfZombiesInAWave = (int) (Math.random() * ((10 - 4) + 1)) + 4;
            for (int i = 0; i < numberOfZombiesInAWave; i++) {
                generateZombies();
            }
            setWaveCounter(1);
        }
    }

    //check the turn
    //todo
    //7 turn pas az marge last zombie true mishe
    @Override
    public boolean canWave() {
        if (getBattle().getCurrentTurn() >= 3 && getWaveCounter() <= 3) {
            return true;
        }
        return false;
    }

    @Override
    public boolean handleWin(Profile profile) {
        //if player lose
        if (zombieReachedToTheEnd()) {
            return false;
        }
        //if player win
        if (allZombiesAreDead(profile)) {
            return false;
        }
        //continue the game
        return true;
    }

    @Override
    public void updateCollection() {
    }

    @Override
    public void generateSun(Battle battle) {
        int numberOfSuns = (int) (Math.random() * ((5 - 2) + 1)) + 2;
        if (lastTurnUpdatingDaySuns == random) {
            random= (int) (Math.random() * ((2 - 1) + 1)) + 1;
            lastTurnUpdatingDaySuns = 0;
            battle.getPlayer(0).setSun(numberOfSuns);
        }
    }

    @Override
    public ArrayList<Card> getAvailableCards() {
        return null;
    }

    @Override
    public Map generateMap() {
        return generateLandMap();
    }

    public void setLastTurnUpdatingDarSuns(int lastTurnUpdatingDarSuns) {
        this.lastTurnUpdatingDaySuns += lastTurnUpdatingDarSuns;
    }

    public void checkLastZombieLife(){

    }

}