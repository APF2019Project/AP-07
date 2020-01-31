package Controller.Menus;

import Model.Player.Profile;
import com.gilecode.yagson.YaGson;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class MainMenu extends Menu  {


    public MainMenu() throws IOException {
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

