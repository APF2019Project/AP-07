package Controller.Menus;

import Controller.GameMode.Battle;
import Model.Player.*;
import View.Main;

import java.util.ArrayList;

public class LoginMenu extends Menu {

    public LoginMenu() {

    }

    private static ArrayList<Profile> profiles = new ArrayList<>();

    public void createAccount(String username, String password) {
        Profile profile = new Profile(username, password);
        profiles.add(profile);
        currentMenu = this;
    }

    public Profile Login(String username, String password) {
        Profile p = Profile.login(username,password);
        if (p !=null)
            menuHandler.setCurrentMenu(mainMenu);
        return p;
    }

    public void LeaderBoard() {
        LeaderBoard leaderBoard = new LeaderBoard();
        currentMenu = leaderBoard;
    }

    public ArrayList<Profile> getProfiles() {
        return profiles;
    }

    public void addToProfiles(Profile profile) {
        profiles.add(profile);
    }

    public void deleteProfile(Profile profile) {
        profiles.remove(profile);
    }
}
