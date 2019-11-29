package Player;

import java.util.ArrayList;

class Profile {

    private ArrayList<Profile> profiles;
    private String username;
    private String password;
    private int score;

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

    public void delete_account() {

    }

    public void create_account() {

    }

    public ArrayList<Profile> getAcoounts() {
        return profiles;
    }
}