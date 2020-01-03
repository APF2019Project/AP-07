package Controller.GameMode;

import Model.Card.Card;
import Model.Card.Plants.Plant;
import Model.Map.Map;
import Model.Player.Profile;

import java.util.ArrayList;

public class PVP extends GameMode {

    //profile e zombie e
    Profile profile;

    public PVP(Profile profile) {
        this.profile = profile;
        for (int i = 0; i < landMower.length; i++) {
            landMower[i] = true;
        }
    }

    @Override
    public void wave() {
        int randomNumberOfPlants = (int) (Math.random() * ((Plant.getPlants().size()) + 1)) + Plant.getPlants().size();
        for (int i = 0; i < randomNumberOfPlants; i++) {
            int randomPlant = (int) (Math.random() * ((Plant.getPlants().size()) + 1)) + Plant.getPlants().size();
            int randomPlace = (int) (Math.random() * (Map.getHEIGHT()) + 1);
            Plant plant = new Plant(Plant.getPlants().get(randomPlant).getName());
            if (plant.getPrice() <= getBattle().getPlayer(0).getSun()) {
                plant.setCell(generateMap().getCell(randomPlace, Map.getWIDTH() - 1));
                generateMap().getCell(randomPlace, 0).setPlant(plant);
                getBattle().getPlayer(0).setSun(-plant.getPrice());
            }
        }
        ZombieGameMode zombieGameMode = new ZombieGameMode(profile, "Land");
        zombieGameMode.wave();
    }

    @Override
    public boolean canWave() {
        return false;
    }

    @Override
    public boolean handleWin(Profile profile) {
        //if player lose
        if(zombieReachedToTheEnd()){
            profile.setExternalCoins(200);
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
        //todo
        //payane har turn
        getBattle().getPlayer(0).setSun(1);
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
