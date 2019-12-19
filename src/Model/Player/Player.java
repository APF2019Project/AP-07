package Model.Player;

import Model.Card.Plants.Plant;
import Model.Shop.Collection;
import Model.Card.Zombies.Zombie;

import java.util.ArrayList;

public class Player {
    private ArrayList<Plant> PlayerPlants;
    private ArrayList<Zombie> PlayerZombies;
    private Profile profile;
    private Collection collection;
    private int externalCoins;
    private int internalCoins;
    private static ArrayList<Player> players = new ArrayList<>();

    public Player(Profile profile){
        this.profile=profile;
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static void addToPlayers(Player player) {
        players.add(player);
    }

    public Profile getProfile() {
        return profile;
    }

    public ArrayList<Plant> getPlayerPlants() {
        return PlayerPlants;
    }

    public void addPlayerPlants(Plant plant) {
        PlayerPlants.add(plant);
    }

    public ArrayList<Zombie> getPlayerZombies() {
        return PlayerZombies;
    }

    public void addPlayerZombies(Zombie zombie) {
        PlayerZombies.add(zombie);
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

    public Collection getCollection() {
        return collection;
    }
}
