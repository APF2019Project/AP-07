package Controller.Menus;

import Controller.GameMode.Battle;
import Model.Player.Player;
import Model.Player.Profile;

import java.util.ArrayList;

public class ProfileMenu extends Menu {
    ArrayList<Profile> profiles = new ArrayList<Profile>();

    //change profile username or password
    public void change(Player player, String username, String password) {
        for (int i = 0; i < profiles.size(); i++) {
            if (profiles.get(i).getUsername().equals(player.getUsername())) {
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


    public void create_account(String username, String password) {
        for (Profile x : profiles)
            if (x.getUsername().equals(username))
                System.out.println("this username has exist, please enter another username");
        profiles.add(new Profile(username, password));
        Menu.menuHandler.setCurrentMenu(loginMenu);
    }


}
