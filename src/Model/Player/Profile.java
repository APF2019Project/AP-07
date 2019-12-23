package Model.Player;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;

import java.util.ArrayList;

public class Profile {

    private static ArrayList<Profile> profiles = new ArrayList<>();
    private String username;
    private String password;
    private int score;
    private ArrayList<Zombie> purchasedZombies = new ArrayList<>();
    private ArrayList<Plant> purchasedPlants = new ArrayList<>();
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
    }

    public String getUsername() {
        return username;
    }

    public void change_username(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void change_Password(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public boolean check_password(String password) {
        return (this.password == password);
    }

    public void delete_account(String username, String password) {
        if(this.username.equals(username) && this.password.equals(password))
            profiles.remove(this);
    }

    //Create Account - Login Menu
    public static void create_account(String username, String password) {
        profiles.add(new Profile(username,password));
    }

    public ArrayList<Profile> getAcoounts() {
        return profiles;
    }

    public ArrayList<Zombie> getPurchasedZombies() {
        return purchasedZombies;
    }

    public ArrayList<Plant> getPurchasedPlants() {
        return purchasedPlants;
    }

    public void addToPurchasedZombies(Zombie z) {
        this.purchasedZombies.add(z);
        //todo
        //baraye player tagheer nemikone
    }

    public void addToPurchasedPlants(Plant p) {
        this.addToPurchasedPlants(p);
        //todo
        //baraye player tagheer nemikone
    }

    public void removeCard(String name) {
        for(int i=0;i<purchasedZombies.size();i++){
            if(purchasedZombies.get(i).getName().equals(name)){
                //1 deletion in loop is okay
                purchasedZombies.remove(i);
                break;
            }
        }
        for(int i=0;i<purchasedPlants.size();i++){
            if(purchasedPlants.get(i).getName().equals(name)){
                //1 deletion in loop is okay
                purchasedPlants.remove(i);
                break;
            }
        }
    }
}