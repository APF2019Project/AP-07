package Controller.Menus;

import Controller.GameMode.Battle;
import Model.Player.Player;
import Model.Player.Profile;

import java.util.ArrayList;

public class ProfileMenu extends Menu {
    LoginMenu loginMenu = new LoginMenu();
    ArrayList<Profile> profiles = loginMenu.getProfiles();

    //change profile username or password
    public void change(Player player, String username, String password) {
        for (int i = 0; i < profiles.size(); i++) {
            if (profiles.get(i).getUsername().equals(player.getProfile().getUsername())) {
                if (profiles.get(i).getPassword().equals(player.getProfile().getPassword())) {
                    player.getProfile().change_username(username);
                    player.getProfile().change_Password(password);
                }
            }
        }
    }

    //delete profile
    public void delete_account(Player player) {
        for (int i = 0; i < profiles.size(); i++) {
            if (profiles.get(i).getUsername().equals(player.getProfile().getUsername())) {
                if (profiles.get(i).getPassword().equals(player.getProfile().getPassword())) {
                    //only 1 deletion so it is okay in the loop
                    profiles.remove(i);
                    break;
                }
            }
        }
    }

    public void rename(Player player, String username) {
        for (int i = 0; i < profiles.size(); i++) {
            if (profiles.get(i).getUsername().equals(player.getProfile().getUsername())) {
                if (profiles.get(i).getPassword().equals(player.getProfile().getPassword())) {
                    //only 1 deletion so it is okay in the loop
                    profiles.get(i).change_username(username);
                    break;
                }
            }
        }
    }


    public void create_account(String username) {
        for (int i = 0; i < profiles.size(); i++) {
            if (profiles.get(i).getUsername().equals(username)) {
                break;
            }
        }
    }


    public void show(Battle battle) {
        for(int i=0;i<Player.getPlayers().size();i++){
            //todo
            //check
            if(Player.getPlayers().get(i).equals(battle.getPlayer(i))){
                System.out.println(Player.getPlayers().get(i).getProfile().getUsername());
            }
        }
    }

}
