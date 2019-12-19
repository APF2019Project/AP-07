package Controller.Menus;
import Controller.GameMode.Battle;
import Model.Player.*;
import View.Main;

import java.util.ArrayList;

public class LoginMenu extends Menu {

    private static ArrayList<Profile> profiles=new ArrayList<>();

    public void createAccount(String username,String password){
        Profile profile = new Profile(username,password);
        profiles.add(profile);
        currentMenu=this;
    }

    public void Login(Player player){
        //this.account =account
        Profile profile=new Profile("bot","1");
        Player player1=new Player(profile);
        Battle battle=new Battle(player,player1);
        MainMenu mainMenu=new MainMenu();
        currentMenu=mainMenu;
    }

    public void LeaderBoard(){
        LeaderBoard leaderBoard=new LeaderBoard();
        currentMenu=leaderBoard;
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
