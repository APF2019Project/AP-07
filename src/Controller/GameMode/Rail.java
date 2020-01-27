package Controller.GameMode;

import Model.Card.Card;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Map.Map;
import Model.Player.Profile;

import java.io.IOException;
import java.util.ArrayList;


public class Rail extends GameMode {

    private ArrayList<Plant> plants = new ArrayList<>();
    private ArrayList<Plant> list = new ArrayList<>();
    private int record=0;
    private int lastTurnUpdatingRailCollection =0;
    int random = (int) (Math.random() * ((4 - 2) + 1)) + 2;

    public Rail() {
        for (int i = 0; i < landMower.length; i++) {
            landMower[i] = true;
        }
    }

    @Override
    //dar asl wave nadare va be soorate tasadofi har chand turn zombie varede zamin mishe
    public void wave(Battle battle) throws IOException {
        //har 3 ta 5 turn
        int random = (int) (Math.random() * ((5 - 3) + 1)) + 3;
        if(lastTurnWaved ==random) {
            lastTurnWaved=0;
            generateZombies(battle);
        }
    }

    @Override
    public boolean canWave(Battle battle) {
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
            return false;
        }
        //continue the game
        return true;
    }


    @Override
    public void updateCollection(Battle battle) throws IOException {
        //har 2 ta 4 turn
        if(lastTurnUpdatingRailCollection ==random){
            lastTurnUpdatingRailCollection =0;
            random= (int) (Math.random() * ((4 - 2) + 1)) + 2;
            int randomPlant = (int) (Math.random() * ((plants.size()) + 1));
            Plant newPlant = Plant.makePlant(Plant.getPlants().get(randomPlant).getName());
            if (plants.size() < 10) {
                getBattle().getPlayer(0).getPlants().add(newPlant);
            }
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

        //deleting dead zombies
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
        record+=zombiesToBeDeleted.size();

        //deleting dead plants
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
        record+=plantsToBeDeleted.size();
    }

    @Override
    public void generateSun(Battle battle) {

    }

    @Override
    public ArrayList<Card> getAvailableCards() {
        return null;
    }

    @Override
    public Map generateMap() {
        return generateLandMap();
    }

    public void addPlant(Battle battle) {
        if (battle.getCurrentTurn() % 5 == 0 && plants.size() < 10) {
            int rnd = (int) (Math.random() * (plants.size() + 1));
            plants.add(plants.get(rnd));
        }
    }

    public ArrayList<Plant> showList() {
        return list;
    }

    public void setLastTurnUpdatingRailCollection(int lastTurnUpdatingRailCollection) {
        this.lastTurnUpdatingRailCollection += lastTurnUpdatingRailCollection;
    }

    public int getRecord() {
        return record;
    }
    public void addRecord(int record) {
        this.record +=record;
    }
}

