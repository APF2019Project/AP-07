package Controller.GameMode;

import Model.Card.Zombies.Zombie;
import Model.Map.UnknoenCell;
import Model.Map.Map;
import Model.Player.Profile;

import java.util.ArrayList;
import java.util.Random;

public class Day extends GameMode {

    @Override
    public void wave() {
        if (getBattle().getCurrentTurn() >= 3 && canWave()) {
            int numberOfZombiesInAWave = (int) (Math.random() * ((10 - 4) + 1)) + 4;
            for (int i = 0; i < numberOfZombiesInAWave; i++) {
                Random random = new Random();
                int randomY = (int) (Math.random() * ((Map.getHEIGHT()) + 1));
                UnknoenCell unknownCell = new UnknoenCell(0, randomY);
                Zombie zombie = Zombie.getZombies().get(random.nextInt());
                zombie.setCell(unknownCell);
                getWaveZombies().add(zombie);
                Map map = new Map();
                map.setUnknownCell(0, randomY, unknownCell);
            }
            setWaveCounter(1);
        }
    }


    //check the turn
    //todo
    //7 turn pas az marge last zombie true mishe
    @Override
    public boolean canWave() {
        return false;
    }

    @Override
    public boolean handleWin(Profile profile) {
        //if player lose
        for (int i = 0; i < getBattle().getMap().getUnknownCells().length; i++) {
            for (int j = 0; j < getBattle().getMap().getUnknownCells()[i].length; i++) {
                for (int k = 0; k < getBattle().getMap().getUnknownCells()[i][j].getZombies().size(); k++) {
                    if (getBattle().getMap().getUnknownCells()[i][j].getZombies().get(k).getCell().x == Map.getWIDTH() + 1) {
                        return false;
                    }
                }
            }
        }
        //if player win
        boolean allZombisAreDead = true;
        ArrayList<Zombie> allZombies = new ArrayList<>();
        for (int i = 0; i < getBattle().getMap().getUnknownCells().length; i++) {
            for (int j = 0; j < getBattle().getMap().getUnknownCells()[i].length; i++) {
                for (int k = 0; k < getBattle().getMap().getUnknownCells()[i][j].getZombies().size(); k++) {
                    allZombies.addAll(getBattle().getMap().getUnknownCells()[i][j].getZombies());
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
            getBattle().getPlayer(0).setNumberOfKilledZombies(1);
            profile.setExternalCoins(getBattle().getPlayer(0).getNumberOfKilledZombies() * 10);
            return false;
        }

        return true;

    }

    @Override
    public void updateCollection() {

    }

    @Override
    public void getAvailableCards() {

    }

    @Override
    public void generateSun(Battle battle) {
        if (battle.getCurrentTurn() == 0) {
            battle.getPlayer(0).setSun(2);
        } else {
            int numberOfPassedTurns = (int) (Math.random() * ((2 - 1) + 1)) + 1;
            int numberOfSuns = (int) (Math.random() * ((5 - 2) + 1)) + 2;
            //todo
            //numberOfPassedTurns ra dar turn asar bede
            battle.getPlayer(0).setSun(numberOfSuns);
        }
    }

    @Override
    public Map generateMap() {
        Map m = new Map();
        for (int i = 0; i < Map.getHEIGHT() + 4; i++) {
            for (int j = 0; j < Map.getWIDTH() + 4; j++) {
                m.setUnknownCell(i, j, new UnknoenCell(i,j));
            }
        }
        return m;
    }

}
