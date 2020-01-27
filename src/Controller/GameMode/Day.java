package Controller.GameMode;

import Model.Card.Card;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Map.Map;
import Model.Player.Profile;

import java.io.IOException;
import java.util.ArrayList;

public class Day extends GameMode {

    private int lastTurnGivingSuns = 0;

    private int lastTurnlastZombieKilled;

    int random = (int) (Math.random() * ((2 - 1) + 1)) + 1;

    public Day() {
        //player is gardner
        getBattle().getPlayer(1).setSun(2);
        for (int i = 0; i < landMower.length; i++) {
            landMower[i] = true;
        }
        this.generateMap();
    }

    @Override
    public void wave(Battle battle) throws IOException {
        if (canWave(battle)) {
            int numberOfZombiesInAWave = (int) (Math.random() * ((10 - 4) + 1)) + 4;
            for (int i = 0; i < numberOfZombiesInAWave; i++) {
                generateZombies(battle);
            }
            setWaveCounter(1);
        }
    }

    @Override
    public boolean canWave(Battle battle) {
        if (battle.getCurrentTurn() >= 3 && this.getWaveCounter() <= 3) {
//            if (lastTurnlastZombieKilled == 7) {
            lastTurnlastZombieKilled = 0;
            return true;
//            }
        }

        return false;
    }

    @Override
    public boolean handleWin(Profile profile, Battle battle) {
        //if player lose
        if (zombieReachedToTheEnd(battle)) {
            return false;
        }
        //if player win
        if (allZombiesAreDead(profile, battle)) {
            lastTurnlastZombieKilled = getBattle().getCurrentTurn();
            return false;
        }
        //continue the game
        return true;
    }

    //removing dead zombies and plants
    @Override
    public void updateCollection(Battle battle) {
        ArrayList<Zombie> zombiesToBeDeleted = new ArrayList<>();
        for (Cell[] i : battle.getMap().getCells()) {
            for (Cell j : i) {
                for (Zombie z : j.getZombies()) {
                    if (z.getHP() == 0) {
                        zombiesToBeDeleted.add(z);
                    }
                }
            }
        }

        for (int k = 0; k < zombiesToBeDeleted.size(); k++) {
            int x = zombiesToBeDeleted.get(k).getCell().x();
            int y = zombiesToBeDeleted.get(k).getCell().y();
            battle.getMap().getCell(x, y).getZombies().remove(zombiesToBeDeleted.get(k));
        }

        System.out.println("update coleectionnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
        ArrayList<Plant> plantsToBeDeleted = new ArrayList<>();
        for (Cell[] i : battle.getMap().getCells()) {
            for (Cell j : i) {
                if (j.getPlant()!=null && j.getPlant().getHP() == 0) {
                    plantsToBeDeleted.add(j.getPlant());
                }
            }
        }
        for (int k = 0; k < plantsToBeDeleted.size(); k++) {
            int x = plantsToBeDeleted.get(k).getCell().x();
            int y = plantsToBeDeleted.get(k).getCell().y();
            battle.getMap().getCell(x, y).setPlant(null);
            System.out.println("size    "+battle.getMap().getCell(x,y).getZombies().size());
        }
        System.out.println("finitoooooooooooooooooooooooooooooooooooooooooooooooooo");
    }

    @Override
    public ArrayList<Card> getAvailableCards() {
        return null;
    }

    @Override
    public void generateSun(Battle battle) {
        int numberOfSuns = (int) (Math.random() * ((5 - 2) + 1)) + 2;
        if (lastTurnGivingSuns == random) {
            random = (int) (Math.random() * ((2 - 1) + 1)) + 1;
            lastTurnGivingSuns = 0;
            battle.getPlayer(1).setSun(numberOfSuns + battle.getPlayer(1).getSun());
        }
    }


    @Override
    public Map generateMap() {
        return generateLandMap();
    }

    public void setLastTurnGivingSuns(int lastTurnUpdatingDarSuns) {
        this.lastTurnGivingSuns += lastTurnUpdatingDarSuns;
    }

}