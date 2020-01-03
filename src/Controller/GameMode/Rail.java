package Controller.GameMode;

import Model.Card.Card;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Map.Map;
import Model.Player.Profile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Rail extends GameMode {

    private ArrayList<Plant> plants = Card.getPlants();
    private ArrayList<Plant> list = new ArrayList<Plant>();

    public Rail() {
        for (int i=0;i<landMower.length;i++){
            landMower[i]=true;
        }
    }

    @Override
    //dar asl wave nadare va be soorate tasadofi har chand turn zombie varede zamin mishe
    public void wave() throws IOException {
        //todo
        //har 3 ta 5 turn
        int zombieNumber = (int) (Math.random() * (12 + 1));
        int randomPlace = (int) (Math.random() * ((Map.getHEIGHT()) + 1));
        Zombie zombie = new Zombie(Card.getZombies().get(zombieNumber).getName());
        zombie.setCell(generateMap().getCell(randomPlace, 0));
        generateMap().getCell(randomPlace, 0).getZombies().add(zombie);
        getWaveZombies().add(zombie);
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
                    if (getBattle().getMap().getCells()[i][j].getZombies().get(k).getCell().x() == Map.getWIDTH() + 1) {
                        if(landMower(i)){
                            return false;
                        }
                        return true;
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
        int randomPlant = (int) (Math.random() * ((plants.size()) + 1));
        Plant newPlant = Plant.makePlant(Plant.getPlants().get(randomPlant).getName());
        if (plants.size() < 10) {
            getBattle().getPlayer(0).getPlants().add(newPlant);
        }
        //if plant the zombie remove it from playerPlants
        ArrayList<Plant> plantsToBeOmitted = new ArrayList<>();
        for (int i = 0; i < plants.size(); i++) {
            if (plants.get(i).getCell() != null) {
                plantsToBeOmitted.add(plants.get(i));
            }
        }
        //do the deletion
        for (int i = 0; i < plantsToBeOmitted.size(); i++) {
            plants.remove(plantsToBeOmitted.get(i));
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
                m.setCell(i, j, new Cell(i, j,false));
            }
        }
        return m;
    }

    public void addPlant(Battle battle) {
        if (battle.getCurrentTurn()%5 == 0 && plants.size()<10) {
            int rnd = (int) (Math.random() *(plants.size()+1));
            plants.add(plants.get(rnd));
        }
    }

    public ArrayList<Plant> showList() {
        return list;
    }

}
