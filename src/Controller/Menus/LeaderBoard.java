package Controller.Menus;

import Model.Player.Profile;

import java.util.ArrayList;
import java.util.Comparator;

public class LeaderBoard extends Menu {
    public void showPlayers() {
        ArrayList<Profile> pros = Profile.getAcoounts();
        pros.sort(new Comparator<Profile>() {
            @Override
            public int compare(Profile o1, Profile o2) {
                if (o1.getScore() > o2.getScore())
                    return -1;
                else if (o1.getScore() < o2.getScore())
                    return 1;
                else
                    return o1.getUsername().compareToIgnoreCase(o2.getUsername());
            }
        });
        for (Profile x : pros)
            System.out.println(x.getUsername());
        menuHandler.setCurrentMenu(loginMenu);
    }
}
