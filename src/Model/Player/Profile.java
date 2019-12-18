package Model.Player;

import java.util.ArrayList;

class Profile {

    private static ArrayList<Profile> profiles = new ArrayList<Profile>();
    private String username;
    private String password;
    private int score;

    private Profile(String username, String password) {
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

    //Create Account - Login Menu
    public static void create_account(String username, String password) {
        profiles.add(new Profile(username,password));
    }

    public ArrayList<Profile> getAcoounts() {
        return profiles;
    }
}