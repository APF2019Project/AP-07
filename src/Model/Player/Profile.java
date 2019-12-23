package Model.Player;

import Model.Card.Card;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.Collection;

public class Profile {

    private ArrayList<Zombie> purchasedZombies = new ArrayList<>();
    private ArrayList<Plant> purchasedPlants = new ArrayList<>();
    private ArrayList<Card> collection=new ArrayList<>();
    private static ArrayList<Profile> profiles = new ArrayList<Profile>();
    private String username;
    private String password;
    private int score;
    private int externalCoins;

    public Profile(String username, String password) {
        this.password = password;
        this.username = username;

        /// zombie va plant haii ke az hmon aval dare
        purchasedPlants.add(Plant.getPlants().get(0));
        purchasedPlants.add(Plant.getPlants().get(1));
        purchasedPlants.add(Plant.getPlants().get(7));
        purchasedPlants.add(Plant.getPlants().get(8));
        purchasedPlants.add(Plant.getPlants().get(10));
        purchasedPlants.add(Plant.getPlants().get(19));
        purchasedPlants.add(Plant.getPlants().get(21));

        purchasedZombies.add(Zombie.getZombies().get(0));
        purchasedZombies.add(Zombie.getZombies().get(1));
        purchasedZombies.add(Zombie.getZombies().get(3));
        purchasedZombies.add(Zombie.getZombies().get(4));
        purchasedZombies.add(Zombie.getZombies().get(6));
        purchasedZombies.add(Zombie.getZombies().get(7));
        purchasedZombies.add(Zombie.getZombies().get(10));

        collection.addAll(purchasedPlants);
        collection.addAll(purchasedZombies);

    }

    public String getUsername() {
        return username;
    }

    public void change_username(String username) {
        this.username = username;
    }

    public void change_Password(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void delete_account(String username, String password) {
        if(this.username.equals(username) && this.password.equals(password))
            profiles.remove(this);
    }

    public static Profile login(String username, String password) {
        for (Profile p : profiles) {
            if (p.password.equals(password) && p.username.equals(username))
                return p ;
        }
        return null;
    }

    public static ArrayList<Profile> getAccounts() {
        return profiles;
    }

    public static void addAccount(Profile profile) {
        profiles.add(profile);
    }

    public ArrayList<Zombie> getPurchasedZombies() {
        return purchasedZombies;
    }

    public ArrayList<Plant> getPurchasedPlants() {
        return purchasedPlants;
    }

    public void addToPurchasedZombies(Zombie zombie) {
        purchasedZombies.add(zombie);
    }

    public void addToPurchasedPlants(Plant plant) {
        purchasedPlants.add(plant);
    }

    public ArrayList<Card> getCollection() {
        return collection;
    }


}