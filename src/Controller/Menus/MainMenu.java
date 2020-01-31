package Controller.Menus;

import Model.Player.Profile;
import com.gilecode.yagson.YaGson;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenu extends Menu implements Initializable {
    @FXML
    public Button start;
    public Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));


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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        start.setOnAction(actionEvent -> {
            System.out.println("Bashe Baba");
        });

    }
}

