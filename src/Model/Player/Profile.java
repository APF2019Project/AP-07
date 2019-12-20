package Model.Player;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;

public class Profile {
    private ArrayList<Zombie> purchasedZombies = new ArrayList<>();
    private ArrayList<Plant> purchasedPlants = new ArrayList<>();
    private static ArrayList<Profile> profiles = new ArrayList<Profile>();
    private String username;
    private String password;
    private int score;
    private int externalCoins;

    public Profile(String username, String password) {
        this.password = password;
        this.username = username;
        /// zombie va plant haii ke az hmon aval dare lazem nis bexare
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

    public static ArrayList<Profile> getAcoounts() {
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


}