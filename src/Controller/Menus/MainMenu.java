package Controller.Menus;

import Model.Player.Profile;
import com.gilecode.yagson.YaGson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainMenu extends Menu {

    public MainMenu() {
        this.orders = new String[] {"Play", "Profiles", "Shop", "Help", "Exit"};
    }

    public void exit() throws IOException {
        Menu.menuHandler.setCurrentMenu(Menu.loginMenu);
        ArrayList<Profile> accounts = Profile.getAccounts();
        String json = new YaGson().toJson(accounts);
        FileWriter writer = new FileWriter("Accounts\\accounts");
        writer.write(json);
        writer.close();
    }
}
