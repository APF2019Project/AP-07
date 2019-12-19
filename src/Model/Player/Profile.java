package Model.Player;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;

public class Profile {
    //kolle data ha
    private static ArrayList<Profile> profiles = new ArrayList<Profile>();
    private String username;
    private String password;
    private int score;

    public Profile(String username, String password) {
        this.password = password;
        this.username = username;
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
}