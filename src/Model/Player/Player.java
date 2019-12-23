package Model.Player;

import Model.Card.Card;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;

import java.util.ArrayList;

public class Player {

    private ArrayList<Plant> playerPlants;
    private ArrayList<Zombie> playerZombies;
    //collection cartha ee ast ke player ba khod be bazi mibarad
    private ArrayList<Card> collection=new ArrayList<>();
    private int externalCoins;
    private int internalCoins;
    private static ArrayList<Player> players = new ArrayList<>();

    public Player(Profile profile){
        this.playerPlants =profile.getPurchasedPlants();
        this.playerZombies =profile.getPurchasedZombies();
        this.collection.addAll(this.playerPlants);
        this.collection.addAll(this.playerZombies);
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static void addToPlayers(Player player) {
        players.add(player);
    }

    public ArrayList<Plant> getPlayerPlants() {
        return playerPlants;
    }

    public void setPlayerPlants(ArrayList<Plant> playerPlants) {
        this.playerPlants = playerPlants;
    }

    public ArrayList<Zombie> getPlayerZombies() {
        return playerZombies;
    }

    public void setPlayerZombies(ArrayList<Zombie> playerZombies) {
        this.playerZombies = playerZombies;
    }

    public int getExternalCoins() {
        return externalCoins;
    }

    public void setExternal_coins(int externalCoins) {
        this.externalCoins += externalCoins;
    }

    public int getInternal_coins() {
        return internalCoins;
    }

    public void setInternal_coins(int internalCoins) {
        this.internalCoins += internalCoins;
    }
}
