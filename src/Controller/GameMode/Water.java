package Controller.GameMode;

import Model.Card.Zombies.Zombie;
import Model.Map.Map;
import Model.Map.UnknownCell;
import Model.Map.WaterCell;

import java.util.Random;

public class Water extends GameMode {

    @Override
    public void wave(Battle battle) {
//        if (getBattle().getCurrentTurn() >= 3 && canWave()) {
//            int numberOfZombiesInAWave = (int) (Math.random() * ((10 - 4) + 1)) + 4;
//            for (int i = 0; i < numberOfZombiesInAWave; i++) {
//                Random random = new Random();
//                int randomY = (int) (Math.random() * ((Map.getHEIGHT()) + 1));
//                UnknownCell unknownCell = new UnknownCell();
//                unknownCell.x = 0;
//                unknownCell.y = randomY;
//                Model.Card.Zombies.Zombie zombie = Zombie.getZombies().get(random.nextInt());
//                zombie.setCell(unknownCell);
//                getWaveZombies().add(zombie);
//                Map map = new Map();
//                map.setUnknownCell(0, randomY, unknownCell);
//            }
//            setWaveCounter(1);
//        }
    }

    //check the turn
    //todo
    //7 turn pas az marge last zombie true mishe
    @Override
    public boolean canWave() {
        return false;
    }

    @Override
    public void handleWin() {

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
//        for (int i = 0; i < Map.getHEIGHT(); i++) {
//            for (int j = 0; j < Map.getWIDTH(); j++) {
//                m.setUnknownCell(i, j, new WaterCell());
//            }
//        }
        return m;
    }
}

