package Controller.GameMode;

import Model.Card.Card;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Map.Map;
import Model.Player.Profile;

import java.util.ArrayList;

public class Day extends GameMode {

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
                int zombieNumber = (int) (Math.random() * (12 + 1));
                int randomPlace = (int) (Math.random() * ((Map.getHEIGHT()) + 1));
                Zombie zombie = new Zombie(Card.getZombies().get(zombieNumber).getName());
                zombie.setCell(generateMap().getCell(randomPlace, 0));
                generateMap().getCell(randomPlace, 0).getZombies().add(zombie);
                getWaveZombies().add(zombie);
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
        int numberOfPassedTurns = (int) (Math.random() * ((2 - 1) + 1)) + 1;
        int numberOfSuns = (int) (Math.random() * ((5 - 2) + 1)) + 2;
        //todo
        //numberOfPassedTurns ra dar turn asar bede
        battle.getPlayer(0).setSun(numberOfSuns);
    }

    @Override
    public ArrayList<Card> getAvailableCards() {
        return null;
    }

    @Override
    public Map generateMap() {
        return generateLandMap();
    }

}
