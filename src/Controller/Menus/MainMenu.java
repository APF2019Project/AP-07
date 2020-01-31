package Controller.Menus;

import Model.Player.Profile;
import com.gilecode.yagson.YaGson;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.awt.*;
import java.beans.EventHandler;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static javafx.application.Platform.exit;

public class MainMenu extends Menu {

    public Parent root;
    @FXML
    public Button start;




    public MainMenu() {
        this.orders = new String[] {"Play", "Profiles", "Shop", "Help", "Exit"};
    }

    public void load() throws IOException {
        root = FXMLLoader.load(getClass().getClassLoader().getResource("\\MainMenu.fxml"));

    }

    public void Exit() throws IOException {
//        Menu.menuHandler.setCurrentMenu(Menu.loginMenu);
//        ArrayList<Profile> accounts = Profile.getAccounts();
//        String json = new YaGson().toJson(accounts);
//        FileWriter writer = new FileWriter("Accounts\\accounts");
//        writer.write(json);
//        writer.close();
    }
}
