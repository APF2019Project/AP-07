package Controller.GameMode;

import Model.Card.Card;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;
import Model.Player.Profile;

import java.util.ArrayList;
import java.util.Random;

public class Water extends GameMode {

    private int lastTurnGivingSuns = 0;
    private int lastTurnlastZombieKilled;
    int random = (int) (Math.random() * ((2 - 1) + 1)) + 1;

    public Water() {
//        //player is gardner
//        getBattle().getPlayer(1).setSun(2);
//        for (int i=0;i<landMower.length;i++){
//            landMower[i]=true;
//        }
    }

    @Override
    public void wave() {
        if (canWave()) {
            int numberOfZombiesInAWave = (int) (Math.random() * ((10 - 4) + 1)) + 4;
            for (int i = 0; i < numberOfZombiesInAWave; i++) {
                Random random = new Random();
                int randomPlace = (int) (Math.random() * ((Map.getHEIGHT()) + 1));
                //if in landCell
                if (randomPlace != 2 && randomPlace != 3) {
                    //zombies number 0 to 12 can be in landCell
                    int zombieNumber = (int) (Math.random() * (12 + 1));
                    Zombie zombie = new Zombie(Card.getZombies().get(zombieNumber).getName());
                    zombie.setCell(generateMap().getCell(randomPlace, 0));
                    generateMap().getCell(randomPlace, 0).getZombies().add(zombie);
                    getWaveZombies().add(zombie);
                }

                //if in water cell
                if (randomPlace == 2 || randomPlace == 3) {
                    int zombieNumber = (int) (Math.random() * ((14 - 13) + 1)) + 13;
                    Zombie zombie = new Zombie(Card.getZombies().get(zombieNumber).getName());
                    zombie.setCell(generateMap().getCell(randomPlace, 0));
                    generateMap().getCell(randomPlace, 0).getZombies().add(zombie);
                    getWaveZombies().add(zombie);
                }
            }
            setWaveCounter(1);
        }
    }

    //check the turn
    //todo
    //7 turn pas az marge last zombie true mishe
    @Override
    public boolean canWave()
    {
        if (getBattle().getCurrentTurn() >= 3 && getWaveCounter() <= 3) {
            if(getBattle().getCurrentTurn()==0 || (getBattle().getCurrentTurn()-lastTurnlastZombieKilled)==7)
                lastTurnlastZombieKilled=0;
            return true;
        }
        return false;
    }

    @Override
    public boolean handleWin(Profile profile) {
        //if player lose
        if(zombieReachedToTheEnd()){
            return false;
        }
        //if player win
        if(allZombiesAreDead(profile)){
            return false;
        }
        //continue the game
        return true;
    }

    @Override
    public void updateCollection() {

    }

    @Override
    public ArrayList<Card> getAvailableCards() {
        return null;
    }


    @Override
    public void generateSun(Battle battle) {
        int numberOfSuns = (int) (Math.random() * ((5 - 2) + 1)) + 2;
        if (lastTurnGivingSuns == random) {
            random= (int) (Math.random() * ((2 - 1) + 1)) + 1;
            lastTurnGivingSuns = 0;
            battle.getPlayer(0).setSun(numberOfSuns);
        }
    }



    @Override
    public Map generateMap() {
        return generateWaterMap();
    }

    public void setLastTurnGivingSuns(int lastTurnUpdatingDarSuns) {
        this.lastTurnGivingSuns += lastTurnUpdatingDarSuns;
    }
}

