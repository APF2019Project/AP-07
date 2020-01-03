package Controller.GameMode;

import Model.Card.Card;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Map.Map;
import Model.Player.Profile;

import java.util.ArrayList;
import java.util.Random;

public class ZombieGameMode extends GameMode {

    private String mapType;
    private Profile profile;

    public ZombieGameMode(Profile profile, String mapType) {
        for (int i=0;i<landMower.length;i++){
            landMower[i]=false;
        }
        profile.setExternalCoins(50);
        this.mapType = mapType;
        this.profile = profile;
        int size = 0;
        ArrayList<Plant> randomPlants = new ArrayList<>();
        randomPlants.add(Plant.findPlant("Explode-o-nut"));
        randomPlants.add(Plant.findPlant("Explode-o-nut"));
        randomPlants.add(Plant.findPlant("Explode-o-nut"));
        randomPlants.add(Plant.findPlant("Scaredy-shroom"));
        randomPlants.add(Plant.findPlant("Scaredy-shroom"));
        randomPlants.add(Plant.findPlant("Scaredy-shroom"));
        randomPlants.add(Plant.findPlant("Scaredy-shroom"));
        randomPlants.add(Plant.findPlant("Scaredy-shroom"));
        randomPlants.add(Plant.findPlant("Scaredy-shroom"));
        randomPlants.add(Plant.findPlant("SnowPea"));
        randomPlants.add(Plant.findPlant("SnowPea"));
        randomPlants.add(Plant.findPlant("Cabbage-pult"));
        randomPlants.add(Plant.findPlant("Cabbage-pult"));
        randomPlants.add(Plant.findPlant("GatlingPea"));

        if (!getBattle().getMap().getCell(0, 2).isWater()) {
            randomPlants.add(Plant.findPlant("PotatoMine"));
            randomPlants.add(Plant.findPlant("PotatoMine"));
            size = randomPlants.size();
        }

        if (getBattle().getMap().getCell(0, 2).isWater()) {
            randomPlants.add(Plant.findPlant("TangleKelp"));
            randomPlants.add(Plant.findPlant("TangleKelp"));
            randomPlants.add(Plant.findPlant("Cattail"));
            randomPlants.add(Plant.findPlant("LilyPad"));
            randomPlants.add(Plant.findPlant("LilyPad"));
            randomPlants.add(Plant.findPlant("LilyPad"));
            size = randomPlants.size();
        }
        int randomNumberOfPlants = (int) (Math.random() * ((size) + 1)) + size;
        for (int i = 0; i < randomNumberOfPlants; i++) {
            int randomPlant = (int) (Math.random() * ((randomPlants.size() - 4) + 1)) + 4;
            int randomPlace = (int) (Math.random() * (Map.getHEIGHT()) + 1);
            Plant plant = new Plant(randomPlants.get(randomPlant).getName());
            plant.setCell(generateMap().getCell(randomPlace, Map.getWIDTH() - 1));
            generateMap().getCell(randomPlace, 0).setPlant(plant);
        }

    }

    public ZombieGameMode() {

    }

    @Override
    public void wave() {
        for (int i = 0; i < getBattle().getMap().getCells().length; i++) {
            ArrayList<Zombie> zombiesInRow = new ArrayList<>();
            for (int j = 0; j < getBattle().getMap().getCells()[i].length; j++) {
                zombiesInRow.addAll(getBattle().getMap().getCells()[i][j].getZombies());
            }
            if (zombiesInRow.size() <= 2) {
                if (mapType.equalsIgnoreCase("Water")) {
                    Random random = new Random();
                    int randomPlace = (int) (Math.random() * ((Map.getHEIGHT()) + 1));
                    //if in landCell
                    if (randomPlace != 2 && randomPlace != 3) {
                        //zombies number 0 to 12 can be in landCell
                        int zombieNumber = (int) (Math.random() * (12 + 1));
                        Zombie zombie = new Zombie(Card.getZombies().get(zombieNumber).getName());
                        if (profile.getExternalCoins() >= zombie.getPrice() * 10) {
                            profile.setExternalCoins(-zombie.getPrice() * 10);
                            zombie.setCell(generateMap().getCell(randomPlace, 0));
                            generateMap().getCell(randomPlace, 0).getZombies().add(zombie);
                            getWaveZombies().add(zombie);
                        }
                    }
                    //if in water cell
                    if (randomPlace == 2 || randomPlace == 3) {
                        int zombieNumber = (int) (Math.random() * ((14 - 13) + 1)) + 13;
                        Zombie zombie = new Zombie(Card.getZombies().get(zombieNumber).getName());
                        if (profile.getExternalCoins() >= zombie.getPrice() * 10) {
                            profile.setExternalCoins(-zombie.getPrice() * 10);
                            zombie.setCell(generateMap().getCell(randomPlace, 0));
                            generateMap().getCell(randomPlace, 0).getZombies().add(zombie);
                            getWaveZombies().add(zombie);
                        }
                    }
                }
                if (mapType.equalsIgnoreCase("Land")) {
                    int zombieNumber = (int) (Math.random() * (12 + 1));
                    int randomPlace = (int) (Math.random() * ((Map.getHEIGHT()) + 1));
                    Zombie zombie = new Zombie(Card.getZombies().get(zombieNumber).getName());
                    if (profile.getExternalCoins() >= zombie.getPrice() * 10) {
                        profile.setExternalCoins(-zombie.getPrice() * 10);
                        zombie.setCell(generateMap().getCell(randomPlace, 0));
                        generateMap().getCell(randomPlace, 0).getZombies().add(zombie);
                        getWaveZombies().add(zombie);
                    }
                }
            }
        }

        for (int i = 0; i < getBattle().getMap().getCells().length; i++) {
            for (int j = 0; j < getBattle().getMap().getCells()[i].length; i++) {
                if (getBattle().getMap().getCells()[i][j].getPlant().getHP() == 0) {
                    Plant p = new Plant(getBattle().getMap().getCells()[i][j].getPlant().getName());
                    profile.setExternalCoins(10 * p.getHP());
                }
            }
        }
    }

    @Override
    public boolean canWave() {
        return false;
    }

    @Override
    public boolean handleWin(Profile profile) {
        boolean allPlantsAreDead=true;
        for (int i = 0; i < getBattle().getMap().getCells().length; i++) {
            for (int j = 0; j < getBattle().getMap().getCells()[i].length; j++) {
                if(getBattle().getMap().getCells()[i][j].getPlant()!=null){
                    allPlantsAreDead=false;
                    break;
                }
            }
        }
        if(allPlantsAreDead){
            return false;
        }
        boolean canNotBuyAnyZombie=true;
        for(int i=0;i< Zombie.getZombies().size();i++){
            if(Zombie.getZombies().get(i).getPrice()<=profile.getExternalCoins()){
                canNotBuyAnyZombie=false;
                break;
            }
        }
        if(canNotBuyAnyZombie){
            return false;
        }
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

    }

    @Override
    public Map generateMap() {
        Map m = new Map();
        if (mapType.equals("Water")) {
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
        }
        if (mapType.equals("Land")) {
            for (int i = 0; i < Map.getHEIGHT() + 4; i++) {
                for (int j = 0; j < Map.getWIDTH() + 4; j++) {
                    m.setCell(i, j, new Cell(i, j, false));
                }
            }
        }
        return m;
    }

}
