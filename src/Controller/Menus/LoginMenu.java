package Controller.Menus;
import Controller.GameMode.Battle;
import Model.Player.*;

import java.util.ArrayList;

public class LoginMenu extends Menu {

    private ArrayList<Profile> profiles=new ArrayList<>();

    public void createAccount(String username,String password){
        Profile profile = new Profile(username,password);
        profiles.add(profile);

        currentMenu=this;
    }

    public void Login(Player player){
        //this.account =account

    }

    public void LeaderBoard(){

    }
}
