package Player;

import Plants.Plants;
import Shop.Collection;
import Zombies.Zombie;

import java.util.ArrayList;

public class Player {
    private ArrayList<Plants> PlayerPlants;
    private ArrayList<Zombie> PlayerZombies;
    private Profile profile;
    private Collection collection;
    //collection cartha ee ast ke player ba khod be bazi mibarad
    private int externalCoins;
    private int internalCoins;
    private static ArrayList<Player> players=new ArrayList<>();

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static void addToPlayers(Player player) {
        players.add(player);
    }

    public Profile getProfile() {
        return profile;
    }

    public ArrayList<Plants> getPlayerPlants() {
        return PlayerPlants;
    }

    public void setPlayerPlants(ArrayList<Plants> playerPlants) {
        PlayerPlants = playerPlants;
    }

    public ArrayList<Zombie> getPlayerZombies() {
        return PlayerZombies;
    }

    public void setPlayerZombies(ArrayList<Zombie> playerZombies) {
        PlayerZombies = playerZombies;
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
