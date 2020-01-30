package Controller.Menus;

import Controller.GameMode.*;
import Model.Player.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayMenu extends Menu implements Initializable {
    public Button start;
    public Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));

    public PlayMenu() throws IOException {
        this.orders = new String[]{"Day", "Water", "Rail", "ZombieGameMode", "PvP"};
    }

    public void startDayGame(Player player1, Player player2) {
        Day day=new Day();
        Battle battle = new Battle(player1, player2,day);
        Menu.menuHandler.setCurrentMenu(Menu.collectionMenu);

    }

    public void startWaterGame(Player player1, Player player2) {
        Water water=new Water();
        Battle battle = new Battle(player1, player2,water);
        Menu.menuHandler.setCurrentMenu(Menu.collectionMenu);
    }

    public void startRailGame(Player player1, Player player2) {
        Rail rail = new Rail();
        Battle battle = new Battle(player1, player2,rail);
        Menu.menuHandler.setCurrentMenu(Menu.railMenu);
        Menu.railMenu.player1 = player1;
        Menu.railMenu.player2 = player2;
        Menu.railMenu.rail = rail;
        Menu.railMenu.battle = battle;
    }

    public void startZombieGame(Player player1, Player player2) {
        ZombieGameMode zombieGameMode=new ZombieGameMode();
        Battle battle = new Battle(player1, player2,zombieGameMode);
        Menu.menuHandler.setCurrentMenu(Menu.collectionMenu);
    }

    public void jhajCJUK() {
        Menu.menuHandler.setCurrentMenu(Menu.mainMenu);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setStart();
    }

    @FXML
    public void setStart() {
        start.setOnAction(actionEvent -> jhajCJUK());
    }
}
