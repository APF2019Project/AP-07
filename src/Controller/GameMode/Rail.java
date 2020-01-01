package Controller.GameMode;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Map.Map;
import Model.Player.Profile;

import java.io.IOException;
import java.util.ArrayList;

public class Rail extends GameMode {

    private ArrayList<Plant> playerPlants = getBattle().getPlayer(0).getPlants();

    @Override
    //dar asl wave nadare va be soorate tasadofi har chand turn zombie varede zamin mishe
    public void wave() throws IOException {
        //todo
        //har 3 ta 5 turn
        int numberOfPassedTurns = (int) (Math.random() * ((5 - 3) + 1)) + 3;
        int randomZombie = (int) (Math.random() * ((Zombie.getZombies().size()) + 1));
        Zombie newZombie = Zombie.makeZombie(Zombie.getZombies().get(randomZombie).getName());
        Cell cell = new Cell(0,(int) (Math.random() * ((5) + 1)) + 5);
        newZombie.setCell(cell);
    }

    @Override
    public boolean canWave() {
        return false;
    }

    @Override
    public boolean handleWin(Profile profile) {
//if player lose
        for (int i = 0; i < getBattle().getMap().getCells().length; i++) {
            for (int j = 0; j < getBattle().getMap().getCells()[i].length; i++) {
                for (int k = 0; k < getBattle().getMap().getCells()[i][j].getZombies().size(); k++) {
                    if (getBattle().getMap().getCells()[i][j].getZombies().get(k).getCell().x == Map.getWIDTH() + 1) {
                        return false;
                    }
                }
            }
        }
        //if player win
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
            getBattle().getPlayer(0).setNumberOfKilledZombies(1);
            profile.setExternalCoins(getBattle().getPlayer(0).getNumberOfKilledZombies() * 10);
            return false;
        }

        return true;


    }


    @Override
    public void updateCollection() throws IOException {
        //todo
        //turn
        int numberOfPassedTurns = (int) (Math.random() * ((4 - 2) + 1)) + 2;
        int randomPlant = (int) (Math.random() * ((playerPlants.size()) + 1));
        Plant newPlant = Plant.makePlant(Plant.getPlants().get(randomPlant).getName());
        if (playerPlants.size() < 10) {
            getBattle().getPlayer(0).getPlants().add(newPlant);
        }
        //if plant the zombie remove it from playerPlants
        ArrayList<Plant> plantsToBeOmitted = new ArrayList<>();
        for (int i = 0; i < playerPlants.size(); i++) {
            if (playerPlants.get(i).getCell() != null) {
                plantsToBeOmitted.add(playerPlants.get(i));
            }
        }
        //do the deletion
        for (int i = 0; i < plantsToBeOmitted.size(); i++) {
            playerPlants.remove(plantsToBeOmitted.get(i));
        }
    }

    @Override
    public void getAvailableCards() {

    }

    @Override
    public void generateSun(Battle battle) {

    }

    @Override
    public Map generateMap() {
        Map m = new Map();
        for (int i = 0; i < Map.getHEIGHT(); i++) {
            for (int j = 0; j < Map.getWIDTH(); j++) {
                m.setCell(i, j, new Cell(i,j));
            }
        }
        getBattle().setMap(m);
        return m;
    }

}
