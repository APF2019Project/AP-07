package Controller.Menus;

import Controller.GameMode.Battle;
import Model.Player.*;
import View.Main;

import javax.xml.stream.StreamFilter;
import java.util.ArrayList;

public class LoginMenu extends Menu {


    public LoginMenu() {
        this.orders = new String[]{"Create account", "Login", "Leaderboard", "Help", "Exit"};
    }


    public void createAccount(String username, String password) {
        Profile profile = new Profile(username, password);
        Profile.addAccount(profile);
        menuHandler.setCurrentMenu(loginMenu);
        System.out.println("Account created");
    }

    public Profile Login(String username, String password) {
        Profile p = Profile.login(username, password);
        if (p != null) {
            System.out.println("logged in");
            menuHandler.setCurrentMenu(mainMenu);
        }
        else
            System.out.println("wrong username or password");
        return p;
    }

    public void exit() {
        menuHandler.setCurrentMenu(null);
    }
}