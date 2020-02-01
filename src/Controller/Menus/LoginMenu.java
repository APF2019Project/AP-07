package Controller.Menus;

import Model.Player.Profile;

import java.awt.*;

public class LoginMenu extends Menu {

    public Button okButton;
    public TextField textField;

    public LoginMenu() {
        this.orders = new String[]{"Create account", "Login", "Leaderboard", "Help", "Exit"};
    }

    public void createAccount(String username, String password) {
        if (Profile.validUsername(username)) {
            Profile profile = new Profile(username, password);
            Profile.addAccount(profile);
            menuHandler.setCurrentMenu(loginMenu);
            System.out.println("Account created");
        } else {
            System.out.println("invalid username");
        }
    }

    public Profile Login(String username, String password) {
        Profile p = Profile.login(username, password);
        if (p != null) {
            System.out.println("logged in");
            menuHandler.setCurrentMenu(mainMenu);
        } else
            System.out.println("wrong username or password");
        return p;
    }

    public void exit() {
        menuHandler.setCurrentMenu(null);
    }
}